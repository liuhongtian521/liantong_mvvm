package com.zdy.study.cdatamodel.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CourseDetailsResponse;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.params.consume.AddCollectionParams;
import com.askia.coremodel.datamodel.http.params.consume.SaveParams;
import com.askia.coremodel.datamodel.http.repository.NetDataRepository;
import com.askia.coremodel.viewmodel.BaseViewModel;

import java.util.List;

public class CourseQueryViewModel extends BaseViewModel {
    private NetDataRepository netDataRepository = null;

    //获取图片验证码
    private MutableLiveData<BaseResponseData<List<CourseQueryResponseBean.DataBean>>> mPageListPadData = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<List<CourseQueryResponseBean.DataBean>>> getCalendarListData() {
        return mPageListPadData;
    }

    //获取图片验证码
    private MutableLiveData<BaseResponseData<CourseDetailsResponse>> mPageListPadDataDetails = new MutableLiveData<>();

    public MutableLiveData<BaseResponseData<CourseDetailsResponse>> getCalendarListDetailsData() {
        return mPageListPadDataDetails;
    }

    //查询课程
    public void getPageListPad(String queryDate) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCalendar(queryDate, mPageListPadData, mDisposable);
    }

    //查询课程详情
    public void queryCurriculumInfoList(String classesId, String curriculumDate, String size, String current, String argPage,
                                        String argPageSize) {
        if (netDataRepository == null)
            netDataRepository = new NetDataRepository();
        netDataRepository.queryCurriculumInfoList(classesId, curriculumDate, size, current, argPage, argPageSize, mPageListPadDataDetails, mDisposable);
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
