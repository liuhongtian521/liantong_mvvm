package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.WebCourseResponseBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class WebBaseCourseAdapter extends BaseQuickAdapter<WebCourseResponseBean.RecordsBean, BaseViewHolder> {
    private Context mContext;

    public WebBaseCourseAdapter(@Nullable List<WebCourseResponseBean.RecordsBean> data, Context context) {
        super(R.layout.web_based_course_item, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, WebCourseResponseBean.RecordsBean item) {
      helper.setText(R.id.tv_content_web, item.getTitle());
      if (!"".equals(item.getUploadTime())){
          helper.setText(R.id.tv_date, item.getUploadTime().substring(0,10));
      }
      ImageView imageView = helper.getView(R.id.iv_right_video);
        if (!"".equals(item.getShowUrl())) {
            Glide.with(mContext).load(item.getShowUrl()).into(imageView);
        }


    }
}
