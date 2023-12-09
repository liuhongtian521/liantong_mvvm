package com.zdy.study.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCButton;

public class LoadMoreConstraintLayout extends ConstraintLayout {

    private FCButton fcbNextPage, fcbPreviousPage;
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

    public interface LoadLitetsner{
        void nextPage();
        void previousPage();
    }
}
