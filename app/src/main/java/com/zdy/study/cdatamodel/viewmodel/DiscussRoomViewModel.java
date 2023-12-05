package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;
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
    //登录
    public void getPageListPad(String argPage, String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.pageListPad(argPage, argPageSize, mPageListPadData, mDisposable);
    }
}
