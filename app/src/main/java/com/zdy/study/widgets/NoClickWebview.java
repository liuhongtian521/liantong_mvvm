package com.zdy.study.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by qinyy on 2019/4/14.
 */

public class NoClickWebview extends WebView
{

    public NoClickWebview(Context context)
    {
        super(context);
    }

    public NoClickWebview(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public NoClickWebview(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOverScrollMode(int mode) {
        super.setOverScrollMode(mode);
       // AutoSize.autoConvertDensityOfGlobal();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
//            return super.onTouchEvent(ev);
        return false;
    }

}
