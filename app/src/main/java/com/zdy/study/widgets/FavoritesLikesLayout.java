package com.zdy.study.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.CommentsAdapter;
import com.zdy.study.adapter.OperationAdapter;
import com.zdy.study.cdatamodel.viewmodel.FavoritesLikesLayoutViewModel;
import com.zdy.study.cdatamodel.viewmodel.OperationDetailViewModel;
import com.zdy.study.fcWidgets.FCButton;

import java.util.ArrayList;
import java.util.List;

public class FavoritesLikesLayout extends ConstraintLayout {

    private FavoritesLikesLayoutViewModel viewModel;
    private CommentsAdapter adapter;
    private List<CommentsBean.PageDataBean> commentsList;
    private RecyclerView rvPinglunList;
    private LinearLayout llPinglun, llDianzan, llShoucang;
    private EditText etComment;
    private FCButton fcbSent;
    private FavoritesLikesBack flback;
    private String argContId;
    private String struId;
    private Context context;
    private ImageView ivPraiseactive, ivAddcollection;
    private TextView tvPraiseactive, tvAddCollection;
    private boolean isPraiseActive, isAddcollection;

    public FavoritesLikesLayout(Context context) {
        super(context);
    }

    public FavoritesLikesLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FavoritesLikesLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public FavoritesLikesLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.layout_favorites_likes, this);

        viewModel = ViewModelProviders.of((FragmentActivity) context).get(FavoritesLikesLayoutViewModel.class);

        rvPinglunList = findViewById(R.id.rv_pinglun_list);
        llPinglun = findViewById(R.id.ll_pinglun);
        llDianzan = findViewById(R.id.ll_dianzan);
        llShoucang = findViewById(R.id.ll_shoucang);
        etComment = findViewById(R.id.et_comment);
        fcbSent = findViewById(R.id.fcb_sent);
        ivPraiseactive = findViewById(R.id.iv_praiseactive);
        ivAddcollection = findViewById(R.id.iv_addcollection);
        tvPraiseactive = findViewById(R.id.tv_praiseactive);
        tvAddCollection = findViewById(R.id.tv_addCollection);

        initList(context);
        initListener();
        onSubscribeViewModel();
    }

    public void getComments(String argContId, String struId){
        this.argContId = argContId;
        this.struId = struId;
        viewModel.queryCommentsList(argContId, "1", "100");
        viewModel.addReadNotes(argContId, struId);//添加阅读记录
    }

    private void initList(Context context){
        commentsList = new ArrayList<>();
        adapter = new CommentsAdapter(commentsList);

        LinearLayoutManager manager = new LinearLayoutManager(context);//数字为行数或列数
        rvPinglunList.setLayoutManager(manager);
        rvPinglunList.setAdapter(adapter);
    }

    private void initListener(){
        llPinglun.setOnClickListener(view -> {
            etComment.setVisibility(VISIBLE);
            fcbSent.setVisibility(VISIBLE);
            etComment.requestFocus();
        });
        fcbSent.setOnClickListener(view -> {
            if (TextUtils.isEmpty(etComment.getText().toString().trim())){
                ToastUtils.showLong("评论内容不能为空！");
                return;
            }
            viewModel.comments(argContId, etComment.getText().toString().trim());
        });
        llDianzan.setOnClickListener(view -> {
            if (isPraiseActive){
                viewModel.cancelPraiseActive(argContId);
            }else
                viewModel.praiseActive(argContId);
        });
        llShoucang.setOnClickListener(view -> {
            if (isAddcollection){
                viewModel.delCollectionList(argContId, struId);
            }else
                viewModel.addCollectionList(argContId, struId);
        });
    }


    public void onSubscribeViewModel() {
        //评论列表
        viewModel.getmCommentsData().observe((LifecycleOwner) context, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            commentsList.addAll(listResult.getResult().getPageData());
            adapter.notifyDataSetChanged();
        });
        //添加评论
        viewModel.getmAddCommentsData().observe((LifecycleOwner) context, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("评论成功");
            emptyComment();//评论成功清空 评论内容
            viewModel.queryCommentsList(argContId, "1", "100");
        });
        //点赞
        viewModel.getmmPraiseActiveDataData().observe((LifecycleOwner) context, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("点赞成功");
            ivPraiseactive.setImageResource(R.mipmap.ic_layout_dianz_al);
            tvPraiseactive.setTextColor(context.getResources().getColor(R.color.txt_yes));
            isPraiseActive = true;
        });
        //取消点赞
        viewModel.getmCancelPraiseActiveData().observe((LifecycleOwner) context, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("取消点赞");
            ivPraiseactive.setImageResource(R.mipmap.ic_layout_dianzan);
            tvPraiseactive.setTextColor(context.getResources().getColor(R.color.txt_nomal));
            isPraiseActive = false;
        });
        //收藏
        viewModel.getmAddCollectionListData().observe((LifecycleOwner) context, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("收藏成功");
            ivAddcollection.setImageResource(R.mipmap.ic_layout_shoucang_al);
            tvAddCollection.setTextColor(context.getResources().getColor(R.color.txt_yes));
            isAddcollection = true;
        });
        //取消收藏
        viewModel.getmDelCollectionListData().observe((LifecycleOwner) context, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong("取消收藏");
            ivAddcollection.setImageResource(R.mipmap.ic_layout_shouchang);
            tvAddCollection.setTextColor(context.getResources().getColor(R.color.txt_nomal));
            isAddcollection = false;
        });
    }

    public void setFavoritesLikesBack(FavoritesLikesBack flback){
        this.flback = flback;
    }
    public void emptyComment(){
        if (etComment != null)
            etComment.setText("");
    }

    public void setPraiseActive(boolean isPraiseActive){
        if (isPraiseActive){
            ivPraiseactive.setImageResource(R.mipmap.ic_layout_dianz_al);
            tvPraiseactive.setTextColor(context.getResources().getColor(R.color.txt_yes));
        }else{
            ivPraiseactive.setImageResource(R.mipmap.ic_layout_dianzan);
            tvPraiseactive.setTextColor(context.getResources().getColor(R.color.txt_nomal));
        }
        this.isPraiseActive = isPraiseActive;
    }

    public void setAddcollection(boolean isAddcollection){
        if (isAddcollection){
            ivAddcollection.setImageResource(R.mipmap.ic_layout_shoucang_al);
            tvAddCollection.setTextColor(context.getResources().getColor(R.color.txt_yes));
        }else{
            ivAddcollection.setImageResource(R.mipmap.ic_layout_shouchang);
            tvAddCollection.setTextColor(context.getResources().getColor(R.color.txt_nomal));
        }
        this.isAddcollection = isAddcollection;
    }
    public interface FavoritesLikesBack{
        void sentComment(String comment);
        void praiseActive();
        void addCollectionList();
    }
}
