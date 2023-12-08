package com.zdy.study.adapter;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.widgets.VideoViewConstraintLayout;

import java.util.List;

public class BroadcastExpressAdapter extends BaseQuickAdapter<BroadcastExpressResponBean.PageDataBean, BaseViewHolder> {
    public BroadcastExpressAdapter(@Nullable List<BroadcastExpressResponBean.PageDataBean> data) {
        super(R.layout.broadcast_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadcastExpressResponBean.PageDataBean item) {
       helper.setText(R.id.tv_content, item.getContName());

        VideoViewConstraintLayout layout = helper.getView(R.id.vcl_video);
        layout.setUrl(item.getContVideo().getVideoUrl());

        //截取天数
    }
}
