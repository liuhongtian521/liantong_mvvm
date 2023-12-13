package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
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

    //获取评论
    private MutableLiveData<BaseResponseData<CommentsBean>> mCommentsData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<CommentsBean>> getmCommentsData() {
        return mCommentsData;
    }

    //添加评论
    private MutableLiveData<BaseResponseData> mAddCommentsData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmAddCommentsData() {
        return mAddCommentsData;
    }

    //点赞
    private MutableLiveData<BaseResponseData> mPraiseActiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmmPraiseActiveDataData() {
        return mPraiseActiveData;
    }

    //收藏
    private MutableLiveData<BaseResponseData> mAddCollectionListData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmAddCollectionListDataData() {
        return mAddCollectionListData;
    }

    //操作技巧详情
    public void queryContListByAudit( String argContId) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCont(argContId, mPageListPadData, mDisposable);
    }

    //获取评论
    public void queryCommentsList( String argContId, String argPage, String argPageSize) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCommentsList(argContId, argPage, argPageSize, mCommentsData, mDisposable);
    }

    //添加评论
    public void comments( String argContId, String argCommContent) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.comments(argContId, argCommContent, mAddCommentsData, mDisposable);
    }

    //点赞
    public void praiseActive( String argContId) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.praiseActive(argContId, mPraiseActiveData, mDisposable);
    }

    //收藏
    public void addCollectionList( String argContId) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.addCollectionList(argContId, mAddCollectionListData, mDisposable);
    }
}
