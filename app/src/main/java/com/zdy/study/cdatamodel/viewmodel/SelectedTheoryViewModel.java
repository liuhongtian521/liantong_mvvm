package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class SelectedTheoryViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;

    //操作技巧
    private MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //操作技巧
    public void queryContListByAudit( String current,
                                      String size,String argPage,
                                      String argPageSize,String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryContListByAudit(current,size,argPage, argPageSize,argStruCode, mPageListPadData, mDisposable);
    }

}
