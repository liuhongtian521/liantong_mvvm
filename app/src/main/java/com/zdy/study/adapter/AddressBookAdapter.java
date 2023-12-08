package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class AddressBookAdapter extends BaseQuickAdapter<AddressBookResponseBean.RecordsBean, BaseViewHolder> {
    private Context mContext;

    public AddressBookAdapter(@Nullable List<AddressBookResponseBean.RecordsBean> data, Context context) {
        super(R.layout.item_address_book, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressBookResponseBean.RecordsBean item) {
        helper.setText(R.id.tv_head_name, item.getStudentName());
        helper.setText(R.id.tv_telephone, item.getStudentPhone());
        ImageView imageView = helper.getView(R.id.iv_head);
        if (!"".equals(item.getStudentImg())) {
            Glide.with(mContext).load(item.getStudentImg()).into(imageView);
        }


    }
}
