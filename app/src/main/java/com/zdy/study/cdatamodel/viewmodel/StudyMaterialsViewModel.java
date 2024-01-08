package com.zdy.study.cdatamodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.StudyDictionaryBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.askia.coremodel.datamodel.http.params.consume.HttpLoginParams;
import com.askia.coremodel.datamodel.http.params.consume.SaveParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.util.EncryptUtils;
import com.askia.coremodel.viewmodel.BaseViewModel;

import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StudyMaterialsViewModel extends BaseViewModel {

    private  NetDataRepository netDataRepository = null;

    //学习资料字典
    private MutableLiveData<BaseResponseData<List<StudyDictionaryBean>>> mDictionaryLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<List<StudyDictionaryBean>>> getmDictionaryLiveData() {
        return mDictionaryLiveData;
    }

    //学习资料
    private MutableLiveData<BaseResponseData<StuyMaterialsListBean>> mMaterialsLiveData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<StuyMaterialsListBean>> getmMaterialsLiveData() {
        return mMaterialsLiveData;
    }

    //学习资料字典
    public void dictionary(String code) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.dictionary(code, mDictionaryLiveData, mDisposable);
    }

    //学习资料列表
    public void queryLearningMaterials(String dictKey, String page, String size) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryLearningMaterials(dictKey, page, size, mMaterialsLiveData, mDisposable);
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
