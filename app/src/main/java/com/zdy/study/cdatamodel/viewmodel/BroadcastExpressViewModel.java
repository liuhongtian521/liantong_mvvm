package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class BroadcastExpressViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<DiscussRoomListBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<DiscussRoomListBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //登录
    public void queryContListByAudit(String argStruCode, String size, String current, String argPage,
                                     String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryContListByAudit(argStruCode, size, current, argPage, argPageSize, mPageListPadData, mDisposable);
    }
}
