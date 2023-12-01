package com.askia.coremodel.datamodel.http;


import android.util.Log;

import com.askia.coremodel.BuildConfig;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.http.service.NetDataService;
import com.blankj.utilcode.util.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    /**
     * 获取指定数据类型
     *
     * @return
     */
    public static NetDataService getNetDataService() {
        String host = DBRepository.QueryUserLoginData().getApiUrl();
        if (host == null || host.trim().equals("")) {
            host = ApiConstants.HOST;
        }
//        String host = ApiConstants.GankHost;
        NetDataService netDataService = initService(host, NetDataService.class);
        return netDataService;
    }

    /**
     * 动态url获取数据
     *
     * @return
     */
/*    public static DynamicApiService getDynamicDataService() {

        DynamicApiService dynamicApiService = ApiClient.initService("", DynamicApiService.class);

        return dynamicApiService;
    }*/

    /**
     * 获得想要的 retrofit service
     *
     * @param baseUrl 数据请求url
     * @param clazz   想要的 retrofit service 接口，Retrofit会代理生成对应的实体类
     * @param <T>     api service
     * @return
     */
    private static <T> T initService(String baseUrl, Class<T> clazz) {
        return getRetrofitInstance(baseUrl).create(clazz);
    }

    /**
     * 单例retrofit
     */
    private static Retrofit retrofitInstance;

    private static Retrofit getRetrofitInstance(String baseUrl) {
        synchronized (ApiClient.class) {
            if (retrofitInstance == null || !baseUrl.equals(retrofitInstance.baseUrl().toString())) {
//                LogUtils.d("retrofit 对象为null 或检测到了baseurl变更");
                try {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            //设置数据解析器
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(getOkHttpClientInstance())
                            .build();
                } catch (Exception e) {

                }

            }
        }
        return retrofitInstance;
    }


    /**
     * 单例OkHttpClient
     */
    private static OkHttpClient okHttpClientInstance;

    private static OkHttpClient getOkHttpClientInstance() {
        if (okHttpClientInstance == null) {
            synchronized (ApiClient.class) {
                if (okHttpClientInstance == null) {
                    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                    builder.connectTimeout(10, TimeUnit.SECONDS)
                            .writeTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(10, TimeUnit.SECONDS);
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        builder.addInterceptor(httpLoggingInterceptor);
                    }

                    builder.addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder builder = chain.request().newBuilder();
                            builder.addHeader("X-Access-Token", DBRepository.QueryUserLoginData().getToken());
                            Response response = chain.proceed(builder.build());
                            return response;
                        }
                    });
                    builder.addInterceptor(new OkHttpRetryInterceptor.Builder()
                            .buildRetryCount(3)
                            .buildRetryInterval(1000)
                            .build());

                    okHttpClientInstance = builder.build();
                }
            }
        }
        return okHttpClientInstance;
    }

}
