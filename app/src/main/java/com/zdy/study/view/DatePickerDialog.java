package com.zdy.study.view;

import com.zdy.study.R;
import com.zdy.study.databinding.DatePickerBinding;
import com.zdy.study.fcWidgets.FCButton;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import java.lang.reflect.Field;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerDialog extends DialogFragment implements DialogInterface.OnClickListener {
    private OnDateSetListener listener; // 日期选择回调接口
    private DatePicker datePicker;
    DatePickerBinding datePickerBinding;
    AlertDialog alertDialog;
    private Context mContext;
    private String month;
    private String year;

    public void setListener(OnDateSetListener listener, DatePickerDialog datePicker, Context context) {
        this.listener = listener;
        this.mContext = context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("liuhongtian123", "onCreate: 222");

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();


    }

    // 定义日期选择回调接口
    public interface OnDateSetListener {
        void onDateSet(String year, String month);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Log.e("liuhongtian123456", "onCreate: 11");
        // 创建一个日期选择弹窗
        alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("选择日期")
                .setView(R.layout.date_picker)
                .create();
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
        }
        return alertDialog;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onResume() {
        super.onResume();
        FCButton buttonYes = alertDialog.findViewById(R.id.yes);
        FCButton buttonNo = alertDialog.findViewById(R.id.no);
        TextView textView1 = alertDialog.findViewById(R.id.tv_year_1);
        TextView textView2 = alertDialog.findViewById(R.id.tv_year_2);
        TextView textView3 = alertDialog.findViewById(R.id.tv_year_3);
        TextView textView4 = alertDialog.findViewById(R.id.tv_year_4);
        TextView textView5 = alertDialog.findViewById(R.id.tv_year_5);
        TextView textView6 = alertDialog.findViewById(R.id.tv_year_6);
        TextView textView_month1 = alertDialog.findViewById(R.id.tv_month_1);
        TextView textView_month2 = alertDialog.findViewById(R.id.tv_month_2);
        TextView textView_month3 = alertDialog.findViewById(R.id.tv_month_3);
        TextView textView_month4 = alertDialog.findViewById(R.id.tv_month_4);
        TextView textView_month5 = alertDialog.findViewById(R.id.tv_month_5);
        TextView textView_month6 = alertDialog.findViewById(R.id.tv_month_6);
        TextView textView_month7 = alertDialog.findViewById(R.id.tv_month_7);
        TextView textView_month8 = alertDialog.findViewById(R.id.tv_month_8);
        TextView textView_month9 = alertDialog.findViewById(R.id.tv_month_9);
        TextView textView_month10 = alertDialog.findViewById(R.id.tv_month_10);
        TextView textView_month11 = alertDialog.findViewById(R.id.tv_month_11);
        TextView textView_month12 = alertDialog.findViewById(R.id.tv_month_12);
        //年
        textView1.setOnClickListener(v -> {
            year = "1";
            textView1.setTextColor(getResources().getColor(R.color.app_white));
            textView1.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView2.setTextColor(getResources().getColor(R.color.app_black));
            textView2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView3.setTextColor(getResources().getColor(R.color.app_black));
            textView3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView4.setTextColor(getResources().getColor(R.color.app_black));
            textView4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView5.setTextColor(getResources().getColor(R.color.app_black));
            textView5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView6.setTextColor(getResources().getColor(R.color.app_black));
            textView6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        textView2.setOnClickListener(v -> {
            year = "2";
            textView2.setTextColor(getResources().getColor(R.color.app_white));
            textView2.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView1.setTextColor(getResources().getColor(R.color.app_black));
            textView1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView3.setTextColor(getResources().getColor(R.color.app_black));
            textView3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView4.setTextColor(getResources().getColor(R.color.app_black));
            textView4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView5.setTextColor(getResources().getColor(R.color.app_black));
            textView5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView6.setTextColor(getResources().getColor(R.color.app_black));
            textView6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        textView3.setOnClickListener(v -> {
            year = "3";
            textView3.setTextColor(getResources().getColor(R.color.app_white));
            textView3.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView2.setTextColor(getResources().getColor(R.color.app_black));
            textView2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView1.setTextColor(getResources().getColor(R.color.app_black));
            textView1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView4.setTextColor(getResources().getColor(R.color.app_black));
            textView4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView5.setTextColor(getResources().getColor(R.color.app_black));
            textView5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView6.setTextColor(getResources().getColor(R.color.app_black));
            textView6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        textView4.setOnClickListener(v -> {
            year = "4";
            textView4.setTextColor(getResources().getColor(R.color.app_white));
            textView4.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView2.setTextColor(getResources().getColor(R.color.app_black));
            textView2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView3.setTextColor(getResources().getColor(R.color.app_black));
            textView3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView1.setTextColor(getResources().getColor(R.color.app_black));
            textView1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView5.setTextColor(getResources().getColor(R.color.app_black));
            textView5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView6.setTextColor(getResources().getColor(R.color.app_black));
            textView6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        textView5.setOnClickListener(v -> {
            year = "5";
            textView5.setTextColor(getResources().getColor(R.color.app_white));
            textView5.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView2.setTextColor(getResources().getColor(R.color.app_black));
            textView2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView3.setTextColor(getResources().getColor(R.color.app_black));
            textView3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView4.setTextColor(getResources().getColor(R.color.app_black));
            textView4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView1.setTextColor(getResources().getColor(R.color.app_black));
            textView1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView6.setTextColor(getResources().getColor(R.color.app_black));
            textView6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        textView6.setOnClickListener(v -> {
            year = "6";
            textView6.setTextColor(getResources().getColor(R.color.app_white));
            textView6.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView2.setTextColor(getResources().getColor(R.color.app_black));
            textView2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView3.setTextColor(getResources().getColor(R.color.app_black));
            textView3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView4.setTextColor(getResources().getColor(R.color.app_black));
            textView4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView5.setTextColor(getResources().getColor(R.color.app_black));
            textView5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView1.setTextColor(getResources().getColor(R.color.app_black));
            textView1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //1月份
        textView_month1.setOnClickListener(v -> {
            month = "01";
            textView_month1.setTextColor(getResources().getColor(R.color.app_white));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //2月份
        textView_month2.setOnClickListener(v -> {
            month = "02";
            textView_month2.setTextColor(getResources().getColor(R.color.app_white));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //3月份
        textView_month3.setOnClickListener(v -> {
            month = "03";
            textView_month3.setTextColor(getResources().getColor(R.color.app_white));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //4月份
        textView_month4.setOnClickListener(v -> {
            month = "04";
            textView_month4.setTextColor(getResources().getColor(R.color.app_white));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //5月份
        textView_month5.setOnClickListener(v -> {
            month = "05";
            textView_month5.setTextColor(getResources().getColor(R.color.app_white));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //6月份
        textView_month6.setOnClickListener(v -> {
            month = "06";
            textView_month6.setTextColor(getResources().getColor(R.color.app_white));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //7月份
        textView_month7.setOnClickListener(v -> {
            month = "07";
            textView_month7.setTextColor(getResources().getColor(R.color.app_white));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //8月份
        textView_month8.setOnClickListener(v -> {
            month = "08";
            textView_month8.setTextColor(getResources().getColor(R.color.app_white));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //9月份
        textView_month9.setOnClickListener(v -> {
            month = "09";
            textView_month9.setTextColor(getResources().getColor(R.color.app_white));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //10月份
        textView_month10.setOnClickListener(v -> {
            month = "10";
            textView_month10.setTextColor(getResources().getColor(R.color.app_white));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //11月份
        textView_month11.setOnClickListener(v -> {
            month = "11";
            textView_month11.setTextColor(getResources().getColor(R.color.app_white));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month12.setTextColor(getResources().getColor(R.color.app_black));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //12月份
        textView_month12.setOnClickListener(v -> {
            month = "12";
            textView_month12.setTextColor(getResources().getColor(R.color.app_white));
            textView_month12.setBackground(mContext.getResources().getDrawable(R.color.app_red));
            textView_month2.setTextColor(getResources().getColor(R.color.app_black));
            textView_month2.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month3.setTextColor(getResources().getColor(R.color.app_black));
            textView_month3.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month4.setTextColor(getResources().getColor(R.color.app_black));
            textView_month4.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month5.setTextColor(getResources().getColor(R.color.app_black));
            textView_month5.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month6.setTextColor(getResources().getColor(R.color.app_black));
            textView_month6.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month7.setTextColor(getResources().getColor(R.color.app_black));
            textView_month7.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month8.setTextColor(getResources().getColor(R.color.app_black));
            textView_month8.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month9.setTextColor(getResources().getColor(R.color.app_black));
            textView_month9.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month10.setTextColor(getResources().getColor(R.color.app_black));
            textView_month10.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month11.setTextColor(getResources().getColor(R.color.app_black));
            textView_month11.setBackground(mContext.getResources().getDrawable(R.color.app_white));
            textView_month1.setTextColor(getResources().getColor(R.color.app_black));
            textView_month1.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        });
        //确定监听
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 调用回调接口，将选择的日期返回给调用方
                listener.onDateSet(year, month);
                alertDialog.dismiss();
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        try {
//            listener = (OnDateSetListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement OnDateSetListener");
//        }


    }
}
