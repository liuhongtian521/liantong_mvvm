package com.zdy.study.activitys;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.WebBaseCourseAdapter;
import com.zdy.study.adapter.WebBaseCourseDetailsAdapter;
import com.zdy.study.databinding.WebBasedCourseActivityBinding;
import com.zdy.study.databinding.WebBasedCourseDetailsActivityBinding;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.WebBasedCourseDetailsActivity)
public class WebBasedCourseDetailsActivity extends BaseActivity {
    private WebBasedCourseDetailsActivityBinding mDataBinding;

    private RecyclerView recyclerView;
    private WebBaseCourseDetailsAdapter adapter;
    private List<WebCourseResponseBean.RecordsBean.SonListBean> list;
    private int page = 1;
    private String pageSize = "10";

    @Override
    public void onInit() {
        onInTitle();
        // 在目标活动（TargetActivity）中获取Bundle
        Bundle receivedBundle = getIntent().getExtras();
        list = (List<WebCourseResponseBean.RecordsBean.SonListBean>) receivedBundle.getSerializable("ENTITY_LIST");
        mDataBinding.tvItemName.setText(getIntent().getExtras().getString("ENTITY_LIST_tvTitle"));
        mDataBinding.tvItemDate.setText(getIntent().getExtras().getString("ENTITY_LIST_tvDate"));
        mDataBinding.tvItemAuthor.setText("作者：" + getIntent().getExtras().getString("ENTITY_LIST_tvAuthor"));
        Glide.with(this).load(getIntent().getExtras().getString("ENTITY_LIST_show_url")).into(mDataBinding.ivItemLeft);
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("课程分集");
        Bundle bundle = new Bundle();
        bundle.putString("url", getIntent().getExtras().getString("ENTITY_LIST_url"));
        onInitRV();
    }

    private void onInTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("网络课程详情");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void onInitRV() {
        recyclerView = mDataBinding.rlOperation;
        GridLayoutManager layoutManager = new GridLayoutManager(this,4,LinearLayoutManager.HORIZONTAL,false);//数字为行数或列数
        adapter = new WebBaseCourseDetailsAdapter(list, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        mDataBinding.ivItemLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("url", getIntent().getExtras().getString("ENTITY_LIST_url"));
                startActivityByRouter(ARouterPath.VideoActivity, bundle);


            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            //bundle.putString("url", list.get(position).getVideoUrl());
            if (null != list && list.size() > 0) {
                bundle.putString("ENTITY_LIST_tvTitle_two", list.get(position).getTitle());
                bundle.putString("ENTITY_LIST_tvDate_two", list.get(position).getUploadTime());
                bundle.putString("ENTITY_LIST_tvAuthor_two", list.get(position).getAuthor());
                bundle.putString("ENTITY_LIST_url_two", list.get(position).getVideoUrl());
                bundle.putString("ENTITY_LIST_show_url_two", list.get(position).getShowUrl());
                bundle.putString("ENTITY_LIST_introduction_two", list.get(position).getIntroduction());
                startActivityByRouter(ARouterPath.WebBasedCourseDetailsTwoActivity, bundle);
            }

        });
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.web_based_course_details_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
