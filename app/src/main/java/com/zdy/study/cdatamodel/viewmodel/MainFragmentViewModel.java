package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFiveBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFourBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseThirdBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseTwoBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

public class MainFragmentViewModel extends BaseViewModel {


    private NetDataRepository netDataRepository = null;

    //获取图片验证码(第一個)
    private MutableLiveData<BaseResponseData<MainFragmentResponseBean>> mPageListPadData1 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MainFragmentResponseBean>> getPageListPadData1() {
        return mPageListPadData1;
    }

    // //获取图片验证码(第2個)
    private MutableLiveData<BaseResponseData<MainFragmentResponseTwoBean>> mPageListPadData2 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MainFragmentResponseTwoBean>> getPageListPadData2() {
        return mPageListPadData2;
    }  //获取图片验证码(第3個)

    private MutableLiveData<BaseResponseData<MainFragmentResponseThirdBean>> mPageListPadData3 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MainFragmentResponseThirdBean>> getPageListPadData3() {
        return mPageListPadData3;
    }
    //获取图片验证码(第4個)

    private MutableLiveData<BaseResponseData<MainFragmentResponseFourBean>> mPageListPadData4 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MainFragmentResponseFourBean>> getPageListPadData4() {
        return mPageListPadData4;
    }

    private MutableLiveData<BaseResponseData<MainFragmentResponseFiveBean>> mPageListPadData5 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<MainFragmentResponseFiveBean>> getPageListPadData5() {
        return mPageListPadData5;
    }

    private MutableLiveData<BaseResponseData<BooksRespponseBean>> mPageListPadData6 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<BooksRespponseBean>> getPageListPadData6() {
        return mPageListPadData6;
    }

    //登录
    public void queryHotAndTopContListByAudit(String argPage, String argPageSize, String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryHotAndTopContListByAudit(argPage, argPageSize, argStruCode, mPageListPadData1, mDisposable);
    }

    public void queryHotAndTopContListByAudit2(String argPage, String argPageSize, String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryHotAndTopContListByAudit2(argPage, argPageSize, argStruCode, mPageListPadData2, mDisposable);
    }

    public void queryHotAndTopContListByAudit3(String argPage, String argPageSize, String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryHotAndTopContListByAudit3(argPage, argPageSize, argStruCode, mPageListPadData3, mDisposable);
    }
/*精选理论*/
    public void queryHotAndTopContListByAudit4(String argPage, String argPageSize, String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryHotAndTopContListByAudit4(argPage, argPageSize, argStruCode, mPageListPadData4, mDisposable);
    }

    public void queryHotAndTopContListByAudit5(String argPage, String argPageSize, String argStruCode) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryHotAndTopContListByAudit5(argPage, argPageSize, argStruCode, mPageListPadData5, mDisposable);
    }

    public void padList(String argPage, String argPageSize) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.padList(argPage, argPageSize, mPageListPadData6, mDisposable);
    }
}
