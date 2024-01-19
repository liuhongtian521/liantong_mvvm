package com.zdy.study.adapter;

import android.content.Context;
import android.text.Html;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class BookListAdapter extends BaseQuickAdapter<BooksRespponseBean.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public BookListAdapter(@Nullable List<BooksRespponseBean.PageDataBean> data, Context context) {
        super(R.layout.item_book_list, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BooksRespponseBean.PageDataBean item) {
        helper.setText(R.id.tv_book_name, Html.fromHtml(item.getBookName()+"<font color='#767882'>"+"(作者：" + item.getAuthorName() + ")"+"</font>"));
        helper.setText(R.id.tv_content_book, item.getBriefIntroduction());
        ImageView imageView = helper.getView(R.id.iv_book_name);
        if (!"".equals(item.getCoverUrl())) {
            Glide.with(mContext).load(item.getCoverUrl()).into(imageView);
        }
        FCLinearLayout layout = helper.getView(R.id.fcll);
        layout.setScale(1.02f);

    }
}
