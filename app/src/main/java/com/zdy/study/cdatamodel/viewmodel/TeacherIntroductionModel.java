package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.TeacherIntroductionResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.TopicResponseBean;
import com.askia.coremodel.datamodel.http.params.consume.SaveParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class TeacherIntroductionModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //学习手册
    private MutableLiveData<BaseResponseData<TeacherIntroductionResponseBean>> mMaterialsLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<TeacherIntroductionResponseBean>> getmMaterialsLiveData() {
        return mMaterialsLiveData;
    }

    //学习手册
    public void queryTeacherInfoList(String id,
                                     String classesId) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryTeacherInfoList(id, classesId, mMaterialsLiveData, mDisposable);
    }

    // 埋点记录时长
    public void save( String menuId, String readStartTime, String readEndTime) {
        SaveParams params = new SaveParams();
        params.setMenuId(menuId);
        params.setReadStartTime(readStartTime);
        params.setReadEndTime(readEndTime);
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.save(convertPostBody(params), new MutableLiveData<>(), mDisposable);
    }
}
