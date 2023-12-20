package com.zdy.study.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.OperationAdapter;
import com.zdy.study.cdatamodel.viewmodel.SelectedTheoryViewModel;
import com.zdy.study.databinding.SelectedTheoryFragmentBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class SelectedTheoryFragment extends BaseFragment {
    private SelectedTheoryFragmentBinding binding;
    private SelectedTheoryViewModel viewModel;
    private int page = 1;
    private String pageSize = "10";
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private OperationAdapter adapter;
    @Override
    public void onInit() {

        initList();
        initLoad();
   //     showLogadingDialog();
        viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.JXLL);
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(getActivity()).get( SelectedTheoryViewModel.class);
    }
    public static SelectedTheoryFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        SelectedTheoryFragment fragment = new SelectedTheoryFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.selected_theory_fragment, container, false);
        return binding.getRoot();
    }

    private void initList(){
        list = new ArrayList<>();
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//第二个参数为网格的列数
        LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());//数字为行数或列数
        adapter = new OperationAdapter(list);
        binding.rlOperation.setLayoutManager(manager2);
        binding.rlOperation.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("argContId", list.get(position).getId());
            bundle.putString("struId", Constants.JXLL);
            startActivityByRouter(ARouterPath.OpreationDetailActivity, bundle);
        });
//        binding.rlOperation.requestFocus();
    }

    private void initLoad(){
        binding.lmViewOperation.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page ++;
                showLogadingDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.JXLL);
            }

            @Override
            public void previousPage() {
                page --;
                showLogadingDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.CZJQ);
            }
        });
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            closeLogadingDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            binding.lmViewOperation.setList(listResult.getResult().getPageData(), page);
            list.clear();
            list.addAll(listResult.getResult().getPageData());
            adapter.notifyDataSetChanged();
        });
    }
}
