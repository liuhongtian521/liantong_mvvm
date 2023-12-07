package com.askia.common.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.askia.common.util.Utils;
import com.askia.common.widget.CountDownText;
import com.blankj.utilcode.util.LogUtils;
import com.yanyusong.y_divideritemdecoration.Dp2Px;

import java.lang.reflect.Method;
public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    private View mRootView;
    private CountDownText mCountDownText;

    private View focusView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 初始化viewmodel
        onInitViewModel();
        // 初始化databing 绑定布局
        mRootView = onInitDataBinding(inflater, container);
        // 初始化其他
        onInit();
        // 订阅viewmodel 数据变动事件
        onSubscribeViewModel();
        if (hasNavBar(getActivity())) {
            hideBottomUIMenu();
        }
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (hasNavBar(getActivity())) {
            hideBottomUIMenu();
        }
    }

    public abstract void onInit();

    public abstract void onInitViewModel();

    public abstract View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    public abstract void onSubscribeViewModel();


    /**
     * 获取宿主Activity
     *
     * @return BaseActivity
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }


    /**
     * 添加fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void addFragment(BaseFragment fragment, @IdRes int frameId) {
        Utils.checkNotNull(fragment);
        getHoldingActivity().addFragment(fragment, frameId);

    }
    /**
     * 判断虚拟按键栏是否重写
     *
     * @return
     */
    private static String getNavBarOverride() {
        String sNavBarOverride = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                Class c = Class.forName("android.os.SystemProperties");
                Method m = c.getDeclaredMethod("get", String.class);
                m.setAccessible(true);
                sNavBarOverride = (String) m.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable e) {
            }
        }
        return sNavBarOverride;
    }

    /**
     * 检查是否存在虚拟按键栏
     *
     * @param context
     * @return
     */
    public static boolean hasNavBar(Context context) {
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("config_showNavigationBar", "bool", "android");
        if (resourceId != 0) {
            boolean hasNav = res.getBoolean(resourceId);
            // check override flag
            String sNavBarOverride = getNavBarOverride();
            if ("1".equals(sNavBarOverride)) {
                hasNav = false;
            } else if ("0".equals(sNavBarOverride)) {
                hasNav = true;
            }
            return hasNav;
        } else { // fallback
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
    }
    /**
     * 隐藏虚拟按键，并且全屏
     */
    public void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = getActivity().getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getActivity().getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;

            decorView.setSystemUiVisibility(uiOptions);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }


    /**
     * 替换fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void replaceFragment(BaseFragment fragment, @IdRes int frameId) {
        Utils.checkNotNull(fragment);
        getHoldingActivity().replaceFragment(fragment, frameId);
    }


    /**
     * 隐藏fragment
     *
     * @param fragment
     */
    protected void hideFragment(BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getHoldingActivity().hideFragment(fragment);
    }


    /**
     * 显示fragment
     *
     * @param fragment
     */
    protected void showFragment(BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getHoldingActivity().showFragment(fragment);
    }


    /**
     * 移除Fragment
     *
     * @param fragment
     */
    protected void removeFragment(BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getHoldingActivity().removeFragment(fragment);

    }


    /**
     * 弹出栈顶部的Fragment
     */
    protected void popFragment() {
        getHoldingActivity().popFragment();
    }

    //显示Dialog
    public void showLogadingDialog() {
        ((BaseActivity) getActivity()).showLogadingDialog();
    }

    public void closeLogadingDialog() {
        ((BaseActivity) getActivity()).closeLogadingDialog();
    }

    public void resolveResponseErrorCode(int code, String mes) {
        //  ((BaseActivity) getActivity()).resolveResponseErrorCode(code,mes);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mCountDownText != null) {
                mCountDownText.start(60);
            }
            //相当于Fragment的onResume
        } else {
            //相当于Fragment的onPause
            if (mCountDownText != null) {
                mCountDownText.cancel();
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            //相当于Fragment的onPause
            if (mCountDownText != null) {
                mCountDownText.cancel();
            }
        } else {  // 在最前端显示 相当于调用了onResume();
            if (mCountDownText != null) {
                mCountDownText.start(60);
            }
        }
    }

    public void startActivityByRouter(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    public void startActivityByRouter(String path, Bundle b) {
        ARouter.getInstance().build(path).with(b).navigation();
    }

    public void setCacheViewFromContent(View focusView){
        this.focusView = focusView;
    }
    public void setmCacheViewFromTab(View focusView){
        this.focusView = focusView;
    }

}
