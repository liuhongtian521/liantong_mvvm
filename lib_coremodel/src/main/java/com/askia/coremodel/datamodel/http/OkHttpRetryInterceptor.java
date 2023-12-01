package com.askia.coremodel.datamodel.http;

import android.util.Log;

import com.blankj.utilcode.util.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

import static okhttp3.Protocol.HTTP_1_1;

public class OkHttpRetryInterceptor implements Interceptor {

    private int mMaxRetryCount;
    private long mRetryInterval;

    public OkHttpRetryInterceptor(int maxRetryCount, long retryInterval) {
        mMaxRetryCount = maxRetryCount;
        mRetryInterval = retryInterval;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = null;

        long beforeTime = System.currentTimeMillis();
        String msg = "";
        try {
            response = doRequest(chain, request);
        }catch (IOException e)
        {
            response = null;
            msg = e.getMessage();
        }
        long afterTime = System.currentTimeMillis();
        if(response != null && response.isSuccessful())
        {
            LogUtils.dTag("qinyy","请求" + request.url().encodedPath() +"成功" + ",耗时" + (afterTime-beforeTime) + "ms");
        }
        else
        {
            int code = 0;
            if(response != null)
            {
                code = response.code();
                msg = response.message();
            }

            LogUtils.dTag("qinyy","请求" + request.url().encodedPath() +"失败" + ",耗时" + (afterTime-beforeTime) + "ms,错误原因"+msg + ",错误码" + code);
        }
        int retryNum = 1;
        while(((response==null)|| !response.isSuccessful())&&retryNum<=mMaxRetryCount){
            try {
                Thread.sleep(mRetryInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogUtils.d("qinyy","网络状态不佳，进行第" + retryNum + "次尝试 " + request.url().encodedPath());
            retryNum++;
            long retryBeforeTime = System.currentTimeMillis();
            try {
                response = doRequest(chain, request);
                if(response != null && response.isSuccessful())
                {
                    long _t = System.currentTimeMillis();
                    LogUtils.dTag("qinyy","请求" + request.url().encodedPath() +"成功" + ",耗时" + (_t-retryBeforeTime) + "ms");
                }
                else
                {
                    long _t = System.currentTimeMillis();
                    int _c = 0;
                    String _m = "";
                    if(response != null)
                    {
                        _c = response.code();
                        _m = response.message();
                    }
                    LogUtils.dTag("qinyy","请求" + request.url().encodedPath() +"失败" + ",耗时" + (_t-retryBeforeTime) + "ms,错误原因"+_m + ",错误码" + _c);
                }
            }catch (IOException e)
            {
                long _t = System.currentTimeMillis();
                String _m = e.getMessage();
                LogUtils.dTag("qinyy","请求" + request.url().encodedPath() +"失败" + ",耗时" + (_t-retryBeforeTime) + "ms,错误原因"+_m);

                // 最后一次如果失败了则直接抛出异常
                if(retryNum > mMaxRetryCount)
                {
                    throw  e;
                }
            }
        }
        return response;
    }

    private Response doRequest(Chain chain, Request request) throws IOException {
        return chain.proceed(request);
    }

    public static class Builder {

        private int mRetryCount = 1;
        private long mRetryInterval = 1000;

        public Builder buildRetryCount(int retryCount){
            this.mRetryCount = retryCount;
            return this;
        }

        public Builder buildRetryInterval(long retryInterval){
            this.mRetryInterval = retryInterval;
            return this;
        }

        public OkHttpRetryInterceptor build(){
            return new OkHttpRetryInterceptor(mRetryCount,mRetryInterval);
        }

    }

}
