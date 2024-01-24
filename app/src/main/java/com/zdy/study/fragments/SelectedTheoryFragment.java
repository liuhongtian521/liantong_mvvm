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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
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
    private String pageSize = "5";
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private OperationAdapter adapter;
    private String Id;
    @Override
    public void onInit() {

        initList();
        initLoad();
   //     showLogadingDialog();
        viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.JXLL);
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
        GridLayoutManager manager2 = new GridLayoutManager(getActivity(),4,LinearLayoutManager.HORIZONTAL,false);//数字为行数或列数
        adapter = new OperationAdapter(list);
        binding.rlOperation.setLayoutManager(manager2);
        binding.rlOperation.setAdapter(adapter);
        binding.clItemLeft.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", Constants.JXLL);
            bundle.putString("INTERNATIONAL_VIEW", Id);
            startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
        });

        adapter.setOnItemClickListener((adapter, view, position) -> {
            /*Bundle bundle = new Bundle();
            bundle.putString("argContId", list.get(position).getId());
            bundle.putString("struId", Constants.JXLL);
            startActivityByRouter(ARouterPath.OpreationDetailActivity, bundle);*/

            Bundle bundle = new Bundle();
            bundle.putString("key", Constants.JXLL);
            bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
            startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
        });
//        binding.rlOperation.requestFocus();
    }

    private void initLoad(){
        binding.lmViewOperation.setPageSize(Integer.parseInt(pageSize));//设置页面条数
        binding.lmViewOperation.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page ++;
                showLogadingDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.JXLL);
            }

            @Override
            public void previousPage() {
                page --;
                showLogadingDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.CZJQ);
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
            if (null!=listResult.getResult().getPageData()&&listResult.getResult().getPageData().size()>0){
                binding.tvItemName.setText(listResult.getResult().getPageData().get(0).getContName());
                Id=listResult.getResult().getPageData().get(0).getId();
                binding.tvItemDate.setText(listResult.getResult().getPageData().get(0).getCreateTime().substring(0, 10));
                Glide.with(this).load(listResult.getResult().getPageData().get(0).getImgUrl()).into(binding.ivItemLeft);
                listResult.getResult().getPageData().remove(0);
                list.addAll(listResult.getResult().getPageData());
            }
            adapter.notifyDataSetChanged();
        });
    }
}
