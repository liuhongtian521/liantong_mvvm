package com.zdy.study.activitys;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.AddressBookAdapter;
import com.zdy.study.adapter.BroadcastExpressAdapter;
import com.zdy.study.adapter.WebBaseCourseAdapter;
import com.zdy.study.cdatamodel.viewmodel.AddressBookViewModel;
import com.zdy.study.cdatamodel.viewmodel.WebBasedCourseViewModel;
import com.zdy.study.databinding.WebBasedCourseActivityBinding;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.WebBasedCourseActivity)
public class WebBasedCourseActivity extends BaseActivity {
    private WebBasedCourseActivityBinding mDataBinding;
    private WebBasedCourseViewModel viewModel;
    private List<WebCourseResponseBean.RecordsBean> list;
    private WebBaseCourseAdapter adapter;
    private RecyclerView recyclerView;
    private int page = 1;
    private String pageSize = "10";


    @Override
    public void onInit() {
        list = new ArrayList<>();
        onInTitle();
        initList();
        initLoad();
    }
    private void onInTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("网络课程列表");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }
    private void initList() {

        list = new ArrayList<>();
        viewModel.pageByApp("1", "10");
        recyclerView = mDataBinding.rvWeb;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new WebBaseCourseAdapter(list, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        mDataBinding.ivHeadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != list && list.size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", list.get(0).getVideoUrl());
                    startActivityByRouter(ARouterPath.VideoActivity, bundle);
                }

            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            //bundle.putString("url", list.get(position).getVideoUrl());
            if (null!=list&&list.size()>0){
                bundle.putSerializable("ENTITY_LIST", (ArrayList<? extends Serializable>) list.get(position).getSonList());
                bundle.putString("ENTITY_LIST_tvTitle", list.get(position).getTitle());
                bundle.putString("ENTITY_LIST_tvDate",  list.get(position).getUploadTime());
                bundle.putString("ENTITY_LIST_tvAuthor",  list.get(position).getAuthor());
                bundle.putString("ENTITY_LIST_url",  list.get(position).getVideoUrl());
                bundle.putString("ENTITY_LIST_show_url",  list.get(position).getShowUrl());
                startActivityByRouter(ARouterPath.WebBasedCourseDetailsActivity, bundle);
            }else {
                bundle.putString("ENTITY_LIST_tvTitle_two", list.get(position).getTitle());
                bundle.putString("ENTITY_LIST_tvDate_two",  list.get(position).getUploadTime());
                bundle.putString("ENTITY_LIST_tvAuthor_two",  list.get(position).getAuthor());
                bundle.putString("ENTITY_LIST_url_two",  list.get(position).getVideoUrl());
                bundle.putString("ENTITY_LIST_show_url_two",  list.get(position).getShowUrl());
                bundle.putString("ENTITY_LIST_introduction_two",  list.get(position).getIntroduction());
                startActivityByRouter(ARouterPath.WebBasedCourseDetailsTwoActivity, bundle);
            }

        });
    }

    private void initLoad() {
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.pageByApp(String.valueOf(page), pageSize);
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.pageByApp(String.valueOf(page), pageSize);
            }
        });
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(WebBasedCourseViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.web_based_course_activity);
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            dismissNetDialog();
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.getData().getRecords() == null ||listResult.getData().getRecords().size() == 0) {
                mDataBinding.lmView.showEmptyView(View.VISIBLE);
                return;
            } else
                mDataBinding.lmView.showEmptyView(View.GONE);
            if (page == 1)
                mDataBinding.lmView.setPreviousPageVisibility(View.GONE);
            else
                mDataBinding.lmView.setPreviousPageVisibility(View.VISIBLE);
            if (listResult.getData().getRecords().size() < 10)
                mDataBinding.lmView.setNextPageVisibility(View.GONE);
            else
                mDataBinding.lmView.setNextPageVisibility(View.VISIBLE);
            list.clear();
            list.addAll(listResult.getData().getRecords());
            adapter.notifyDataSetChanged();
            if (null != list && list.size() > 0 && !"".equals(list.get(0).getShowUrl())) {
                Glide.with(this).load(list.get(0).getShowUrl()).into(mDataBinding.ivHeadVideo);
            }
        });
    }

    @Override
    public void onMResume() {

    }
}
