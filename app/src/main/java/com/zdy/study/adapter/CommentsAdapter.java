package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.CommentsBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class CommentsAdapter extends BaseQuickAdapter<CommentsBean.PageDataBean, BaseViewHolder> {


    public CommentsAdapter(@Nullable List<CommentsBean.PageDataBean> data) {
        super(R.layout.item_comment, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, CommentsBean.PageDataBean item) {
        helper.setText(R.id.tv_name, item.getCreateName()+ "：");
        helper.setText(R.id.tv_comment, item.getCommContent());
        /*ImageView imageView = helper.getView(R.id.iv_head);
        if (!"".equals(item.getStudentImg())) {
            Glide.with(mContext).load(item.getStudentImg()).into(imageView);
        }
        FCLinearLayout layout = helper.getView(R.id.fcll);
        layout.setLitScale();*/

    }
}
