package com.zdy.study.widgets;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;


public class PageCountDownTimer extends CountDownTimer {
    private Context mContext;
    private Handler.Callback mCallback;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receiver
     *                          {@link #onTick(long)} callbacks.
     */
    public PageCountDownTimer(Context context, long millisInFuture, long countDownInterval, Handler.Callback callback) {
        super(millisInFuture, countDownInterval);
        mContext = context;
        mCallback = callback;
    }

    /**
     * 倒计时期间会调用
     *
     * @param millisUntilFinished
     */
    @Override
    public void onTick(long millisUntilFinished) {
        Message msg = Message.obtain();
        msg.what = 100;
        mCallback.handleMessage(msg);
    }

    /**
     * 倒计时完成后调用
     */
    @Override
    public void onFinish() {
        Message msg = Message.obtain();
        msg.what = 200;
        mCallback.handleMessage(msg);
    }
}
