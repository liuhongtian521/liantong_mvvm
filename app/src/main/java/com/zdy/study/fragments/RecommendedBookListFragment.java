package com.zdy.study.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.http.entities.consume.BookListResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.StudyDictionaryBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.tabs.TabLayout;
import com.zdy.study.R;
import com.zdy.study.adapter.BookAdapter;
import com.zdy.study.adapter.BookListAdapter;
import com.zdy.study.cdatamodel.viewmodel.BookListViewModel;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.databinding.RecommendedBookListFragmentBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

/*推荐书单*/
public class RecommendedBookListFragment extends BaseFragment {
    private RecommendedBookListFragmentBinding mDataBinding;
    private BookListViewModel viewModel;
    private List<BookListResponseBean> mBookList;
    private List<BooksRespponseBean.PageDataBean> list;
    private RecyclerView recyclerView;
    private BookListAdapter adapter;
    private int pageTab = 0;
    private BooksRespponseBean.PageDataBean bean;
    private int page = 1;

    @Override
    public void onInit() {
        bean = new BooksRespponseBean.PageDataBean();
        list = new ArrayList<>();
        mBookList = new ArrayList<>();
        viewModel.bookClass(Constants.SJZD);
        viewModel.padList("1", "10", "");
        initRvListener();
        initLoad();
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(getActivity()).get(BookListViewModel.class);
    }

    public void operationSecondClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("BookListDetails", bean);
        bundle.putString("key", Constants.TJSD);
        bundle.putString("INTERNATIONAL_VIEW", list.get(0).getId());
        startActivityByRouter(ARouterPath.BookDetailsActivity, bundle);
    }

    public static RecommendedBookListFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        RecommendedBookListFragment fragment = new RecommendedBookListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    private void initRvListener() {
        recyclerView = mDataBinding.rvBook;
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());//数字为行数或列数
        adapter = new BookListAdapter(list, getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("BookListDetails", list.get(position));
            bundle.putString("key", Constants.TJSD);
            bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
            startActivityByRouter(ARouterPath.BookDetailsActivity, bundle);

        });
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.recommended_book_list_fragment, container, false);
        mDataBinding.setHandlers(this);
        return mDataBinding.getRoot();
    }

    private void initLoad() {
        mDataBinding.lmMaterialsView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                viewModel.padList(String.valueOf(page), "10", mBookList.get(pageTab).getClassification());
            }

            @Override
            public void previousPage() {
                page--;
                viewModel.padList(String.valueOf(page), "10", mBookList.get(pageTab).getClassification());
            }
        });
    }

    private void initTab() {
        TabLayout.Tab tab2;
        View view;
        BookListResponseBean bean = new BookListResponseBean();
        bean.setClassificName("全部");
        bean.setClassification("");
        mBookList.add(0, bean);
        mDataBinding.tabLayout.removeAllTabs();
        for (BookListResponseBean bookListResponseBean : mBookList) {
            tab2 = mDataBinding.tabLayout.newTab();
            //  tab2.setText(studyDictionaryBean.getDictValue());
            view = LayoutInflater.from(getActivity()).inflate(R.layout.tablayout_bg, null);
            TextView tv = (TextView) view.findViewById(R.id.tv_tablayout_name);
            tv.setText(bookListResponseBean.getClassificName());
            tab2.setCustomView(view);
            mDataBinding.tabLayout.addTab(tab2);
        }
        mDataBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page = 1;
                pageTab = tab.getPosition();
                viewModel.padList(String.valueOf(page), "10", mBookList.get(pageTab).getClassification());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mBookList.clear();
            if (null != listResult.getResult() && listResult.getResult().size() > 0) {
                mBookList.addAll(listResult.getResult());
                initTab();
            }
        });
        viewModel.getPageListPadData6().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                mDataBinding.lmMaterialsView.setList(listResult.getResult().getPageData(), page);
                list.addAll(listResult.getResult().getPageData());
                bean = list.get(0);
                mDataBinding.tvBookName.setText(list.get(0).getBookName());
                mDataBinding.tvBookAuthor.setText("(作者：" + list.get(0).getAuthorName() + ")");
                mDataBinding.tvContent.setText(list.get(0).getBriefIntroduction());
                if (!"".equals(list.get(0).getCoverUrl())) {
                    Glide.with(getActivity()).load(list.get(0).getCoverUrl()).into(mDataBinding.ivBookName);
                }
                list.remove(0);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
