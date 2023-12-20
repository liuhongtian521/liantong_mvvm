package com.zdy.study.activitys;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.databinding.ActivityAboutUsBinding;


@Route(path = ARouterPath.AboutUsActivity)
public class AboutUsActivity extends BaseActivity {


    private ActivityAboutUsBinding binding;
    @Override
    public void onInit() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
        //获取APP版本versionName
        String versionName = packageInfo.versionName;
        binding.tvVersionName.setText("国企高管学习v"+versionName);
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_us);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
