package com.zdy.study.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class InternationalPerspectiveAdapter extends BaseQuickAdapter<BroadcastExpressResponBean.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public InternationalPerspectiveAdapter(@Nullable List<BroadcastExpressResponBean.PageDataBean> data, Context context) {
        super(R.layout.web_based_course_item, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadcastExpressResponBean.PageDataBean item) {
        FCLinearLayout fcLinearLayout = helper.getView(R.id.fc_linearLayout);
        fcLinearLayout.setLitScale();
        helper.setText(R.id.tv_content_web, item.getContName());
        if (!"".equals(item.getCreateTime())) {
            helper.setText(R.id.tv_date, item.getCreateTime().substring(0, 10));
        }
        ImageView imageView = helper.getView(R.id.iv_right_video);
        if (!"".equals(item.getImgUrl())) {
//            helper.getView(R.id.iv_play).setVisibility(View.VISIBLE);
            Glide.with(mContext).load(item.getImgUrl()).into(imageView);
        } else {
//            helper.getView(R.id.iv_play).setVisibility(View.GONE);
        }


    }
}
