package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.params.consume.SaveParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class AddressBookViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<AddressBookResponseBean>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<AddressBookResponseBean>> getPageListPadData() {
        return mPageListPadData;
    }

    //通讯录
    public void queryStudentInfoListByClass( String argPage,
                                      String argPageSize,String classesId) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryStudentInfoListByClass(argPage, argPageSize,classesId, mPageListPadData, mDisposable);
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
