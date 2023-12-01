package com.zdy.study.widgets;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.zdy.study.R;


public class CommonMessageDialog extends Dialog {

    LinearLayout bg;
    TextView mTvSure, mTvQuick,mTvTitle,mTvMainContent,mTvSubContent;
    Context context;
    OnClickBottomListener onConfirmCallback;
    OnClickBottomListener onCancelCallback;

    private String mTitle = "提示";
    private String mMainContent = "";
    private String mSubContent = "";
    private String mConfirm = "确认";
    private String mCancel = "取消";


    public CommonMessageDialog(@NonNull Context context) {
        super(context, R.style.DialogTwoTheme);
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_common_message);
        bg = findViewById(R.id.rel_bg);
        mTvSure = findViewById(R.id.tv_sure);
        mTvQuick=findViewById(R.id.tv_cancel);
        mTvTitle=findViewById(R.id.tv_title);
        mTvMainContent = findViewById(R.id.tv_main_content);
        mTvSubContent = findViewById(R.id.tv_sub_content);
        mTvSure.setText(mConfirm);
        mTvQuick.setText(mCancel);
        mTvMainContent.setText(mMainContent);
        mTvSubContent.setText(mSubContent);
        mTvTitle.setText(mTitle);
        this.setCanceledOnTouchOutside(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bg.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                }
            });
        }

        if(onConfirmCallback != null)
        {
            mTvSure.setVisibility(View.VISIBLE);
        }
        else
        {
            mTvSure.setVisibility(View.GONE);
        }
        if(onCancelCallback != null)
        {
            mTvQuick.setVisibility(View.VISIBLE);
        }
        else
        {
            mTvQuick.setVisibility(View.GONE);
        }

        mTvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onConfirmCallback != null)
                    onConfirmCallback.onCallBack(CommonMessageDialog.this);
                dismiss();
            }
        });

        mTvQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }
    public void setMainContent(String content)
    {
        mMainContent = content;
    }
    public void setSubContent(String content)
    {
        mSubContent = content;
    }


    public void setOnConfirmCallback(String content,OnClickBottomListener onClickBottomListener) {
        this.onConfirmCallback = onClickBottomListener;
        mConfirm = content;
    }

    public void setOnCancelCallback (String content,OnClickBottomListener onClickBottomListener) {
        this.onCancelCallback = onClickBottomListener;
        mCancel = content;
    }
    public interface OnClickBottomListener {
        void onCallBack(CommonMessageDialog dialog);
    }



    @Override
    public void show() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        super.show();
        fullScreenImmersive(getWindow().getDecorView());
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }


    private void fullScreenImmersive(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            view.setSystemUiVisibility(uiOptions);
        }
    }


    public static class MessageDialogBuilder{
        private String mTitle = "提示";
        private String mMainContent = "";
        private String mSubContent = "";
        private String mConfirm = "确认";
        private String mCancel = "取消";
        OnClickBottomListener onConfirmCallback;
        OnClickBottomListener onCancelCallback;
        public CommonMessageDialog create(Context context)
        {
            CommonMessageDialog dialog = new CommonMessageDialog(context);
            dialog.setMainContent(mMainContent);
            dialog.setTitle(mTitle);
            dialog.setSubContent(mSubContent);
            dialog.setOnConfirmCallback(mConfirm,onConfirmCallback);
            dialog.setOnCancelCallback(mCancel,onCancelCallback);
            return dialog;
        }

        public MessageDialogBuilder setTitle(String title)
        {
            mTitle = title;
            return this;
        }

        public MessageDialogBuilder setMainContent(String content)
        {
            mMainContent = content;
            return this;
        }

        public MessageDialogBuilder setSubContent(String content)
        {
            mSubContent = content;
            return this;
        }

        public MessageDialogBuilder setConfirm(String content,OnClickBottomListener callback)
        {
            mConfirm = content;
            onConfirmCallback = callback;
            return this;
        }

        public MessageDialogBuilder setCancel(String content,OnClickBottomListener callback)
        {
            mCancel = content;
            onCancelCallback = callback;
            return this;
        }

    }
}
