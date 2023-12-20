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


public class CommonMessageTipsDialog extends Dialog {

    LinearLayout bg;
    TextView mTvSure, mTvQuick,mTvTitle,mTvMainContent,mTvSubContent, mTvUpdateDescription;
    Context context;
    OnClickBottomListener onConfirmCallback;
    OnClickBottomListener onCancelCallback;

   // private String mTitle = "提示";
    private String mMainContent = "";
    private String mSubContent = "";
    private String mUpdateDescription = "";
    private String mConfirm = "确认";
    private String mCancel = "取消";

    private String mTitle = "提示";

    public CommonMessageTipsDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_common_message2);
        bg = findViewById(R.id.rel_bg);
        mTvSure = findViewById(R.id.tv_sure);
        mTvQuick=findViewById(R.id.tv_cancel);
       // mTvTitle=findViewById(R.id.tv_title);
        mTvMainContent = findViewById(R.id.tv_main_content);
        mTvSubContent = findViewById(R.id.tv_sub_content);
        mTvUpdateDescription = findViewById(R.id.update_description);
        mTvSure.setText(mConfirm);
        mTvQuick.setText(mCancel);
        mTvMainContent.setText(mMainContent);
        mTvSubContent.setText(mSubContent);
        mTvUpdateDescription.setText(mUpdateDescription.replace("\\n", "\n"));
     //   mTvTitle.setText(mTitle);
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
                    onConfirmCallback.onCallBack(CommonMessageTipsDialog.this);
                dismiss();
            }
        });

        mTvQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
/*        lp.gravity = Gravity.CENTER;*/
        lp.dimAmount = 0.3f; // 去背景遮盖
        lp.alpha = 1.0f;
/*        lp.width = WindowManager.LayoutParams.MATCH_PARENT;*/
   /*     lp.width = Utils.dp2px(mContext,280);
        lp.height = Utils.dp2px(mContext,100);*/
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setAttributes(lp);
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
        void onCallBack(CommonMessageTipsDialog dialog);
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

    public CommonMessageTipsDialog setTitle(String title)
    {
        mTitle = title;
        return this;
    }

    public CommonMessageTipsDialog setMainContent(String content)
    {
        mMainContent = content;
        if (mTvMainContent != null)
            mTvMainContent.setText(mMainContent);
        return this;
    }

    public CommonMessageTipsDialog setSubContent(String content)
    {
        mSubContent = content;
        if (mTvSubContent != null)
            mTvSubContent.setText(mSubContent);
        return this;
    }

    public CommonMessageTipsDialog setUpdateDescription(String content)
    {
        mUpdateDescription = content;
        if (mTvUpdateDescription != null)
            mTvUpdateDescription.setText(mUpdateDescription.replace("\\n", "\n"));
        return this;
    }

    public CommonMessageTipsDialog setConfirm(String content,OnClickBottomListener callback)
    {
        mConfirm = content;
        onConfirmCallback = callback;
        return this;
    }

    public CommonMessageTipsDialog setCancel(String content,OnClickBottomListener callback)
    {
        mCancel = content;
        onCancelCallback = callback;
        return this;
    }

}
