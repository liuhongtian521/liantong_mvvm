package com.zdy.study.activitys;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.common.util.ImageUtil;
import com.askia.coremodel.datamodel.database.repository.SharedPreUtil;
import com.askia.coremodel.datamodel.http.ApiConstants;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.askia.coremodel.util.EncryptUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.databinding.ActLoginBinding;
import com.zdy.study.widgets.AesEncryptUtil;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


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
//            SharedPreUtil.getInstance().putCaptchaKey(imCodeResult.getKey());
            key = imCodeResult.getKey();
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

        SharedPreUtil.getInstance().putCaptchacode(mDataBinding.etLoginImcode.getText().toString());
//        mViewModel.login("18943453434","CScs@135");

        postUser( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.request().toString();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                dismissNetDialog();
                String ss = response.body().string();
                ToastUtils.showLong(ss);
                /*HttpLoginResult httpLoginResult =  new Gson().fromJson(ss, HttpLoginResult.class);
                if (!TextUtils.isEmpty(httpLoginResult.getError_description())){
                    Observable.just(1L)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(a -> {
                                String errorText = "Bad credentials".equals(httpLoginResult.getError_description())?"用户名或密码错误":httpLoginResult.getError_description();
                                Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
                            }, throwable -> {
                                throwable.printStackTrace();
                            });

                    mViewModel.getCode();

                    Log.e("TagSnake", "登录失败" + httpLoginResult.getMessage() + httpLoginResult.getCode());
                }else{
                    SharedPreUtil.getInstance().putPsd(binding.etPassWord.getText().toString());
                    SharedPreUtil.getInstance().putUserName(binding.etUserName.getText().toString());
                    SharedPreUtil.getInstance().putToken(httpLoginResult.getAccess_token());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }*/
            }
        });
    }

    private String key = "";

    private void postUser( Callback callback){


        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        builder.connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        //2.创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder()
                /*.add("password",httpLoginParams.getPassword())
                .add("username",httpLoginParams.getUsername())
                .add("grant_type","captcha")
                .add("type","account")
                .add("key",key)
                .add("code",binding.etCode.getText().toString())*/
                .build();

        String url = "";
        try {
            String rsaPws = EncryptUtils.encryptMD5ToString("CScs@135").toLowerCase();
            url = ApiConstants.HOST+"/cdls-auth/oauth/token";
            url+= "?" +
                    "username="+"18943453434"+"&"+
                    "password="+rsaPws+"&"+
                    "grant_type=captcha&"+
                    "scope=all&"+
                    "type=account&"+
                    "tenantId=000000";



        } catch (Exception e) {
            e.printStackTrace();

        }

        String kesdfy = key;
        String dd = mDataBinding.etLoginImcode.getText().toString();

        Request request = new Request.Builder().url(url).post(requestBody)
                .addHeader("Authorization","Basic c3dvcmQ6c3dvcmRfc2VjcmV0")
                .addHeader("Captcha-Code",dd)
                .addHeader("Captcha-Key",kesdfy)
                .addHeader("Cache-Control","no-cache")
                .build();
        //4.创建一个call对象,参数就是Request请求对象
        okHttpClient.newCall(request).enqueue(callback);
    }
}
