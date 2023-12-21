package com.zdy.study.uitls;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;


import com.zdy.study.BuildConfig;
import com.zdy.study.widgets.CommonMessageTipsDialog;
import com.zdy.study.widgets.CommonPrgressDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @describe Update Checker
 * @date 2023-06-06
 */
public final class UpdateChecker {
    public static final String APP_CHECK = "https://www.pgyer.com/apiv2/app/check";
    public String _api_key = "";
    private Context context;

    /**
     * @param _api_key 蒲公英 api key
     */
    public UpdateChecker(String _api_key, Context context) {
        this._api_key = _api_key;
        this.context = context;
    }

    /**
     * 检测App是否有更新
     * @see <a href="https://www.pgyer.com/doc/view/api#appUpdate">https://www.pgyer.com/doc/view/api#appUpdate</a>
     *
     * @param appKey appKey
     * @param buildVersion (选填)使用 App 本身的 Build 版本号，Android 对应字段为 versionname, iOS 对应字段为 version
     * @param buildBuildVersion (选填)使用蒲公英生成的自增 Build 版本号
     * @param channelKey (选填)渠道KEY
     * @param callback 结果回调
     */
    public void check(String appKey, String buildVersion, Integer buildBuildVersion, String channelKey, Callback callback) {
        Map<String, String> data = new HashMap<>();

        data.put("_api_key", _api_key);
        data.put("appKey", appKey);
        data.put("buildVersion", buildVersion == null ? "" : buildVersion);
        data.put("buildBuildVersion", buildBuildVersion == null ? "" : (buildBuildVersion + ""));
        data.put("channelKey", channelKey == null ? "" : channelKey);

        Log.i("DOWNLOAD",data.toString());

        Http.post(APP_CHECK, data, new Http.Callback() {
            @Override
            public Boolean response(String response) {
                Map<String, String> dataMap = parseResponse(response);
                if (dataMap == null) {
                    callback.error("response no data");
                    return false;
                }

                if (dataMap.containsKey("message")) {
                    callback.error(dataMap.get("message"));
                    return false;
                }

                UpdateInfo updateInfo = new UpdateInfo();
                updateInfo.buildBuildVersion = Integer.parseInt(dataMap.get("buildBuildVersion"));
                updateInfo.forceUpdateVersion = dataMap.get("forceUpdateVersion");
                updateInfo.forceUpdateVersionNo = dataMap.get("forceUpdateVersionNo");
                updateInfo.needForceUpdate = dataMap.get("needForceUpdate").equals("true");
                updateInfo.downloadURL = dataMap.get("downloadURL");
                updateInfo.buildHaveNewVersion = dataMap.get("buildHaveNewVersion").equals("true");
                updateInfo.buildVersionNo = dataMap.get("buildVersionNo");
                updateInfo.buildVersion = dataMap.get("buildVersion");
                updateInfo.buildShortcutUrl = dataMap.get("buildShortcutUrl") == null ? "" : dataMap.get("buildShortcutUrl");
                updateInfo.buildUpdateDescription = unicodeDecode(dataMap.get("buildUpdateDescription"));
                callback.result(updateInfo);
                if (BuildConfig.VERSION_CODE < Integer.parseInt(updateInfo.buildVersionNo)) {
                    Message msg = myHandler.obtainMessage();
                    msg.what = 0; //消息标识
                    msg.obj = updateInfo;
                    myHandler.sendMessage(msg); //发送消息
                }
                return true;
            }

            @Override
            public void error(String message) {
                callback.error(message);
            }
        });
    }

