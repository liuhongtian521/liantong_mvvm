package com.zdy.study.fcWidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

import com.meetsl.scardview.SCardView;
import com.zdy.study.R;

public class FCRelativeLayout extends RelativeLayout {
    private SCardView sCardView;
    private float i = 0;
    public FCRelativeLayout(Context context) {
        super(context);
        setFocusChange();
    }

    public FCRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bg_textview_layout2, this);
        sCardView=findViewById(R.id.scv_bg_menu_sel_bg1);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FCRelativeLayout);
        i = ta.getFloat(R.styleable.FCRelativeLayout_scale, 1.10f);
        setFocusChange();
    }

    public FCRelativeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusChange();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FCRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFocusChange();
    }

    private void setFocusChange(){
        this.setOnFocusChangeListener((view, b) -> {
            if (b) {
                // 此处为得到焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(i==0? 1.10f: i)
                        .scaleY(i==0? 1.10f: i)
                        .translationZ(1)
                        .start();
                sCardView.setVisibility(VISIBLE);
//                view.setBackgroundColor(Color.LTGRAY);
            } else {
                // 此处为失去焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(1)
                        .scaleY(1)
                        .translationZ(1)
                        .start();
                sCardView.setVisibility(GONE);
//                view.setBackgroundColor(Color.TRANSPARENT);
            }
        });
    }
    public void setScale(float i){
        this.i = i;
    }

    public void setLitScale(){
        this.i = 1.02f;
    }

    public void setBigScale(){
        this.i = 1.25f;
    }
}
