package com.zdy.study.fcWidgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;


@SuppressLint("AppCompatCustomView")
public class FCButton extends Button {

    public FCButton(Context context) {
        super(context);
        setFocusChange();
    }

    public FCButton(Context context, AttributeSet attrs) {
        super(context, attrs);
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
                        .scaleX(1.10f)
                        .scaleY(1.10f)
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
}
