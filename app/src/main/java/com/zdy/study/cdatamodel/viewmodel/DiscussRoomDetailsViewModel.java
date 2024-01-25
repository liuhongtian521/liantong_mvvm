package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomDetailsResponse;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class DiscussRoomDetailsViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<DiscussRoomDetailsResponse>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<DiscussRoomDetailsResponse>> getPageListPadData() {
        return mPageListPadData;
    }

    //通讯录
    public void pageTopicListPAD( String argPage,
                                      String argPageSize,String roomId) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.pageTopicListPAD(argPage, argPageSize,roomId, mPageListPadData, mDisposable);
    }
}
