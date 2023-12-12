package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.SchoolServiceBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class SchoolServiceViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;



    //在院服务
    private MutableLiveData<BaseResponseData<SchoolServiceBean>> mMaterialsLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<SchoolServiceBean>> getmMaterialsLiveData() {
        return mMaterialsLiveData;
    }

    //在院服务
    public void queryHospitalService(String page, String size) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryHospitalService(page, size, mMaterialsLiveData, mDisposable);
    }

}
