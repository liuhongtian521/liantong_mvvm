package com.zdy.study.activitys;

import static com.askia.common.util.Utils.getActivity;
import static com.askia.common.util.Utils.listToString;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.askia.coremodel.datamodel.http.entities.consume.HistoryResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionTitleResponse;
import com.askia.coremodel.datamodel.http.entities.consume.Remark;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zdy.study.R;
import com.zdy.study.adapter.HistoryAdapter;
import com.zdy.study.adapter.InternationalPerspectiveAdapter;
import com.zdy.study.adapter.MyCollectionAdapter;
import com.zdy.study.cdatamodel.viewmodel.MyCollectionViewModel;
import com.zdy.study.cdatamodel.viewmodel.OperationDetailViewModel;
import com.zdy.study.databinding.CollectionMainBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.lang.reflect.Type;
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
    private int itemType = -1;//item样式
    private Gson gson;

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
            Bundle bundle = new Bundle();
            switch (view.getId()) {
                case R.id.fc_linearLayout:
                        bundle.putString("key", mListTitle.get(pageTab).getStruCode());
                        bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
                        startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
                    break;
                case R.id.iv_delete:
                    //删除一条
                    if (MyCollectionAdapter.FD == list.get(position).getItemType()) //联播速递分段 删除
                        viewModel.delCollectionList(list.get(position).getId(),
                                list.get(position).getMyRemark().getId(), mListTitle.get(pageTab).getStruCode());
                    else
                        viewModel.delCollectionList(list.get(position).getId(), mListTitle.get(pageTab).getStruCode());
                    break;
                case R.id.fcc_fdyd:
                    //联播速递分段 详情
                    bundle.putString("key", Constants.LBSD);
                    bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
                    bundle.putString("argContChildId", list.get(position).getMyRemark().getId());
                    startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
                    break;
            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            //跳转详情
            if (MyCollectionAdapter.MN == list.get(position).getItemType()) {//联播速递默认 跳视频播放
                Bundle bundle1 = new Bundle();
                bundle1.putString("url", list.get(position).getContVideo().getVideoUrl());
                startActivityByRouter(ARouterPath.VideoActivity, bundle1);
            }
            /*else if(MyCollectionAdapter.FD == list.get(position).getItemType()){//联播速递分段
                Bundle bundle = new Bundle();
                bundle.putString("key", Constants.SJAL);
                bundle.putString("INTERNATIONAL_VIEW", list.get(position).getMyRemark().getId());
                startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
            }*/
        });

    }

    private void inItRecycleView() {
        recyclerView = mMainBinding.rvBook;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new MyCollectionAdapter(list, clickTrueOrFalse);
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
            if (Constants.LBSD.equals(dataBean.getId())){
                tv.setText("联播速递");
            }else {
                tv.setText(dataBean.getStruName());
            }


            tab2.setCustomView(view);
            mMainBinding.tabLayout.addTab(tab2);
        }

        mMainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page = 1;
                pageTab = tab.getPosition();
                setItemType(mListTitle.get(pageTab).getStruCode());
                mMainBinding.etSearch.setText("");
                mMainBinding.tvDelete.setBackgroundResource(R.mipmap.ic_delect);
                viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(),
                        mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", String.valueOf(page), "10");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setItemType(String struCode){
        if (Constants.LBSD.equals(struCode))
            itemType = MyCollectionAdapter.LBSD;
        else
            itemType = MyCollectionAdapter.YWSL;
        /*switch (struCode){
            case Constants.YWSL:
                itemType = MyCollectionAdapter.YWSL;
                break;
            case Constants.LBSD:
                itemType = MyCollectionAdapter.LBSD;
                break;
        }*/
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

    //将分段数据加到list中
    private void makeFD(List<MyCollectionResponse.PageDataBean> data){
        if (gson == null)
            gson = new Gson();
        for (MyCollectionResponse.PageDataBean bean: data){
            bean.setFieldType(HistoryAdapter.MN);
            list.add(bean);
            if (!TextUtils.isEmpty(bean.getRemark())){
                Type type =new TypeToken<List<Remark>>(){}.getType();
                List<Remark> jsonObject = gson.fromJson(bean.getRemark(), type);
                for (Remark remark: jsonObject){
                    MyCollectionResponse.PageDataBean bean1 = new MyCollectionResponse.PageDataBean();
                    bean1.setId(bean.getId());
                    bean1.setMyRemark(remark);
                    bean1.setFieldType(HistoryAdapter.FD);
                    list.add(bean1);
                }
            }
        }
    }

    @Override
    public void onSubscribeViewModel() {
        //列表数据
        viewModel.getPageListPadData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mMainBinding.lmMaterialsView.setList(listResult.getResult().getPageData(), page);
            list.clear();
            if (itemType ==HistoryAdapter.LBSD)
                makeFD(listResult.getResult().getPageData());
            else {
                list.addAll(listResult.getResult().getPageData());
                //添加item样式
                for (MyCollectionResponse.PageDataBean pageDataBean : list)
                    pageDataBean.setFieldType(itemType);

            }

            adapter.notifyDataSetChanged();
        });
        //删除数据
        viewModel.getmDelCollectionListData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.isSuccess()) {
                viewModel.queryCollectionList(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(), mListTitle.get(pageTab).getStruCode(), mMainBinding.etSearch.getText() + "", "1", "10");
            }

        });
        //标题数据
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
                    setItemType(mListTitle.get(0).getStruCode());
                    viewModel.queryCollectionList(mListTitle.get(0).getStruCode(), mListTitle.get(0).getId(), mListTitle.get(0).getStruCode(), mMainBinding.etSearch.getText() + "", "1", "10");
                }
            }
        });
    }

    @Override
    public void onMResume() {

    }
}
