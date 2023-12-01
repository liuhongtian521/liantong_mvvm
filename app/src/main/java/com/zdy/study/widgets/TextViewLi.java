package com.zdy.study.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Create bt she:
 *
 * @date 2019/11/21
 */
public class TextViewLi extends View {

    public static final int LAYOUT_CHANGED = 10001101;
    private Paint paint;
    private int mTextPosx = 0;// x坐标
    private int mTextPosy = 0;// y坐标
    private int mTextWidth = 0;// 绘制宽度
    private int mTextHeight = 0;// 绘制高度
    private int mFontHeight = 0;// 绘制字体高度
    private float mFontSize = 30;// 字体大小
    private int mRealLine = 0;// 字符串真实的行数
    private int mLineWidth = 0;//列宽度
    private int TextLength = 0;//字符串长度
    private String oldtxt = "";//存储久的width
    private int newPostY = 0;//初始高度
    private String text = "";//待显示的文字
    private Matrix matrix;
    private Align textStartAlign = Align.LEFT;//draw start left or right.//default right
    BitmapDrawable drawable = (BitmapDrawable) getBackground();

    private void setnul() {
        mTextPosx = 0;
        mTextPosy = 0;
        mTextWidth = 0;
        mFontHeight = 0;
        mRealLine = 0;// 字符串真实的行数
        mLineWidth = 0;//列宽度
        TextLength = 0;//字符串长度
        newPostY = 0;//初始高度
    }


