package com.zdy.study.adapter;

import android.content.Context;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class DiscussRoomAdapter extends BaseQuickAdapter<DiscussRoomListBean.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public DiscussRoomAdapter(@Nullable List<DiscussRoomListBean.PageDataBean> data, Context context) {
        super(R.layout.item_discuss, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussRoomListBean.PageDataBean item) {
        //helper.setText(R.id.tv_quotation_mark, item.getRoomName());

    }
}