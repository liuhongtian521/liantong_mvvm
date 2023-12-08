package com.zdy.study.activitys;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.zdy.study.R;
import com.zdy.study.adapter.BroadcastExpressAdapter;
import com.zdy.study.adapter.CourseQueryDetailsAdapter;
import com.zdy.study.cdatamodel.viewmodel.BroadcastExpressViewModel;
import com.zdy.study.cdatamodel.viewmodel.CourseQueryViewModel;
import com.zdy.study.databinding.BroadcastExpressActivityBinding;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.BroadcastExpressActivity)
public class BroadcastExpressActivity extends BaseActivity {
    private BroadcastExpressActivityBinding mDataBinding;
    private BroadcastExpressViewModel viewModel;
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private RecyclerView recyclerView;
    private BroadcastExpressAdapter adapter;


    @Override
    public void onInit() {

        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("联播速递");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
        list = new ArrayList<>();
        viewModel.queryContListByAudit("1", "10", "E8\u200C81\u200C94E6\u200C92\u200CAD_parent");
        recyclerView = mDataBinding.rvBroadcastExpress;

        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new BroadcastExpressAdapter(list);
        recyclerView.setLayoutManager(manager2);
        recyclerView.setAdapter(adapter);

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
            if (listResult.isSuccess()) {
                if (null != listResult.getResult()) {
                    list.clear();
                    list.addAll(listResult.getResult().getPageData());
                    Log.e("BroadcastExpressActivity", "onSubscribeViewModel: "+list.toString() );
                }
            }
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onMResume() {

    }
}
