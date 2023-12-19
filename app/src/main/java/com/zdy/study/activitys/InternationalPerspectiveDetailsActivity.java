package com.zdy.study.activitys;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.WebBaseCourseDetailsAdapter;
import com.zdy.study.cdatamodel.viewmodel.InternationalPerspectiveDetailsViewModel;
import com.zdy.study.cdatamodel.viewmodel.InternationalPerspectiveViewModel;
import com.zdy.study.databinding.InternationalPerspectiveDetailsBinding;
import com.zdy.study.databinding.WebBasedCourseDetailsTwoActivityBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.tools.URLEncodeing;

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
    private String mUrl;

    @Override
    public void onInit() {
        key = getIntent().getExtras().getString("key");
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
        mDataBinding.flOperation.getComments(getIntent().getExtras().getString("INTERNATIONAL_VIEW"), key);//获取评论
        viewModel.queryCont(getIntent().getExtras().getString("INTERNATIONAL_VIEW"));
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


    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(InternationalPerspectiveDetailsViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.international_perspective_details);
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
            mDataBinding.tvAuthor.setText("作者：" + listResult.getResult().getLink());
            if (null == listResult.getResult().getImgUrl() || "".equals(listResult.getResult().getImgUrl())) {
                mDataBinding.rlVideo.setVisibility(View.GONE);
            } else {
                Glide.with(this).load(listResult.getResult().getImgUrl()).into(mDataBinding.ivVideo);
            }
            mUrl = listResult.getResult().getContVideo().getVideoUrl();
            setContent(listResult.getResult().getAudioListList().get(0).getContText(), mDataBinding.webContent);
        });

    }

    private void setContent(String dataCont, WebView webView) {
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
}
