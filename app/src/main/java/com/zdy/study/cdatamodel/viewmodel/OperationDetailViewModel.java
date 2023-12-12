package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class OperationDetailViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;

    //操作技巧详情
    private MutableLiveData<BaseResponseData<OperationDetailBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<OperationDetailBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //操作技巧详情
    public void queryContListByAudit( String argContId) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCont(argContId, mPageListPadData, mDisposable);
    }

}
