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
import com.zdy.study.tools.Constants;
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
    private BroadcastExpressResponBean.PageDataBean pageDataBean;
    private InternationalPerspectiveAdapter adapter;
    private RecyclerView recyclerView;
    private int page = 1;
    private String pageSize = "10";
    private String KeyWord;

    @Override
    public void onInit() {
        list = new ArrayList<>();
        KeyWord = getIntent().getExtras().getString("KeyWord");
        initList();
        initLoad();
    }

    private void onInTitle(String title) {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText(title);
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void initList() {
        if (Constants.GJSY.equals(KeyWord)) {
            onInTitle("国际视野");
            viewModel.queryContListByAudit("1", "10", Constants.GJSY);
        } else {
            //实践案列
            onInTitle("实践案例");
            viewModel.queryContListByAudit("1", "10", Constants.SJAL);
        }
        list = new ArrayList<>();
        recyclerView = mDataBinding.rvWeb;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new InternationalPerspectiveAdapter(list, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        mDataBinding.fcrVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != list && list.size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", pageDataBean.getContVideo().getVideoUrl());
                    startActivityByRouter(ARouterPath.VideoActivity, bundle);
                }

            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", KeyWord);
            bundle.putInt("PraiseCount", list.get(position).getPraiseCount());
            bundle.putString("Collection", list.get(position).getCollection());
            bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
            startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
        });
    }

    private void initLoad() {
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.GJSY);
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.GJSY);
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
            mDataBinding.lmView.setList(listResult.getResult().getPageData(), page);
            list.clear();
            list.addAll(listResult.getResult().getPageData());
            if (list.size() > 0) {
                pageDataBean = list.get(0);
                mDataBinding.tvVideoName.setText(list.get(0).getContName());
                mDataBinding.tvVideoDate.setText(list.get(0).getCreateTime().substring(0, 10));
                if (null != list && list.size() > 0 && !"".equals(list.get(0).getImgUrl())) {
                    Glide.with(this).load(list.get(0).getImgUrl()).into(mDataBinding.ivHeadVideo);
                }
                list.remove(0);
            }
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onMResume() {

    }
}
