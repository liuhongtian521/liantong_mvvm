package com.zdy.study.activitys;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.CourseDetailsResponse;
import com.askia.coremodel.datamodel.http.entities.consume.CourseQueryResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.CourseQueryAdapter;
import com.zdy.study.adapter.CourseQueryDetailsAdapter;
import com.zdy.study.cdatamodel.viewmodel.CourseQueryViewModel;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.databinding.CourseQueryActivityBinding;
import com.zdy.study.fcWidgets.FCButton;
import com.zdy.study.view.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Route(path = ARouterPath.CourseQueryActivity)
public class CourseQueryActivity extends BaseActivity {
    CourseQueryActivityBinding mDataBinding;
    private TextView mTitle;
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView2;
    private CourseQueryViewModel mCourseQueryViewModel;
    private CourseQueryAdapter mCourseQueryAdapter;
    private CourseQueryDetailsAdapter mCourseQueryDetailsAdapter;
    private List<CourseQueryResponseBean.DataBean> list;
    private List<CourseDetailsResponse.RecordsBean> mDetailsList;
    private String mYear;
    private String mMonth;

    @SuppressLint("WrongViewCast")
    @Override
    public void onInit() {
        Log.e("liuhongtian", "1111");
        Date currentDate = new Date(); // 获取当前时间
        Calendar calendar = Calendar.getInstance(); // 创建Calendar对象
        calendar.setTime(currentDate); // 设置Calendar对象的时间为当前时间
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String dateString = formatter.format(currentDate);
        mDataBinding.tvYearClick.setVisibility(View.VISIBLE);
        mDataBinding.tvYearClick.setText(year + "年" + month + "月");
        showNetDialog();
        mCourseQueryViewModel.getPageListPad(dateString + "-01");

        list = new ArrayList<>();
        mDetailsList = new ArrayList<>();
        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("课程查询");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });

        //recyclerview初始化
        mRecyclerView = mDataBinding.rvCourse;
        mRecyclerView2 = mDataBinding.rvCourseOne;
        //上方recycleView
        LinearLayoutManager manager = new LinearLayoutManager(this);//数字为行数或列数
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置为横向滑动
        mCourseQueryAdapter = new CourseQueryAdapter(list);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mCourseQueryAdapter);
        //下方recycleView
        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        mCourseQueryDetailsAdapter = new CourseQueryDetailsAdapter(mDetailsList);
        mRecyclerView2.setLayoutManager(manager2);
        mRecyclerView2.setAdapter(mCourseQueryDetailsAdapter);

        mDataBinding.tvYearClick.setOnClickListener(v -> {
            DatePickerDialog mDatePickerDialog = new DatePickerDialog();
            mDatePickerDialog.setListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(String year, String month) {
                    switch (year) {
                        case "1":
                            mYear = "2020";
                            break;
                        case "2":
                            mYear = "2021";
                            break;
                        case "3":
                            mYear = "2022";
                            break;
                        case "4":
                            mYear = "2023";
                            break;
                        case "5":
                            mYear = "2024";
                            break;
                        case "6":
                            mYear = "2026";
                            break;
                        default:
                            break;
                    }
                    mDataBinding.tvYearClick.setVisibility(View.VISIBLE);
                    mDataBinding.tvYearClick.setText(mYear + "年" + month + "月");
                    mCourseQueryViewModel.getPageListPad(mYear + "-" + month + "-01");

                    Log.e("CourseQueryActivity", "onDateSet:" + year + "::::::::::" + month);
                }
            }, mDatePickerDialog, this);
            // 显示日期选择弹窗
            mDatePickerDialog.show(getSupportFragmentManager(), "datePicker");
        });
        //recyclerview item 点击事件
        mCourseQueryAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (null != list && list.size() > 0) {
                mCourseQueryViewModel.queryCurriculumInfoList(list.get(position).getClassesId(), list.get(position).getCalendarDate(), "10", "1", "10", "1");
            }
        });
        mCourseQueryDetailsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("id",mDetailsList.get(position).getTeacherId());
                bundle.putString("classesId", mDetailsList.get(position).getClassesId());
                startActivityByRouter(ARouterPath.TeacherIntroductionDetails, bundle);
            }
        });
        /*mCourseQueryDetailsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_teacher:
                        Bundle bundle = new Bundle();
                        bundle.putString("id",mDetailsList.get(position).getTeacherId());
                        bundle.putString("classesId", mDetailsList.get(position).getClassesId());
                        startActivityByRouter(ARouterPath.TeacherIntroductionDetails, bundle);
                        break;
                }
            }
        });*/
        mDataBinding.rlLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityByRouter(ARouterPath.MapActivity);
            }
        });
        mDataBinding.tvYearClick.requestFocus();
    }

    @Override
    public void onInitViewModel() {
        mCourseQueryViewModel = ViewModelProviders.of(this).get(CourseQueryViewModel.class);

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.course_query_activity);
    }

    @Override
    public void onSubscribeViewModel() {
        mCourseQueryViewModel.getCalendarListData().observe(this, listResult -> {
            dismissNetDialog();
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (listResult.isSuccess()) {
                if (null != listResult.getData()) {
                    list.clear();
                    list.addAll(listResult.getData());
                }
            }
            mCourseQueryAdapter.notifyDataSetChanged();
            if (null != list && list.size() > 0) {
                mCourseQueryViewModel.queryCurriculumInfoList(list.get(0).getClassesId(), list.get(0).getCalendarDate(), "10", "1", "10", "1");
            }

        });
        mCourseQueryViewModel.getCalendarListDetailsData().observe(this, listResult -> {
            if (listResult.isSuccess()) {
                if (null != listResult.getData() && null != listResult.getData().getRecords()) {
                    mDetailsList.clear();
                    mDetailsList.addAll(listResult.getData().getRecords());
                }
            }
            mCourseQueryDetailsAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onMResume() {

    }
}
