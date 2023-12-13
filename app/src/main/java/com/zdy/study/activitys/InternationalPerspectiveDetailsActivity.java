package com.zdy.study.activitys;

import android.os.Bundle;
import android.view.View;

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

    @Override
    public void onInit() {
        onInTitle();
        viewModel.queryCont(getIntent().getExtras().getString("INTERNATIONAL_VIEW"));
    }

    private void onInTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("国际视野详情");
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

            // 在目标活动（TargetActivity）中获取Bundle
            mDataBinding.tvTitle.setText(listResult.getResult().getContName());
            mDataBinding.tvDate.setText(listResult.getResult().getDisplayTime());
            mDataBinding.tvIntroduction.setText(getIntent().getExtras().getString("ENTITY_LIST_introduction_two"));
            mDataBinding.tvAuthor.setText("作者：" + listResult.getResult().getLink());
            Glide.with(this).load(listResult.getResult().getImgUrl()).into(mDataBinding.ivVideo);
            mDataBinding.tvTitleCourse.setText("课程介绍");
        });
        
    }

    @Override
    public void onMResume() {

    }
}
