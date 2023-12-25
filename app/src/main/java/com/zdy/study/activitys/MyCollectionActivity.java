package com.zdy.study.activitys;

import static com.askia.common.util.Utils.getActivity;
import static com.askia.common.util.Utils.listToString;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BookListResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionTitleResponse;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.tabs.TabLayout;
import com.zdy.study.R;
import com.zdy.study.adapter.InternationalPerspectiveAdapter;
import com.zdy.study.adapter.MyCollectionAdapter;
import com.zdy.study.cdatamodel.viewmodel.MyCollectionViewModel;
import com.zdy.study.cdatamodel.viewmodel.OperationDetailViewModel;
import com.zdy.study.databinding.CollectionMainBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.MyCollectionActivity)
public class MyCollectionActivity extends BaseActivity {
    private CollectionMainBinding mMainBinding;
    private MyCollectionViewModel viewModel;
    private List<MyCollectionResponse.PageDataBean> list;
    private List<MyCollectionTitleResponse.DataBean> mListTitle;
    private int pageTab = 0;
    private RecyclerView recyclerView;
    private MyCollectionAdapter adapter;
    private int page = 1;
    private boolean clickTrueOrFalse = false;

    @Override
    public void onInit() {
        list = new ArrayList<>();
        mListTitle = new ArrayList<>();
        viewModel.queryStruList();
        inItRecycleView();
        initLoad();
        inInRVOnListen();
    }

    @SuppressLint("NonConstantResourceId")
    private void inInRVOnListen() {
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.fc_linearLayout:
                        Bundle bundle = new Bundle();
                        bundle.putString("key", mListTitle.get(pageTab).getStruCode());
                        bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
                        startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
                    break;
                case R.id.iv_delete:
                    //删除一条
                    viewModel.delCollectionList(list.get(position).getId(), mListTitle.get(pageTab).getStruCode());
                    viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(), mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", "1", "10");
                    break;
            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            //跳转详情
            if (Constants.CZJQ.equals(mListTitle.get(pageTab))) {
                Bundle bundle = new Bundle();
                bundle.putString("argContId", list.get(position).getId());
                bundle.putString("struId", Constants.CZJQ);
                startActivityByRouter(ARouterPath.OpreationDetailActivity, bundle);
            } else if (Constants.JXLL.equals(mListTitle.get(pageTab))) {
                //跳转详情
                Bundle bundle = new Bundle();
                bundle.putString("argContId", list.get(position).getId());
                bundle.putString("struId", Constants.JXLL);
                startActivityByRouter(ARouterPath.OpreationDetailActivity, bundle);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("key", mListTitle.get(pageTab).getStruCode());
                bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
                startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
            }
        });

    }

    private void inItRecycleView() {
        recyclerView = mMainBinding.rvBook;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new MyCollectionAdapter(list, this, clickTrueOrFalse);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void inInTab() {
        TabLayout.Tab tab2;
        View view;
        mMainBinding.tabLayout.removeAllTabs();
        for (MyCollectionTitleResponse.DataBean dataBean : mListTitle) {
            tab2 = mMainBinding.tabLayout.newTab();
            //  tab2.setText(studyDictionaryBean.getDictValue());
            view = LayoutInflater.from(this).inflate(R.layout.tablayout_bg_two, null);
            TextView tv = (TextView) view.findViewById(R.id.tv_tablayout_name);
            tv.setText(dataBean.getStruName());
            tab2.setCustomView(view);
            mMainBinding.tabLayout.addTab(tab2);
        }

        mMainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page = 1;
                pageTab = tab.getPosition();
                mMainBinding.etSearch.setText("");
                viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(), mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", String.valueOf(page), "10");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void onClickSearch(View view) {
        viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(), mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", "1", "10");
    }

    public void onClickDelete(View view) {
        if (clickTrueOrFalse) {
            mMainBinding.tvDelete.setBackgroundResource(R.mipmap.ic_delect);
            clickTrueOrFalse = false;
            for (MyCollectionResponse.PageDataBean pageDataBean : list) {
                pageDataBean.setTrueOrFalse(clickTrueOrFalse);
            }
            adapter.notifyDataSetChanged();
        } else {
            mMainBinding.tvDelete.setBackgroundResource(R.mipmap.ic_true);
            clickTrueOrFalse = true;
            for (MyCollectionResponse.PageDataBean pageDataBean : list) {
                pageDataBean.setTrueOrFalse(clickTrueOrFalse);
            }
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(MyCollectionViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.collection_main);
        mMainBinding.setHandlers(this);
    }

    private void initLoad() {
        mMainBinding.lmMaterialsView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(), mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", String.valueOf(page), "10");
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(), mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", String.valueOf(page), "10");
            }
        });
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.isSuccess()) {
                if (null != listResult.getResult().getPageData()) {
                    list.clear();
                    list.addAll(listResult.getResult().getPageData());
                    mMainBinding.lmMaterialsView.setList(listResult.getResult().getPageData(), page);
                }
            }
            adapter.notifyDataSetChanged();
        });
        viewModel.getPageListPadData1().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.isSuccess()) {
                if (null != listResult.getResult()) {
                    mListTitle.clear();
                    mListTitle.addAll(listResult.getResult().getData());
                    inInTab();
                    viewModel.queryCollectionList(mListTitle.get(0).getStruCode(), mListTitle.get(0).getId(), mListTitle.get(0).getStruCode(), mMainBinding.etSearch.getText() + "", "1", "10");
                }
            }
        });
    }

    @Override
    public void onMResume() {

    }
}
