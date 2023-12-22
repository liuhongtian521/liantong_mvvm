package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.askia.coremodel.datamodel.http.params.consume.AddCollectionParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class BroadcastExpressViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //联播速度
    private MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //联播速度
    public void queryContListByAudit(String current,
                                     String size, String argPage,
                                     String argPageSize,String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryContListByAudit(current,size,argPage, argPageSize,argStruCode, mPageListPadData, mDisposable);
    }

    //添加阅读记录
    public void addReadNotes( String argContId, String struId) {
        AddCollectionParams params = new AddCollectionParams();
        params.setContentParentId(argContId);
        params.setStruId(struId);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.addReadNotes(convertPostBody(params), new MutableLiveData<>(), mDisposable);
    }
}
