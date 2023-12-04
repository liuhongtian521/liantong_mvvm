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
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.CaptchaResultBean;
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
import com.askia.coremodel.datamodel.http.entities.query.PeopleMoneyData;
import com.askia.coremodel.util.DeviceUtils;

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

    // 获取消费机配置
    public static Observable<HttpConsumeConfigBean> getConsumeConfig(String sn) {
        Observable<HttpConsumeConfigBean> responseData = ApiClient.getNetDataService()
                .getConsumeConfig(sn);
        return responseData;
    }

    //登录
    public void login(RequestBody body,
                      MutableLiveData<HttpLoginResult> mLoginLiveData,
                      CompositeDisposable mDisposable) {
        Observable<HttpLoginResult> responseData = ApiClient.getNetDataService()
                .login(body);
        if (responseObserv == null)
            responseObserv = new ResponseObserv();
        responseObserv.responseObserv(responseData, mLoginLiveData, mDisposable);
    }

    //修改密码
    public static Observable<CBaseResponseData> changePassword(RequestBody body) {
        Observable<CBaseResponseData> responseData = ApiClient.getNetDataService()
                .changePassword(body);
        return responseData;
    }


}
