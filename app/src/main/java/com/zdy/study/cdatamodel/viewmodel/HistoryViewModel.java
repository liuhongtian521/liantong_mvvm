package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.HistoryResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionTitleResponse;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class HistoryViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;


    //tab标题
    private MutableLiveData<BaseResponseData<MyCollectionTitleResponse>> mhistoryQueryStruData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MyCollectionTitleResponse>> getmhistoryQueryStruData() {
        return mhistoryQueryStruData;
    }
    //阅读记录列表
    private MutableLiveData<BaseResponseData<HistoryResponse>> mHistoryData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<HistoryResponse>> getmHistoryData() {
        return mHistoryData;
    }


    //阅读记录标题头
    public void historyQueryStruList() {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.historyQueryStruList(mhistoryQueryStruData, mDisposable);
    }

    //阅读记录列表
    public void queryReadNotes(String argStruCode, String contentParentId, String struId,
                               String content,String argPage, String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryReadNotes(argStruCode, contentParentId, struId, content,
                argPage, argPageSize, mHistoryData, mDisposable);
    }

}
