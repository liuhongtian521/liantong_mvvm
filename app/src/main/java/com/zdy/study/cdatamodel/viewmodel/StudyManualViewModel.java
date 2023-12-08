package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyManualListBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class StudyManualViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;



    //学习手册
    private MutableLiveData<BaseResponseData<StuyManualListBean>> mMaterialsLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<StuyManualListBean>> getmMaterialsLiveData() {
        return mMaterialsLiveData;
    }

    //学习手册
    public void queryStudentHandbook(String page, String size) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryStudentHandbook(page, size, mMaterialsLiveData, mDisposable);
    }

}
