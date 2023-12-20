package com.zdy.study.activitys;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.zdy.study.R;
import com.zdy.study.databinding.ActivitySettingBinding;


@Route(path = ARouterPath.SettingActivity)
public class SettingActivity extends BaseActivity {

    private ActivitySettingBinding binding;

    @Override
    public void onInit() {
        //标题
        binding.includeLayout.preferenceActivityTitleText.setText("设置");
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    public void logout(View view){
        DBRepository.QueryTVUserLoginData().setAccess_token("");
        DBRepository.StoreTVUserLoginData(null);
    }
    @Override
    public void onMResume() {

    }
}
