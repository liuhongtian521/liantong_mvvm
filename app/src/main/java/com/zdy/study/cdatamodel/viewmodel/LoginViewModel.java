package com.zdy.study.cdatamodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.ResponseCode;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.util.DeviceUtils;
import com.askia.coremodel.viewmodel.BaseViewModel;

import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {
    private  NetDataRepository netDataRepository = null;

    private MutableLiveData<CaptchaResultBean> mCaptchaResultData = new MutableLiveData<>();


    public MutableLiveData<CaptchaResultBean> getCaptchaResultLiveData() {
        return mCaptchaResultData;
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

}
