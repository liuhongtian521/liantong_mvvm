package com.zdy.study.activitys;

import android.util.Log;
import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.common.util.ImageUtil;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.databinding.ActLoginBinding;
import com.zdy.study.widgets.AesEncryptUtil;



@Route(path = ARouterPath.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    ActLoginBinding mDataBinding;
    private LoginViewModel mViewModel;


    @Override
    public void onMResume() {

    }

    @Override
    public void onInit() {

        initTab();
        mViewModel.getCaptcha();
    }


    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);


    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_login);
        mDataBinding.setHandlers(this);
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getCaptchaResultLiveData().observe(this, imCodeResult -> {
            /*if(!imCodeResult.isSuccess()){
                ToastUtils.showLong(imCodeResult.getMessage().toString());
                return;
            }*/
            if(!"".equals(imCodeResult.getError())){
                ToastUtils.showLong(imCodeResult.getError().toString());
                return;
            }
            mDataBinding.ivLoginImcode.setImageBitmap(ImageUtil.base642Bitmap(imCodeResult.getImage()));

        });

    }

    private void initTab(){
        TabLayout.Tab tab2 = mDataBinding.tabLayout.newTab();
        tab2.setText("密码登录");
        mDataBinding.tabLayout.addTab(tab2);

        TabLayout.Tab tab = mDataBinding.tabLayout.newTab();
        tab.setText("验证码登录");
        mDataBinding.tabLayout.addTab(tab);

        mDataBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0){//点击密码登录
                    mDataBinding.clLoginPhonecode.setVisibility(View.GONE);
                    mDataBinding.llLoginPassword.setVisibility(View.VISIBLE);
                    mDataBinding.clLoginImcode.setVisibility(View.VISIBLE);
                }else if(tab.getPosition() == 1){//点击验证码登录
                    mDataBinding.clLoginPhonecode.setVisibility(View.VISIBLE);
                    mDataBinding.llLoginPassword.setVisibility(View.GONE);
                    mDataBinding.clLoginImcode.setVisibility(View.GONE);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void login(View view) {

//        mViewModel.login(httpLoginParams);

        /*if (mDataBinding.editPhone.getText().toString().equals("") || mDataBinding.editPassword.getText().toString().equals("")) {
            Toast.makeText(this, "手机号和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }*/
        /*HttpLoginParams httpLoginParams = new HttpLoginParams();
        httpLoginParams.setUsername(mDataBinding.editPhone.getText().toString());
       // SharedPreUtil.getInstance().setUsername(mDataBinding.editPhone.getText().toString());
        try {
            String psd = AesEncryptUtil.encrypt(mDataBinding.editPassword.getText().toString());
            Log.e("TagSnake", psd);
           // SharedPreUtil.getInstance().setPassword(psd);
            httpLoginParams.setPassword(psd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mViewModel.login(httpLoginParams);*/
    }
}
