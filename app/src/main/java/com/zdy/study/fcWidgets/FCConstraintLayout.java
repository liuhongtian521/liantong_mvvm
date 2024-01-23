package com.zdy.study.fcWidgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;

import com.meetsl.scardview.SCardView;
import com.zdy.study.R;
import com.zdy.study.uitls.DipPx;

public class FCConstraintLayout  extends ConstraintLayout {
    private float i = 0;
//    private View bgSelected, bgUnSelect;

    private static final int DEFAULT_VALUE_SHADOW_COLOR = R.color.white;
    private static final int DEFAULT_VALUE_SHADOW_CARD_COLOR = R.color.white;
    private static final int DEFAULT_VALUE_SHADOW_ROUND = 0;

    private static final int DEFAULT_VALUE_SHADOW_RADIUS = 10;
    private static final int DEFAULT_VALUE_SHADOW_TOP_HEIGHT = 5;
    private static final int DEFAULT_VALUE_SHADOW_LEFT_HEIGHT = 5;
    private static final int DEFAULT_VALUE_SHADOW_RIGHT_HEIGHT = 5;
    private static final int DEFAULT_VALUE_SHADOW_BOTTOM_HEIGHT = 5;
    private static final int DEFAULT_VALUE_SHADOW_OFFSET_Y = 0;
    private static final int DEFAULT_VALUE_SHADOW_OFFSET_X = DEFAULT_VALUE_SHADOW_TOP_HEIGHT / 3;

    private int shadowRound;
    private int shadowColor;
    private int shadowCardColor;
    private int shadowRadius;
    private int shadowOffsetY;
    private int shadowOffsetX;
    private int shadowTopHeight;
    private int shadowLeftHeight;
    private int shadowRightHeight;
    private int shadowBottomHeight;
    private int selectColor;//选中颜色
    private int unSelectColor;//未选中颜色
    public FCConstraintLayout(@NonNull Context context) {
        super(context);
        setFocusChange();
    }

    public FCConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FCConstraintLayout);
        i = ta.getFloat(R.styleable.FCConstraintLayout_scale, 1.10f);
        initView(context, attrs);
        setFocusChange();
    }

    public FCConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusChange();
    }

    public FCConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
                /*if (bgSelected != null)
                    bgSelected.setVisibility(VISIBLE);
                if (bgUnSelect != null)
                    bgUnSelect.setVisibility(GONE);*/
                shadowColor = selectColor;
//                view.setBackgroundColor(Color.LTGRAY);
            } else {
                // 此处为失去焦点时的处理内容
                ViewCompat.animate(view)
                        .scaleX(1)
                        .scaleY(1)
                        .translationZ(1)
                        .start();
                /*if (bgSelected != null)
                    bgSelected.setVisibility(GONE);
                if (bgUnSelect != null)
                    bgUnSelect.setVisibility(VISIBLE);*/
//                view.setBackgroundColor(Color.TRANSPARENT);
                shadowColor = unSelectColor;
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
    //设置背景阴影效果
    /*public void setBackGround(View bgSelected, View bgUnSelect){
        this.bgSelected = bgSelected;//背景选中效果
        this.bgUnSelect = bgUnSelect;//背景未选中效果
    }*/

    public void setShadowColor(int selectColor){
        this.selectColor = getResources().getColor(selectColor);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FCConstraintLayout);
        shadowRound = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowRound, DEFAULT_VALUE_SHADOW_ROUND);
        shadowColor = a.getColor(R.styleable.FCConstraintLayout_shadowColor, getResources().getColor(DEFAULT_VALUE_SHADOW_COLOR));
        unSelectColor = a.getColor(R.styleable.FCConstraintLayout_shadowColor, getResources().getColor(DEFAULT_VALUE_SHADOW_COLOR));
        selectColor = getResources().getColor(R.color.dash_red);
        shadowCardColor = a.getColor(R.styleable.FCConstraintLayout_shadowCardColor, getResources().getColor(DEFAULT_VALUE_SHADOW_CARD_COLOR));
        shadowTopHeight = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowTopHeight, DipPx.dip2px(getContext(), DEFAULT_VALUE_SHADOW_TOP_HEIGHT));
        shadowRightHeight = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowRightHeight, DipPx.dip2px(getContext(), DEFAULT_VALUE_SHADOW_RIGHT_HEIGHT));
        shadowLeftHeight = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowLeftHeight, DipPx.dip2px(getContext(), DEFAULT_VALUE_SHADOW_LEFT_HEIGHT));
        shadowBottomHeight = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowBottomHeight, DipPx.dip2px(getContext(), DEFAULT_VALUE_SHADOW_BOTTOM_HEIGHT));
        shadowOffsetY = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowOffsetY, DipPx.dip2px(getContext(), DEFAULT_VALUE_SHADOW_OFFSET_Y));
        shadowOffsetX = a.getDimensionPixelSize(R.styleable.FCConstraintLayout_shadowOffsetX, DipPx.dip2px(getContext(), DEFAULT_VALUE_SHADOW_OFFSET_X));
        shadowRadius = a.getInteger(R.styleable.FCConstraintLayout_shadowRadius, DEFAULT_VALUE_SHADOW_RADIUS);
        a.recycle();
        setPadding(shadowLeftHeight, shadowTopHeight, shadowRightHeight, shadowBottomHeight);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }



    @Override
    protected void dispatchDraw(Canvas canvas) {
        Paint shadowPaint = new Paint();
        shadowPaint.setColor(Color.WHITE);
        shadowPaint.setStyle(Paint.Style.FILL);
        shadowPaint.setAntiAlias(true);
        float left = shadowLeftHeight;
        float top = shadowTopHeight;
        float right = getWidth() - shadowRightHeight;
        float bottom = getHeight() - shadowBottomHeight;
        shadowPaint.setShadowLayer(shadowRadius, shadowOffsetX, shadowOffsetX, shadowColor);
        RectF rectF = new RectF(left, top, right, bottom);
        canvas.drawRoundRect(rectF, shadowRound, shadowRound, shadowPaint);
        canvas.save();
        super.dispatchDraw(canvas);
    }
}
