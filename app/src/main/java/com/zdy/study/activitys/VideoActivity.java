package com.zdy.study.activitys;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.Remark;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zdy.study.R;
import com.zdy.study.adapter.VideoFdydAdapter;
import com.zdy.study.databinding.ActVideoBinding;

import java.lang.reflect.Type;
import java.util.List;


@Route(path = ARouterPath.VideoActivity)
public class VideoActivity extends BaseActivity {

    private ActVideoBinding mDataBinding;
    private String url;
    private TextView btfdyd;
    private RecyclerView rvfdyd;
    @Override
    public void onInit() {
        btfdyd = mDataBinding.vvcl.getBTfdyd();
        rvfdyd = mDataBinding.vvcl.getRVfdyd();
        makeUrl();
        makeRemark();//分段要点

    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_video);
    }

    private void makeUrl(){
        url = getIntent().getExtras().getString("url");
        if (TextUtils.isEmpty(url))
            ToastUtils.showLong("播放地址不能为空！");
        else
            mDataBinding.vvcl.setUrl(url);
    }
    private void makeRemark(){
        String remark = getIntent().getExtras().getString("remark");
        if (TextUtils.isEmpty(remark))//无分段要点
            btfdyd.setVisibility(View.GONE);
        else {//有分段要点
            btfdyd.setVisibility(View.VISIBLE);
            btfdyd.setOnClickListener(view -> {
                if (rvfdyd.getVisibility() == View.GONE) {
                    btfdyd.setBackgroundResource(R.drawable.shape_4_red);
                    rvfdyd.setVisibility(View.VISIBLE);
                }else{
                    btfdyd.setBackgroundResource(R.drawable.shape_4_999999);
                    rvfdyd.setVisibility(View.GONE);
                }
            });
            Type type =new TypeToken<List<Remark>>(){}.getType();
            List<Remark> jsonObject = new Gson().fromJson(remark, type);

            VideoFdydAdapter adapter = new VideoFdydAdapter(jsonObject);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvfdyd.setLayoutManager(layoutManager);
            rvfdyd.setAdapter(adapter);
        }
    }
    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }

    /*public boolean onKeyDown(int kCode, KeyEvent kEvent)
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
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                mDataBinding.vvcl.play();
                return true;
            case KeyEvent.KEYCODE_BACK:
                finish();
                return false; }
        return super.onKeyDown(kCode,kEvent);
    }*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDataBinding.vvcl.destroy();
    }
}
