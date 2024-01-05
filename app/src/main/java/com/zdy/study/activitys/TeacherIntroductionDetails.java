package com.zdy.study.activitys;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.StudyMaterialsViewModel;
import com.zdy.study.cdatamodel.viewmodel.TeacherIntroductionModel;
import com.zdy.study.databinding.ActivityTeacherInttoductionBinding;
import com.zdy.study.tools.URLEncodeing;

@Route(path = ARouterPath.TeacherIntroductionDetails)
public class TeacherIntroductionDetails extends BaseActivity {
    private ActivityTeacherInttoductionBinding mMainBinding;
    private TeacherIntroductionModel mViewModel;

    @Override
    public void onInit() {
        onInTitle("师资介绍");
        mViewModel.queryTeacherInfoList(getIntent().getExtras().getString("id"), getIntent().getExtras().getString("classesId"));
    }

    private void onInTitle(String title) {
        mMainBinding.includeLayout.preferenceActivityTitleText.setText(title);
        mMainBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(TeacherIntroductionModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_inttoduction);
    }

    private void setContent(String dataCont, WebView webView) {
        if ("".equals(dataCont)) {
            mMainBinding.wvContent.setVisibility(View.GONE);
        } else {
            mMainBinding.wvContent.setVisibility(View.VISIBLE);
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
    public void onSubscribeViewModel() {
        mViewModel.getmMaterialsLiveData().observe(this, listResult -> {
            dismissNetDialog();
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (null == listResult.getData() || null == listResult.getData().getRecords() || listResult.getData().getRecords().size() == 0) {
                ToastUtils.showLong("暂无师资数据");
            }
            if (null != listResult.getData() && null != listResult.getData().getRecords() && listResult.getData().getRecords().size() > 0) {
                mMainBinding.tvTeacherName.setText(listResult.getData().getRecords().get(0).getTeacherName());
                mMainBinding.tvCareer.setText(listResult.getData().getRecords().get(0).getTeacherPost());
                setContent(listResult.getData().getRecords().get(0).getTeacherIntroduction(), mMainBinding.wvContent);
            }

        });
    }

    @Override
    public void onMResume() {

    }
}
