package com.zdy.study.activitys;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.Remark;
import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zdy.study.R;
import com.zdy.study.adapter.BroadcastExpressAdapter;
import com.zdy.study.adapter.CourseQueryDetailsAdapter;
import com.zdy.study.cdatamodel.viewmodel.BroadcastExpressViewModel;
import com.zdy.study.cdatamodel.viewmodel.CourseQueryViewModel;
import com.zdy.study.databinding.BroadcastExpressActivityBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.BroadcastExpressActivity)
public class BroadcastExpressActivity extends BaseActivity {
    private BroadcastExpressActivityBinding mDataBinding;
    private BroadcastExpressViewModel viewModel;
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private RecyclerView recyclerView;
    private BroadcastExpressAdapter adapter;
    private int page = 1;
    private String pageSize = "9";
    private String keyId;
    private Bundle bundle;
    private Gson gson;

    @Override
    public void onInit() {
        bundle = getIntent().getExtras();
        keyId = bundle.getString("keyId");
        mDataBinding.lmView.setNextPageVisibility(View.GONE);
        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("联播速递");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
        initList();
        if (EmptyUtils.isEmpty(keyId)) {
            initLoad();
            mDataBinding.lmView.setNextPageVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("LongLogTag")
    private void initList() {
        list = new ArrayList<>();
        if (EmptyUtils.isEmpty(keyId)) {
            Log.e("BroadcastExpressActivity", "keyId" + keyId);
            viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.LBSD);
        } else {
            list.clear();
            BroadcastExpressResponBean.PageDataBean pageDataBean = (BroadcastExpressResponBean.PageDataBean) bundle.getSerializable("MainFragmentList");
            list.add(pageDataBean);
        }
        recyclerView = mDataBinding.rvBroadcastExpress;
         GridLayoutManager layoutManager = new GridLayoutManager(this, 3);//第二个参数为网格的列数
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new BroadcastExpressAdapter(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter, view, position) -> {
            switch (list.get(position).getItemType()) {
                case BroadcastExpressAdapter.MN:
                    HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();
                    if (!TextUtils.isEmpty(httpLoginResult.getAccess_token()))
                        viewModel.addReadNotes(list.get(position).getId(), Constants.LBSD);//添加阅读记录
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("url", list.get(position).getContVideo().getVideoUrl());
                    startActivityByRouter(ARouterPath.VideoActivity, bundle1);
                    break;
                case BroadcastExpressAdapter.FD:
                    Bundle bundle = new Bundle();
                    bundle.putString("key", Constants.LBSD);
                    bundle.putString("INTERNATIONAL_VIEW", list.get(position).getId());
                    bundle.putString("argContChildId", list.get(position).getMyRemark().getId());
                    startActivityByRouter(ARouterPath.InternationalPerspectiveDetailsActivity, bundle);
                    break;
            }
        });
        recyclerView.requestFocus();
    }

    private void initLoad() {
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.LBSD);
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.queryContListByAudit(String.valueOf(page), pageSize,String.valueOf(page), pageSize, Constants.LBSD);
            }
        });
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(BroadcastExpressViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.broadcast_express_activity);
    }

    @SuppressLint("LongLogTag")
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

//            makeFD(listResult.getResult().getPageData());//添加分段要点

            list.addAll(listResult.getResult().getPageData());
            adapter.notifyDataSetChanged();
        });

    }
    //将分段数据加到list中
    private void makeFD(List<BroadcastExpressResponBean.PageDataBean> data){
        if (gson == null)
            gson = new Gson();
        for (BroadcastExpressResponBean.PageDataBean bean: data){
            bean.setFieldType(BroadcastExpressAdapter.MN);
            list.add(bean);
            if (!TextUtils.isEmpty(bean.getRemark())){
                Type type =new TypeToken<List<Remark>>(){}.getType();
                List<Remark> jsonObject = gson.fromJson(bean.getRemark(), type);
                for (Remark remark: jsonObject){
                    BroadcastExpressResponBean.PageDataBean bean1 = new BroadcastExpressResponBean.PageDataBean();
                    bean1.setId(bean.getId());
                    bean1.setMyRemark(remark);
                    bean1.setFieldType(BroadcastExpressAdapter.FD);
                    list.add(bean1);
                }
            }
        }
    }

    @Override
    public void onMResume() {

    }
}
