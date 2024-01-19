package com.zdy.study.widgets;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.meetsl.scardview.SCardView;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VideoViewConstraintLayout extends ConstraintLayout {
    private VideoView videoView;
    private TVSeekBar seekBar;
    private SCardView scv_bg_seekbar;//seekbar背景框
    private ImageView fiv_onoff;
    private RecyclerView rv_fdyd;
    private TextView textViewTime ,textViewCurrentPosition, fct_fdyd;
    private boolean isPlaying = false;
    private String url;

    private boolean isDragging = false;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!isDragging && videoView.isPlaying()) {
                int current = videoView.getCurrentPosition();
                seekBar.setProgress(current);
                textViewCurrentPosition.setText(time(videoView.getCurrentPosition()));
            }
            handler.postDelayed(runnable, 500);
        }
    };

    public VideoViewConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.view_videoview, this);
        // 获取控件
        videoView =  findViewById(R.id.videoView);
        textViewTime =  findViewById(R.id.textViewTime);
        fct_fdyd =  findViewById(R.id.fct_fdyd);
        textViewCurrentPosition =  findViewById(R.id.textViewCurrentPosition);
        fiv_onoff =  findViewById(R.id.fiv_onoff);
        seekBar = (TVSeekBar) findViewById(R.id.seekBar);
        scv_bg_seekbar = findViewById(R.id.scv_bg_seekbar);//seekbar背景框
        rv_fdyd = findViewById(R.id.rv_fdyd);
        fiv_onoff.setOnClickListener(view -> play());
        fiv_onoff.setEnabled(false);
        fiv_onoff.requestFocus();
        seekBarSetLintener();
    }

    private void seekBarSetLintener(){
        // 为进度条添加进度更改事件
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener); //拖到监听好用
        //按键监听重写
        seekBar.setChangeListener(new TVSeekBar.ChangeListener() {
            @Override
            public void dwonListener() {
                isDragging = true;
            }

            @Override
            public void upListener() {
                isDragging = false;
                int progress = seekBar.getProgress();
                if (videoView.isPlaying()) {
                    // 设置当前播放的位置
                    videoView.seekTo(progress);
                }
            }
        });

        seekBar.setOnFocusChangeListener((view, b) -> {
            if (b)scv_bg_seekbar.setVisibility(VISIBLE);//seekbar背景框显示
            else scv_bg_seekbar.setVisibility(GONE);//seekbar背景框隐藏
        });
    }

    public VideoViewConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VideoViewConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public VideoViewConstraintLayout(@NonNull Context context) {
        super(context);

    }

    public TextView getBTfdyd(){
        return fct_fdyd;
    }

    public RecyclerView getRVfdyd(){
        return rv_fdyd;
    }

    public void setUrl(String url){
        this.url = url;
        videoView = findViewById(R.id.videoView);
        if (TextUtils.isEmpty(url))
            return;
        Uri uri = Uri.parse(url);
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(mediaPlayer -> {
            textViewTime.setText(time(videoView.getDuration()));
            fiv_onoff.setEnabled(true);

            play();
        });
    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        // 当进度条停止修改的时候触发
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // 取得当前进度条的刻度
            int progress = seekBar.getProgress();
            if (videoView.isPlaying()) {
                // 设置当前播放的位置
                videoView.seekTo(progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
        }
    };

    public void play() {

        if (!isPlaying) {
            fiv_onoff.setImageResource(R.mipmap.ic_video_pause);
            handler.postDelayed(runnable, 0);
            videoView.start();
            seekBar.setMax(videoView.getDuration());
            isPlaying = true;
        } else {
            fiv_onoff.setImageResource(R.mipmap.ic_video_paly2);
            if (videoView.isPlaying()) {
                videoView.pause();
                isPlaying = false;
            }
        }

    }

    protected void stop() {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }
    }

    protected String time(long millionSeconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millionSeconds);
        return simpleDateFormat.format(c.getTime());
    }

    public void destroy(){
        handler.removeCallbacks(runnable);
        videoView.stopPlayback();

    }
}