    public TextViewLi(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TextViewLi(Context context, AttributeSet attrs) {
        super(context, attrs);
        matrix = new Matrix();
        paint = new Paint();//新建画笔
        paint.setTextAlign(Align.CENTER);//文字居中
        paint.setAntiAlias(true);//平滑处理
        paint.setColor(Color.WHITE);//默认文字颜色
        paint.setFakeBoldText(true);
//        try {
//            mFontSize = Float.parseFloat(attrs.getAttributeValue(null, "textSize"));//获取字体大小属性
//        } catch (Exception e) {
//        }

    }

    //设置文字
    public final void setText(String text) {
        if (text.equals(""))
            text=" ";
//            text = "战胜自我不服输，高考场上显身手";
//        text = "  " + text + "  ";
//        if (text.length() < 16) {
//            int num = 16 - text.length();
//            for (int index = 0; index < num / 2; index++) {
//                text = " " + text + " ";
//            }


        this.text  = text;
    }

    //设置字体大小
    public final void setTextSize(float size) {
        if (size != paint.getTextSize()) {
            mFontSize = size;
            if (mTextHeight > 0) GetTextInfo();
        }
    }

    //设置字体颜色
    public final void setTextColor(int color) {
        paint.setColor(color);
    }

    //设置字体颜色
    public final void setTextARGB(int a, int r, int g, int b) {
        paint.setARGB(a, r, g, b);
    }

    //设置字体
    public void setTypeface(Typeface tf) {
        if (this.paint.getTypeface() != tf) {
            this.paint.setTypeface(tf);
        }
    }

    //设置行宽
    public void setLineWidth(int LineWidth) {
        mLineWidth = LineWidth;
    }

    //获取实际宽度
    public int getTextWidth() {
        return mTextWidth;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setnul();
        this.TextLength = text.length();
//        if (mTextHeight > 0)
        GetTextInfo();


        if (drawable != null) {
            //画背景
            Bitmap b = Bitmap.createBitmap(drawable.getBitmap(), 0, 0, mTextWidth, mTextHeight);
            canvas.drawBitmap(b, matrix, paint);
        }
        //画字
        Log.e("TagSnake", "onDraw");

        draw(canvas, this.text);

        Log.e("TagSnake", "onDrawEnd");
    }

    private void draw(Canvas canvas, String thetext) {

        char ch;
        mTextPosy = 0;//初始化y坐标

        mTextPosx = textStartAlign == Align.LEFT ? mLineWidth : mTextWidth - mLineWidth;//初始化x坐标

//        Log.e("TagSnake", mTextPosx + ":" + mTextPosy + ":" + mTextWidth); // 29:0:87
        Log.e("TagSnake", mFontHeight + ":" + mRealLine + ":" + mLineWidth + ":" + TextLength); //22:3:29:24
        Log.e("TagSnake", newPostY + ":" + mTextHeight + ":" + thetext);  // 4:0:264:  人贵知足，唯学不然。人功不竭，天巧不传。
        int mid = this.TextLength / 2;
        Log.e("TagSnake", mid + ":");
        if (this.TextLength % 2 != 0)
            mid++;

        boolean newl = true;
        int newy = 0;
        int numk = 0;
        int nums = 0;

        for (int txtind = 0; txtind < TextLength; txtind++) {

            ch = thetext.charAt(txtind);
//            Log.e("TagLog", String.valueOf(ch));
            if (String.valueOf(ch).equals(" "))
                numk++;
            if (numk == 2) {
                newy++;
                numk = 0;
            }
        }


        for (int i = 0; i < this.TextLength; i++) {
            nums++;
            Log.e("TagLog", nums + "");
            ch = thetext.charAt(i);
            if (nums > 50) {
                break;
            }
//            if (i == mid) {
//                if (newl) {
//                    if (textStartAlign == Align.LEFT) {
//                        mTextPosx += mLineWidth;// 换列
//                    } else {
//                        mTextPosx -= mLineWidth;// 换列
//                    }
//                    mTextPosy = 0;
////                    newPostY = (getHeight() - mTextHeight) / 2;
//                    mTextPosy = mFontHeight * (newy + 1);
//                    i--;
//                    newl = false;
//                } else {
//                    newl = true;
//                    canvas.drawText(String.valueOf(ch), mTextPosx, mTextPosy, paint);
//                }
//            } else {
                mTextPosy += mFontHeight;
                Log.e("TagLog", mTextPosy + ":B 1:" + mTextHeight);
                if (mTextPosy > this.mTextHeight) {
                    if (textStartAlign == Align.LEFT) {
                        mTextPosx += mLineWidth;// 换列
                    } else {
                        mTextPosx -= mLineWidth;// 换列
                    }
                    i--;
                    newPostY = (getHeight() - mTextHeight) / 2;
                    mTextPosy = mFontHeight * (newy + 1);
                    Log.e("TagLog", mTextPosy + ":B 2:" + mTextHeight);
                    Log.e("TagLog", mFontHeight + ":B 3:" + newy);

                } else {
                    Log.e("TagLog", "C1" + mTextPosx + ":" + mTextPosy);
                    canvas.drawText(String.valueOf(ch), mTextPosx, mTextPosy, paint);
//                }
            }
        }

    }

    //计算文字行数和总宽
    private void GetTextInfo() {
        char ch;
        int h = 0;
        paint.setTextSize(mFontSize);
        //获得字宽
        if (mLineWidth == 0) {
            float[] widths = new float[1];
            paint.getTextWidths("正", widths);//获取单个汉字的宽度
            mLineWidth = (int) Math.ceil(widths[0] * 1.1 + 2);
        }

        FontMetrics fm = paint.getFontMetrics();
        mFontHeight = (int) (Math.ceil(fm.descent - fm.top) * 0.9);// 获得字体高度
        int mid = this.TextLength / 2;
        if (this.TextLength % 2 != 0)
            mid++;
        //计算文字行数
//        mRealLine = 0;
//        for (int i = 0; i < this.TextLength; i++) {
//            ch = this.text.charAt(i);
//            if (i == mid) {
//                mRealLine++;// 真实的行数加一
//                h = mFontHeight;
//            } else {
//                h += mFontHeight;
//                if (h > this.mTextHeight) {
//                    mRealLine++;// 真实的行数加一
//                    i--;
//                    h = 0;
//                } else {
//                    if (i == this.TextLength - 1) {
//                        mRealLine++;// 真实的行数加一
//                    }
//                }
//            }
//        }
//        mRealLine++;//额外增加一行
        mTextWidth = mLineWidth ;//计算文字总宽度
        mTextHeight = mFontHeight * this.TextLength;
//        Log.e("TagSnake", mTextHeight + ":" + mFontHeight + ":" + mid);
//        measure(mTextWidth, mTextHeight);//重新调整大小
//        layout(getLeft(), getTop(), getLeft() + mTextWidth, getBottom());//重新绘制容器
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        Log.e("TagSnake", "onMeasureStart");
        int measuredHeight = measureHeight(heightMeasureSpec);
//        int measuredWidth = measureWidth(widthMeasureSpec);
        if (mTextWidth == 0)
            GetTextInfo();
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
//        if (!oldtxt.equals(text)) {//
//            oldtxt = text;
//            if (mHandler != null) mHandler.sendEmptyMessage(LAYOUT_CHANGED);
//        }
//        Log.e("TagSnake", "onMeasureEnd");

    }

    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 20;
        if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        mTextHeight = result;//设置文本高度
        return result;
    }
}
