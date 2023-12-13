package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class InternationalPerspectiveViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //通讯录
    public void queryContListByAudit( String argPage,
                                      String argPageSize,String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryContListByAudit(argPage, argPageSize, argStruCode, mPageListPadData, mDisposable);
    }
}
