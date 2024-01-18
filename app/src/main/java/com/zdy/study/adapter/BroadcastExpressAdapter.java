package com.zdy.study.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.Remark;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCConstraintLayout;
import com.zdy.study.fcWidgets.FCLinearLayout;
import com.zdy.study.widgets.VideoViewConstraintLayout;

import java.lang.reflect.Type;
import java.util.List;

public class BroadcastExpressAdapter extends BaseMultiItemQuickAdapter<BroadcastExpressResponBean.PageDataBean, BaseViewHolder> {

    //默认
    public static final int MN = 0;
    //分段
    public static final int FD = 1;
    public BroadcastExpressAdapter(@Nullable List<BroadcastExpressResponBean.PageDataBean> data) {
        super(data);
        addItemType(MN, R.layout.broadcast_item);
        addItemType(FD, R.layout.layout_fdyd);
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadcastExpressResponBean.PageDataBean item) {
        switch (helper.getItemViewType()) {
            case MN:
                helper.setText(R.id.tv_content, item.getContName());
                helper.setText(R.id.tv_date, item.getContVideo().getTimeLength());
                   /*     setText(R.id.tv_create_time,
                                TextUtils.isEmpty(item.getCreateTime())? "": item.getCreateTime().substring(0, 10));
                if (TextUtils.isEmpty(item.getRemark()))
                    helper.setVisible(R.id.ll_fdyd, false);
                else
                    helper.setVisible(R.id.ll_fdyd, true);*/
                FCConstraintLayout layout = helper.getView(R.id.fcll);
                layout.setBackGround(helper.getView(R.id.scv_bg_menu_sel), null);
                ImageView imageView = helper.getView(R.id.iv_broadcast_video);
                Glide.with(mContext).load("http://cdls-cms-image.oss-cn-huhehaote-nebula-1.aliyuncs.com/xinwen_video.jpeg").into(imageView);
                break;
            case FD:
                helper.setText(R.id.tv_content_fdyd, item.getMyRemark().getContName())
                    .setText(R.id.tv_fd_time, item.getMyRemark().getCreateTime().substring(0, 10));
                break;
        }

    }



}
