package com.zdy.study.uitls;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

public class VideoFrameExtractor {
    public static Bitmap getVideoFirstFrame(String videoUrl) throws Exception {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        try {
            // 设置要提取的视频源为指定的URL
            retriever.setDataSource(videoUrl);

            // 通过getFrameAtTime()方法获取视频的第一帧图像
            Bitmap frame = retriever.getFrameAtTime();

            return frame;
        } finally {
            // 最后记得关闭retriever对象
            retriever.release();
        }
    }
}
