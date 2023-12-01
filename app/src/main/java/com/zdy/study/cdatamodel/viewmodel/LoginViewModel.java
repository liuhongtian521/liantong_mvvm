package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.util.DeviceUtils;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class LoginViewModel extends BaseViewModel {
    private  NetDataRepository netDataRepository = null;

    private MutableLiveData<HttpLoginResult> mLoginLiveData = new MutableLiveData<>();


    public MutableLiveData<HttpLoginResult> getmLoginLiveData() {
        return mLoginLiveData;
    }



    public void login(HttpLoginParams params) {
        params.setSn(DeviceUtils.getDeviceSN());
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.login(convertPostBody(params), mLoginLiveData, mDisposable);

    }


}
