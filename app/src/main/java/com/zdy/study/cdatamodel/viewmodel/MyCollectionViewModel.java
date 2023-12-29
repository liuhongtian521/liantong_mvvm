package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionTitleResponse;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.askia.coremodel.datamodel.http.params.consume.AddCollectionParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class MyCollectionViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    private MutableLiveData<BaseResponseData<MyCollectionResponse>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MyCollectionResponse>> getPageListPadData() {
        return mPageListPadData;
    }

    private MutableLiveData<BaseResponseData<MyCollectionTitleResponse>> mPageListPadData1 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MyCollectionTitleResponse>> getPageListPadData1() {
        return mPageListPadData1;
    }
    //取消收藏
    private MutableLiveData<BaseResponseData> mDelCollectionListData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmDelCollectionListData() {
        return mDelCollectionListData;
    }
    //我的收藏列表
    public void queryCollectionList(String argStruCode, String contentParentId, String
            struId, String content, String argPage, String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCollectionList(argStruCode,
                contentParentId,
                struId, content,
                argPage,
                argPageSize, mPageListPadData, mDisposable);
    }

    //我的收藏标题头
    public void queryStruList() {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryStruList(mPageListPadData1, mDisposable);
    } //删除

    //取消收藏
    public void delCollectionList( String argContId, String struId) {
        AddCollectionParams params = new AddCollectionParams();
        params.setContentParentId(argContId);
        params.setStruId(struId);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.delCollectionList(convertPostBody(params), mDelCollectionListData, mDisposable);
    }

    //分段要点 取消收藏
    public void delCollectionList( String argContId,String contentChildrenId, String struId) {
        AddCollectionParams params = new AddCollectionParams();
        params.setContentParentId(argContId);
        params.setContentChildrenId(contentChildrenId);
        params.setStruId(struId);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.delCollectionList(convertPostBody(params), mDelCollectionListData, mDisposable);
    }

}
