package com.zdy.study.activitys;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.askia.coremodel.datamodel.http.entities.consume.OperationDetailBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.CommentsAdapter;
import com.zdy.study.cdatamodel.viewmodel.OperationDetailViewModel;
import com.zdy.study.databinding.ActOperationDetailBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.tools.URLEncodeing;
import com.zdy.study.widgets.FavoritesLikesLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//没有用
@Route(path = ARouterPath.OpreationDetailActivity)
public class OperationDetailActivity extends BaseActivity {

    private ActOperationDetailBinding binding;
    private OperationDetailViewModel viewModel;

    private String argContId = "";
    private String struId = "";
    private String readStartTime; //埋点 开始时间

    @Override
    public void onInit() {
        struId = getIntent().getExtras().getString("struId");
        argContId = getIntent().getExtras().getString("argContId");
        if (Constants.CZJQ.equals(struId)){
            onInTitle("操作技巧详情");
        }else {
            onInTitle("精选理论详情");
        }
        seveStartTime();
        showNetDialog();
        viewModel.queryContListByAudit(argContId);
        binding.flOperation.getComments(argContId, struId);//获取评论
    }

    private void onInTitle(String title) {
        binding.includeLayout.preferenceActivityTitleText.setText(title);
        binding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(OperationDetailViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.act_operation_detail);
    }

    private void seveStartTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        readStartTime = simpleDateFormat.format(date);
    }

    @Override
    public void onSubscribeViewModel() {
        //详情
        viewModel.getPageListPadData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            setDetail(listResult.getResult());
        });
    }

    private void setDetail(OperationDetailBean data){
        binding.tvTitle.setText(data.getContName());
        binding.tvTime.setText(data.getDisplayTime().substring(0, data.getDisplayTime().length()- 3));
        binding.tvSource.setText(TextUtils.isEmpty(data.getSource())? "": "来源：" + data.getSource());
        binding.tvAuthor.setText(TextUtils.isEmpty(data.getLink())? "": "作者：" + data.getLink());
        setContent(data.getCont());

        binding.flOperation.setPraiseActive("0".equals(data.getPraise())? false: true);
        binding.flOperation.setAddcollection("0".equals(data.getCollection())? false: true);
    }

    private void setContent(String dataCont){
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

        // sb.append("<img src='file:///"+AContext.getFileUtil().getDownloadsPath()+"'>");

        sb.append("</body></html>");

        // webView.loadData(data, mimeType, encoding);

        //设置字符编码，避免乱码

        binding.webContent.getSettings().setDefaultTextEncodingName("utf-8");

        binding.webContent.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);

        //禁止上下左右滚动(不显示滚动条)
        binding.webContent.setVerticalScrollBarEnabled(false);
        binding.webContent.setHorizontalScrollBarEnabled(false);

        //Only disabled the horizontal scrolling:
        binding.webContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        //To disabled the horizontal and vertical scrolling:
        binding.webContent.setOnTouchListener((v, event) -> (event.getAction() == MotionEvent.ACTION_MOVE));
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
        viewModel.addReadTime("", argContId, struId, readStartTime, simpleDateFormat.format(date));
    }
}
