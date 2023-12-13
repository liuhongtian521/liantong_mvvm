package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussResponseBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class DiscussAdapter extends BaseQuickAdapter<DiscussResponseBean, BaseViewHolder> {
    private Context mContext;

    public DiscussAdapter(@Nullable List<DiscussResponseBean> data, Context context) {
        super(R.layout.item_discuss, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussResponseBean item) {
        helper.setText(R.id.tv_quotation_mark, item.getRoomName());

    }
}
