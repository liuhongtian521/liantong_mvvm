package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class BookAdapter extends BaseQuickAdapter<BooksRespponseBean.PageDataBean, BaseViewHolder> {
    private Context mContext;

    public BookAdapter(@Nullable List<BooksRespponseBean.PageDataBean> data, Context context) {
        super(R.layout.item_book, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, BooksRespponseBean.PageDataBean item) {
        helper.setText(R.id.tv_head_name, item.getBookName());
        helper.setText(R.id.tv_author, "作者" + item.getAuthorName());
        ImageView imageView = helper.getView(R.id.iv_book);
        if (!"".equals(item.getCoverUrl())) {
            Glide.with(mContext).load(item.getCoverUrl()).into(imageView);
        }
        FCLinearLayout layout = helper.getView(R.id.fcll);
        layout.setScale(1.04f);

    }
}
