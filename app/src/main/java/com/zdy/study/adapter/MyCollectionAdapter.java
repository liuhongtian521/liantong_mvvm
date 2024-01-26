package com.zdy.study.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gcssloop.widget.RCRelativeLayout;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;
import com.zdy.study.fcWidgets.FCRelativeLayout;

import java.util.List;

public class MyCollectionAdapter extends BaseMultiItemQuickAdapter<MyCollectionResponse.PageDataBean, BaseViewHolder> {
    //其它样式
    public static final int YWSL = 0;
    //联播速递
    public static final int LBSD = 1;
    //联播速递默认
    public static final int MN = 11;
    //联播速递分段
    public static final int FD = 12;

    public MyCollectionAdapter(@Nullable List<MyCollectionResponse.PageDataBean> data, boolean isClick) {
        super(data);
//        addItemType(YWSL, R.layout.my_collection_item);
        addItemType(YWSL, R.layout.item_operation);
        addItemType(LBSD, R.layout.broadcast_item);
        addItemType(MN, R.layout.broadcast_item);
        addItemType(FD, R.layout.item_fdyd);

    }

    @Override
    protected void convert(BaseViewHolder helper, MyCollectionResponse.PageDataBean item) {
        switch (helper.getItemViewType()){
            case YWSL:
                /*FCRelativeLayout fcLinearLayout = helper.getView(R.id.fc_linearLayout);
                fcLinearLayout.setLitScale();
                helper.addOnClickListener(R.id.iv_delete);
                helper.addOnClickListener(R.id.fc_linearLayout);
                helper.setText(R.id.tv_content_web, item.getContName());
                if (item.getCreateTime().length() > 10) {
                    helper.setText(R.id.tv_date, item.getCreateTime().substring(0, 10));
                }
                ImageView imageView = helper.getView(R.id.iv_right_video);
                if (!"".equals(item.getImgUrl())) {
                    Glide.with(mContext).load(item.getImgUrl()).into(imageView);
                }
                if (item.isTrueOrFalse()) {
                    helper.getView(R.id.iv_delete).setVisibility(View.VISIBLE);
                } else {
                    helper.getView(R.id.iv_delete).setVisibility(View.GONE);
                }*/

                helper.setText(R.id.tv_title, item.getContName());
                helper.setText(R.id.tv_time, item.getCreateTime().substring(0, 10));
                ImageView ivOperation = helper.getView(R.id.iv_operation);
                Glide.with(mContext).load(item.getImgUrl()).into(ivOperation);
                break;
            case LBSD:
            case MN:
                helper.setText(R.id.tv_content, item.getContName());
                helper.setText(R.id.tv_date, item.getContVideo().getTimeLength());
                /*if (TextUtils.isEmpty(item.getRemark())||"[]".equals(item.getRemark()))
                    helper.setVisible(R.id.ll_fdyd, false);
                else
                    helper.setVisible(R.id.ll_fdyd, true);*/
                ImageView imageViewcv = helper.getView(R.id.iv_broadcast_video);
                Glide.with(mContext).load("http://cdls-cms-image.oss-cn-huhehaote-nebula-1.aliyuncs.com/xinwen_video.jpeg").into(imageViewcv);
                break;
            case FD:
                helper.addOnClickListener(R.id.fcc_fdyd);
                helper.addOnClickListener(R.id.iv_delete);
                helper.setText(R.id.tv_content_fdyd, item.getMyRemark().getContName())
                        .setText(R.id.tv_fd_time, item.getMyRemark().getCreateTime().substring(0, 10));
                if (item.isTrueOrFalse()) {
                    helper.getView(R.id.iv_delete).setVisibility(View.VISIBLE);
                } else {
                    helper.getView(R.id.iv_delete).setVisibility(View.GONE);
                }
                break;

        }
    }
}
