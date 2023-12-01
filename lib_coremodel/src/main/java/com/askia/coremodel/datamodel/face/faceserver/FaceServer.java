package com.askia.coremodel.datamodel.face.faceserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.net.Uri;
import android.util.Log;

import com.arcsoft.face.ErrorInfo;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.FaceSimilar;
import com.arcsoft.face.enums.DetectFaceOrientPriority;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.util.ImageUtils;
import com.askia.coremodel.datamodel.face.faceserver.model.FaceRegisterInfo;
import com.askia.coremodel.event.FaceHandleEvent;
import com.ttsea.jrxbus2.RxBus2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 人脸库操作类，包含注册和搜索
 */
public class FaceServer {
    private static final String TAG = "FaceServer";
    public static final String IMG_JPG_SUFFIX = ".jpg";
    public static final String IMG_PNG_SUFFIX = ".png";
    private static FaceEngine faceEngine = null;
    private static FaceServer faceServer = null;
    private static List<FaceRegisterInfo> faceRegisterInfoList;
    private static List<CompareResult.Message> getfaceList;
    public static String ROOT_PATH;
    public static final String SAVE_IMG_DIR = "register" + File.separator + "imgs";
    private static final String SAVE_FEATURE_DIR = "register" + File.separator + "features";

    public static String READ_FACE_DIR = "/mnt/sdcard/zhstoriginfaces";
    //public static String READ_FACE_DIR = "/sdcard/zhstoriginfaces";

    /**
     * 是否正在搜索人脸，保证搜索操作单线程进行
     */
    private boolean isProcessing = false;

    public static FaceServer getInstance() {
        if (faceServer == null) {
            synchronized (FaceServer.class) {
                if (faceServer == null) {
                    faceServer = new FaceServer();

                }
            }
        }
        return faceServer;
    }

    /**
     * 初始化
     *
     * @param context 上下文对象
     * @return 是否初始化成功
     */
    public boolean init(Context context) {
        synchronized (this) {
            if (faceEngine == null && context != null) {
                faceEngine = new FaceEngine();
                int engineCode = faceEngine.init(context, DetectMode.ASF_DETECT_MODE_IMAGE, DetectFaceOrientPriority.ASF_OP_ALL_OUT, 16, 3, FaceEngine.ASF_FACE_RECOGNITION | FaceEngine.ASF_FACE_DETECT);
                if (engineCode == ErrorInfo.MOK) {
                    initFaceList(context);
                    return true;
                } else {
                    faceEngine = null;
                    Log.e(TAG, "init: failed! code = " + engineCode);
                    return false;
                }
            }
            return false;
        }
    }
    public int getFaceNum(Context context) {
        if (ROOT_PATH == null) {
            ROOT_PATH = context.getFilesDir().getAbsolutePath();
        }
        //图片存储的文件夹
        File imgDir = new File(ROOT_PATH + File.separator + SAVE_IMG_DIR);
        if (!imgDir.exists()) {
            return 0;
        }
        File[] files = imgDir.listFiles();
        if (files == null || files.length == 0 ) {
            return 0;
        }
        return files.length;
    }

    /**
     * 销毁
     */
    public void unInit() {
        synchronized (this) {
            if (faceRegisterInfoList != null) {
                faceRegisterInfoList.clear();
                faceRegisterInfoList = null;
            }
            if (faceEngine != null) {
                faceEngine.unInit();
                faceEngine = null;
            }
        }
    }

