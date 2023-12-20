package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class DiscussRoomViewModel extends BaseViewModel {


    private  NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<DiscussRoomListBean>> mPageListPadData = new MutableLiveData<>();
    public MutableLiveData<BaseResponseData<DiscussRoomListBean>> getPageListPadData() {
        return mPageListPadData;
    }

    private MutableLiveData<BaseResponseData<DiscussRoomListBean>> mPageListPadData1 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<DiscussRoomListBean>> getPageListPadMyData() {
        return mPageListPadData1;
    }
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
    public void getPageListPad(String argPage, String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.pageListPad(argPage, argPageSize, mPageListPadData, mDisposable);
    }

    public void pageListMyPad(String argPage, String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.pageListMyPad(argPage, argPageSize, mPageListPadData1, mDisposable);
    }
}
