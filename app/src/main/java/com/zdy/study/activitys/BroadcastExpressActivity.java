package com.zdy.study.activitys;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.BroadcastExpressAdapter;
import com.zdy.study.adapter.CourseQueryDetailsAdapter;
import com.zdy.study.cdatamodel.viewmodel.BroadcastExpressViewModel;
import com.zdy.study.cdatamodel.viewmodel.CourseQueryViewModel;
import com.zdy.study.databinding.BroadcastExpressActivityBinding;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.BroadcastExpressActivity)
public class BroadcastExpressActivity extends BaseActivity {
    private BroadcastExpressActivityBinding mDataBinding;
    private BroadcastExpressViewModel viewModel;
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private RecyclerView recyclerView;
    private BroadcastExpressAdapter adapter;
    private int page = 1;
    private String pageSize = "10";


    @Override
    public void onInit() {

        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("联播速递");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
        initList();
        initLoad();
    }

    private void initList(){
        list = new ArrayList<>();
        viewModel.queryContListByAudit(String.valueOf(page), pageSize, "E8\u200C81\u200C94E6\u200C92\u200CAD_parent");
        recyclerView = mDataBinding.rvBroadcastExpress;
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//第二个参数为网格的列数
//        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new BroadcastExpressAdapter(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("url", list.get(position).getContVideo().getVideoUrl());
            startActivityByRouter(ARouterPath.VideoActivity, bundle);
        });
        recyclerView.requestFocus();
    }
    private void initLoad(){
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page ++;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, "E8\u200C81\u200C94E6\u200C92\u200CAD_parent");
            }

            @Override
            public void previousPage() {
                page --;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, "E8\u200C81\u200C94E6\u200C92\u200CAD_parent");
            }
        });
    }
    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(BroadcastExpressViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.broadcast_express_activity);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.getResult().getPageData().size() == 0) {
                mDataBinding.lmView.showEmptyView(View.VISIBLE);
                return;
            }else{
                mDataBinding.lmView.showEmptyView(View.GONE);
            }
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
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onMResume() {

    }
}
