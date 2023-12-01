package com.zdy.study.activitys;


import androidx.databinding.DataBindingUtil;

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;

import com.zdy.study.R;
import com.zdy.study.databinding.ActSplashBinding;


public class SplashActivity extends BaseActivity {
//    public final CompositeDisposable mDisposable = new CompositeDisposable();
    private ActSplashBinding mActSplashBinding;



    @Override
    public void onMResume() {

    }

    @Override
    public void onInit() {
        startActivityByRouter(ARouterPath.MAIN_ACTIVITY);
        finish();


    }




    @Override
    public void onInitViewModel() {
    }

    @Override
    public void onInitDataBinding() {
        mActSplashBinding = DataBindingUtil.setContentView(this, R.layout.act_splash);
    }

    @Override
    public void onSubscribeViewModel() {

        /*mViewModel.getmLoginLiveData().observe(this, new android.arch.lifecycle.Observer<HttpLoginResult>() {
            @Override
            public void onChanged(@Nullable HttpLoginResult httpLoginResult) {
                startActivityByRouter(ARouterPath.LOGIN_ACTIVITY);
            }
        });*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mDisposable.clear();
    }
}
