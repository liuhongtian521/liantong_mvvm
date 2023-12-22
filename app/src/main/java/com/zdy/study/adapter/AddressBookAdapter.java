package com.zdy.study.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class AddressBookAdapter extends BaseQuickAdapter<AddressBookResponseBean.RecordsBean, BaseViewHolder> {
    private Context mContext;

    public AddressBookAdapter(@Nullable List<AddressBookResponseBean.RecordsBean> data, Context context) {
        super(R.layout.item_address_book, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressBookResponseBean.RecordsBean item) {
        helper.setText(R.id.tv_head_name, item.getStudentName());
        helper.setText(R.id.tv_telephone, item.getStudentPhone());
        ImageView imageView = helper.getView(R.id.iv_head);
        if (!"".equals(item.getStudentImg())) {
//            Glide.with(mContext).load(item.getStudentImg()).into(imageView);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.ic_mine_header)//图片加载出来前，显示的图片
                    .fallback( R.mipmap.ic_mine_header) //url为空的时候,显示的图片
                    .error(R.mipmap.ic_mine_header)//图片加载失败后，显示的图片
                    .circleCropTransform();
            Glide.with(mContext).asBitmap().load(item.getStudentImg()).apply(options)
                    .into(imageView);
        }
        FCLinearLayout layout = helper.getView(R.id.fcll);
        layout.setLitScale();

    }

}
