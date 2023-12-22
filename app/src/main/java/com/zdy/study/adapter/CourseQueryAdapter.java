package com.zdy.study.adapter;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.database.db.consume.ShoppingRecord;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class CourseQueryAdapter extends BaseQuickAdapter<CourseQueryResponseBean.DataBean, BaseViewHolder> {
    public CourseQueryAdapter(@Nullable List<CourseQueryResponseBean.DataBean> data) {
        super(R.layout.course_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CourseQueryResponseBean.DataBean item) {
        helper.setText(R.id.tv_week, item.getWeek());
        //截取天数
        if (null != item.getCalendarDate()) {
            helper.setText(R.id.tv_month, item.getCalendarDate().substring(item.getCalendarDate().length() - 2));
        }
        if ("0".equals(item.getCurriculumNum())) {
            helper.setText(R.id.tv_course, "无");
        } else {
            helper.setText(R.id.tv_course, item.getCurriculumNum() + "节");
        }

    }
}
