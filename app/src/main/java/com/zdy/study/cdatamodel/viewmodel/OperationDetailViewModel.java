package com.zdy.study.cdatamodel.viewmodel;

import android.provider.ContactsContract;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.askia.coremodel.datamodel.http.params.consume.AddCollectionParams;
import com.askia.coremodel.datamodel.http.params.consume.AddReadTimeParams;
import com.askia.coremodel.datamodel.http.params.consume.SaveParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;
import com.zdy.study.tools.Constants;

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
        netDataRepository.queryCont(argContId,"", mPageListPadData, mDisposable);
    }


    //学习助手 埋点记录时长
    public void addReadTime(String contentParentId, String contentChildrenId,
                            String struId, String readStartTime, String readEndTime) {
        AddReadTimeParams params = new AddReadTimeParams();
        params.setStruId(struId);
        params.setContentChildrenId(contentChildrenId);
        params.setContentParentId(contentParentId);
        params.setReadStartTime(readStartTime);
        params.setReadEndTime(readEndTime);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.addReadTime(convertPostBody(params), new MutableLiveData<>(), mDisposable);
    }

}
