package com.askia.common.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

import com.askia.common.R;
import com.askia.common.util.Utils;
import com.blankj.utilcode.util.LogUtils;

public class CountDownText extends AppCompatTextView {
    private Context mContext;
    private CountDownTimer mCountDownTimer;
    private CountDownFinishListener mCountDownFinishListener;
    private int mSecond;

    public CountDownText(Context context, int second, CountDownFinishListener listener) {
        super(context);
        mContext = context;
        mCountDownFinishListener = listener;
        mSecond = second;
        init();
    }

    public CountDownText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public CountDownText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public void setCountDownFinishListener(CountDownFinishListener listener)
    {
        mCountDownFinishListener = listener;
    }

    public void init() {
     /*   setWidth(Utils.dp2px(mContext, 87));
        setHeight(Utils.dp2px(mContext, 35));*/
        setTextSize(8);
        setGravity(Gravity.CENTER);
        setTextColor(Color.parseColor("#941800"));

        mCountDownTimer = new CountDownTimer(mSecond * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setText(millisUntilFinished / 1000 + "s"); //设置倒计时时间
            }

            @Override
            public void onFinish() {
                if(mCountDownFinishListener != null)
                    mCountDownFinishListener.onFinish();
            }
        };
       // start(mSecond);
    }

    public void start(int second) {
        mSecond = second;
        mCountDownTimer.start();
        LogUtils.d("Count Down start");
    }

    public void cancel() {
        mCountDownTimer.cancel();
        LogUtils.d("Count Down cancel");
    }

    public interface CountDownFinishListener {
        void onFinish();
    }

}
