package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.TopicResponseBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class TopicAdapter extends BaseQuickAdapter<TopicResponseBean.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public TopicAdapter(@Nullable List<TopicResponseBean.PageDataBean> data, Context context) {
        super(R.layout.item_topic, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicResponseBean.PageDataBean item) {
        helper.setText(R.id.tv_title, item.getTopicTitle());
        helper.setText(R.id.tv_name, item.getCreateName());
        helper.setText(R.id.tv_follows, item.getFollowCount()+"人参与");
        ImageView imageView = helper.getView(R.id.iv_head);
        if (!"".equals(item.getCreateUserImg())) {
            Glide.with(mContext).load(item.getCreateUserImg()).into(imageView);
        }
        FCLinearLayout layout = helper.getView(R.id.fl_content);
        layout.setLitScale();

    }
}
