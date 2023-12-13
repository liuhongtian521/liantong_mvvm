package com.zdy.study.activitys;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.InternationalPerspectiveAdapter;
import com.zdy.study.adapter.WebBaseCourseAdapter;
import com.zdy.study.cdatamodel.viewmodel.InternationalPerspectiveViewModel;
import com.zdy.study.cdatamodel.viewmodel.WebBasedCourseViewModel;
import com.zdy.study.databinding.InternationalPerspectiveActivityBinding;
import com.zdy.study.databinding.WebBasedCourseActivityBinding;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*国际视野列表*/
@Route(path = ARouterPath.InternationalPerspectiveActivity)
public class InternationalPerspectiveActivity extends BaseActivity {
    private InternationalPerspectiveActivityBinding mDataBinding;
    private InternationalPerspectiveViewModel viewModel;
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private InternationalPerspectiveAdapter adapter;
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
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("国际视野");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void initList() {

        list = new ArrayList<>();
        viewModel.queryContListByAudit("1", "10", "INTERNATIONAL_VIEW");
        recyclerView = mDataBinding.rvWeb;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new InternationalPerspectiveAdapter(list, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        mDataBinding.ivHeadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != list && list.size() > 0) {
                    Bundle bundle = new Bundle();
                    //      bundle.putString("url", list.get(0).getVideoUrl());
                    startActivityByRouter(ARouterPath.VideoActivity, bundle);
                }

            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
        });
    }

    private void initLoad() {
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, "INTERNATIONAL_VIEW");
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, "INTERNATIONAL_VIEW");
            }
        });
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(InternationalPerspectiveViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.international_perspective_activity);
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            dismissNetDialog();
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.getResult().getPageData() == null || listResult.getResult().getPageData().size() == 0) {
                mDataBinding.lmView.showEmptyView(View.VISIBLE);
                return;
            } else
                mDataBinding.lmView.showEmptyView(View.GONE);
            if (page == 1)
                mDataBinding.lmView.setPreviousPageVisibility(View.GONE);
            else
                mDataBinding.lmView.setPreviousPageVisibility(View.VISIBLE);
            if (listResult.getResult().getPageData().size() < 10)
                mDataBinding.lmView.setNextPageVisibility(View.GONE);
            else
                mDataBinding.lmView.setNextPageVisibility(View.VISIBLE);
            list.clear();
            list.addAll(listResult.getResult().getPageData());
            mDataBinding.tvVideoName.setText(list.get(0).getContName());
            mDataBinding.tvVideoDate.setText(list.get(0).getCreateTime().substring(0, 10));
            if (null != list && list.size() > 0 && !"".equals(list.get(0).getImgUrl())) {
                Glide.with(this).load(list.get(0).getImgUrl()).into(mDataBinding.ivHeadVideo);
            }
            list.remove(0);


            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onMResume() {

    }
}
