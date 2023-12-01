package com.askia.coremodel.datamodel.database.repository;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.askia.coremodel.datamodel.database.db.UserLoginData;
import com.askia.coremodel.util.DeviceUtils;

import static com.tencent.bugly.beta.tinker.TinkerManager.getApplication;

public class DBRepository {

    public static void init(Context context) {
        SharedPreUtil.initSharedPreference(context);
    }

    //学校id赋值
    public static void SetSchoolId(String id){
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setSchoolId(id);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //查询用户登陆信息
    public static UserLoginData QueryUserLoginData() {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        if (userLoginData == null) {
            userLoginData = new UserLoginData();
            userLoginData.setDeviceRooted(DeviceUtils.isDeviceRooted());
            userLoginData.setDevMac(DeviceUtils.getMacAddress());
            userLoginData.setDevModel(DeviceUtils.getModel());
            userLoginData.setShowWelcomPage(true);
            userLoginData.setManufacturer(DeviceUtils.getManufacturer());
            userLoginData.setSDKVersionName(DeviceUtils.getSDKVersionName());
            try {
                userLoginData.setIMEINum(DeviceUtils.getIMEI());
                userLoginData.setVersionNum(getApplication().getPackageManager().getPackageInfo(
                        getApplication().getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            userLoginData.setPhoneNum(DeviceUtils.getPhoneNum());
            userLoginData.setUserPwd("");
            userLoginData.setToken("");
            StoreUserLoginData(userLoginData);
        }
        return userLoginData;
    }

    //保存用户登陆信息
    public static void StoreUserLoginData(UserLoginData userLoginData) {
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //设置是否显示欢迎页面
    public static void SetShowWelcomPage(boolean show) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setShowWelcomPage(show);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    public static void SetShowWelcomPageAndVersionNum(boolean show, String versionNum) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setShowWelcomPage(show);
        userLoginData.setVersionNum(versionNum);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //更新用户名密码
    public static void UpdateUserNumAndPwd(String phoneNum, String passWord) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setPhoneNum(phoneNum);
        userLoginData.setUserPwd(passWord);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //更新用户名密码
    public static void UpdateUserPwd(String passWord) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setUserPwd(passWord);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //更新用户身份
  /*  public static void UpdateUserType(User.DataBean dataBean) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setType(dataBean.getType());
        userLoginData.setTeacherName(dataBean.getTeacherName());
        userLoginData.setTeacherPhone(dataBean.getTeacherPhone());
        userLoginData.setClassId(dataBean.getClassId());
        if (TextUtils.equals(dataBean.getType(), "2")) { //教师
            userLoginData.setUserName(dataBean.getTeacherName());
        } else {
            userLoginData.setUserName(dataBean.getStudentName());
        }
        SharedPreUtil.getInstance().putUser(userLoginData);
    }*/

    //设置接口服务器url
    public static void SetApiUrl(String url) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setApiUrl(url);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //设置宿舍id
    public static void setDormId(String id) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setDormId(id);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //设置宿舍code
    public static void setDormCode(String id) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setDormCode(id);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //设置宿舍名称
    public static void setDormName(String name) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setDormName(name);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //设置教室id
    public static void setClassroomId(String classId) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setClassroomId(classId);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    //设置班级名称
    public static void setClassName(String name, String id) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setClassName(name);
        userLoginData.setClassId(id);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }

    // 设置首页布局类型
    public static void setHomeLayoutType(int type) {
        UserLoginData userLoginData = SharedPreUtil.getInstance().getUser();
        userLoginData.setHomeLayoutType(type);
        SharedPreUtil.getInstance().putUser(userLoginData);
    }
}
