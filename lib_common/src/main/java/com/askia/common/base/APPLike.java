package com.askia.common.base;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.askia.common.BuildConfig;
import com.askia.common.util.BuglyUtils;
import com.askia.common.util.Fresco_ImagePipelineConfigUtil;
import com.askia.common.util.Utils;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.loader.app.DefaultApplicationLike;


public class APPLike extends DefaultApplicationLike {

    public static final String TAG = "Tinker.MyApplicationLike";


    public APPLike(Application application, int tinkerFlags,
                   boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime,
                   long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }
    public class CrashHandler implements Thread.UncaughtExceptionHandler {
        @Override

        public void uncaughtException(Thread t, Throwable e) {
            ProcessPhoenix.triggerRebirth(getApplication());
        }

    }


    @Override
    public void onCreate() {
        super.onCreate();
        if (ProcessPhoenix.isPhoenixProcess(getApplication())) {
            return;
        }
        CrashHandler crashHandler = new CrashHandler();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        final Application sInstance = getApplication();
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId

        //初始化工具类
        Utils.init(sInstance);
        //初始化Arouter
        //注：一定要写在router init() 前面
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
            //初始化LOG
            LogUtils.getLogConfig()
                    .configAllowLog(true)
                    .configTagPrefix("askia")
                    .configShowBorders(false)
                    .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}");

        }
        ARouter.init(sInstance);
        //Fresco初始化
        Fresco.initialize(sInstance, Fresco_ImagePipelineConfigUtil.getDefaultImagePipelineConfig(sInstance));
        //二维码扫描初始化
        //ZXingLibrary.initDisplayOpinion(sInstance);
        //DB 初始化
        DBRepository.init(sInstance);
        //悬浮窗
/*        Button button = new Button(sInstance);
        button.setBackgroundColor(Color.TRANSPARENT);
        FloatWindow
                .with(sInstance)
                .setView(button)
                .setWidth(1) //设置悬浮控件宽高
                .setHeight(1)
                .setX(Screen.width, 0f)
                .setY(Screen.height, 0f)
                .setPermissionListener(mPermissionListener)
                .setDesktopShow(true)
                .setMoveType(MoveType.inactive, 100, -100)
                .setMoveStyle(500, new BounceInterpolator())
                .build();*/

        // 调试时，将第三个参数改为true
        if (DBRepository.QueryUserLoginData() == null || DBRepository.QueryUserLoginData().getSchoolId() == null || DBRepository.QueryUserLoginData().getSchoolId().equals("")) {
            BuglyUtils.init(sInstance, null);
        } else {
            BuglyStrategy buglyStrategy = new BuglyStrategy();
            buglyStrategy.setAppChannel(DBRepository.QueryUserLoginData().getSchoolId());
            Log.e("TagSnake appid", DBRepository.QueryUserLoginData().getSchoolId());
            BuglyUtils.init(sInstance, buglyStrategy);
        }
    }

   /* private PermissionListener mPermissionListener = new PermissionListener() {
        @Override
        public void onSuccess() {
            if (!FloatWindow.get().isShowing()) {
                try {
                    FloatWindow.get().show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void onFail() {
        }
    };*/

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // 安装tinker
        // TinkerManager.installTinker(this); 替换成下面Bugly提供的方法
        Beta.installTinker(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }

}