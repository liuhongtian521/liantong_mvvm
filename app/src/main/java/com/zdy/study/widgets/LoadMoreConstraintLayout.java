package com.zdy.study.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCButton;

public class LoadMoreConstraintLayout extends ConstraintLayout {

    private FCButton fcbNextPage, fcbPreviousPage;
    private ImageView ivEmpty;
    private TextView tvEmpty;
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

    public interface LoadLitetsner{
        void nextPage();
        void previousPage();
    }
}
