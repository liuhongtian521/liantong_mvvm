package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class EBookViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;



    //电子课件
    private MutableLiveData<BaseResponseData<EBookListBean>> mMaterialsLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<EBookListBean>> getmMaterialsLiveData() {
        return mMaterialsLiveData;
    }

    //电子课件
    public void queryCoursewareListByUser(String page, String size) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCoursewareListByUser(page, size, mMaterialsLiveData, mDisposable);
    }

}
