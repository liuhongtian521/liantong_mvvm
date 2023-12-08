package com.zdy.study.activitys;


import android.graphics.Canvas;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;
import com.zdy.study.R;

import java.io.File;

public class PdfViewActivity extends AppCompatActivity implements OnPageChangeListener
        , OnLoadCompleteListener, OnDrawListener {
    private PDFView pdfView ;
    private int page = 1;

    public static String fileName = "111.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        pdfView = (PDFView) findViewById( R.id.pdfView );

        //从assets目录读取pdf
//        displayFromAssets("0010000022464002F__李东.pdf");


        File apk = new File(getExternalCacheDir() + fileName);
        //从文件中读取pdf
        displayFromFile( apk);

    }

    private void displayFromAssets(String assetFileName ) {
        pdfView.fromAsset(assetFileName)   //设置pdf文件地址
                .defaultPage(page)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
                .swipeVertical( false )  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻页
//                 .pages()  //把 5 过滤掉
                .load();
    }


    public boolean onKeyDown(int kCode, KeyEvent kEvent)
    {
        switch(kCode)
        {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (page > 1)
                    page --;
                pdfView.jumpTo(page);
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (page<pdfView.getPageCount())
                    page ++;
                pdfView.jumpTo(page);
                return true;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                return true;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                return true;
            case KeyEvent.KEYCODE_BACK:
                finish();
                return false; }
        return super.onKeyDown(kCode,kEvent);
    }

    private void displayFromFile(File file ) {
        pdfView.fromFile(file)   //设置pdf文件地址
                .defaultPage(1)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
                .swipeVertical( false )  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻
                // .pages( 2 ，5  )  //把2  5 过滤掉
                .load();
    }

    /**
     * 翻页回调
     * @param page
     * @param pageCount
     */
    @Override
    public void onPageChanged(int page, int pageCount) {
        /*Toast.makeText( this , "page= " + page +
                " pageCount= " + pageCount , Toast.LENGTH_SHORT).show();*/
    }

    /**
     * 加载完成回调
     * @param nbPages  总共的页数
     */
    @Override
    public void loadComplete(int nbPages) {
        Toast.makeText( this ,  "加载完成" + nbPages  , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
        // Toast.makeText( MainActivity.this ,  "pageWidth= " + pageWidth + "
        // pageHeight= " + pageHeight + " displayedPage="  + displayedPage , Toast.LENGTH_SHORT).show();
    }
}
