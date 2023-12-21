package com.zdy.study.uitls;


import android.os.CountDownTimer;
import android.widget.TextView;
public class VerifyCodeTimeDown extends CountDownTimer {

    private TextView btGetVerifyCode;

    public VerifyCodeTimeDown(long millisInFuture, long countDownInterval, TextView btGetVerifyCode) {
        super(millisInFuture, countDownInterval);
        this.btGetVerifyCode = btGetVerifyCode;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        btGetVerifyCode.setText(millisUntilFinished / 1000 + "秒");
    }

    @Override
    public void onFinish() {
        btGetVerifyCode.setText("重新获取");
        btGetVerifyCode.setClickable(true);
    }

    public void startNow() {
        btGetVerifyCode.setClickable(false);
        start();
    }
}


