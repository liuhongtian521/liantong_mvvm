package com.askia.coremodel.datamodel.http.service;




import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;

import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;


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
    Observable<BaseResponseData<StuyMaterialsListBean>> queryCoursewareListByUser(@Query("size") String size,
                                                                                  @Query("current") String current,
                                                                                  @Query("argPage") String argPage,
                                                                                  @Query("argPageSize") String argPageSize);

    // 讨论室列表
    @GET("/cdls-cms/DiscussionRoomController/pageListPad")
    Observable<BaseResponseData<DiscussRoomListBean>> pageListPad(@Query("argPage") String argPage,
                                                                  @Query("argPageSize") String argPageSize);



    //修改密码
    @Headers({"Content-Type: application/json"})
    @PUT("/campuscanteen/sys/user/changePassword")
    Observable<CBaseResponseData> changePassword(@Body RequestBody userinfo);//(@Field("username") String username, @Field("password") String password);



}