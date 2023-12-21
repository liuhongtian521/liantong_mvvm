package com.zdy.study.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gcssloop.widget.RCRelativeLayout;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;
import com.zdy.study.fcWidgets.FCRelativeLayout;

import java.util.List;

public class MyCollectionAdapter extends BaseQuickAdapter<MyCollectionResponse.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public MyCollectionAdapter(@Nullable List<MyCollectionResponse.PageDataBean> data, Context context, boolean isClick) {
        super(R.layout.my_collection_item, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCollectionResponse.PageDataBean item) {
        FCRelativeLayout fcLinearLayout = helper.getView(R.id.fc_linearLayout);
        fcLinearLayout.setLitScale();
        helper.addOnClickListener(R.id.iv_delete);
        helper.addOnClickListener(R.id.fc_linearLayout);
        helper.setText(R.id.tv_content_web, item.getContName());
        if (!"".equals(item.getCreateTime())) {
            helper.setText(R.id.tv_date, item.getCreateTime().substring(0, 10));
        }
        ImageView imageView = helper.getView(R.id.iv_right_video);
        if (!"".equals(item.getImgUrl())) {
            Glide.with(mContext).load(item.getImgUrl()).into(imageView);
        }
        if (item.isTrueOrFalse()
        ) {
            helper.getView(R.id.iv_delete).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.iv_delete).setVisibility(View.GONE);
        }

    }
}
