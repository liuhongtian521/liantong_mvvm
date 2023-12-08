package com.zdy.study.activitys;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.databinding.ActWebviewBinding;


@Route(path = ARouterPath.WEBVIEW)
public class WebViewActivity extends BaseActivity {

    private ActWebviewBinding mDataBinding;

    private String url;

    @Override
    public void onInit() {
        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("url");
        webViewInit();
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_webview);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1111) {
            webViewInit();

        }
    }


    private void webViewInit(){

        WebSettings webSettings = mDataBinding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        /*webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);*/
//        String url = "http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/1f310d7dfa8a4bcdb166442938451381.pdf?Expires=1701931820&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=LPpKSOaRPPDEhfbNfpIrzFg7In4%3D";



       /* WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);*/
//        webView.loadUrl("http://docs.google.com/gview?url=http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/1f310d7dfa8a4bcdb166442938451381.pdf?Expires=1701931820&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=LPpKSOaRPPDEhfbNfpIrzFg7In4%3D");
//        ("file:///android_asset/pdfjs/web/viewer.html?file=" + pdfUrl);
//        webView.loadUrl("file:///android_asset/pdf.html?"+URL文件)
//        webView.loadUrl("http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/1f310d7dfa8a4bcdb166442938451381.pdf?Expires=1701931820&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=LPpKSOaRPPDEhfbNfpIrzFg7In4%3D" );
//        webView.loadUrl("file:///android_asset/index.html?" + "http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/1f310d7dfa8a4bcdb166442938451381.pdf?Expires=1701931820&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=LPpKSOaRPPDEhfbNfpIrzFg7In4%3D");


//        mDataBinding.webView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=" + url);
//        mDataBinding.webView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=/sdcard/111.pdf" + url);
//        mDataBinding.webView.loadUrl("file:///sdcard/111.pdf");



//        webView.loadUrl("http://mozilla.github.io/pdf.js/web/viewer.html?file=" + URL);
    }
}