    /**
     * @Title: unicodeDecode
     * @Description: unicode解码
     * @param string
     * @return
     */
    public static String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }

    private Map<String, String> parseResponse(String response) {
        Map<String, String> responseMap = new HashMap<>();
        String responseRegexp = "^\\{\"code\":(.*),\"message\":\"(.*?)\".*\\}$";
        Pattern responsePattern = Pattern.compile(responseRegexp);
        Matcher responseMatcher = responsePattern.matcher(response);

        if (responseMatcher.find()) {
            responseMap.put("code", responseMatcher.group(1));
            responseMap.put("message", responseMatcher.group(2));
        } else {
            return null;
        }

        String data = "";
        String responseDataRegexp = "^\\{\"code\":.*,\"message\":\".*\",\"data\":(.*)\\}$";
        Pattern responseDataPattern = Pattern.compile(responseDataRegexp);
        Matcher responseDataMatcher = responseDataPattern.matcher(response);

        if (responseDataMatcher.find()) {
            data = responseDataMatcher.group(1);
        } else {
            return responseMap;
        }

        Map<String, String> dataMap = new HashMap<>();
        String dataRegexp = "\"(.*?)\":(\".*?\"|true|false)";
        Pattern dataPattern = Pattern.compile(dataRegexp);
        Matcher dataMatcher = dataPattern.matcher(data);

        while (dataMatcher.find()) {
            String key = dataMatcher.group(1);
            String value = dataMatcher.group(2);
            if (value.equals("true") || value.equals("false")) {
                dataMap.put(key, value);
            } else {
                dataMap.put(key, value.substring(1, value.length() - 1));
            }
        }

        return dataMap;
    }

    public class UpdateInfo {
        /** 蒲公英生成的用于区分历史版本的build号 */
        public Integer buildBuildVersion = 0;
        /** 强制更新版本号（未设置强置更新默认为空） */
        public String forceUpdateVersion = "";
        /** 强制更新的版本编号 */
        public String forceUpdateVersionNo = "";
        /** 是否强制更新 */
        public Boolean needForceUpdate = false;
        /** 应用安装地址 */
        public String downloadURL = "";
        /** 是否有新版本 */
        public Boolean buildHaveNewVersion = false;
        /** 上传包的版本编号，默认为1 (即编译的版本号，一般来说，编译一次会变动一次这个版本号, 在 Android 上叫 Version Code。对于 iOS 来说，是字符串类型；对于 Android 来说是一个整数。例如：1001，28等。) */
        public String buildVersionNo = "";
        /** 版本号, 默认为1.0 (是应用向用户宣传时候用到的标识，例如：1.1、8.2.1等。) */
        public String buildVersion = "";
        /** 应用短链接 */
        public String buildShortcutUrl = "";
        /** 应用更新说明 */
        public String buildUpdateDescription = "";
    }

    public interface Callback {
        public void result(UpdateInfo updateInfo);
        public void error(String message);
    }

    private static class Http {
        private static final Integer TIMEOUT = 3000;
        private static final String BOUNDARY = UUID.randomUUID().toString();

        public static void get(String url, Map<String, String> query, Callback callback) {
            request(url, "GET", query, null, callback);
        }

        public static void post(String url, Map<String, String> data, Callback callback) {
            request(url, "POST", null, data, callback);
        }

        public static void request(String url, String method, Map<String, String> query, Map<String, String> data, Callback callback) {
            new Thread(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    try {
                        String queryString = "";
                        if (method.equals("GET") && query != null) {
                            queryString = makeQueryString(query);
                        }

                        HttpURLConnection connection = (HttpURLConnection) new URL(url + "?" + queryString).openConnection();
                        connection.setRequestMethod(method);
                        connection.setUseCaches(false);
                        connection.setConnectTimeout(TIMEOUT);
                        connection.setReadTimeout(TIMEOUT);
                        Log.i("DOWNLOAD","111");
                        if (method.equals("POST") && data != null) {
                            connection.setDoInput(true);
                            connection.setDoOutput(true);
                            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
                            connection.setRequestProperty("Accept", "application/json");

                            OutputStream outputStream = connection.getOutputStream();
                            outputStream.write(makeFormData(data).getBytes());
                            outputStream.close();
                        }

                        connection.connect();
                        int responseCode = connection.getResponseCode();
                        Log.i("DOWNLOAD","code="+responseCode);
                        if (responseCode == 200) {
                            String response = readResponse(connection);
                            Log.i("DOWNLOAD","response="+response);
                            callback.response(response);
                        } else {
                            callback.error("Status Code " + responseCode);
                        }
                        connection.disconnect();
                    } catch (Exception e) {
                        callback.error(e.getMessage());
                    }
                }
            }).start();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private static String makeQueryString(Map<String, String> query) {
            List<String> list = new ArrayList(0);
            for (String key: query.keySet()) {
                list.add(key + "=" + query.get(key));
            }
            return String.join("&", list);
        }

        private static String makeFormData(Map<String, String> data) {
            StringBuilder formData = new StringBuilder();;
            for (String key: data.keySet()) {
                formData.append(String.format("--%s\r\n", BOUNDARY));
                formData.append(String.format("Content-Disposition: form-data; name=\"%s\"\r\n", key));
                formData.append("\r\n");
                formData.append(String.format("%s\r\n", data.get(key)));
            }
            formData.append(String.format("--%s--\r\n", BOUNDARY));
            return formData.toString();
        }

        private static String readResponse(HttpURLConnection connection) {
            try {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[256];
                int readLength = 0;

                while ((readLength = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, readLength);
                }

                String response = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
                inputStream.close();
                outputStream.close();
                return response;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        public interface Callback {
            public Boolean response(String response);
            public void error(String message);
        }
    }

    String filename = "/zdy.apk";
    Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0:
                    UpdateInfo updateInfo = (UpdateInfo) msg.obj;
                    upLoadTipsDialog("更新提示",
                            "更新版本："+updateInfo.buildVersion,
                                    updateInfo.buildUpdateDescription,
                            updateInfo.downloadURL);
                    break;
                case 1:
                    //更新UI等
                    mCommonPrgressDialog.setProgress(msg.arg1);
                    break;
                case 2:
                    //更新UI等
                    mCommonPrgressDialog.dismiss();
//                    Toast.makeText(reactContext, "下载完成", Toast.LENGTH_SHORT).show();
//
                    File apk = new File(context.getExternalCacheDir()+filename);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri uri = FileProvider.getUriForFile(context, "com.zdy.study.fileprovider", apk);
                    intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

    public void downloadFile1(String url) {
        try{
            //下载路径，如果路径无效了，可换成你的下载路径
            final long startTime = System.currentTimeMillis();
            Log.i("DOWNLOAD","startTime="+startTime);
            //下载函数
//            filename = timeSeconds+"zdy.apk";
            //获取文件名
            URL myURL = new URL(url);
            URLConnection conn = myURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            int fileSize = conn.getContentLength();//根据响应获取文件大小
            if (fileSize <= 0) throw new RuntimeException("无法获知文件大小 ");
            if (is == null) throw new RuntimeException("stream is null");
            File file1 = context.getExternalCacheDir();
            Log.i("DOWNLOAD",context.getExternalCacheDir().toString());
            if(!file1.exists()){
                file1.mkdirs();
            }
            //把数据存入路径+文件名
            FileOutputStream fos = new FileOutputStream(file1+filename);
            byte buf[] = new byte[1024];
            int downLoadFileSize = 0;
            do{
                //循环读取
                int numread = is.read(buf);
                if (numread == -1)
                {
                    break;
                }
                fos.write(buf, 0, numread);
                downLoadFileSize += numread;

                DecimalFormat df=new DecimalFormat("0.00");//设置保留位数

                String ss = df.format((float)downLoadFileSize/fileSize);
//                Log.i("DOWNLOAD","download "+ss+"%");
                Message msg = myHandler.obtainMessage();
                msg.what = 1; //消息标识
                msg.arg1 = (int) (Double.parseDouble(ss)*100);
                myHandler.sendMessage(msg); //发送消息
                //更新进度条
            } while (true);
            Message msg = myHandler.obtainMessage();
            msg.what = 2; //消息标识
            myHandler.sendMessage(msg); //发送消息
            Log.i("DOWNLOAD","download success");
            Log.i("DOWNLOAD","totalTime="+ (System.currentTimeMillis() - startTime));

            is.close();
        } catch (Exception ex) {
            Log.e("DOWNLOAD", "error: " + ex.getMessage(), ex);
        }
    }

    private CommonMessageTipsDialog commonMessageTipsDialog;
    private CommonPrgressDialog mCommonPrgressDialog;

    private void upLoadTipsDialog(String title, String content, String buildUpdateDescription, String url){
        if (commonMessageTipsDialog == null) {
            commonMessageTipsDialog = new CommonMessageTipsDialog(context);
            mCommonPrgressDialog = new CommonPrgressDialog(context);
        }
        if (!commonMessageTipsDialog.isShowing())
            commonMessageTipsDialog.setTitle(title)
                    .setMainContent("是否确认更新？")
                    .setSubContent(content)
                    .setUpdateDescription(buildUpdateDescription)
                    .setConfirm("确认", dialog -> {
                        commonMessageTipsDialog.dismiss();
                        if (!"".equals(url))
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    downloadFile1(url);
                                }
                            }).start();
                        mCommonPrgressDialog.setDes("更新下载进度");
                        mCommonPrgressDialog.setProgress(0);
                        mCommonPrgressDialog.show();
                    })
                    .setCancel("取消", dialog -> { })
                    .show();
    }
}