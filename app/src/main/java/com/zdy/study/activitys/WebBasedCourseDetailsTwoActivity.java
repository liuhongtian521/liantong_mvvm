package com.zdy.study.activitys;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.WebBaseCourseDetailsAdapter;
import com.zdy.study.databinding.WebBasedCourseDetailsTwoActivityBinding;

import java.util.List;

@Route(path = ARouterPath.WebBasedCourseDetailsTwoActivity)
public class WebBasedCourseDetailsTwoActivity extends BaseActivity {
    private WebBasedCourseDetailsTwoActivityBinding mDataBinding;

    private RecyclerView recyclerView;
    private WebBaseCourseDetailsAdapter adapter;
    private List<WebCourseResponseBean.RecordsBean.SonListBean> list;
    private int page = 1;
    private String pageSize = "10";

    @Override
    public void onInit() {
        onInTitle();

        // 在目标活动（TargetActivity）中获取Bundle
        mDataBinding.tvTitle.setText(getIntent().getExtras().getString("ENTITY_LIST_tvTitle_two"));
        mDataBinding.tvDate.setText(getIntent().getExtras().getString("ENTITY_LIST_tvDate_two"));
        mDataBinding.tvIntroduction.setText(getIntent().getExtras().getString("ENTITY_LIST_introduction_two"));
        mDataBinding.tvAuthor.setText("作者：" + getIntent().getExtras().getString("ENTITY_LIST_tvAuthor_two"));
        Glide.with(this).load(getIntent().getExtras().getString("ENTITY_LIST_show_url_two")).into(mDataBinding.ivVideo);
        mDataBinding.tvTitleCourse.setText("课程介绍");
        onInitRV();
    }
    private void onInTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("网络课程详情");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void onInitRV() {
        mDataBinding.ivVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("url", getIntent().getExtras().getString("ENTITY_LIST_url_two"));
                startActivityByRouter(ARouterPath.VideoActivity, bundle);


            }
        });

    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.web_based_course_details_two_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
