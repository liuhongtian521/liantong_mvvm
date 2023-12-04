package com.askia.coremodel.datamodel.http.service;




import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;

import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;


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
    @GET("/cdls-auth/oauth/captcha")
    Observable<CaptchaResultBean> captcha();

    // 获取消费机配置
    @GET("/campuscanteen/appForConsume/getConfiguration")
    Observable<HttpConsumeConfigBean> getConsumeConfig(@Query("sn") String sn);

    //登录
    @POST("/campuscanteen/sys/login")
    Observable<HttpLoginResult> login(@Body RequestBody body);

    //修改密码
    @Headers({"Content-Type: application/json"})
    @PUT("/campuscanteen/sys/user/changePassword")
    Observable<CBaseResponseData> changePassword(@Body RequestBody userinfo);//(@Field("username") String username, @Field("password") String password);



}