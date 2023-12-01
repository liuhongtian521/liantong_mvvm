package com.askia.coremodel.datamodel.http.repository;


import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;
import com.blankj.utilcode.util.ToastUtils;

import java.net.SocketTimeoutException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ResponseObserv<T extends BaseResponseData> {

    public void responseObserv(Observable<T> responseData,
                               MutableLiveData<T> resultData,
                               CompositeDisposable mDisposable){
        responseData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull T httpResult) {
                        resultData.postValue(httpResult);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof SocketTimeoutException) {
                            ToastUtils.showLong("连接超时，请重试");
                        } else {
                            ToastUtils.showLong(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
