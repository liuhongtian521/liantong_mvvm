package com.askia.common.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.askia.common.R;
import com.askia.coremodel.datamodel.http.entities.query.AdListData;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create bt she:
 *
 * @date 2019/11/25
 */
public class PhotoListShowView extends RelativeLayout {
    ImageView img_one;
    ImageView img_two;
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    private Handler mHandler = null;
    private boolean isPause = false;
    private boolean isStop = true;
    Animation animationin;
    Animation animationout;

    Context context;


    private static final int UPDATE_TEXTVIEW = 01010101;
    private static boolean show = false;

    List<AdListData.DataBeanTwo> list = null;
    int index = 0;

    public PhotoListShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
//        Log.e("TagSnake", "create");
        LayoutInflater.from(context).inflate(R.layout.showlistlayout, this, true);
        img_one = findViewById(R.id.imgshowone);
        img_two = findViewById(R.id.imgshowtwo);
        animationin = AnimationUtils.loadAnimation(context, R.anim.photoin);
        animationout = AnimationUtils.loadAnimation(context, R.anim.photoout);
    }




    //赋值
    public void setList(List<AdListData.DataBeanTwo> list) {
        this.list = list;
        index = 0;
        img_two.startAnimation(animationout);
        setUI();
    }

    //初始化
    public void setStatr() {
        if (show) {
            return;
        }
        show = true;
        Log.e("Tags", "onSteatr");
        anmImgIn();
        anmImgOut();

//        img_two.startAnimation(animationout);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE_TEXTVIEW:
                        //更新ui
                        setUI();
                        break;
                    default:
                        break;
                }
            }
        };

        animationin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (img_two.getVisibility() == View.INVISIBLE)
                    img_two.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                Log.e("TagSnake", "a3");
                img_one.setImageDrawable(img_two.getDrawable());
                index++;
                if (index == list.size())
                    index = 0;
                img_two.startAnimation(animationout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        animationout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img_two.setVisibility(INVISIBLE);
                setImg();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void setUI() {
//        Log.e("TagSnake", "a2");
        img_two.startAnimation(animationin);
    }

    public void start() {
        if (list != null) {
            if (mTimer == null) {
                mTimer = new Timer();
            }
            if (mTimerTask == null) {
                mTimerTask = new TimerTask() {
                    @Override
                    public void run() {
                        do {
                            sendMessage(UPDATE_TEXTVIEW);
                        } while (isPause);

                    }
                };
            }
            if (mTimer != null && mTimerTask != null)
                mTimer.schedule(mTimerTask, 5000, 5000);
        } else {
            img_one.setImageResource(R.drawable.photo_main);
        }
    }

    public void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }

    public void sendMessage(int id) {
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }

    TranslateAnimation animationIn;
    AnimationSet setout;
    AnimationSet setin;

    public void anmImgIn() {
        if (setin == null) {
            setin = new AnimationSet(true);
            AlphaAnimation animation4 = new AlphaAnimation(0.0f, 1.0f);
            animation4.setDuration(500);
            animation4.setFillAfter(true);
            animationIn = new TranslateAnimation(600, 0, 0, 0);
            animationIn.setDuration(1000);
            animationIn.setFillAfter(true);
//            setin.addAnimation(animation4);
            setin.addAnimation(animationIn);
        }
    }

    public void anmImgOut() {
        if (setout == null) {
            setout = new AnimationSet(true);
            AlphaAnimation animation3 = new AlphaAnimation(1.0f, 0.0f);
            animation3.setDuration(100);
            animation3.setFillAfter(true);
            TranslateAnimation animationOut = new TranslateAnimation(0, 600, 0, 0);
            animationOut.setDuration(100);
            animationOut.setFillAfter(true);
//            setout.addAnimation(animation3);
            setout.addAnimation(animationOut);
        }
    }

    public void setImg() {
        Glide.with(context).load(list.get(index).getMsgImg()).into(img_two);
    }

}
