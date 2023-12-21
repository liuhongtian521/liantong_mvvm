package com.zdy.study.activitys;

import android.text.TextUtils;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.zdy.study.R;
import com.zdy.study.databinding.ActivitySettingBinding;
import com.zdy.study.widgets.CommonMessageDialog;
import com.zdy.study.widgets.TipsDialog;


@Route(path = ARouterPath.SettingActivity)
public class SettingActivity extends BaseActivity {

    private ActivitySettingBinding binding;

    @Override
    public void onInit() {
        //标题
        binding.includeLayout.preferenceActivityTitleText.setText("设置");

        if (TextUtils.isEmpty(DBRepository.QueryTVUserLoginData().getAccess_token()))
            binding.fcbLogout.setVisibility(View.GONE);
        else
            binding.fcbLogout.setVisibility(View.VISIBLE);

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

    public void aboutUs(View view){
        startActivityByRouter(ARouterPath.AboutUsActivity);
    }
    public void logout(View view){

        TipsDialog dialog=new TipsDialog(this, R.style.Theme_dialog);
        dialog.setTips1("是否退出登录？")
//                .setTips2("￥"+getTotalPrice(list))
//        .setCancel("取消", dialog12 -> ToastUtils.info("canncel"));
                .setConfirm("确认", dialog1 -> {
                    DBRepository.QueryTVUserLoginData().setAccess_token("");
                    DBRepository.StoreTVUserLoginData(null);
                    DBRepository.StoreTVUserInfoData(null);
                    startActivityByRouter(ARouterPath.MAIN_ACTIVITY);
                    finish();
                });
        dialog.show();


    }
    @Override
    public void onMResume() {

    }
}
