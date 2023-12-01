package com.askia.common.ui;


import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.TextureView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.arcsoft.face.AgeInfo;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.GenderInfo;
import com.arcsoft.face.LivenessInfo;
import com.askia.common.base.BaseFragment;
import com.askia.common.util.faceUtils.ConfigUtil;
import com.askia.common.util.faceUtils.DrawHelper;
import com.askia.common.util.faceUtils.FaceHelper;
import com.askia.common.util.faceUtils.FaceListener;
import com.askia.common.util.faceUtils.RequestFeatureStatus;
import com.askia.common.widget.camera.CameraHelper;
import com.askia.common.widget.camera.CameraListener;
import com.askia.common.widget.face.FaceRectView;
import com.askia.coremodel.datamodel.face.faceserver.CompareResult;
import com.askia.coremodel.datamodel.face.faceserver.FaceEngineManager;
import com.askia.coremodel.datamodel.face.faceserver.model.DrawInfo;
import com.askia.coremodel.datamodel.face.faceserver.model.FacePreviewInfo;
import com.askia.coremodel.viewmodel.FaceAuthViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseFaceAuthFragment extends BaseFragment {
    // 最大识别人脸数量
    private final int MAX_DETECT_NUM = 3;
    private final String TAG = "FaceAuthFragment";
    private FaceAuthViewModel mViewModel;
    // 虹软人脸错误码
    private int afCode;
    // 虹软人脸引擎
    private FaceEngine mFaceEngine;
    private CameraHelper cameraHelper;
    private DrawHelper drawHelper;
    private Camera.Size previewSize;
    private FaceHelper faceHelper;
    protected boolean mIsMirror = false;
    private ConcurrentHashMap<Integer, Integer> requestFeatureStatusMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Integer> livenessMap = new ConcurrentHashMap<>();

    /**
     * 优先打开的摄像头，本界面主要用于单目RGB摄像头设备，因此默认打开前置
     */
    private Integer rgbCameraID = Camera.CameraInfo.CAMERA_FACING_FRONT;

    protected boolean isCameraInit = false;
    public boolean mFaceDecting = true;
    // 连续5帧在指定区域
    protected int frames = 0;
    protected FaceFeature mCurrentFeature;
    protected Handler mMainHandler = new Handler();
    protected TextureView mPreview;
    protected FaceRectView mFaceRectView;
    protected ImageView mIvRect;
    private long startDectTime;
    private long startSearchTime;
    //连续50帧没有人脸数据
    protected int notface = 0;

    @Override
    public void onInit() {
        mFaceEngine = FaceEngineManager.getFaceEngineInstance();
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(FaceAuthViewModel.class);
    }


    @Override
    public void onSubscribeViewModel() {
        mViewModel.getSearchResultLiveData().observe(this,
                new Observer<CompareResult>() {
                    @Override
                    public void onChanged(@Nullable CompareResult compareResult) {
//                        Log.e("TagSnake", "人脸搜索时间为" + (System.currentTimeMillis() - startSearchTime) + "ms");
//                        if (compareResult.getSimilar() >= 0.7f) {
                        // 成功
                        //  MyToastUtils.info(compareResult.getUserName()); + (System.currentTimeMillis() - startSearchTime) + "ms"
                        onFaceDetected(compareResult.getData());
//                        } else {
//
//                            if (com.askia.coremodel.Set.notPeopleCD > 0) {
//                                //延时Xs重新识别
//
//                                mMainHandler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        mFaceDecting = true;
//                                    }
//                                }, com.askia.coremodel.Set.notPeopleCD * 1000);
//                            } else {
//                                mFaceDecting = true;
//                            }
//                        }
                    }
                });
    }

    protected abstract void onFaceDetected(List<CompareResult.Message> messasList);

    protected abstract void setUI(boolean showFace);

    /**
     * 初始化相机
     */
    protected void initCamera() {
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        final FaceListener faceListener = new FaceListener() {
            @Override
            public void onFail(Exception e) {
                Log.e(TAG, "onFail: " + e.getMessage());
            }

            //请求FR的回调
            @Override
            public void onFaceFeatureInfoGet(@Nullable final FaceFeature faceFeature, final Integer requestId) {
                //FR成功
                if (faceFeature != null) {
//                    Log.i(TAG, "onPreview: fr end = " + System.currentTimeMillis() + " trackId = " + requestId);
                    mCurrentFeature = faceFeature;
                    mFaceDecting = false;
                    frames = 0;
                    Log.e("TagSnake", "人脸检测时间 + " + (System.currentTimeMillis() - startDectTime) + " ms");
                    // 搜索人脸
                    startSearchTime = System.currentTimeMillis();
                    mViewModel.searchFace(faceFeature);
                   /* //活体检测通过，搜索特征
                    if (livenessMap.get(requestId) != null && livenessMap.get(requestId) == LivenessInfo.ALIVE) {
                        //searchFace(faceFeature, requestId);
                    }
                    //活体检测未出结果，延迟100ms再执行该函数
                    else if (livenessMap.get(requestId) != null && livenessMap.get(requestId) == LivenessInfo.UNKNOWN) {
                        Observable.timer(100, TimeUnit.MILLISECONDS)
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long aLong) {
                                        onFaceFeatureInfoGet(faceFeature, requestId);
                                    }
                                });
                    }
                    //活体检测失败
                    else {
                        requestFeatureStatusMap.put(requestId, RequestFeatureStatus.NOT_ALIVE);
                    }
*/
                }
                //FR 失败
                else {
                    requestFeatureStatusMap.put(requestId, RequestFeatureStatus.FAILED);
                }
            }

        };

        CameraListener cameraListener = new CameraListener() {
            @Override
            public void onCameraOpened(Camera camera, int cameraId, int displayOrientation, boolean isMirror) {
//                Camera.Parameters parameters = camera.getParameters();
//                parameters.set("preview-flip", "flip-h");
//                camera.setParameters(parameters);
                previewSize = camera.getParameters().getPreviewSize();
                drawHelper = new DrawHelper(mPreview.getWidth(), mPreview.getHeight(), mPreview.getWidth(), mPreview.getHeight(), displayOrientation
                        , cameraId, isMirror, true, false);//false,false:查询机   true,false:消费机
                Log.i(TAG, "onCameraOpened: " + drawHelper.toString());
                faceHelper = new FaceHelper.Builder()
                        .faceEngine(mFaceEngine)
                        .frThreadNum(MAX_DETECT_NUM)
                        .previewSize(previewSize)
                        .faceListener(faceListener)
                        .currentTrackId(ConfigUtil.getTrackId(getActivity().getApplicationContext()))
                        .build();
            }


            /**
             * 修改了判断，先判断有没有人脸 最后在判断在不在区域内
             * @param nv21
             * @param camera 相机实例
             */
            @Override
            public void onPreview(final byte[] nv21, Camera camera) {
                mFaceRectView.clearFaceInfo();
                if (!mFaceDecting)
                    return;
                List<FacePreviewInfo> facePreviewInfoList = faceHelper.onPreviewFrame(nv21);
                if (facePreviewInfoList != null && mFaceRectView != null && drawHelper != null) {
                    drawPreviewInfo(facePreviewInfoList);
                }
                clearLeftFace(facePreviewInfoList);
                if (facePreviewInfoList != null && facePreviewInfoList.size() > 0 && facePreviewInfoList.get(0).getLivenessInfo().getLiveness() == LivenessInfo.ALIVE) {
//                    setUI(true);
                    notface = 0;
                    if (isFaceinRect(facePreviewInfoList)) {
                        if (frames == 0) {
                            startDectTime = System.currentTimeMillis();
                        }
                        frames++;
//                        Log.e("TagSnake", "人脸在指定区域内 frame " + frames);
                        if (frames >= 4) {
                         /*   if(!mFaceAuthTimerDialog.isShowing()) {
                            mFaceAuthTimerDialog.show();
                        }*/
                            faceHelper.requestFaceFeature(nv21, facePreviewInfoList.get(0).getFaceInfo(), previewSize.width, previewSize.height, FaceEngine.CP_PAF_NV21, facePreviewInfoList.get(0).getTrackId());
                        }
                    }

                } else {
                    frames = 0;
//                    Log.e("TagSnake", "不在人脸在指定区域内 frame " + frames);
//                    notface++;
//                    if (notface > 100)
//                        setUI(false);
                    //mFaceAuthTimerDialog.dismiss();
                }

             /*   if (facePreviewInfoList != null && facePreviewInfoList.size() > 0 && previewSize != null) {
                    for (int i = 0; i < facePreviewInfoList.size(); i++) {
                        livenessMap.put(facePreviewInfoList.get(i).getTrackId(), facePreviewInfoList.get(i).getLivenessInfo().getLiveness());
                        if (requestFeatureStatusMap.get(facePreviewInfoList.get(i).getTrackId()) == null
                                || requestFeatureStatusMap.get(facePreviewInfoList.get(i).getTrackId()) == RequestFeatureStatus.FAILED) {
                            requestFeatureStatusMap.put(facePreviewInfoList.get(i).getTrackId(), RequestFeatureStatus.SEARCHING);
//                            Log.i(TAG, "onPreview: fr start = " + System.currentTimeMillis() + " trackId = " + facePreviewInfoList.get(i).getTrackId());
                        }
                    }
                }*/
            }

            @Override
            public void onCameraClosed() {
                Log.i(TAG, "onCameraClosed: ");
            }

            @Override
            public void onCameraError(Exception e) {
                Log.i(TAG, "onCameraError: " + e.getMessage());
            }

            @Override
            public void onCameraConfigurationChanged(int cameraID, int displayOrientation) {
                if (drawHelper != null) {
                    drawHelper.setCameraDisplayOrientation(displayOrientation);
                }
                Log.i(TAG, "onCameraConfigurationChanged: " + cameraID + "  " + displayOrientation);
            }
        };

        cameraHelper = new CameraHelper.Builder()
                .previewViewSize(new Point(mPreview.getWidth(), mPreview.getHeight()))
                .rotation(getActivity().getWindowManager().getDefaultDisplay().getRotation())
                .specificCameraId(rgbCameraID != null ? rgbCameraID : Camera.CameraInfo.CAMERA_FACING_FRONT)
                .isMirror(mIsMirror)
                .previewOn(mPreview)
                .cameraListener(cameraListener)
                .build();
        cameraHelper.init();
        isCameraInit = true;
        cameraHelper.start();
    }
    private void drawPreviewInfo(List<FacePreviewInfo> facePreviewInfoList) {
        List<DrawInfo> drawInfoList = new ArrayList<>();
        for (int i = 0; i < facePreviewInfoList.size(); i++) {
            String name = faceHelper.getName(facePreviewInfoList.get(i).getTrackId());
            Integer liveness = facePreviewInfoList.get(0).getLivenessInfo().getLiveness();
            drawInfoList.add(new DrawInfo(drawHelper.adjustRect(facePreviewInfoList.get(i).getFaceInfo().getRect()), GenderInfo.UNKNOWN, AgeInfo.UNKNOWN_AGE,
                    name == null ? String.valueOf(facePreviewInfoList.get(i).getTrackId()) : name));
        }
        drawHelper.draw(mFaceRectView, drawInfoList);
    }

    /**
     * 删除已经离开的人脸
     *
     * @param facePreviewInfoList 人脸和trackId列表
     */
    private void clearLeftFace(List<FacePreviewInfo> facePreviewInfoList) {
        Set<Integer> keySet = requestFeatureStatusMap.keySet();
        if (facePreviewInfoList == null || facePreviewInfoList.size() == 0) {
            requestFeatureStatusMap.clear();
            livenessMap.clear();
            return;
        }

        for (Integer integer : keySet) {
            boolean contained = false;
            for (FacePreviewInfo facePreviewInfo : facePreviewInfoList) {
                if (facePreviewInfo.getTrackId() == integer) {
                    contained = true;
                    break;
                }
            }
            if (!contained) {
                requestFeatureStatusMap.remove(integer);
                livenessMap.remove(integer);
            }
        }

    }

    private boolean isFaceinRect(List<FacePreviewInfo> tracedFaces) {
        boolean ret = false;

        // 计算中间区域
        int areaWidth = mIvRect.getWidth();
        int areaHeight = mIvRect.getHeight();
        float heightRatio = mPreview.getHeight() * 1f / cameraHelper.getRealPreviewSize().height;//预览的OpenGLView 按高度适配
        float widthRatio = mPreview.getWidth() * 1f / cameraHelper.getRealPreviewSize().width;//预览的OpenGLView 按高度适配

        int rectLeft = (int) ((mFaceRectView.getWidth()) / 2 - areaWidth / 2);
        int rectRight = (int) ((mFaceRectView.getWidth()) / 2 + areaWidth / 2);
        int rectTop = (int) ((mFaceRectView.getHeight()) / 2 - areaHeight / 2);
        int rectBottom = (int) ((mFaceRectView.getHeight()) / 2 + areaHeight / 2);

        int top = (int) (tracedFaces.get(0).getFaceInfo().getRect().top * heightRatio);
        int bottom = (int) (tracedFaces.get(0).getFaceInfo().getRect().bottom * heightRatio);
        int left = (int) (tracedFaces.get(0).getFaceInfo().getRect().left * widthRatio);
        int right = (int) (tracedFaces.get(0).getFaceInfo().getRect().right * widthRatio);

        if (top >= rectTop && bottom <= rectBottom && left >= rectLeft && right <= rectRight)
            ret = true;
        else
            ret = false;

/*        Log.d(TAG,"rect is top:" + rectTop + ";bottom:"+rectBottom+";left:"+rectLeft+";right:"+rectRight+"; \n"
                + "face is top:"+top+";bottom:"+bottom+";left:"+left+";right:"+right);*/
        return ret;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (!isCameraInit)
                cameraHelper.start();
        } else {
            //相当于Fragment的onPause
            cameraHelper.stop();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            cameraHelper.stop();
            return;
        } else {  // 在最前端显示 相当于调用了onResume();
            if (!isCameraInit)
                cameraHelper.start();
        }
    }


    public void goContinueDetectFace() {
        mFaceDecting = true;
    }



}
