package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.askia.coremodel.datamodel.http.params.consume.AddReadTimeParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class InternationalPerspectiveDetailsViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<OperationDetailBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<OperationDetailBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //通讯录
    public void queryCont( String argContId, String argContChildId) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCont(argContId, argContChildId, mPageListPadData, mDisposable);
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
