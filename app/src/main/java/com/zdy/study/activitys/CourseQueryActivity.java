package com.zdy.study.activitys;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.databinding.CourseQueryActivityBinding;
import com.zdy.study.fcWidgets.FCButton;
import com.zdy.study.view.DatePickerDialog;

@Route(path = ARouterPath.CourseQueryActivity)
public class CourseQueryActivity extends BaseActivity {
    CourseQueryActivityBinding mDataBinding;

    @Override
    public void onInit() {
        Log.e("liuhongtian", "1111");
        mDataBinding.button1.setOnClickListener(v -> {
            DatePickerDialog mDatePickerDialog = new DatePickerDialog();
            mDatePickerDialog.setListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(String year, String month) {
                    Log.e("CourseQueryActivity", "onDateSet:" + year + "::::::::::" + month);
                }
            }, mDatePickerDialog, this);
// 显示日期选择弹窗
            mDatePickerDialog.show(getSupportFragmentManager(), "datePicker");
        });

    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.course_query_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
