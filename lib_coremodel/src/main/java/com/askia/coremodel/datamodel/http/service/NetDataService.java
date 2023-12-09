package com.askia.coremodel.datamodel.http.service;


import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.CourseDetailsResponse;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;

import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.StudyDictionaryBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyManualListBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface NetDataService {

    // 获取图片验证码
    @GET("/cdls-bds/App/oauth/captcha")
    Observable<CaptchaResultBean> captcha();

    //登录
   /* @POST("/cdls-auth/oauth/token")
    Observable<HttpLoginResult> login(@Query("username") String username,
                                      @Query("password") String password,
                                      @Query("tenantId") String tenantId,
                                      @Query("type") String type,
                                      @Query("scope") String scope,
                                      @Query("grant_type") String grant_type);*/


    // 电子课件
//    @GET("/cdls-bds/CoursewareInfoController/queryCoursewareInfoList")
    @GET("/cdls-bds/App/queryCoursewareListByUser")
    Observable<BaseResponseData<EBookListBean>> queryCoursewareListByUser(@Query("current") String current,
                                                                          @Query("size") String size,
                                                                          @Query("argPage") String argPage,
                                                                          @Query("argPageSize") String argPageSize);


    // 学习资料字典
    @GET("/cdls-system/dict-biz/dictionary")
    Observable<BaseResponseData<List<StudyDictionaryBean>>> dictionary(@Query("code") String code);

    // 学习资料
    @GET("/cdls-bds/App/queryLearningMaterials")
    Observable<BaseResponseData<StuyMaterialsListBean>> queryLearningMaterials(@Query("dictKey") String dictKey,
                                                                               @Query("current") String current,
                                                                                  @Query("size") String size,
                                                                                  @Query("argPage") String argPage,
                                                                                  @Query("argPageSize") String argPageSize);

    // 学习手册
    @GET("/cdls-bds/App/queryStudentHandbook")
    Observable<BaseResponseData<StuyManualListBean>> queryStudentHandbook(@Query("current") String current,
                                                                          @Query("size") String size,
                                                                          @Query("argPage") String argPage,
                                                                          @Query("argPageSize") String argPageSize);
    // 讨论室列表
    @GET("/cdls-cms/DiscussionRoomController/pageListPad")
    Observable<BaseResponseData<DiscussRoomListBean>> pageListPad(@Query("argPage") String argPage,
                                                                  @Query("argPageSize") String argPageSize);

    // 联播速递列表
    @GET("/cdls-cms/ApisController/queryContListByAudit")
    Observable<BaseResponseData<BroadcastExpressResponBean>> queryContListByAudit( @Query("argPage") String argPage, @Query("argPageSize") String argPageSize,@Query("argStruCode") String argStruCode);

    // 通讯录列表
    @GET("/cdls-bds/App/queryStudentInfoListByClass")
    Observable<BaseResponseData<AddressBookResponseBean>> queryStudentInfoListByClass(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize, @Query("classesId") String classesId);

    // 网络课程
    @GET("/cdls-bds/App/pageByApp")
    Observable<BaseResponseData<WebCourseResponseBean>> pageByApp(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize);


    //修改密码
    @Headers({"Content-Type: application/json"})
    @PUT("/campuscanteen/sys/user/changePassword")
    Observable<CBaseResponseData> changePassword(@Body RequestBody userinfo);//(@Field("username") String username, @Field("password") String password);

    // 课程查询
    @GET("/cdls-bds/App/queryCalendar")
    Observable<BaseResponseData<List<CourseQueryResponseBean.DataBean>>> queryCalendar(@Query("queryDate") String queryDate);
    // 课程详情查询
    @GET("/cdls-bds/CurriculumInfoController/queryCurriculumInfoList")
    Observable<BaseResponseData<CourseDetailsResponse>> queryCurriculumInfoList(@Query("classesId") String classesId, @Query("curriculumDate") String curriculumDate, @Query("size") String size, @Query("current") String current, @Query("argPage") String argPage, @Query("argPageSize") String argPageSize);

}