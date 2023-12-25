package com.zdy.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class DiscussRoomMyAdapter extends BaseQuickAdapter<DiscussRoomListBean.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public DiscussRoomMyAdapter(@Nullable List<DiscussRoomListBean.PageDataBean> data, Context context) {
        super(R.layout.item_my_discuss_list, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussRoomListBean.PageDataBean item) {
        helper.setText(R.id.tv_person, item.getFollowCount() + "人参与");
        helper.setText(R.id.subject, item.getTopicCount() + "个话题");
        helper.setText(R.id.tv_dfdsf, item.getRoomName());
        TextView textView = helper.getView(R.id.tv_my_create);
        if (item.getCreateBy().equals(item.getMyId())) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
        ImageView imageView = helper.getView(R.id.iv_discuss_left);
        if (!"".equals(item.getCreateUserImg())) {
            Glide.with(mContext).load(item.getCreateUserImg()).into(imageView);
        }
    }
}