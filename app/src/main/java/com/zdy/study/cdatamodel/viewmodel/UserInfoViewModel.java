package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class UserInfoViewModel extends BaseViewModel {

    private NetDataRepository netDataRepository = null;

    //用户信息
    private MutableLiveData<BaseResponseData<UserInfoBean>> mUserInfoLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<UserInfoBean>> getmUserInfoLiveDataLiveData() {
        return mUserInfoLiveData;
    }

    //用户信息
    public void queryClassesByPhone(String phone) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryClassesByPhone(phone, mUserInfoLiveData, mDisposable);
    }
}
