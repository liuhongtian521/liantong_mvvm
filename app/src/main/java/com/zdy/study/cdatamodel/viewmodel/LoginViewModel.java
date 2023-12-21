package com.zdy.study.cdatamodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.util.EncryptUtils;
import com.askia.coremodel.viewmodel.BaseViewModel;

import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<CaptchaResultBean> mCaptchaResultData = new MutableLiveData<>();
    public MutableLiveData<CaptchaResultBean> getCaptchaResultLiveData() {
        return mCaptchaResultData;
    }

    //登录结果
    private MutableLiveData<HttpLoginResult> mLoginLiveData = new MutableLiveData<>();

    public MutableLiveData<HttpLoginResult> getmLoginLiveData() {
        return mLoginLiveData;
    }


    //用户信息
    private MutableLiveData<BaseResponseData<UserInfoBean>> mUserInfoLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<UserInfoBean>> getmUserInfoLiveDataLiveData() {
        return mUserInfoLiveData;
    }


    //获取图片验证码
    public void getCaptcha() {
        NetDataRepository.captcha()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribe(new Observer<CaptchaResultBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable.add(d);
                    }


                    @Override
                    public void onNext(@NonNull CaptchaResultBean noticeStudentData) {
                        mCaptchaResultData.setValue(noticeStudentData);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TagSnake back", Log.getStackTraceString(e));
                        CaptchaResultBean responseData = new CaptchaResultBean();
                        if (e instanceof SocketTimeoutException) {
                            responseData.setError("连接超时，请重试");
                        } else {
                            responseData.setError(e.getMessage());//"服务器无响应，请重试");
                        }
                        mCaptchaResultData.setValue(responseData);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    //用户信息
    public void queryClassesByPhone(String phone) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryClassesByPhone(phone, mUserInfoLiveData, mDisposable);
    }

    //登录
    /*public void login(String account, String password) {
        HttpLoginParams params = new HttpLoginParams();
        params.setUsername(account.trim());

        String rsaPws = EncryptUtils.encryptMD5ToString(password.trim());
        *//*try {
//            String rsaPws = RSAUtils.encrypt(password.trim(), Constans.publicKey);
            String rsaPws = EncryptUtils.encryptMD5ToString(password.trim());

            String ss = rsaPws.replaceAll("\n", "");
            params.setPassword(ss);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*//*
        params.setTenantId("000000");
        params.setType("account");
        params.setScope("all");
        params.setGrant_type("captcha");

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.login(account, rsaPws, mLoginLiveData, mDisposable);
    }*/

}
