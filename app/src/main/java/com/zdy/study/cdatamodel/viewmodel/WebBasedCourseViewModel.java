package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class WebBasedCourseViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<WebCourseResponseBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<WebCourseResponseBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //通讯录
    public void pageByApp( String argPage,
                                      String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.pageByApp(argPage, argPageSize, mPageListPadData, mDisposable);
    }
}
