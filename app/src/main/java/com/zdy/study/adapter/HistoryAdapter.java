package com.zdy.study.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.HistoryResponse;
import com.askia.coremodel.datamodel.http.entities.consume.MyCollectionResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;
import com.zdy.study.uitls.DipPx;

import java.util.List;

public class HistoryAdapter extends BaseMultiItemQuickAdapter<HistoryResponse.PageDataBean, BaseViewHolder> {

    //要闻速览
    public static final int YWSL = 0;
    //联播速递
    public static final int LBSD = 1;
    //国际视野
    public static final int GJSY = 2;
    //实践案例
    public static final int SJAL = 3;
    //精选理论
    public static final int JXLL = 4;
    //操作技巧
    public static final int CZJQ = 5;
    //推荐书单
    public static final int TJSD = 6;

    //联播速递默认
    public static final int MN = 11;
    //联播速递分段
    public static final int FD = 12;

    public HistoryAdapter(@Nullable List<HistoryResponse.PageDataBean> data) {
        super(data);
        addItemType(LBSD, R.layout.broadcast_item);
        addItemType(MN, R.layout.broadcast_item);
        addItemType(FD, R.layout.layout_fdyd);
        addItemType(YWSL, R.layout.web_based_course_item);
        addItemType(GJSY, R.layout.web_based_course_item);
        addItemType(SJAL, R.layout.web_based_course_item);
        addItemType(JXLL, R.layout.item_operation);
        addItemType(CZJQ, R.layout.item_operation);
        addItemType(TJSD, R.layout.item_book_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryResponse.PageDataBean item) {
        switch (helper.getItemViewType()){
            case LBSD:
            case MN:
                helper.setText(R.id.tv_content, item.getContName());
                helper.setText(R.id.tv_date, item.getContVideo().getTimeLength());
                /*if (TextUtils.isEmpty(item.getRemark())||"[]".equals(item.getRemark()))
                    helper.setVisible(R.id.ll_fdyd, false);
                else
                    helper.setVisible(R.id.ll_fdyd, true);*/
                RequestOptions options = new RequestOptions()
                        .placeholder(R.drawable.loading)
                        .bitmapTransform(new RoundedCorners(DipPx.dip2px(mContext, 7)));
                ImageView imageView = helper.getView(R.id.iv_broadcast_video);
                Glide.with(mContext).load("http://cdls-cms-image.oss-cn-huhehaote-nebula-1.aliyuncs.com/xinwen_video.jpeg")
                        .apply(options).into(imageView);
                break;
            case FD:
                helper.setText(R.id.tv_content_fdyd, item.getMyRemark().getContName())
                        .setText(R.id.tv_fd_time, item.getMyRemark().getCreateTime().substring(0, 10));
                break;
            case YWSL:
            case GJSY:
            case SJAL:
                helper.setText(R.id.tv_content_web, item.getContName())
                        .setText(R.id.tv_date, item.getCreateTime().substring(0, 10));
                ImageView imageViewGjsy = helper.getView(R.id.iv_right_video);
                Glide.with(mContext).load(item.getImgUrl()).into(imageViewGjsy);
                break;
            case JXLL:
            case CZJQ:
                helper.setText(R.id.tv_title, item.getContName());
                helper.setText(R.id.tv_time, item.getCreateTime());
                ImageView ivOperation = helper.getView(R.id.iv_operation);
                Glide.with(mContext).load(item.getImgUrl()).into(ivOperation);
                break;
            case TJSD:
                helper.setText(R.id.tv_book_name, Html.fromHtml(item.getContName()+"<font color='#767882'>"
                        +"(作者：" + item.getAuthorName() + ")"+"</font>"));
                helper.setText(R.id.tv_content_book, item.getBriefIntroduction());
                ImageView imageViewTjsd = helper.getView(R.id.iv_book_name);
                Glide.with(mContext).load(item.getImgUri()).into(imageViewTjsd);

                break;
        }






    }
}
