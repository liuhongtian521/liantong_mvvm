package com.askia.coremodel.datamodel.http.service;


import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.BookListResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.askia.coremodel.datamodel.http.entities.consume.CourseDetailsResponse;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HistoryResponse;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;

import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionTitleResponse;
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
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
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

    // 在院服务
    @GET("/cdls-bds/App/queryHospitalService")
    Observable<BaseResponseData<SchoolServiceBean>> queryHospitalService(@Query("current") String current,
                                                                         @Query("size") String size,
                                                                         @Query("argPage") String argPage,
                                                                         @Query("argPageSize") String argPageSize);


    // 讨论室列表
    @GET("/cdls-cms/DiscussionRoomController/pageListPad")
    Observable<BaseResponseData<DiscussRoomListBean>> pageListPad(@Query("argPage") String argPage,
                                                                  @Query("argPageSize") String argPageSize);

    // book字典
    @GET("/cdls-cms/BookListController/bookClass")
    Observable<BaseResponseData<List<BookListResponseBean>>> bookClass(@Query("code") String code
    );

    // 联播速递列表 、操作技巧
    @GET("/cdls-cms/ApisController/queryContListByAudit")
    Observable<BaseResponseData<BroadcastExpressResponBean>> queryContListByAudit(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize, @Query("argStruCode") String argStruCode);

    // 学习助手主页 联播接口1
    @GET("/cdls-cms/ApisController/queryHotAndTopContListByAudit")
    Observable<BaseResponseData<MainFragmentResponseBean>> queryHotAndTopContListByAudit(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize, @Query("argStruCode") String argStruCode);

        @GET("/cdls-cms/BookListController/padList")
        Observable<BaseResponseData<BooksRespponseBean>> padList(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize, @Query("classification") String classification);

    // 通讯录列表
    @GET("/cdls-bds/App/queryStudentInfoListByClass")
    Observable<BaseResponseData<AddressBookResponseBean>> queryStudentInfoListByClass(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize, @Query("classesId") String classesId);

    // 网络课程
    @GET("/cdls-bds/App/pageByApp")
    Observable<BaseResponseData<WebCourseResponseBean>> pageByApp(@Query("argPage") String argPage, @Query("argPageSize") String argPageSize);

    // 网络课程
    @GET("/cdls-cms/DiscussionRoomController/queryHotRooms")
    Observable<BaseResponseData<List<DiscussResponseBean>>> queryHotRooms();


    //修改密码
   /* @Headers({"Content-Type: application/json"})
    @PUT("/campuscanteen/sys/user/changePassword")
    Observable<CBaseResponseData> changePassword(@Body RequestBody userinfo);//(@Field("username") String username, @Field("password") String password);
*/
    // 课程查询
    @GET("/cdls-bds/App/queryCalendar")
    Observable<BaseResponseData<List<CourseQueryResponseBean.DataBean>>> queryCalendar(@Query("queryDate") String queryDate);

    // 课程详情查询
    @GET("/cdls-bds/CurriculumInfoController/queryCurriculumInfoList")
    Observable<BaseResponseData<CourseDetailsResponse>> queryCurriculumInfoList(@Query("classesId") String classesId, @Query("curriculumDate") String curriculumDate, @Query("size") String size, @Query("current") String current, @Query("argPage") String argPage, @Query("argPageSize") String argPageSize);

    // 操作技巧详情
    @GET("/cdls-cms/ApisController/queryCont")
    Observable<BaseResponseData<OperationDetailBean>> queryCont(@Query("argContId") String argContId);

    // 获取评论
    @GET("/cdls-cms/CommentsController/queryCommentsList")
    Observable<BaseResponseData<CommentsBean>> queryCommentsList(@Query("argContId") String argContId,
                                                                 @Query("argPage") String argPage,
                                                                 @Query("argPageSize") String argPageSize);

    // 添加评论
    @POST("/cdls-cms/CommentsController/comments")
    Observable<BaseResponseData> comments(@Query("argContId") String argContId,
                                          @Query("argCommContent") String argCommContent);

    // 点赞
    @GET("/cdls-cms/InteractiveController/praiseActive")
    Observable<BaseResponseData> praiseActive(@Query("argContId") String argContId);

    // 取消点赞
    @GET("/cdls-cms/InteractiveController/cancelPraiseActive")
    Observable<BaseResponseData> cancelPraiseActive(@Query("argContId") String argContId);

    // 收藏
    @POST("/cdls-cms/CollectionController/addCollectionList")
    Observable<BaseResponseData> addCollectionList(@Body RequestBody body);

    // 取消收藏
    @POST("/cdls-cms/CollectionController/delCollectionList")
    Observable<BaseResponseData> delCollectionList(@Body RequestBody body);

    // 阅读记录
    @POST("/cdls-cms/ReadNotesController/addReadNotes")
    Observable<BaseResponseData> addReadNotes(@Body RequestBody body);

    // 用户信息
    @GET("/cdls-bds/App/queryClassesByPhone")
    Observable<BaseResponseData<UserInfoBean>> queryClassesByPhone(@Query("phone") String phone);
    // 我的收藏标题头
    @GET("/cdls-cms/CollectionController/queryStruList")
    Observable<BaseResponseData<MyCollectionTitleResponse>> queryStruList();
    // 我的收藏列表
    @GET("/cdls-cms/CollectionController/queryCollectionList")
    Observable<BaseResponseData<MyCollectionResponse>> queryCollectionList(@Query("argStruCode") String argStruCode,
                                                                           @Query("contentParentId") String contentParentId,
                                                                           @Query("struId") String struId,
                                                                           @Query("content") String content,
                                                                           @Query("argPage") String argPage,
                                                                           @Query("argPageSize") String argPageSize);

    // 阅读记录标题头
    @GET("/cdls-cms/ReadNotesController/queryStruList")
    Observable<BaseResponseData<MyCollectionTitleResponse>> historyQueryStruList();

    // 阅读记录列表
    @GET("/cdls-cms/ReadNotesController/queryReadNotes")
    Observable<BaseResponseData<HistoryResponse>> queryReadNotes(@Query("argStruCode") String argStruCode,
                                                                 @Query("contentParentId") String contentParentId,
                                                                 @Query("struId") String struId,
                                                                 @Query("content") String content,
                                                                 @Query("argPage") String argPage,
                                                                 @Query("argPageSize") String argPageSize);

}