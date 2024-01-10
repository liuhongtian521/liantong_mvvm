package com.zdy.study.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.common.util.ImageUtil;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
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
import java.util.Timer;
import java.util.TimerTask;
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

    private int pageTab = 0;


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
        //验证码图片
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
        //获取短信验证码
        mViewModel.getmCaptchaLiveData().observe(this, listResult -> {
            if(!"".equals(listResult.getError())){
                ToastUtils.showLong(listResult.getError().toString());
                return;
            }
            ToastUtils.showLong(listResult.getMessage());
            key = listResult.getKey();
        });
        //获取用户信息
        mViewModel.getmUserInfoLiveDataLiveData().observe(this, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            DBRepository.StoreTVUserInfoData(listResult.getData());

            ToastUtils.showLong("登录成功");
                    Bundle bundle = getIntent().getExtras();
                    if (!TextUtils.isEmpty(bundle.getString("url")))
                        startActivityByRouter(bundle.getString("url"));
                    finish();
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
                pageTab = tab.getPosition();
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

    //获取短信验证码
    public void countDownTimer(View view) {
        if (TextUtils.isEmpty(mDataBinding.etLoginPhone.getText())){
            ToastUtils.showLong("请输入手机号！");
            return;
        }
        mDataBinding.tvLoginPhonecode.setEnabled(false);
        countDownTimer.start();
        mViewModel.message(mDataBinding.etLoginPhone.getText().toString());
    }

    /**
     * 第一个参数表示总时间，第二个参数表示间隔时间。意思就是每隔一秒会回调一次方法onTick，然后10秒之后会回调onFinish方法
     */
    private CountDownTimer countDownTimer = new CountDownTimer(1000 * 120, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //秒转化成 00:00形式一
//            timeView2.setText(formatTime1(millisUntilFinished) + "");

            //秒转化成 00:00形式二
            mDataBinding.tvLoginPhonecode.setText(formatTime2(millisUntilFinished / 1000)+ "秒");
            Log.e("hehehe ", millisUntilFinished + " ");
        }

        @Override
        public void onFinish() {
            mDataBinding.tvLoginPhonecode.setText("获取验证码");
            mDataBinding.tvLoginPhonecode.setEnabled(true);
        }
    };

    private String formatTime2(long seconds) {
        return String.format("%02d", seconds % 60);
    }


    public void getImgCode(View v){
        //获取图片验证码
        mViewModel.getCaptcha();
    }

    public void login(View view) {
        if (TextUtils.isEmpty(mDataBinding.etLoginPhone.getText())){
            ToastUtils.showLong("请输入手机号！");
            return;
        }
        if (TextUtils.isEmpty(mDataBinding.etLoginPassword.getText())&& pageTab == 0){
            ToastUtils.showLong("请输入密码！");
            return;
        }
        if (TextUtils.isEmpty(mDataBinding.etLoginImcode.getText())&& pageTab == 0){
            ToastUtils.showLong("请输入图形验证码！");
            return;
        }
        if (TextUtils.isEmpty(mDataBinding.etLoginPhonecode.getText())&& pageTab == 1){
            ToastUtils.showLong("请输入短信验证码！");
            return;
        }
        showNetDialog();
        postUser( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.request().toString();
            }

            @SuppressLint("CheckResult")
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                dismissNetDialog();
                String ss = response.body().string();
                HttpLoginResult httpLoginResult =  new Gson().fromJson(ss, HttpLoginResult.class);
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
                    //获取图片验证码
                    mViewModel.getCaptcha();
                }else{
                    DBRepository.StoreTVUserLoginData(httpLoginResult);

                    mViewModel.queryClassesByPhone(httpLoginResult.getUser_name());//获取用户信息

                }
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
//            String rsaPws = EncryptUtils.encryptMD5ToString("CScs@135").toLowerCase();
            String rsaPws = EncryptUtils.encryptMD5ToString(mDataBinding.etLoginPassword.getText().toString()).toLowerCase();
            url = ApiConstants.HOST+"/cdls-auth/oauth/token";
            /*url+= "?" +
                    "username="+"18943453434"+"&"+
                    "password="+rsaPws+"&"+
                    "grant_type=captcha&"+
                    "scope=all&"+
                    "type=account&"+
                    "tenantId=000000";*/

            url+= "?" +
                    "username="+mDataBinding.etLoginPhone.getText().toString()+"&"+
                    "password="+rsaPws+"&"+
                    "grant_type=captcha&"+
                    "scope=all&"+
                    "type=account&"+
                    "tenantId=000000";


        } catch (Exception e) {
            e.printStackTrace();

        }
        String code = "";
        if (pageTab == 0)
            code = mDataBinding.etLoginImcode.getText().toString();
        else if(pageTab == 1)
            code = mDataBinding.etLoginPhonecode.getText().toString();
        Request request = new Request.Builder().url(url).post(requestBody)
                .addHeader("Authorization","Basic cGFkOnBhZF9zZWNyZXQ=")
                .addHeader("Captcha-Code",code)
                .addHeader("Captcha-Key",key)
                .addHeader("Tenant-Id","000000")
                .build();
        //4.创建一个call对象,参数就是Request请求对象
        okHttpClient.newCall(request).enqueue(callback);
    }
}
