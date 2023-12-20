package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.StuyManualListBean;
import com.askia.coremodel.datamodel.http.entities.consume.TopicResponseBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class TopicPostedViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;



    //学习手册
    private MutableLiveData<BaseResponseData<TopicResponseBean>> mMaterialsLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<TopicResponseBean>> getmMaterialsLiveData() {
        return mMaterialsLiveData;
    }

    //学习手册
    public void queryStudentHandbook(String page, String size) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.pageMyTopicListPAD(page, size, mMaterialsLiveData, mDisposable);
    }
}
