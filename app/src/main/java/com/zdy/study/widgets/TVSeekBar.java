package com.zdy.study.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.SeekBar;

@SuppressLint("AppCompatCustomView")
public class TVSeekBar extends SeekBar {
    public TVSeekBar(Context context) {
        super(context);
    }

    public TVSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TVSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TVSeekBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



    ChangeListener changeListener;

    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT || keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            changeListener.upListener();
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT || keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            changeListener.dwonListener();
        }
        return super.onKeyDown(keyCode, event);
    }

    interface ChangeListener{
        void dwonListener();
        void upListener();
    }
}
