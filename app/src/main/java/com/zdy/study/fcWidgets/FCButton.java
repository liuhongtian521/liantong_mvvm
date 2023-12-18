package com.zdy.study.fcWidgets;

import com.zdy.study.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;


@SuppressLint("AppCompatCustomView")
public class FCButton extends Button {

    private float i = 0;

    public FCButton(Context context) {
        super(context);
        setFocusChange();
    }

    public FCButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FCButton);
        i = ta.getFloat(R.styleable.FCButton_scale, 1.10f);
        setFocusChange();
    }

    public FCButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusChange();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FCButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

            } else {
                // 此处为失去焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(1)
                        .scaleY(1)
                        .translationZ(1)
                        .start();
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
