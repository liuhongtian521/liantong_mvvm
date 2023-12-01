package com.zdy.study.adapter;

import android.graphics.Color;

import com.askia.coremodel.datamodel.database.db.consume.ShoppingRecord;
import com.blankj.utilcode.util.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class LocalConsumeAdapter extends BaseQuickAdapter<ShoppingRecord, BaseViewHolder>  {

    public LocalConsumeAdapter(List<ShoppingRecord> data){
        super(R.layout.item_local_consume, data);

    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, ShoppingRecord item) {
        baseViewHolder.setText(R.id.tv_name, item.getStuName());
        baseViewHolder.setText(R.id.tv_number, item.getStuNo());
        baseViewHolder.setText(R.id.tv_card_number, item.getCardCode());
        baseViewHolder.setText(R.id.tv_time, TimeUtils.millis2String(item.getTimeStamp()));

        String status = "--";
        String colorMoney = null;
        if ("2".equals(item.getOrderStatus())){
            status = "校园消费";
            colorMoney = "#666666";
            baseViewHolder.setText(R.id.tv_money, "-" + item.getMoney());
        }else if ("4".equals(item.getOrderStatus())){
            status = "校园退款";
            colorMoney = "#FF9200";
            baseViewHolder.setText(R.id.tv_money, "+" + item.getMoney());
        }
        baseViewHolder.setTextColor(R.id.tv_money,Color.parseColor(colorMoney));
        baseViewHolder.setText(R.id.tv_type, status);
        //0 未同步  1已同步
        if ("0".equals(item.getSyncStatus())){
            baseViewHolder.setImageResource(R.id.iv_state, R.drawable.icon_un_upload);
            baseViewHolder.setText(R.id.tv_state,"未上传");
        }else {
            baseViewHolder.setImageResource(R.id.iv_state, R.drawable.icon_upload_success);
            baseViewHolder.setText(R.id.tv_state,"已上传");
        }

        int position = baseViewHolder.getLayoutPosition();
        String color;
        if (position % 2 != 0) {
            color = "#FAFAFA";
        } else {
            color = "#ffffff";
        }
        baseViewHolder.itemView.setBackgroundColor(Color.parseColor(color));
    }
}
