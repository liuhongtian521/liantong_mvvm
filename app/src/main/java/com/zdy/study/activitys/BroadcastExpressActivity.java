package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.BroadcastExpressViewModel;
import com.zdy.study.cdatamodel.viewmodel.CourseQueryViewModel;
import com.zdy.study.databinding.BroadcastExpressActivityBinding;
@Route(path = ARouterPath.BroadcastExpressActivity)
public class BroadcastExpressActivity extends BaseActivity {
    private BroadcastExpressActivityBinding mDataBinding;
    private BroadcastExpressViewModel viewModel;
    @Override
    public void onInit() {
        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("联播速递");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
     //   viewModel.queryContListByAudit("E88194E692AD","10","1","10","1");
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(BroadcastExpressViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.broadcast_express_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
