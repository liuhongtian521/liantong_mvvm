package com.zdy.study.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.CommentsAdapter;
import com.zdy.study.adapter.OperationAdapter;
import com.zdy.study.fcWidgets.FCButton;

import java.util.ArrayList;
import java.util.List;

public class FavoritesLikesLayout extends ConstraintLayout {

    private CommentsAdapter adapter;
    private List<CommentsBean.PageDataBean> commentsList;
    private RecyclerView rvPinglunList;
    private LinearLayout llPinglun, llDianzan, llShoucang;
    private EditText etComment;
    private FCButton fcbSent;
    private FavoritesLikesBack flback;

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
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.layout_favorites_likes, this);

        rvPinglunList = findViewById(R.id.rv_pinglun_list);
        llPinglun = findViewById(R.id.ll_pinglun);
        llDianzan = findViewById(R.id.ll_dianzan);
        llShoucang = findViewById(R.id.ll_shoucang);
        etComment = findViewById(R.id.et_comment);
        fcbSent = findViewById(R.id.fcb_sent);

        initList(context);
        initListener();
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
            flback.sentComment(etComment.getText().toString().trim());
        });
        llDianzan.setOnClickListener(view -> flback.praiseActive());
        llShoucang.setOnClickListener(view -> flback.addCollectionList());
    }

    public void setCommentsList(List<CommentsBean.PageDataBean> list){
        commentsList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    public void setFavoritesLikesBack(FavoritesLikesBack flback){
        this.flback = flback;
    }
    public void emptyComment(){
        if (etComment != null)
            etComment.setText("");
    }
    public interface FavoritesLikesBack{
        void sentComment(String comment);
        void praiseActive();
        void addCollectionList();
    }
}
