package com.zdy.study.activitys;

import static android.provider.MediaStore.Video.Thumbnails.MINI_KIND;
import static com.askia.common.util.Utils.getContext;
import static com.bumptech.glide.load.resource.bitmap.VideoDecoder.FRAME_OPTION;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.zdy.study.R;
import com.zdy.study.adapter.WebBaseCourseDetailsAdapter;
import com.zdy.study.cdatamodel.viewmodel.InternationalPerspectiveDetailsViewModel;
import com.zdy.study.cdatamodel.viewmodel.InternationalPerspectiveViewModel;
import com.zdy.study.databinding.InternationalPerspectiveDetailsBinding;
import com.zdy.study.databinding.WebBasedCourseDetailsTwoActivityBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.tools.URLEncodeing;
import com.zdy.study.uitls.VideoFrameExtractor;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Route(path = ARouterPath.InternationalPerspectiveDetailsActivity)
public class InternationalPerspectiveDetailsActivity extends BaseActivity {
    private InternationalPerspectiveDetailsBinding mDataBinding;

    private RecyclerView recyclerView;
    private WebBaseCourseDetailsAdapter adapter;
    private List<WebCourseResponseBean.RecordsBean.SonListBean> list;
    private int page = 1;
    private String pageSize = "10";
    private InternationalPerspectiveDetailsViewModel viewModel;
    private String key;
    String argContId;
    String argContChildId;
    private String readStartTime; //埋点 开始时间
    private String mUrl = "";
    private Handler mHandler; // 定义全局变量mHandler

