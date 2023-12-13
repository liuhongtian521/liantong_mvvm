package com.askia.coremodel.datamodel.http.repository;


import androidx.lifecycle.MutableLiveData;

import com.askia.coremodel.datamodel.http.ApiClient;
import com.askia.coremodel.datamodel.http.entities.ConsumeRecordData;
import com.askia.coremodel.datamodel.http.entities.GetCPListResponseData;
import com.askia.coremodel.datamodel.http.entities.HotSearchData;
import com.askia.coremodel.datamodel.http.entities.HttpWorkbenchCommentData;
import com.askia.coremodel.datamodel.http.entities.MealDetailData;
import com.askia.coremodel.datamodel.http.entities.MealListData;
import com.askia.coremodel.datamodel.http.entities.MealOrderListData;
import com.askia.coremodel.datamodel.http.entities.MealOrderOnlineListData;
import com.askia.coremodel.datamodel.http.entities.MyEvaluationData;
import com.askia.coremodel.datamodel.http.entities.NoticeData;
import com.askia.coremodel.datamodel.http.entities.QueryFaceZipsUrlsData;
import com.askia.coremodel.datamodel.http.entities.StuInfoData;
import com.askia.coremodel.datamodel.http.entities.TimeLisData;
import com.askia.coremodel.datamodel.http.entities.WeekMealsData;
import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.CourseDetailsResponse;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpCheckTokenBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpCommentRankBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeBannerBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpFoodListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpGetBusyFlag;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.HttpOrderFormResultInfo;
import com.askia.coremodel.datamodel.http.entities.consume.HttpOrderPayResult;
import com.askia.coremodel.datamodel.http.entities.consume.HttpPersonalInfoBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpRankTop10Bean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpRankTopBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpSaleStatusBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpStudentGetFoodBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpSyncShoppingBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpSysCodeBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpWorkbenchStatisticsBean;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.askia.coremodel.datamodel.http.entities.consume.SchoolServiceBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFiveBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFourBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseThirdBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseTwoBean;
import com.askia.coremodel.datamodel.http.entities.consume.StudyDictionaryBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyManualListBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.askia.coremodel.datamodel.http.entities.query.AdListData;
import com.askia.coremodel.datamodel.http.entities.query.PeopleMoneyData;
import com.askia.coremodel.util.DeviceUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public class NetDataRepository {

    private ResponseObserv responseObserv = null;


    //获取图片验证码
    public static Observable<CaptchaResultBean> captcha() {
        Observable<CaptchaResultBean> responseData = ApiClient.getNetDataService()
                .captcha();
        return responseData;
    }

    /*public void captcha(MutableLiveData<CaptchaResultBean> mLoginLiveData,
                      CompositeDisposable mDisposable) {
        Observable<CaptchaResultBean> responseData = ApiClient.getNetDataService()
                .captcha();
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }*/

    //登录
    /*public void login( String username,
                       String password,
                      MutableLiveData<HttpLoginResult> mLoginLiveData,
                      CompositeDisposable mDisposable) {
        Observable<HttpLoginResult> responseData = ApiClient.getNetDataService()
                .login(username, password, "000000", "account", "all", "captcha");
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }*/

    //获取电子课件
    public void queryCoursewareListByUser(String argPage, String argPageSize,
                                          MutableLiveData<BaseResponseData<EBookListBean>> mLoginLiveData,
                                          CompositeDisposable mDisposable) {
        Observable<BaseResponseData<EBookListBean>> responseData = ApiClient.getNetDataService()
                .queryCoursewareListByUser(argPage, argPageSize, argPage, argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //学习资料
    public void queryLearningMaterials(String dictKey, String argPage, String argPageSize,
                                       MutableLiveData<BaseResponseData<StuyMaterialsListBean>> mLoginLiveData,
                                       CompositeDisposable mDisposable) {
        Observable<BaseResponseData<StuyMaterialsListBean>> responseData = ApiClient.getNetDataService()
                .queryLearningMaterials(dictKey, argPage, argPageSize, argPage, argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //学习字典
    public void dictionary(String code,
                           MutableLiveData<BaseResponseData<List<StudyDictionaryBean>>> mLoginLiveData,
                           CompositeDisposable mDisposable) {
        Observable<BaseResponseData<List<StudyDictionaryBean>>> responseData = ApiClient.getNetDataService()
                .dictionary(code);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //学习手册
    public void queryStudentHandbook(String argPage, String argPageSize,
                                     MutableLiveData<BaseResponseData<StuyManualListBean>> mLoginLiveData,
                                     CompositeDisposable mDisposable) {
        Observable<BaseResponseData<StuyManualListBean>> responseData = ApiClient.getNetDataService()
                .queryStudentHandbook(argPage, argPageSize, argPage, argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //获取在院服务
    public void queryHospitalService(String argPage, String argPageSize,
                                          MutableLiveData<BaseResponseData<SchoolServiceBean>> mLoginLiveData,
                                          CompositeDisposable mDisposable) {
        Observable<BaseResponseData<SchoolServiceBean>> responseData = ApiClient.getNetDataService()
                .queryHospitalService(argPage, argPageSize, argPage, argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //讨论室列表
    public void pageListPad(String argPage, String argPageSize,
                            MutableLiveData<BaseResponseData<DiscussRoomListBean>> mLoginLiveData,
                            CompositeDisposable mDisposable) {
        Observable<BaseResponseData<DiscussRoomListBean>> responseData = ApiClient.getNetDataService()
                .pageListPad(argPage, argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //学习助手页面 联播接口
    public void queryHotAndTopContListByAudit(String argPage,
                                              String argPageSize, String argStruCode,
                                              MutableLiveData<BaseResponseData<MainFragmentResponseBean>> mLoginLiveData,
                                              CompositeDisposable mDisposable) {
        Observable<BaseResponseData<MainFragmentResponseBean>> responseData = ApiClient.getNetDataService()
                .queryHotAndTopContListByAudit(argPage,
                        argPageSize, argStruCode);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //书单
    public void padList(String argPage,
                        String argPageSize,
                        MutableLiveData<BaseResponseData<BooksRespponseBean>> mLoginLiveData,
                        CompositeDisposable mDisposable) {
        Observable<BaseResponseData<BooksRespponseBean>> responseData = ApiClient.getNetDataService()
                .padList(argPage,
                        argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }


    //联播速列表

    //联播速列表 、操作技巧
    public void queryContListByAudit(String argPage,
                                     String argPageSize, String argStruCode,
                                     MutableLiveData<BaseResponseData<BroadcastExpressResponBean>> mLoginLiveData,
                                     CompositeDisposable mDisposable) {
        Observable<BaseResponseData<BroadcastExpressResponBean>> responseData = ApiClient.getNetDataService()
                .queryContListByAudit(argPage,
                        argPageSize, argStruCode);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //通讯录
    public void queryStudentInfoListByClass(String argPage,
                                            String argPageSize, String classesId,
                                            MutableLiveData<BaseResponseData<AddressBookResponseBean>> mLoginLiveData,
                                            CompositeDisposable mDisposable) {
        Observable<BaseResponseData<AddressBookResponseBean>> responseData = ApiClient.getNetDataService()
                .queryStudentInfoListByClass(argPage,
                        argPageSize, classesId);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //网络课程
    public void pageByApp(String argPage,
                          String argPageSize,
                          MutableLiveData<BaseResponseData<WebCourseResponseBean>> mLoginLiveData,
                          CompositeDisposable mDisposable) {
        Observable<BaseResponseData<WebCourseResponseBean>> responseData = ApiClient.getNetDataService()
                .pageByApp(argPage,
                        argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //学习助手（讨论）
    public void queryHotRooms(
                          MutableLiveData<BaseResponseData<List<DiscussResponseBean>>> mLoginLiveData,
                          CompositeDisposable mDisposable) {
        Observable<BaseResponseData<List<DiscussResponseBean>>> responseData = ApiClient.getNetDataService()
                .queryHotRooms();
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //课程查询
    public void queryCalendar(String queryDate,
                              MutableLiveData<BaseResponseData<List<CourseQueryResponseBean.DataBean>>> mLoginLiveData,
                              CompositeDisposable mDisposable) {
        Observable<BaseResponseData<List<CourseQueryResponseBean.DataBean>>> responseData = ApiClient.getNetDataService()
                .queryCalendar(queryDate);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }
    //课程详情列表查询

    public void queryCurriculumInfoList(String classesId, String curriculumDate, String size, String current, String argPage,
                                        String argPageSize,
                                        MutableLiveData<BaseResponseData<CourseDetailsResponse>> mLoginLiveData,
                                        CompositeDisposable mDisposable) {
        Observable<BaseResponseData<CourseDetailsResponse>> responseData = ApiClient.getNetDataService()
                .queryCurriculumInfoList(classesId, curriculumDate, size, current, argPage,
                        argPageSize);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //操作技巧详情
    public void queryCont(String argContId,
                              MutableLiveData<BaseResponseData<OperationDetailBean>> mLoginLiveData,
                              CompositeDisposable mDisposable) {
        Observable<BaseResponseData<OperationDetailBean>> responseData = ApiClient.getNetDataService()
                .queryCont(argContId);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }
}
