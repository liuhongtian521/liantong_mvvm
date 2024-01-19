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
import com.meetsl.scardview.SCardView;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCButton;

import java.util.List;

public class LoadMoreConstraintLayout extends ConstraintLayout implements View.OnFocusChangeListener, View.OnClickListener {

    private ImageView ivRightPage, ivLeftPage;
    private SCardView scv_bg_right_sel, scv_bg_left_sel;
    private ImageView ivEmpty;
    private TextView tvEmpty;
    private LoadLitetsner loadLitetsner;
    private int pageSize = 10;//条数默认10

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
        ivRightPage = findViewById(R.id.iv_right_page);
        ivLeftPage = findViewById(R.id.iv_left_page);
        scv_bg_right_sel = findViewById(R.id.scv_bg_right_sel);
        scv_bg_left_sel = findViewById(R.id.scv_bg_left_sel);
        ivEmpty = findViewById(R.id.iv_empty);
        tvEmpty = findViewById(R.id.tv_empty);
        initListener();
        showEmptyView(GONE);
    }

    private void initListener(){
        ivRightPage.setOnClickListener(this);
        ivLeftPage.setOnClickListener(this);
        ivRightPage.setOnFocusChangeListener(this);
        ivLeftPage.setOnFocusChangeListener(this);
    }

    //设置页面条数
    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

    public void setLoadLitetsner(LoadLitetsner loadLitetsner){
        this.loadLitetsner = loadLitetsner;
    }

    public void setPreviousPageVisibility(int visibility){
        if (ivLeftPage.getVisibility() != visibility)
            ivLeftPage.setVisibility(visibility);
    }

    public void setNextPageVisibility(int visibility){
        if (ivRightPage.getVisibility() != visibility)
            ivRightPage.setVisibility(visibility);
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
            return;
        }else{
            showEmptyView(View.GONE);// 隐藏缺省页
        }
        if (page == 1)
            setPreviousPageVisibility(View.GONE);// 第一页隐藏上一页
        else
            setPreviousPageVisibility(View.VISIBLE);// 其它显示上一页
        if (list.size() < pageSize)
            setNextPageVisibility(View.GONE);// 数据小于pageSize条隐藏下一页
        else
            setNextPageVisibility(View.VISIBLE);// 显示下一页

//        if (fcbNextPage.getVisibility() == GONE && fcbPreviousPage.getVisibility() == GONE)
//            viewLeft.setVisibility(GONE); //设置左侧上下按键背景 隐藏
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.iv_right_page:
                if (b)scv_bg_right_sel.setVisibility(VISIBLE);
                else scv_bg_right_sel.setVisibility(GONE);
                break;
            case R.id.iv_left_page:
                if (b)scv_bg_left_sel.setVisibility(VISIBLE);
                else scv_bg_left_sel.setVisibility(GONE);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_right_page:
                if (loadLitetsner != null)
                    loadLitetsner.nextPage();
                break;
            case R.id.iv_left_page:
                if (loadLitetsner != null)
                    loadLitetsner.previousPage();
                break;
        }
    }

    public interface LoadLitetsner{
        void nextPage();
        void previousPage();
    }
}
