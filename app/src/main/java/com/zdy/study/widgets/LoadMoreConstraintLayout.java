package com.zdy.study.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCButton;

import java.util.List;

public class LoadMoreConstraintLayout extends ConstraintLayout {

    private TextView fcbNextPage, fcbPreviousPage;
    private ImageView ivEmpty;
    private TextView tvEmpty;
    private View viewLeft;
    private LoadLitetsner loadLitetsner;

    public LoadMoreConstraintLayout(@NonNull Context context) {
        super(context);
    }

    public LoadMoreConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LoadMoreConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public LoadMoreConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.layout_load_more, this);
        fcbNextPage = findViewById(R.id.fcb_next_page);
        fcbPreviousPage = findViewById(R.id.fcb_previous_page);
        viewLeft = findViewById(R.id.view_left);
        ivEmpty = findViewById(R.id.iv_empty);
        tvEmpty = findViewById(R.id.tv_empty);
        fcbNextPage.setOnClickListener(view -> {
            if (loadLitetsner != null)
                loadLitetsner.nextPage();
        });
        fcbPreviousPage.setOnClickListener(view -> {
            if (loadLitetsner != null)
                loadLitetsner.previousPage();
        });
        showEmptyView(GONE);
    }

    public void setLoadLitetsner(LoadLitetsner loadLitetsner){
        this.loadLitetsner = loadLitetsner;
    }

    public void setPreviousPageVisibility(int visibility){
        if (fcbPreviousPage.getVisibility() != visibility)
            fcbPreviousPage.setVisibility(visibility);
    }

    public void setNextPageVisibility(int visibility){
        if (fcbNextPage.getVisibility() != visibility)
            fcbNextPage.setVisibility(visibility);
    }

    public void showEmptyView(int visibility){
        if (ivEmpty.getVisibility() != visibility){
            ivEmpty.setVisibility(visibility);
            tvEmpty.setVisibility(visibility);
        }
    }

    public void setList(List<?> list, int page){
        if (list.size() == 0) {
            showEmptyView(View.VISIBLE);//显示缺省页
            setNextPageVisibility(View.GONE);
            if (page != 1)
                setPreviousPageVisibility(View.VISIBLE);// 其它显示上一页
            return;
        }else{
            showEmptyView(View.GONE);// 隐藏缺省页
        }
        if (page == 1)
            setPreviousPageVisibility(View.GONE);// 第一页隐藏上一页
        else
            setPreviousPageVisibility(View.VISIBLE);// 其它显示上一页
        if (list.size() < 10)
            setNextPageVisibility(View.GONE);// 数据小于10条隐藏下一页
        else
            setNextPageVisibility(View.VISIBLE);// 显示下一页

//        if (fcbNextPage.getVisibility() == GONE && fcbPreviousPage.getVisibility() == GONE)
//            viewLeft.setVisibility(GONE); //设置左侧上下按键背景 隐藏
    }

    public interface LoadLitetsner{
        void nextPage();
        void previousPage();
    }
}