    @Override
    public void onInit() {
        key = getIntent().getExtras().getString("key");
        mHandler = new Handler(); // 初始化Handler对象
        switch (key) {
            case Constants.GJSY:
                onInTitle("国际视野详情");
                break;
            case Constants.SJAL:
                onInTitle("实践案列详情");
                break;
            case Constants.JXLL:
                onInTitle("精选理论详情");
                mDataBinding.rlVideo.setVisibility(View.GONE);
                mDataBinding.tvAuthor.setVisibility(View.GONE);
                break;
            case Constants.CZJQ:
                onInTitle("操作技巧详情");
                mDataBinding.rlVideo.setVisibility(View.GONE);
                mDataBinding.tvAuthor.setVisibility(View.GONE);
                break;

        }
        seveStartTime();
        argContId = getIntent().getExtras().getString("INTERNATIONAL_VIEW");
        argContChildId = getIntent().getExtras().getString("argContChildId");
        mDataBinding.flOperation.getComments(argContId, argContChildId, key);//获取评论
        viewModel.queryCont(argContId, argContChildId);
        mDataBinding.rlVideo.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("url", mUrl);
            startActivityByRouter(ARouterPath.VideoActivity, bundle);
        });
    }

    private void onInTitle(String title) {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText(title);
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void seveStartTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        readStartTime = simpleDateFormat.format(date);
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(InternationalPerspectiveDetailsViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.international_perspective_details);
    }

    /**
     * 使用Glide方式获取视频某一帧
     *
     * @param context         上下文
     * @param uri             视频地址
     * @param imageView       设置image
     * @param frameTimeMicros 获取某一时间帧.
     */
    public static void loadVideoScreenshot(final Context context, String uri, ImageView imageView, long frameTimeMicros) {
        RequestOptions requestOptions = RequestOptions.frameOf(frameTimeMicros);
        requestOptions.set(FRAME_OPTION, MediaMetadataRetriever.OPTION_CLOSEST);
        requestOptions.transform(new BitmapTransformation() {
            @Override
            protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
                Log.d("--使用glide方式--", "高度为" + toTransform.getHeight() + "寛度为" + toTransform.getWidth());
                return toTransform;
            }

            @Override
            public void updateDiskCacheKey(MessageDigest messageDigest) {
                try {
                    messageDigest.update((context.getPackageName() + "RotateTransform").getBytes("utf-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Glide.with(context).load(uri).apply(requestOptions).into(imageView);
    }

    /**
     * 使用MediaMetadataRetriever获取视频指定微秒处的帧图片
     * url  网络url
     * timeUs 微秒
     */
    @SuppressLint("LongLogTag")
    public static Bitmap GetFramePictures(String url, long timeUs) {
        Bitmap videoShortCut = null;
        String width;
        String height;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (url != null) {
                HashMap<String, String> headers;
                headers = new HashMap<>();
                headers.put("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.4.2; zh-CN; MW-KW-001 Build/JRO03C) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/1.0.0.001 U4/0.8.0 Mobile Safari/533.1");
                mediaMetadataRetriever.setDataSource(url, headers);
            } else {
                //mmr.setDataSource(mFD, mOffset, mLength);
            }
            videoShortCut = mediaMetadataRetriever.getFrameAtTime(timeUs, MediaMetadataRetriever.OPTION_CLOSEST);
            width = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
            height = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
            Log.d("--使用MediaMetadata方式--", "图片高度为：" + width + "图片宽度为：" + height);
        } catch (IllegalArgumentException e) {
            Log.e("setFrameAtTimeWithView ERROR:", e.toString(), e);
        }
        mediaMetadataRetriever.release();
        return videoShortCut;
    }

    /**
     * 获取视频的第一帧缩略图
     * 先通过ThumbnailUtils来创建一个视频的缩略图，然后再利用ThumbnailUtils来生成指定大小的缩略图。
     * 如果想要的缩略图的宽和高都小于MICRO_KIND，则类型要使用MICRO_KIND作为kind的值，这样会节省内存。
     *
     * @param videoPath 视频的路径
     * @param width     指定输出视频缩略图的宽度
     * @param height    指定输出视频缩略图的高度度
     * @param kind      参照MediaStore.Images(Video).Thumbnails类中的常量MINI_KIND和MICRO_KIND。
     *                  其中，MINI_KIND: 512 x 384，MICRO_KIND: 96 x 96
     * @return 指定大小的视频缩略图
     */
    public static Bitmap getVideoThumbnail(String videoPath, int width, int height, int kind) {
        Bitmap bitmap = null;
        // 获取视频的缩略图
        bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind); //调用ThumbnailUtils类的静态方法createVideoThumbnail获取视频的截图；
        if (bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);//调用ThumbnailUtils类的静态方法extractThumbnail将原图片（即上方截取的图片）转化为指定大小；
        }
        return bitmap;
    }

    @Override
    public void onSubscribeViewModel() {

        viewModel.getPageListPadData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mDataBinding.flOperation.setPraiseActive("0".equals(listResult.getResult().getPraise()) ? false : true);
            mDataBinding.flOperation.setAddcollection("0".equals(listResult.getResult().getCollection()) ? false : true);
            // 在目标活动（TargetActivity）中获取Bundle
            mDataBinding.tvTitle.setText(listResult.getResult().getContName());
            mDataBinding.tvDate.setText(listResult.getResult().getDisplayTime());
            mDataBinding.tvIntroduction.setText(getIntent().getExtras().getString("ENTITY_LIST_introduction_two"));
            /*实践案例作者隐藏*/
            if (!"".equals(listResult.getResult().getLink())) {
                mDataBinding.tvAuthor.setVisibility(View.VISIBLE);
                mDataBinding.tvAuthor.setText("作者：" + listResult.getResult().getLink());
            } else {
                mDataBinding.tvAuthor.setVisibility(View.GONE);
            }

            if ("".equals(listResult.getResult().getSource())) {
                mDataBinding.tvSource.setVisibility(View.GONE);
            } else {
                mDataBinding.tvSource.setVisibility(View.VISIBLE);
                mDataBinding.tvSource.setText("来源：" + listResult.getResult().getSource());
            }
            mUrl = listResult.getResult().getContVideo().getVideoUrl();
            if (null == listResult.getResult().getContVideo() || "".equals(listResult.getResult().getContVideo().getVideoUrl()) || null == listResult.getResult().getContVideo().getVideoUrl()) {
                mDataBinding.rlVideo.setVisibility(View.GONE);
            } else {
                mDataBinding.rlVideo.setVisibility(View.VISIBLE);
            }

            setContent(listResult.getResult().getCont(), mDataBinding.webContent);
            //该方法加载视频的第一帧时间较长，放到子线程中
            // 在后台线程中执行耗时操作
            new Thread(() -> {
                try {
                    // 模拟耗时操作
                    Thread.sleep(100);
                    // 更新UI界面
                    runOnUiThread(() -> {
                        Glide.with(this).load(GetFramePictures(mUrl, 100000)).into(mDataBinding.ivVideo);
                        // UI相关操作
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        });

    }

    private void setContent(String dataCont, WebView webView) {
        if ("".equals(dataCont)) {
            mDataBinding.webContent.setVisibility(View.GONE);
        } else {
            mDataBinding.webContent.setVisibility(View.VISIBLE);
        }
        StringBuffer sb = new StringBuffer();
        //添加html
        sb.append("<html><head><meta http-equiv='content-type' content='text/html; charset=utf-8'>");
        sb.append("<meta charset='utf-8'  content='1'></head><body style='color: black'><p></p>");
        //< meta http-equiv="refresh"content="time" url="url" >
        //添加文件的内容
//        sb.append("<h5>一.在线支付</h5><p>1.支付宝：支付宝即时到账，方便快捷。</p ><p>2.网上银行：通过网上银行，用户可以享受到方便、快捷、高效和可靠的全方位服务。</p >");
        String html = URLEncodeing.toURLDecoder(dataCont);
        sb.append(html.replace("<img", "<img height=\"250px\"; width=\"100%\""));
        //加载本地文件
        sb.append("</body></html>");
        // webView.loadData(data, mimeType, encoding);
        //设置字符编码，避免乱码
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
        //禁止上下左右滚动(不显示滚动条)
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        //Only disabled the horizontal scrolling:
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        //To disabled the horizontal and vertical scrolling:
        webView.setOnTouchListener((v, event) -> (event.getAction() == MotionEvent.ACTION_MOVE));
    }

    @Override
    public void onMResume() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        //埋点记录
        viewModel.addReadTime(argContId, argContChildId, key, readStartTime, simpleDateFormat.format(date));
    }
}
