package com.zdy.study.activitys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingConversion;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.HistoryResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionTitleResponse;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.tabs.TabLayout;
import com.zdy.study.R;
import com.zdy.study.adapter.HistoryAdapter;
import com.zdy.study.adapter.MyCollectionAdapter;
import com.zdy.study.cdatamodel.viewmodel.HistoryViewModel;
import com.zdy.study.databinding.ActivityHistoryBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;


@Route(path = ARouterPath.HistoryActivityActivity)
public class HistoryActivity extends BaseActivity {

    private ActivityHistoryBinding binding;
    private HistoryViewModel viewModel;
    private List<MyCollectionTitleResponse.DataBean> mListTitle;
    private List<HistoryResponse.PageDataBean> histotyList;
    private HistoryAdapter adapter;
    private int page = 1;
    private int itemType = -1;//item样式
    private int pageTab;

    @Override
    public void onInit() {
        histotyList = new ArrayList<>();
        inItRecycleView();
        viewModel.historyQueryStruList();//获取标题
        initLoad();
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history);
        binding.setHandlers(this);
    }
    private void inItRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new HistoryAdapter(histotyList);
        binding.rvHistory.setLayoutManager(layoutManager);
        binding.rvHistory.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (itemType == HistoryAdapter.LBSD){
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("url", histotyList.get(position).getContVideo().getVideoUrl());
                    startActivityByRouter(ARouterPath.VideoActivity, bundle1);
                }else if(itemType == HistoryAdapter.TJSD){
                    Bundle bundle = new Bundle();
                    BooksRespponseBean.PageDataBean pageDataBean = new BooksRespponseBean.PageDataBean();
                    pageDataBean.setBookName(histotyList.get(position).getBookName());
                    pageDataBean.setCoverUrl(histotyList.get(position).getImgUrl());
                    pageDataBean.setRecommendPerson(histotyList.get(position).getRecommendPerson());
                    pageDataBean.setBriefIntroduction(histotyList.get(position).getBriefIntroduction());
                    pageDataBean.setChapterContent(histotyList.get(position).getChapterContent());
                    bundle.putSerializable("BookListDetails", pageDataBean);
                    startActivityByRouter(ARouterPath.BookDetailsActivity, bundle);
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putString("key", mListTitle.get(pageTab).getStruCode());
                    bundle.putString("INTERNATIONAL_VIEW", histotyList.get(position).getId());
                    startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
                }
            }
        });
    }

    private void initLoad() {
        binding.lmHistoryView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.queryReadNotes(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(),
                        mListTitle.get(pageTab).getStruCode(), binding.etSearch.getText().toString(),
                        String.valueOf(page), "10");
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.queryReadNotes(mListTitle.get(pageTab).getStruCode(), mListTitle.get(pageTab).getId(),
                        mListTitle.get(pageTab).getStruCode(),binding.etSearch.getText().toString(),
                        String.valueOf(page), "10");
            }
        });
    }
    @Override
    public void onSubscribeViewModel() {
        //标题tab
        viewModel.getmhistoryQueryStruData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            setTitle(listResult.getResult().getData());
        });
        //列表
        viewModel.getmHistoryData().observe(this, listResult -> {
            dismissNetDialog();
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            //设置上一页 下一页 缺省页
            binding.lmHistoryView.setList(listResult.getResult().getPageData(), page);
            histotyList.clear();
            histotyList.addAll(listResult.getResult().getPageData());
            //添加item样式
            for (HistoryResponse.PageDataBean pageDataBean: histotyList)
                pageDataBean.setFieldType(itemType);

            adapter.notifyDataSetChanged();
        });
    }

    private void setTitle(List<MyCollectionTitleResponse.DataBean> data){
        //删除第七条
        if (data.size() >=7 )
            data.remove(6);

        List<MyCollectionTitleResponse.DataBean> titles = new ArrayList<>();
        //固定顺序 要闻速览 联播速递 国际视野 实践案例 精选理论 操作技巧 推荐书单
        String[] ids = {Constants.YWSL, Constants.LBSD, Constants.GJSY, Constants.SJAL,
                Constants.JXLL, Constants.CZJQ, Constants.TJSD};
        //排序
        for (String id : ids) {
            for (MyCollectionTitleResponse.DataBean dataBean : data) {
                if (id.equals(dataBean.getStruCode())) {
                    if (id.equals(Constants.LBSD))
                        dataBean.setStruName("联播速递");
                    titles.add(dataBean);

                }
            }
        }
        mListTitle = titles;
        setTab();
    }

    private void setItemType(String struCode){
        switch (struCode){
            case Constants.YWSL:
                itemType = HistoryAdapter.YWSL;
                break;
            case Constants.LBSD:
                itemType = HistoryAdapter.LBSD;
                break;
            case Constants.GJSY:
                itemType = HistoryAdapter.GJSY;
                break;
            case Constants.SJAL:
                itemType = HistoryAdapter.SJAL;
                break;
            case Constants.JXLL:
                itemType = HistoryAdapter.JXLL;
                break;
            case Constants.CZJQ:
                itemType = HistoryAdapter.CZJQ;
                break;
            case Constants.TJSD:
                itemType = HistoryAdapter.TJSD;
                break;
        }
    }
    private void setTab(){
        TabLayout.Tab tab;
        View view;
        for (MyCollectionTitleResponse.DataBean dataBean : mListTitle) {
            tab = binding.tabLayout.newTab();
            //  tab2.setText(studyDictionaryBean.getDictValue());
            view = LayoutInflater.from(this).inflate(R.layout.tablayout_bg_two, null);
            TextView tv = (TextView) view.findViewById(R.id.tv_tablayout_name);
            tv.setText(dataBean.getStruName());
            tab.setCustomView(view);
            binding.tabLayout.addTab(tab);
        }

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pageTab = tab.getPosition();
                getListData(mListTitle.get(pageTab));//根据选择tab 获取第一页列表数据
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        getListData(mListTitle.get(0));//根据选择tab 获取第一页列表数据
    }

    private void getListData(MyCollectionTitleResponse.DataBean title){
        //设置itemtype 样式
        setItemType(title.getStruCode());
        page = 1;
        showNetDialog();
        viewModel.queryReadNotes(title.getStruCode(), title.getId(), title.getStruCode(),
                binding.etSearch.getText().toString(), String.valueOf(page), "10");
    }

    public void onClickSearch(View view) {
        getListData(mListTitle.get(pageTab));//根据选择tab 获取第一页列表数据
    }
    @Override
    public void onMResume() {

    }
}
