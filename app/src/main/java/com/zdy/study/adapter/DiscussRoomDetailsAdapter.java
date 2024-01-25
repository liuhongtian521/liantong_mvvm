package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomDetailsResponse;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class DiscussRoomDetailsAdapter extends BaseQuickAdapter<DiscussRoomDetailsResponse.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public DiscussRoomDetailsAdapter(@Nullable List<DiscussRoomDetailsResponse.PageDataBean> data, Context context) {
        super(R.layout.item_discuss_new, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussRoomDetailsResponse.PageDataBean item) {
            helper.setText(R.id.tv_count, item.getFollowCount()+"人参与");
            helper.setText(R.id.tv_title, item.getTopicTitle());
        if (!"".equals(item.getCreateBy())) {
            int length = item.getCreateBy().length(); // 获取字符串长度
            if (length >= 5) {
                String result = item.getCreateBy().substring(length - 5); // 从倒数第五位开始截取到结尾
                helper.setText(R.id.tv_time, "学员"+result);
            }

        }
        ImageView imageView = helper.getView(R.id.iv_operation);
        imageView.setBackgroundResource(R.mipmap.ic_discuss_left);
        }


    }

