package com.zdy.study.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.Remark;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCConstraintLayout;

import java.util.List;

public class VideoFdydAdapter extends BaseQuickAdapter<Remark, BaseViewHolder> {

    //默认
    public static final int MN = 0;
    //分段
    public static final int FD = 1;
    public VideoFdydAdapter(@Nullable List<Remark> data) {
        super(R.layout.item_video_fdyd, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Remark item) {
        helper.setText(R.id.tv_content, item.getContName());

        FCConstraintLayout layout = helper.getView(R.id.fcll);
        layout.setBackGround(helper.getView(R.id.scv_bg_menu_sel), null);
        ImageView imageView = helper.getView(R.id.iv_broadcast_video);
        Glide.with(mContext).load("http://cdls-cms-image.oss-cn-huhehaote-nebula-1.aliyuncs.com/xinwen_video.jpeg").into(imageView);



    }



}
