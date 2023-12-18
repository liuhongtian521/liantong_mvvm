package com.zdy.study.activitys;

import android.view.KeyEvent;

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

    public boolean onKeyDown(int kCode, KeyEvent kEvent)
    {
        switch(kCode)
        {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                return true;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                return true;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                mDataBinding.vvcl.play();
                return true;
            case KeyEvent.KEYCODE_BACK:
                finish();
                return false; }
        return super.onKeyDown(kCode,kEvent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDataBinding.vvcl.destroy();
    }
}
