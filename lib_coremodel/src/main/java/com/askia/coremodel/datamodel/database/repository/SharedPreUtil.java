package com.askia.coremodel.datamodel.database.repository;

import java.io.IOException;
import java.io.StreamCorruptedException;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.askia.coremodel.datamodel.database.db.UserLoginData;
import com.askia.coremodel.datamodel.http.entities.ConsumeRecordData;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeBannerBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.blankj.utilcode.util.LogUtils;

public class SharedPreUtil {

    // 用户名key
    public final static String KEY_NAME = "KEY_NAME";

    public final static String KEY_NAME_TV = "KEY_NAME_TV";
    public final static String KEY_INFO_TV = "KEY_INFO_TV";

    public final static String KEY_LEVEL = "KEY_LEVEL";

    // url
    public final static String KEY_URL = "KEY_URL";

    public final static String CONSUME_CONFIG = "CONSUME_CONFIG";
    public final static String CONSUME_BANNER = "CONSUME_BANNER";
    public final static  String  TRANSMIT_CODE="TRANSMIT_CODE";//  transmitCode
    public final static String SHOWFACEMSG = "SHOW_FACE_MESSAGE";
    public final static String DIRECTION = "SHOW_FACE_DIRECTION";
    public final static String USERNAME = "USERNAME";
    public final static String PASSWORD = "PASSWORD";
    public final static String CaptchaKey = "Captcha-Key";
    public final static String Captchacode = "Captcha-code";



    // 离线模式
    public final static String OFFLINE_MODEL = "OFFLINE_MODEL";



    // zip包时间戳
    public final static String KEY_ZIP_TIMESTAMP = "KEY_ZIP_TIMESTAMP";

    private static SharedPreUtil s_SharedPreUtil;

    private static UserLoginData s_User = null;
    //登录信息
    private static HttpLoginResult s_TVUser = null;
    //用户信息
    private static UserInfoBean userInfo = null;

    private static HttpConsumeConfigBean.ResultBean sConsumeConfig = null;
    private static HttpConsumeBannerBean sConsumeBannerBean = null;

    private SharedPreferences msp;

    // 初始化，一般在应用启动之后就要初始化
    public static synchronized void initSharedPreference(Context context) {
         if (s_SharedPreUtil == null) {
            s_SharedPreUtil = new SharedPreUtil(context);
        }
    }

    /**
     * 获取唯一的instance
     *
     * @return
     */
    public static synchronized SharedPreUtil getInstance() {

        return s_SharedPreUtil;
    }

    public synchronized boolean getDirection() {
        boolean str = msp.getBoolean(SharedPreUtil.DIRECTION, true);
        Log.e("TagSnake", str + ":SharedPreUtil.DIRECTION");
        return str;
    }

