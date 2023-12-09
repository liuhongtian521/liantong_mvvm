package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.databinding.ActVideoBinding;


@Route(path = ARouterPath.VideoActivity)
public class VideoActivity extends BaseActivity {

    private ActVideoBinding mDataBinding;
    private String url;
    @Override
    public void onInit() {
        url = getIntent().getExtras().getString("url");
        mDataBinding.vvcl.setUrl(url);
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_video);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDataBinding.vvcl.destroy();
    }
}
