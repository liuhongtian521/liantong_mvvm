package com.zdy.study.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


public class TopRadiusImageView extends ImageView {

    public TopRadiusImageView(Context context, AttributeSet attrs,
                              int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    public TopRadiusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public TopRadiusImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public Bitmap drawableToBitmap(Drawable drawable) {

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;

    }

    private float xRadius = 20;
    private float yRadius = 20;
    private Paint imgPaint;
    private boolean isRadiusTopLeft = true;
    private boolean isRadiusTopRight = true;
    private boolean isRadiusBottomLeft = false;
    private boolean isRadiusBottomRight = false;

    // @Override
    // protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    // // TODO Auto-generated method stub
    // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    // postInvalidate();
    // }

    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);
        Drawable mDrawable = getDrawable();
        if (mDrawable == null) {
            return;
        }

        if (mDrawable.getIntrinsicWidth() <= 0
                || mDrawable.getIntrinsicHeight() <= 0) {
            return; // nothing to draw (empty bounds)
        }
        int w = getWidth();
        int h = getHeight();

        if (imgPaint == null) {
            initBitPaint(mDrawable);
//            if(eraserPaint==null){
//                initEraserPaint();
//            }
        }

        RectF rectF = new RectF(0, 0, w, h);
        int layerId = canvas.saveLayer(rectF, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawRoundRect(rectF, xRadius, yRadius, imgPaint);

        if (!isRadiusTopLeft) {
            canvas.drawRect(0, 0, xRadius, yRadius, eraserPaint);
//            canvas.drawRect(0, 0, xRadius, yRadius, imgPaint);
        }
        if (!isRadiusTopRight) {
            canvas.drawRect(rectF.right - xRadius, 0, rectF.right, yRadius,
                    eraserPaint);
//            canvas.drawRect(rectF.right - xRadius, 0, rectF.right, yRadius,
//                    imgPaint);
        }
        if (!isRadiusBottomLeft) {
            canvas.drawRect(0, rectF.bottom - yRadius, xRadius, rectF.bottom,
                    eraserPaint);
//            canvas.drawRect(0, rectF.bottom - yRadius, xRadius, rectF.bottom,
//                    imgPaint);
        }
        if (!isRadiusBottomRight) {
            canvas.drawRect(rectF.right - xRadius, rectF.bottom - yRadius,
                    rectF.right, rectF.bottom, eraserPaint);
//            canvas.drawRect(rectF.right - xRadius, rectF.bottom - yRadius,
//                    rectF.right, rectF.bottom, imgPaint);
        }
        canvas.restoreToCount(layerId);
    }

    public void initBitPaint(Drawable mDrawable) {
        Bitmap imgBitmap = drawableToBitmap(mDrawable);
        BitmapShader mShader = new BitmapShader(imgBitmap, Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        imgPaint = new Paint();
        imgPaint.setAntiAlias(true);
        imgPaint.setShader(mShader);

        eraserPaint = new Paint();
        eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        eraserPaint.setAntiAlias(true);
        eraserPaint.setShader(mShader);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private Paint eraserPaint;


}