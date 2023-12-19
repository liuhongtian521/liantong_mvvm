package com.zdy.study.activitys;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.blankj.utilcode.util.ToastUtils;
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
    private String pageSize = "10";
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private OperationAdapter adapter;

    @Override
    public void onInit() {
        //标题
        binding.includeLayout.preferenceActivityTitleText.setText("操作技巧");

        initList();
        initLoad();
        showNetDialog();
        viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.CZJQ);
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
        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new OperationAdapter(list);
        binding.rlOperation.setLayoutManager(manager2);
        binding.rlOperation.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("argContId", list.get(position).getId());
            bundle.putString("struId", Constants.CZJQ);
            startActivityByRouter(ARouterPath.OpreationDetailActivity, bundle);
        });
        binding.rlOperation.requestFocus();
    }

    private void initLoad(){
        binding.lmViewOperation.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page ++;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.CZJQ);
            }

            @Override
            public void previousPage() {
                page --;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize, Constants.CZJQ);
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
            binding.lmViewOperation.setList(listResult.getResult().getPageData(), page);
            list.clear();
            list.addAll(listResult.getResult().getPageData());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onMResume() {

    }
}
