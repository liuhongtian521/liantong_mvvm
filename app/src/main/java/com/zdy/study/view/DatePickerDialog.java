package com.zdy.study.view;

import com.zdy.study.R;
import com.zdy.study.databinding.DatePickerBinding;
import com.zdy.study.fcWidgets.FCButton;
import com.zdy.study.fcWidgets.FCTextview;

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

    FCTextview textView1;
    FCTextview textView2;
    FCTextview textView3;
    FCTextview textView4;
    FCTextview textView5;
    FCTextview textView6;
    FCTextview textView_month1;
    FCTextview textView_month2;
    FCTextview textView_month3;
    FCTextview textView_month4;
    FCTextview textView_month5;
    FCTextview textView_month6;
    FCTextview textView_month7;
    FCTextview textView_month8;
    FCTextview textView_month9;
    FCTextview textView_month10;
    FCTextview textView_month11;
    FCTextview textView_month12;

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
        textView1       = alertDialog.findViewById(R.id.tv_year_1);
        textView2       = alertDialog.findViewById(R.id.tv_year_2);
        textView3       = alertDialog.findViewById(R.id.tv_year_3);
        textView4       = alertDialog.findViewById(R.id.tv_year_4);
        textView5       = alertDialog.findViewById(R.id.tv_year_5);
        textView6       = alertDialog.findViewById(R.id.tv_year_6);
        textView_month1 = alertDialog.findViewById(R.id.tv_month_1);
        textView_month2 = alertDialog.findViewById(R.id.tv_month_2);
        textView_month3 = alertDialog.findViewById(R.id.tv_month_3);
        textView_month4 = alertDialog.findViewById(R.id.tv_month_4);
        textView_month5 = alertDialog.findViewById(R.id.tv_month_5);
        textView_month6 = alertDialog.findViewById(R.id.tv_month_6);
        textView_month7 = alertDialog.findViewById(R.id.tv_month_7);
        textView_month8 = alertDialog.findViewById(R.id.tv_month_8);
        textView_month9 = alertDialog.findViewById(R.id.tv_month_9);
        textView_month10 = alertDialog.findViewById(R.id.tv_month_10);
        textView_month11 = alertDialog.findViewById(R.id.tv_month_11);
        textView_month12 = alertDialog.findViewById(R.id.tv_month_12);

        textView1.setScale(1.3f);
        textView2.setScale(1.3f);
        textView3.setScale(1.3f);
        textView4.setScale(1.3f);
        textView5.setScale(1.3f);
        textView6.setScale(1.3f);
        textView_month1 .setScale(1.3f);
        textView_month2.setScale(1.3f);
        textView_month3.setScale(1.3f);
        textView_month4.setScale(1.3f);
        textView_month5.setScale(1.3f);
        textView_month6.setScale(1.3f);
        textView_month7.setScale(1.3f);
        textView_month8.setScale(1.3f);
        textView_month9.setScale(1.3f);
        textView_month10.setScale(1.3f);
        textView_month11.setScale(1.3f);
        textView_month12.setScale(1.3f);

        //年
        textView1.setOnClickListener(v -> {
            year = "1";
            setYear(textView1);
        });
        textView2.setOnClickListener(v -> {
            year = "2";
            setYear(textView2);
        });
        textView3.setOnClickListener(v -> {
            year = "3";
            setYear(textView3);
        });
        textView4.setOnClickListener(v -> {
            year = "4";
            setYear(textView4);

        });
        textView5.setOnClickListener(v -> {
            year = "5";
            setYear(textView5);

        });
        textView6.setOnClickListener(v -> {
            year = "6";
            setYear(textView6);
        });
        //1月份
        textView_month1.setOnClickListener(v -> {
            month = "01";
            setMonth(textView_month1);
        });
        //2月份
        textView_month2.setOnClickListener(v -> {
            month = "02";
            setMonth(textView_month2);
        });
        //3月份
        textView_month3.setOnClickListener(v -> {
            month = "03";
            setMonth(textView_month3);
        });
        //4月份
        textView_month4.setOnClickListener(v -> {
            month = "04";
            setMonth(textView_month4);
        });
        //5月份
        textView_month5.setOnClickListener(v -> {
            month = "05";
            setMonth(textView_month5);
        });
        //6月份
        textView_month6.setOnClickListener(v -> {
            month = "06";
            setMonth(textView_month6);
        });
        //7月份
        textView_month7.setOnClickListener(v -> {
            month = "07";
            setMonth(textView_month7);
        });
        //8月份
        textView_month8.setOnClickListener(v -> {
            month = "08";
            setMonth(textView_month8);
        });
        //9月份
        textView_month9.setOnClickListener(v -> {
            month = "09";
            setMonth(textView_month9);
        });
        //10月份
        textView_month10.setOnClickListener(v -> {
            month = "10";
            setMonth(textView_month10);
        });
        //11月份
        textView_month11.setOnClickListener(v -> {
            month = "11";
            setMonth(textView_month11);
        });
        //12月份
        textView_month12.setOnClickListener(v -> {
            month = "12";
            setMonth(textView_month12);
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

    FCTextview lastYear;
    private void setYear(FCTextview view){
        view.setTextColor(getResources().getColor(R.color.app_white));
        view.setBackground(mContext.getResources().getDrawable(R.color.app_red));
        if (lastYear != null){
            lastYear.setTextColor(getResources().getColor(R.color.app_black));
            lastYear.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        }
        lastYear = view;
    }

    FCTextview lastMounth;
    private void setMonth(FCTextview view){
        view.setTextColor(getResources().getColor(R.color.app_white));
        view.setBackground(mContext.getResources().getDrawable(R.color.app_red));
        if (lastMounth != null){
            lastMounth.setTextColor(getResources().getColor(R.color.app_black));
            lastMounth.setBackground(mContext.getResources().getDrawable(R.color.app_white));
        }
        lastMounth = view;
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
