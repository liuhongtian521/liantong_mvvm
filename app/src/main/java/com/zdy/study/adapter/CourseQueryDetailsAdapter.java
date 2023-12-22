package com.zdy.study.adapter;

import androidx.annotation.Nullable;

import com.askia.coremodel.datamodel.http.entities.consume.CourseDetailsResponse;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class CourseQueryDetailsAdapter extends BaseQuickAdapter<CourseDetailsResponse.RecordsBean, BaseViewHolder> {
    public CourseQueryDetailsAdapter(@Nullable List<CourseDetailsResponse.RecordsBean> data) {
        super(R.layout.item_course_details, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CourseDetailsResponse.RecordsBean item) {
        helper.setText(R.id.tv_time, item.getClassTime());
        helper.setText(R.id.tv_style, item.getCurriculumStatus());
        helper.addOnClickListener(R.id.tv_teacher);
        if ("上课中".equals(item.getCurriculumStatus())) {
            helper.setBackgroundRes(R.id.tv_style, R.mipmap.ic_in_class);
        } else if ("未开始".equals(item.getCurriculumStatus())) {
            helper.setBackgroundRes(R.id.tv_style, R.mipmap.ic_no_start);
        } else if ("已结束".equals(item.getCurriculumStatus())) {
            helper.setBackgroundRes(R.id.tv_style, R.mipmap.ic_already_end);
        }
//内容
        helper.setText(R.id.tv_content, item.getCurriculumName());
        helper.setText(R.id.tv_classes_room, item.getCurriculumAddress());
        helper.setText(R.id.tv_name, item.getTeacherName());
        FCLinearLayout layout = helper.getView(R.id.fcll);
        layout.setLitScale();
    }
}
