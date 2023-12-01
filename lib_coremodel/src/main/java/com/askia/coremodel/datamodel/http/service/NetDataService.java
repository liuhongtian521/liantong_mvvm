package com.askia.coremodel.datamodel.http.service;


import com.askia.coremodel.datamodel.http.entities.BaseResponseData;
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
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
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
import com.askia.coremodel.datamodel.http.entities.query.AdListData;
import com.askia.coremodel.datamodel.http.entities.query.DisheAboutData;
import com.askia.coremodel.datamodel.http.entities.query.DisheDayAmountData;
import com.askia.coremodel.datamodel.http.entities.query.DisheMsgData;
import com.askia.coremodel.datamodel.http.entities.query.DishesNutritionRemarkData;
import com.askia.coremodel.datamodel.http.entities.query.EvaluationData;
import com.askia.coremodel.datamodel.http.entities.query.FoodOrCondimentData;
import com.askia.coremodel.datamodel.http.entities.query.LastMealDateData;
import com.askia.coremodel.datamodel.http.entities.query.MealRecordData;
import com.askia.coremodel.datamodel.http.entities.query.NutritionAnalysisData;
import com.askia.coremodel.datamodel.http.entities.query.PaiHangData;
import com.askia.coremodel.datamodel.http.entities.query.PeopleMoneyData;
import com.askia.coremodel.datamodel.http.entities.query.PingjiaNumberData;
import com.askia.coremodel.datamodel.http.entities.query.QBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.query.QueryDeviceData;
import com.askia.coremodel.datamodel.http.entities.query.SearchDisheData;
import com.askia.coremodel.datamodel.http.entities.query.SearchPeopleMsgData;
import com.askia.coremodel.datamodel.http.entities.query.WeekOrderData;

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

    /**
     * 消费机
     */
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