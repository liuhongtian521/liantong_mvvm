package com.zdy.study.widgets;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
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

import com.zdy.study.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VideoViewConstraintLayout extends ConstraintLayout {
    private VideoView videoView;
    private SeekBar seekBar;
    private TextView textViewTime ,textViewCurrentPosition;
    private boolean isPlaying = false;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            if (videoView.isPlaying()) {
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
        textViewCurrentPosition =  findViewById(R.id.textViewCurrentPosition);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        // 为进度条添加进度更改事件
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        videoView.setOnFocusChangeListener((view, b) -> {
            if (b) {
                // 此处为得到焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(1.10f)
                        .scaleY(1.10f)
                        .translationZ(1)
                        .start();

            } else {
                // 此处为失去焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(1)
                        .scaleY(1)
                        .translationZ(1)
                        .start();
            }
        });
        videoView.setOnClickListener(view -> play());
        videoView.setEnabled(false);

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

    public void setUrl(String url){
        final Uri uri = Uri.parse(url);
        videoView = (VideoView) this.findViewById(R.id.videoView);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(mediaPlayer -> {
            textViewTime.setText(time(videoView.getDuration()));
            videoView.setEnabled(true);

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

    protected void play() {

        if (!isPlaying) {
            handler.postDelayed(runnable, 0);
            videoView.start();
            seekBar.setMax(videoView.getDuration());
            isPlaying = true;
        } else {
//            buttonPlay.setText("播放");
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
}