    /**
     * 初始化人脸特征数据以及人脸特征数据对应的注册图
     *
     * @param context 上下文对象
     */
    private void initFaceList(Context context) {
        synchronized (this) {
            if (ROOT_PATH == null) {
                ROOT_PATH = context.getFilesDir().getAbsolutePath();
            }
            File featureDir = new File(ROOT_PATH + File.separator + SAVE_FEATURE_DIR);
            if (!featureDir.exists() || !featureDir.isDirectory()) {
                return;
            }
            File[] featureFiles = featureDir.listFiles();
            if (featureFiles == null || featureFiles.length == 0) {
                return;
            }
            faceRegisterInfoList = new ArrayList<>();
            for (File featureFile : featureFiles) {
                try {
                    FileInputStream fis = new FileInputStream(featureFile);
                    byte[] feature = new byte[FaceFeature.FEATURE_SIZE];
                    fis.read(feature);
                    fis.close();
                    faceRegisterInfoList.add(new FaceRegisterInfo(feature, featureFile.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getFaceNumber(Context context) {
        synchronized (this) {
            if (context == null) {
                return 0;
            }
            if (ROOT_PATH == null) {
                ROOT_PATH = context.getFilesDir().getAbsolutePath();
            }

            File featureFileDir = new File(ROOT_PATH + File.separator + SAVE_FEATURE_DIR);
            int featureCount = 0;
            if (featureFileDir.exists() && featureFileDir.isDirectory()) {
                String[] featureFiles = featureFileDir.list();
                featureCount = featureFiles == null ? 0 : featureFiles.length;
            }
            int imageCount = 0;
            File imgFileDir = new File(ROOT_PATH + File.separator + SAVE_IMG_DIR);
            if (imgFileDir.exists() && imgFileDir.isDirectory()) {
                String[] imageFiles = imgFileDir.list();
                imageCount = imageFiles == null ? 0 : imageFiles.length;
            }
            return featureCount > imageCount ? imageCount : featureCount;
        }
    }

    public int clearAllFaces(Context context) {
        synchronized (this) {
            if (context == null) {
                return 0;
            }
            if (ROOT_PATH == null) {
                ROOT_PATH = context.getFilesDir().getAbsolutePath();
            }
            if (faceRegisterInfoList != null) {
                faceRegisterInfoList.clear();
            }
            FaceHandleEvent event = new FaceHandleEvent();
            event.setType(0);
            RxBus2.getInstance().post(event);
            File featureFileDir = new File(ROOT_PATH + File.separator + SAVE_FEATURE_DIR);
            int deletedFeatureCount = 0;
            if (featureFileDir.exists() && featureFileDir.isDirectory()) {
                File[] featureFiles = featureFileDir.listFiles();
                if (featureFiles != null && featureFiles.length > 0) {
                    for (File featureFile : featureFiles) {
                        if (featureFile.delete()) {
                            deletedFeatureCount++;
                        }
                    }
                }
            }
            int deletedImageCount = 0;
            File imgFileDir = new File(ROOT_PATH + File.separator + SAVE_IMG_DIR);
            if (imgFileDir.exists() && imgFileDir.isDirectory()) {
                File[] imgFiles = imgFileDir.listFiles();
                if (imgFiles != null && imgFiles.length > 0) {
                    for (File imgFile : imgFiles) {
                        if (imgFile.delete()) {
                            deletedImageCount++;
                        }
                    }
                }
            }
            return deletedFeatureCount > deletedImageCount ? deletedImageCount : deletedFeatureCount;
        }
    }
    public List<String> nameList = null;

    public int registerMultyLocalFaces(Context context) {
        if (nameList == null)
            nameList = new ArrayList<>();
        else
            nameList.clear();

        String realDir = READ_FACE_DIR;
        List<String> failedFileNameList = new ArrayList<>();
        File dir = new File(realDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!dir.isDirectory()) {
            dir.delete();
            dir.mkdir();
        }
        final File[] jpgFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(FaceServer.IMG_JPG_SUFFIX) || name.endsWith(FaceServer.IMG_PNG_SUFFIX) || name.endsWith(".JPG") || name.endsWith(".PNG");
            }
        });


        int totalCount = jpgFiles == null ? 0 : jpgFiles.length;
        int successCount = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < totalCount; i++) {
            FaceHandleEvent event = new FaceHandleEvent();
            event.setType(1);
            event.setTotal(totalCount);
            event.setCurrent(i + 1);
            RxBus2.getInstance().post(event);
            final int finalI = i;
            final File jpgFile = jpgFiles[i];
//            if (jpgFile.toString().indexOf("_") != -1) {
//                jpgFile.delete();
//            }

            boolean canAdd = true;
            for (String name : nameList) {
                if (jpgFile.getName().equals(name)) {
                    canAdd = false;
                    Log.e("TagSnake", jpgFile.getName() + "已导入");
                    Log.e("FaceImport", "第" + (i + 1) + "个人脸已导入" + jpgFile.getName());
                    break;
                }
            }

            if (canAdd) {
                Log.e("FaceImport", jpgFile.getName() + "导入");
                nameList.add(jpgFile.getName());
                Bitmap bitmap = BitmapFactory.decodeFile(jpgFile.getAbsolutePath());
                if (bitmap == null) {
                    Log.e("FaceImport", jpgFile.getName() + "导入 bitmap == null");

                    failedFileNameList.add(jpgFile.getName());
                    continue;
                }
                bitmap = ImageUtils.alignBitmapForBgr24(bitmap);
                if (bitmap == null) {
                    Log.e("FaceImport", jpgFile.getName() + "导入 bitmap 2 == null");

                    failedFileNameList.add(jpgFile.getName());
                    continue;
                }
                byte[] bgr24 = ImageUtils.bitmapToBgr24(bitmap);
                String name = Uri.decode(jpgFile.getName());
                name = name.substring(0, name.lastIndexOf("."));
                String[] nameList = name.split("_");
                if (nameList.length == 1)
                    name = nameList[0];
                else
                    name = name.split("_")[0] + "_" + name.split("_")[1];
                boolean success = registerBgr24(context, bgr24, bitmap.getWidth(), bitmap.getHeight(), name);
                if (!success) {
                    failedFileNameList.add(name);
                    Log.e("FaceImport", "第" + (i + 1) + "个人脸解压失败" + jpgFile.getName());
                } else {
                    successCount++;
                    Log.e("FaceImport", "第" + (i + 1) + "个人脸解压完成" + jpgFile.getName());

                    // 删除
                    jpgFile.delete();
                }
                bitmap.recycle();

            }else {
                // 删除
                jpgFile.delete();
            }
        }
        long endTime = System.currentTimeMillis();
        float average = (endTime - startTime) / totalCount;
        Log.e("FaceImport", "平均人脸导入时间" + average + "ms");
        for (String name : failedFileNameList) {
            Log.e(TAG, "人脸图片注册失败:" + name);
        }
        return successCount;
    }

    /**
     * 用于预览时注册人脸
     *
     * @param context  上下文对象
     * @param nv21     NV21数据
     * @param width    NV21宽度
     * @param height   NV21高度
     * @param faceInfo {@link FaceEngine#detectFaces(byte[], int, int, int, List)}获取的人脸信息
     * @param name     保存的名字，若为空则使用时间戳
     * @return 是否注册成功
     */
    public boolean registerNv21(Context context, byte[] nv21, int width, int height, FaceInfo faceInfo, String name) {
        synchronized (this) {
            if (faceEngine == null || context == null || nv21 == null || width % 4 != 0 || nv21.length != width * height * 3 / 2) {
                return false;
            }

            if (ROOT_PATH == null) {
                ROOT_PATH = context.getFilesDir().getAbsolutePath();
            }
            boolean dirExists = true;
            //特征存储的文件夹
            File featureDir = new File(ROOT_PATH + File.separator + SAVE_FEATURE_DIR);
            if (!featureDir.exists()) {
                dirExists = featureDir.mkdirs();
            }
            if (!dirExists) {
                return false;
            }
            //图片存储的文件夹
            File imgDir = new File(ROOT_PATH + File.separator + SAVE_IMG_DIR);
            if (!imgDir.exists()) {
                dirExists = imgDir.mkdirs();
            }
            if (!dirExists) {
                return false;
            }
            FaceFeature faceFeature = new FaceFeature();
            //特征提取
            int code = faceEngine.extractFaceFeature(nv21, width, height, FaceEngine.CP_PAF_NV21, faceInfo, faceFeature);
            String userName = name == null ? String.valueOf(System.currentTimeMillis()) : name;
            try {
                //保存注册结果（注册图、特征数据）
                if (code == ErrorInfo.MOK) {
                    YuvImage yuvImage = new YuvImage(nv21, ImageFormat.NV21, width, height, null);
                    //为了美观，扩大rect截取注册图
                    Rect cropRect = getBestRect(width, height, faceInfo.getRect());
                    if (cropRect == null) {
                        return false;
                    }
                    File file = new File(imgDir + File.separator + userName + IMG_JPG_SUFFIX);
                    FileOutputStream fosImage = new FileOutputStream(file);
                    yuvImage.compressToJpeg(cropRect, 100, fosImage);
                    fosImage.close();
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                    //判断人脸旋转角度，若不为0度则旋转注册图
                    boolean needAdjust = false;
                    if (bitmap != null) {
                        switch (faceInfo.getOrient()) {
                            case FaceEngine.ASF_OC_0:
                                break;
                            case FaceEngine.ASF_OC_90:
                                bitmap = ImageUtils.rotateBitmap(bitmap, 90);
                                needAdjust = true;
                                break;
                            case FaceEngine.ASF_OC_180:
                                bitmap = ImageUtils.rotateBitmap(bitmap, 180);
                                needAdjust = true;
                                break;
                            case FaceEngine.ASF_OC_270:
                                bitmap = ImageUtils.rotateBitmap(bitmap, 270);
                                needAdjust = true;
                                break;
                            default:
                                break;
                        }
                    }
                    if (needAdjust) {
                        fosImage = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fosImage);
                        fosImage.close();
                    }

                    FileOutputStream fosFeature = new FileOutputStream(featureDir + File.separator + userName);
                    fosFeature.write(faceFeature.getFeatureData());
                    fosFeature.close();

                    //内存中的数据同步
                    if (faceRegisterInfoList == null) {
                        faceRegisterInfoList = new ArrayList<>();
                    }
                    faceRegisterInfoList.add(new FaceRegisterInfo(faceFeature.getFeatureData(), userName));
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public List<File> getLocalFaceFiles(Context context, int pageSize, int pageNum) {
        if (ROOT_PATH == null) {
            ROOT_PATH = context.getFilesDir().getAbsolutePath();
        }
        //图片存储的文件夹
        File imgDir = new File(ROOT_PATH + File.separator + SAVE_IMG_DIR);
        if (!imgDir.exists()) {
            return new ArrayList<>();
        }

        File[] files = imgDir.listFiles();
        if (files == null || files.length == 0 || files.length < (pageSize * (pageNum - 1) + 1)) {
            return new ArrayList<>();
        }

        List<File> result = Arrays.asList(files);

        if (result.size() < (pageSize * pageNum)) {
            result = result.subList(pageSize * (pageNum - 1), result.size());
        } else {
            result = result.subList(pageSize * (pageNum - 1), pageSize * pageNum);
        }

        return result;
    }

    /**
     * 用于注册照片人脸
     *
     * @param context 上下文对象
     * @param bgr24   bgr24数据
     * @param width   bgr24宽度
     * @param height  bgr24高度
     * @param name    保存的名字，若为空则使用时间戳
     * @return 是否注册成功
     */
    public boolean registerBgr24(Context context, byte[] bgr24, int width, int height, String name) {
        synchronized (this) {
            if (faceEngine == null || context == null || bgr24 == null || width % 4 != 0 || bgr24.length != width * height * 3) {
                return false;
            }

            if (ROOT_PATH == null) {
                ROOT_PATH = context.getFilesDir().getAbsolutePath();
            }
            boolean dirExists = true;
            //特征存储的文件夹
            File featureDir = new File(ROOT_PATH + File.separator + SAVE_FEATURE_DIR);
            if (!featureDir.exists()) {
                dirExists = featureDir.mkdirs();
            }
            if (!dirExists) {
                return false;
            }
            //图片存储的文件夹
            File imgDir = new File(ROOT_PATH + File.separator + SAVE_IMG_DIR);
            if (!imgDir.exists()) {
                dirExists = imgDir.mkdirs();
            }
            if (!dirExists) {
                return false;
            }
            //人脸检测
            int code = 0;
            List<FaceInfo> faceInfoList = new ArrayList<>();
            try {
                long start = System.currentTimeMillis();
                code = faceEngine.detectFaces(bgr24, width, height, FaceEngine.CP_PAF_BGR24, faceInfoList);
                Log.e("FaceImport", "人脸检测时间" + (System.currentTimeMillis() - start) + "ms");
            } catch (Exception e) {
                int i = 0;
            }
//            Log.e("TagSnake",code+":code");
//            Log.e("TagSnake",(faceInfoList==null)+":faceInfoList==null");
//            if (faceInfoList != null)
//            Log.e("TagSnake",faceInfoList.size() +":faceInfoList");

            if (code == ErrorInfo.MOK && faceInfoList != null && faceInfoList.size() > 0) {
                FaceFeature faceFeature = new FaceFeature();
                //特征提取
                long start1 = System.currentTimeMillis();
                code = faceEngine.extractFaceFeature(bgr24, width, height, FaceEngine.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
                Log.d("FaceImport", "提取特征时间" + (System.currentTimeMillis() - start1) + "ms");

                String userName = name == null ? String.valueOf(System.currentTimeMillis()) : name;
                try {
                    //保存注册结果（注册图、特征数据）
                    if (code == ErrorInfo.MOK) {
                        long start2 = System.currentTimeMillis();
                        //为了美观，扩大rect截取注册图
                        Rect cropRect = getBestRect(width, height, faceInfoList.get(0).getRect());
                        if (cropRect == null) {
                            return false;
                        }
                        if ((cropRect.width() & 1) == 1) {
                            cropRect.right--;
                        }
                        if ((cropRect.height() & 1) == 1) {
                            cropRect.bottom--;
                        }
                        File file = new File(imgDir + File.separator + userName + IMG_JPG_SUFFIX);
                        FileOutputStream fosImage = new FileOutputStream(file);
                        byte[] headBgr24 = ImageUtils.cropBgr24(bgr24, width, height, cropRect);
                        Bitmap headBmp = ImageUtils.bgrToBitmap(headBgr24, cropRect.width(), cropRect.height());
                        headBmp.compress(Bitmap.CompressFormat.JPEG, 100, fosImage);
                        fosImage.close();
                        headBmp.recycle();
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                        //判断人脸旋转角度，若不为0度则旋转注册图
                        boolean needAdjust = false;
                        if (bitmap != null) {
                            switch (faceInfoList.get(0).getOrient()) {
                                case FaceEngine.ASF_OC_0:
                                    break;
                                case FaceEngine.ASF_OC_90:
                                    bitmap = ImageUtils.rotateBitmap(bitmap, 90);
                                    needAdjust = true;
                                    break;
                                case FaceEngine.ASF_OC_180:
                                    bitmap = ImageUtils.rotateBitmap(bitmap, 180);
                                    needAdjust = true;
                                    break;
                                case FaceEngine.ASF_OC_270:
                                    bitmap = ImageUtils.rotateBitmap(bitmap, 270);
                                    needAdjust = true;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (needAdjust) {
                            fosImage = new FileOutputStream(file);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fosImage);
                            fosImage.close();
                            bitmap.recycle();
                        }
                        Log.d("FaceImport", "储存人脸图片" + (System.currentTimeMillis() - start2) + "ms");


                        long start3 = System.currentTimeMillis();
                        FileOutputStream fosFeature = new FileOutputStream(featureDir + File.separator + userName);
                        fosFeature.write(faceFeature.getFeatureData());
                        fosFeature.close();
                        Log.d("FaceImport", "储存特征值" + (System.currentTimeMillis() - start3) + "ms");

                        //内存中的数据同步
                        if (faceRegisterInfoList == null) {
                            faceRegisterInfoList = new ArrayList<>();
                        }
                        faceRegisterInfoList.add(new FaceRegisterInfo(faceFeature.getFeatureData(), userName));
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    /**
     * 用文件名字进行比对
     */

    public CompareResult getImgHeardByName(String name) {
        float maxSimilar = 0.8f;
        for (int i = 0; i < faceRegisterInfoList.size(); i++) {
            if (faceRegisterInfoList.get(i).getName().equals(name)) {
                CompareResult.Message messa = new CompareResult.Message(faceRegisterInfoList.get(i).getName(), maxSimilar);
                ArrayList<CompareResult.Message> list = new ArrayList<>();
                list.add(messa);
                return new CompareResult(list);
            }
        }
        return null;
    }


    /**
     * 在特征库中搜索
     * <p>
     * she修改：返回所有大于0.8的人脸信息
     *
     * @param faceFeature 传入特征数据
     * @return 比对结果
     */

    FaceFeature tempFaceFeature;
    FaceSimilar faceSimilar;
    public CompareResult getTopOfFaceLib(FaceFeature faceFeature) {
        if (faceEngine == null || isProcessing || faceFeature == null || faceRegisterInfoList == null || faceRegisterInfoList.size() == 0) {
            return null;
        }

        if (getfaceList == null)
            getfaceList = new ArrayList<>();
        getfaceList.clear();

        if (tempFaceFeature==null)
          tempFaceFeature = new FaceFeature();

        if (faceSimilar==null)
          faceSimilar = new FaceSimilar();
        float maxSimilar = 0.8f;
        int maxSimilarIndex = -1;
        isProcessing = true;
        for (int i = 0; i < faceRegisterInfoList.size(); i++) {
            tempFaceFeature.setFeatureData(faceRegisterInfoList.get(i).getFeatureData());
            faceEngine.compareFaceFeature(faceFeature, tempFaceFeature, faceSimilar);
            if (faceSimilar.getScore() > 0.8f) {//人脸分值
                getfaceList.add(new CompareResult.Message(faceRegisterInfoList.get(i).getName(), faceSimilar.getScore()));
//                maxSimilar = faceSimilar.getScore();
//                maxSimilarIndex = i;
            }
//            if (faceSimilar.getScore() > maxSimilar) {
//                maxSimilar = faceSimilar.getScore();
//                maxSimilarIndex = i;
//            }
        }
        isProcessing = false;
        if (getfaceList.size() > 0) {
            return new CompareResult(getfaceList);
        }
//        if (maxSimilarIndex != -1) {
//            return new CompareResult(faceRegisterInfoList.get(maxSimilarIndex).getName(), maxSimilar);
//        }
        return null;
    }


    /**
     * 将图像中需要截取的Rect向外扩张一倍，若扩张一倍会溢出，则扩张到边界，若Rect已溢出，则收缩到边界
     *
     * @param width   图像宽度
     * @param height  图像高度
     * @param srcRect 原Rect
     * @return 调整后的Rect
     */
    private static Rect getBestRect(int width, int height, Rect srcRect) {

        if (srcRect == null) {
            return null;
        }
        Rect rect = new Rect(srcRect);
        //1.原rect边界已溢出宽高的情况
        int maxOverFlow = 0;
        int tempOverFlow = 0;
        if (rect.left < 0) {
            maxOverFlow = -rect.left;
        }
        if (rect.top < 0) {
            tempOverFlow = -rect.top;
            if (tempOverFlow > maxOverFlow) {
                maxOverFlow = tempOverFlow;
            }
        }
        if (rect.right > width) {
            tempOverFlow = rect.right - width;
            if (tempOverFlow > maxOverFlow) {
                maxOverFlow = tempOverFlow;
            }
        }
        if (rect.bottom > height) {
            tempOverFlow = rect.bottom - height;
            if (tempOverFlow > maxOverFlow) {
                maxOverFlow = tempOverFlow;
            }
        }
        if (maxOverFlow != 0) {
            rect.left += maxOverFlow;
            rect.top += maxOverFlow;
            rect.right -= maxOverFlow;
            rect.bottom -= maxOverFlow;
            return rect;
        }
        //2.原rect边界未溢出宽高的情况
        int padding = rect.height() / 2;
        //若以此padding扩张rect会溢出，取最大padding为四个边距的最小值
        if (!(rect.left - padding > 0 && rect.right + padding < width && rect.top - padding > 0 && rect.bottom + padding < height)) {
            padding = Math.min(Math.min(Math.min(rect.left, width - rect.right), height - rect.bottom), rect.top);
        }

        rect.left -= padding;
        rect.top -= padding;
        rect.right += padding;
        rect.bottom += padding;
        return rect;
    }
}
