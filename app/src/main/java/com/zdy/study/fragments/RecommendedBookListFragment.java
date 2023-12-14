package com.zdy.study.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.http.entities.consume.BookListResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.BookAdapter;
import com.zdy.study.adapter.BookListAdapter;
import com.zdy.study.cdatamodel.viewmodel.BookListViewModel;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.databinding.RecommendedBookListFragmentBinding;
import com.zdy.study.tools.Constants;

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

    @Override
    public void onInit() {
        list = new ArrayList<>();
        mBookList = new ArrayList<>();
        viewModel.bookClass(Constants.SJZD);
        viewModel.padList("1", "10", "");
        initRvListener();
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(getActivity()).get(BookListViewModel.class);
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
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.recommended_book_list_fragment, container, false);
        return mDataBinding.getRoot();
    }

    @SuppressLint("SetTextI18n")
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
            }
        });
        viewModel.getPageListPadData6().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.addAll(listResult.getResult().getPageData());

                list.get(0).getAuthorName();
                mDataBinding.tvBookName.setText(list.get(0).getBookName());
                mDataBinding.tvBookAuthor.setText("(" + list.get(0).getAuthorName() + ")");
                mDataBinding.tvContent.setText(list.get(0).getAuthorIntroduction());
                if (!"".equals(list.get(0).getCoverUrl())) {
                    Glide.with(getActivity()).load(list.get(0).getCoverUrl()).into(mDataBinding.ivBookName);
                }
                list.remove(0);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
