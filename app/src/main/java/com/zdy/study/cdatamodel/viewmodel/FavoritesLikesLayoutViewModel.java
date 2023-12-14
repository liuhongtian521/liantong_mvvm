package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.askia.coremodel.datamodel.http.params.consume.AddCollectionParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;
import com.zdy.study.tools.Constants;

public class FavoritesLikesLayoutViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;


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
    //取消点赞
    private MutableLiveData<BaseResponseData> mCancelPraiseActiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmCancelPraiseActiveData() {
        return mCancelPraiseActiveData;
    }

    //收藏
    private MutableLiveData<BaseResponseData> mAddCollectionListData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmAddCollectionListData() {
        return mAddCollectionListData;
    }

    //取消收藏
    private MutableLiveData<BaseResponseData> mDelCollectionListData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData> getmDelCollectionListData() {
        return mDelCollectionListData;
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

    //取消点赞
    public void cancelPraiseActive( String argContId) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.cancelPraiseActive(argContId, mCancelPraiseActiveData, mDisposable);
    }

    //收藏
    public void addCollectionList( String argContId, String struId) {
        AddCollectionParams params = new AddCollectionParams();
        params.setContentParentId(argContId);
        params.setStruId(struId);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.addCollectionList(convertPostBody(params), mAddCollectionListData, mDisposable);
    }

    //取消收藏
    public void delCollectionList( String argContId, String struId) {
        AddCollectionParams params = new AddCollectionParams();
        params.setContentParentId(argContId);
        params.setStruId(struId);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.delCollectionList(convertPostBody(params), mDelCollectionListData, mDisposable);
    }


}
