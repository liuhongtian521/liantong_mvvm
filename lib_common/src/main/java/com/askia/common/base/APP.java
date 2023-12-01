package com.askia.common.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.askia.common.util.BuglyUtils;
import com.askia.common.util.ScreenUtil;
import com.askia.coremodel.datamodel.database.repository.SharedPreUtil;
import com.askia.coremodel.datamodel.http.entities.HisMsgData;
import com.askia.coremodel.datamodel.http.entities.TimeLisData;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.liulishuo.filedownloader.FileDownloader;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 *
 * @name APP
 */
public class APP extends TinkerApplication {
    private boolean isBackGround = true;
    private TimeLisData timeLisData;

    public APP() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.askia.common.base.APPLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }


    public TimeLisData getTimeLisData() {
        if (timeLisData == null)
            return null;
        else
            return timeLisData;
    }

    public void setTimeLisData(TimeLisData timeLisData) {
        this.timeLisData = timeLisData;
    }

    public static boolean mBugly = false;

    @Override
    public void onCreate() {
        super.onCreate();
        com.askia.common.util.Utils.init(this);
        registerActivityLifeCallback();
        // logUtil init
        Utils.init(this);
        // 文件下载
        FileDownloader.setup(this);



/*        com.blankj.utilcode.util.LogUtils.getConfig().setLogHeadSwitch(false).setBorderSwitch(false).setLogSwitch(
                true).setLog2FileSwitch(false);*/

        com.blankj.utilcode.util.LogUtils.getConfig().setLogHeadSwitch(false).setBorderSwitch(false).setLogSwitch(
                true).setLog2FileSwitch(true).setDir("/mnt/sdcard/consumeLog");

        ToastUtils.setBgColor(Color.DKGRAY);
        ToastUtils.setMsgColor(Color.WHITE);


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    private void registerActivityLifeCallback() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (isBackGround) {
                    ScreenUtil.hideBottomUIMenu(getApplicationContext());
                    isBackGround = false;
                    LogUtils.i("APP回到了前台");
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        if (level == TRIM_MEMORY_UI_HIDDEN) {
            isBackGround = true;
            ScreenUtil.showBottomUIMenu(getApplicationContext());
            LogUtils.d("进入后台");
        }
    }
}