    public synchronized void setDirection(boolean direction) {
        Editor editor = msp.edit();
        editor.putBoolean(DIRECTION, direction);
        editor.commit();
    }
    private SharedPreUtil(Context context) {
        msp = context.getSharedPreferences("SharedPreUtil",
                Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPref() {
        return msp;
    }


    public synchronized void setOfflineModel(Boolean isOpen) {
        Editor editor = msp.edit();
        if(isOpen)
        {
            LogUtils.d("开启离线模式");
        }
        else
        {
            LogUtils.d("关闭离线模式");
        }
        editor.putBoolean(OFFLINE_MODEL, isOpen);
        editor.commit();
    }

    public synchronized Boolean getOfflineModel() {
        Boolean str = msp.getBoolean(SharedPreUtil.OFFLINE_MODEL, false);
       // LogUtils.d("获取是否开启离线模式 " + str);
        return str;
    }


    public synchronized void putZipTimestamp(String timestamp) {
        Editor editor = msp.edit();
        LogUtils.d("put zip time stamp " + timestamp);
        editor.putString(KEY_ZIP_TIMESTAMP, timestamp);
        editor.commit();
    }

    public synchronized String getZipTimestamp() {
        String str = msp.getString(SharedPreUtil.KEY_ZIP_TIMESTAMP, "");
        LogUtils.d("get zip time stamp " + str);
        return str;
    }

    public synchronized void putTransmitCode(String transmitCode){
        Editor editor = msp.edit();
        editor.putString(TRANSMIT_CODE, transmitCode);
        editor.commit();
    }

    public synchronized String getTransmitCode() {
        String str = msp.getString(SharedPreUtil.TRANSMIT_CODE, "");
        return str;
    }

    public synchronized void putUser(UserLoginData user) {

        Editor editor = msp.edit();

        String str = "";
        try {
            str = SerializableUtil.obj2Str(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString(KEY_NAME, str);
        editor.commit();

        s_User = user;
    }

    public synchronized void putTVUserInfo(UserInfoBean userinfo) {

        Editor editor = msp.edit();

        String str = "";
        try {
            str = SerializableUtil.obj2Str(userinfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString(KEY_INFO_TV, str);
        editor.commit();

        userInfo = userinfo;
    }

    public synchronized UserInfoBean getTVUserInfo() {

        if (userInfo == null) {
            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.KEY_INFO_TV, "");

            try {
                Object obj = SerializableUtil.str2Obj(str);
                if (obj != null) {
                    userInfo = (UserInfoBean) obj;
                }

            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userInfo;
    }
    public synchronized void putTVUser(HttpLoginResult user) {

        Editor editor = msp.edit();

        String str = "";
        try {
            str = SerializableUtil.obj2Str(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString(KEY_NAME_TV, str);
        editor.commit();

        s_TVUser = user;
    }
    public synchronized HttpLoginResult getTVUser() {

        if (s_TVUser == null) {
            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.KEY_NAME_TV, "");

            try {
                Object obj = SerializableUtil.str2Obj(str);
                if (obj != null) {
                    s_TVUser = (HttpLoginResult) obj;
                }

            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return s_TVUser;
    }
    /*public synchronized String getUserName(){
        String str = msp.getString(SharedPreUtil.USERNAME,"");
        return str;
    }

    public synchronized void setUsername(String userName) {
        Editor editor = msp.edit();
        editor.putString(USERNAME, userName);
        editor.commit();
    }

    public synchronized String getPassword(){
        String str = msp.getString(SharedPreUtil.PASSWORD,"");
        return str;
    }

    public synchronized void setPassword(String psw) {
        Editor editor = msp.edit();
        editor.putString(PASSWORD, psw);
        editor.commit();
    }*/


    public synchronized boolean getShowFaceMsg(){
        boolean str = msp.getBoolean(SharedPreUtil.SHOWFACEMSG, true);
        return str;
    }

    public synchronized void putShowFaceMsg(boolean canGet) {
        Editor editor = msp.edit();
        editor.putBoolean(SHOWFACEMSG, canGet);
        editor.commit();
    }

    public synchronized UserLoginData getUser() {

        if (s_User == null) {
            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.KEY_NAME, "");

            try {
                Object obj = SerializableUtil.str2Obj(str);
                if (obj != null) {
                    s_User = (UserLoginData) obj;
                }

            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return s_User;
    }

    public synchronized void putConsumeBannerBean(HttpConsumeBannerBean bean) {
        Editor editor = msp.edit();
        String str = "";
        try {
            str = SerializableUtil.obj2Str(bean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString(CONSUME_BANNER, str);
        editor.commit();

        sConsumeBannerBean = bean;
    }

    public synchronized HttpConsumeBannerBean getConsumeBannerBean() {

        if (sConsumeBannerBean == null) {
            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.CONSUME_BANNER, "");

            try {
                Object obj = SerializableUtil.str2Obj(str);
                if (obj != null) {
                    sConsumeBannerBean = (HttpConsumeBannerBean) obj;
                }

            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sConsumeBannerBean;
    }

    public synchronized void putConsumeConfig(HttpConsumeConfigBean.ResultBean bean) {

        Editor editor = msp.edit();

        String str = "";
        try {
            str = SerializableUtil.obj2Str(bean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString(CONSUME_CONFIG, str);
        editor.commit();

        sConsumeConfig = bean;

    }

    public synchronized HttpConsumeConfigBean.ResultBean getConsumeConfig() {

        if (sConsumeConfig == null) {
            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.CONSUME_CONFIG, "");
            try {
                Object obj = SerializableUtil.str2Obj(str);
                if (obj != null) {
                    sConsumeConfig = (HttpConsumeConfigBean.ResultBean) obj;
                }

            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sConsumeConfig;
    }

    public synchronized void DeleteUser() {
        Editor editor = msp.edit();
        editor.putString(KEY_NAME, "");

        editor.commit();
        s_User = null;
    }

    public synchronized void putCaptchaKey(String transmitCode){
        Editor editor = msp.edit();
        editor.putString(CaptchaKey, transmitCode);
        editor.commit();
    }

    public synchronized String getCaptchaKey() {
        String str = msp.getString(SharedPreUtil.CaptchaKey, "");
        return str;
    }

    public synchronized void putCaptchacode(String transmitCode){
        Editor editor = msp.edit();
        editor.putString(Captchacode, transmitCode);
        editor.commit();
    }

    public synchronized String getCaptchacode() {
        String str = msp.getString(SharedPreUtil.Captchacode, "");
        return str;
    }

}