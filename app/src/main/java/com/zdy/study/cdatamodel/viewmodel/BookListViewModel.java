package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BookListResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

import java.util.List;

public class BookListViewModel extends BaseViewModel {


    private  NetDataRepository netDataRepository = null;
    private MutableLiveData<BaseResponseData<BooksRespponseBean>> mPageListPadData6 = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<BooksRespponseBean>> getPageListPadData6() {
        return mPageListPadData6;
    }
    //获取图片验证码
    private MutableLiveData<BaseResponseData<List<BookListResponseBean>>> mPageListPadData = new MutableLiveData<>();
    public MutableLiveData<BaseResponseData<List<BookListResponseBean>>> getPageListPadData() {
        return mPageListPadData;
    }
    //书籍字典
    public void bookClass(String code) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.bookClass(code, mPageListPadData, mDisposable);
    }

    public void padList(String argPage, String argPageSize,String classification) {

        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.padList(argPage, argPageSize, classification,mPageListPadData6, mDisposable);
    }

}
