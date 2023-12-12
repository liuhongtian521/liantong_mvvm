package com.zdy.study.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class OperationAdapter extends BaseQuickAdapter<BroadcastExpressResponBean.PageDataBean, BaseViewHolder> {
    public OperationAdapter(@Nullable List<BroadcastExpressResponBean.PageDataBean> data) {
        super(R.layout.item_operation, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadcastExpressResponBean.PageDataBean item) {
        helper.setText(R.id.tv_title, item.getContName());
        helper.setText(R.id.tv_time, item.getCreateTime());
        ImageView ivOperation = helper.getView(R.id.iv_operation);
        Glide.with(mContext).load(item.getImgUrl()).into(ivOperation);
        FCLinearLayout layout = helper.getView(R.id.fcll);
        layout.setLitScale();

        /*VideoViewConstraintLayout layout = helper.getView(R.id.vcl_video);
        layout.setUrl(item.getContVideo().getVideoUrl());*/

        //截取天数
    }
}
