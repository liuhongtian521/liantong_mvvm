package com.zdy.study.uitls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;

import com.meetsl.scardview.SCardView;
import com.zdy.study.R;

public class BGTextview extends ConstraintLayout {
    private float i = 0;
    private SCardView bgSelected;
    private String text;
    private TextView mText;
    private View mViewCircle;

    public void setText(String text) {
        mText.setText(text);
    }

    public void setCircleVisibility(boolean a) {
       if (a){
           mViewCircle.setVisibility(VISIBLE);
       }else {
           mViewCircle.setVisibility(GONE);
       }
    }

    public BGTextview(@NonNull Context context) {
        super(context);
        initLayout(context);
        setFocusChange();
    }

    private void initLayout(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bg_textview_layout, this, true);
        bgSelected = findViewById(R.id.scv_bg_menu_sel_bg);
        mText = findViewById(R.id.tv_student_text);
        mViewCircle = findViewById(R.id.view_circle);
    }

    public BGTextview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FCConstraintLayout);
        i = ta.getFloat(R.styleable.FCConstraintLayout_scale, 1.10f);
        setFocusChange();
    }

    public BGTextview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
        setFocusChange();
    }

    public BGTextview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFocusChange();
    }

    private void setFocusChange() {
        this.setOnFocusChangeListener((view, b) -> {
            if (b) {
                // 此处为得到焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(i == 0 ? 1.10f : i)
                        .scaleY(i == 0 ? 1.10f : i)
                        .translationZ(1)
                        .start();
                if (bgSelected != null)
                    bgSelected.setVisibility(VISIBLE);
            } else {
                // 此处为失去焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(1)
                        .scaleY(1)
                        .translationZ(1)
                        .start();
                if (bgSelected != null)
                    bgSelected.setVisibility(GONE);
            }
        });
    }

    public void setScale(float i) {
        this.i = i;
    }

    public void setLitScale() {
        this.i = 1.02f;
    }

    public void setBigScale() {
        this.i = 1.25f;
    }
}
