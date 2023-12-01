package com.zdy.study.adapter;

import android.graphics.Color;

import com.askia.coremodel.datamodel.database.db.consume.StudentCardInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class LocalStudentListAdapter extends BaseQuickAdapter<StudentCardInfo, BaseViewHolder>  {

    public LocalStudentListAdapter(List<StudentCardInfo> data){
        super(R.layout.item_student_list, data);

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StudentCardInfo item) {
        baseViewHolder.setText(R.id.tv_name, item.getStuName());
        baseViewHolder.setText(R.id.tv_number, item.getStuNo());
        baseViewHolder.setText(R.id.tv_card_number, item.getCardCode());
        baseViewHolder.setText(R.id.tv_class, item.getClassName());


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
