package com.zdy.study.adapter;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class BroadcastExpressAdapter extends BaseQuickAdapter<BroadcastExpressResponBean.PageDataBean, BaseViewHolder> {
    public BroadcastExpressAdapter(@Nullable List<BroadcastExpressResponBean.PageDataBean> data) {
        super(R.layout.broadcast_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadcastExpressResponBean.PageDataBean item) {
       helper.setText(R.id.time_length, item.getContVideo().getTimeLength());
       helper.setText(R.id.tv_content, item.getContName());
        //截取天数
    }
}
