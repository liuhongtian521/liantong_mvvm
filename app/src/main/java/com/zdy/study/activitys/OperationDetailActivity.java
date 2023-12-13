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
import com.zdy.study.tools.URLEncodeing;
import com.zdy.study.widgets.FavoritesLikesLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.OpreationDetailActivity)
public class OperationDetailActivity extends BaseActivity {

    private ActOperationDetailBinding binding;
    private OperationDetailViewModel viewModel;

    private String argContId = "";

    @Override
    public void onInit() {
        argContId = getIntent().getExtras().getString("argContId");
        showNetDialog();
        viewModel.queryContListByAudit(argContId);
        viewModel.queryCommentsList(argContId, "1", "100");

        binding.flOperation.setFavoritesLikesBack(new FavoritesLikesLayout.FavoritesLikesBack() {
            @Override
            public void sentComment(String comment) {
                showNetDialog();
                viewModel.comments(argContId, comment);
            }

            @Override
            public void praiseActive() {
                showNetDialog();
                viewModel.praiseActive(argContId);
            }
            @Override
            public void addCollectionList() {
                showNetDialog();
                viewModel.addCollectionList(argContId);
            }
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
        //评论列表
        viewModel.getmCommentsData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            binding.flOperation.setCommentsList(listResult.getResult().getPageData());

        });
        //添加评论
        viewModel.getmAddCommentsData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("评论成功");
            binding.flOperation.emptyComment();//评论成功清空 评论内容
            showNetDialog();
            viewModel.queryCommentsList(argContId, "1", "100");
        });
        //点赞
        viewModel.getmmPraiseActiveDataData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("点赞成功");
        });
        //收藏
        viewModel.getmAddCollectionListDataData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("收藏成功");
        });
    }

    private void setDetail(OperationDetailBean data){
        binding.tvTitle.setText(data.getContName());
        binding.tvTime.setText(data.getDisplayTime().substring(0, data.getDisplayTime().length()- 3));
        binding.tvSource.setText(TextUtils.isEmpty(data.getSource())? "": "来源：" + data.getSource());
        binding.tvAuthor.setText(TextUtils.isEmpty(data.getLink())? "": "作者：" + data.getLink());
        setContent(data.getCont());

        if("0".equals(data.getPraise()))
            ToastUtils.showLong("未点赞");
        else
            ToastUtils.showLong("已点赞");
        if("0".equals(data.getCollection()))
            ToastUtils.showLong("未收藏");
        else
            ToastUtils.showLong("已收藏");
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
}
