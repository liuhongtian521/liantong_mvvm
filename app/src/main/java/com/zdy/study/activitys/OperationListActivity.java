package com.zdy.study.activitys;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.OperationAdapter;
import com.zdy.study.cdatamodel.viewmodel.OperationViewModel;
import com.zdy.study.databinding.ActOperationListBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.OpreationActivity)
public class OperationListActivity extends BaseActivity {

    private ActOperationListBinding binding;
    private OperationViewModel viewModel;
    private int page = 1;
    private String pageSize = "5";
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private OperationAdapter adapter;
    private String Id;

    @Override
    public void onInit() {
        //标题
        binding.includeLayout.preferenceActivityTitleText.setText("操作技巧");

        initList();
        initLoad();
        showNetDialog();
        viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.CZJQ);
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(OperationViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.act_operation_list);
    }

    private void initList(){
        list = new ArrayList<>();
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//第二个参数为网格的列数
        GridLayoutManager manager2 = new GridLayoutManager(this,4,LinearLayoutManager.HORIZONTAL,false);//数字为行数或列数
        adapter = new OperationAdapter(list);
        binding.includeLayoutList.rlOperation.setLayoutManager(manager2);
        binding.includeLayoutList.rlOperation.setAdapter(adapter);
        binding.includeLayoutList.clItemLeft.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", Constants.JXLL);
            bundle.putString("INTERNATIONAL_VIEW", Id);
            startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            /*Bundle bundle = new Bundle();
            bundle.putString("argContId", list.get(position).getId());
            bundle.putString("struId", Constants.CZJQ);
            startActivityByRouter(ARouterPath.OpreationDetailActivity, bundle);*/

            Bundle bundle = new Bundle();
            bundle.putString("key", Constants.CZJQ);
            bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
            startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
        });
        binding.includeLayoutList.rlOperation.requestFocus();
    }

    private void initLoad(){
        binding.includeLayoutList.lmViewOperation.setPageSize(Integer.parseInt(pageSize));//设置页面条数
        binding.includeLayoutList.lmViewOperation.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page ++;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.CZJQ);
            }

            @Override
            public void previousPage() {
                page --;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.CZJQ);
            }
        });
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            dismissNetDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            binding.includeLayoutList.lmViewOperation.setList(listResult.getResult().getPageData(), page);
            list.clear();
            if (null!=listResult.getResult().getPageData()&&listResult.getResult().getPageData().size()>0){
                binding.includeLayoutList.tvItemName.setText(listResult.getResult().getPageData().get(0).getContName());
                Id=listResult.getResult().getPageData().get(0).getId();
                binding.includeLayoutList.tvItemDate.setText(listResult.getResult().getPageData().get(0).getCreateTime().substring(0, 10));
                Glide.with(this).load(listResult.getResult().getPageData().get(0).getImgUrl()).into(binding.includeLayoutList.ivItemLeft);
                listResult.getResult().getPageData().remove(0);
                list.addAll(listResult.getResult().getPageData());
            }
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onMResume() {

    }
}
