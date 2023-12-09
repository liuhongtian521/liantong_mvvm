package com.askia.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

import com.askia.common.R;
import com.askia.common.util.Utils;
import com.bumptech.glide.Glide;
import com.yanyusong.y_divideritemdecoration.Dp2Px;


public class NetLoadingDialog extends AlertDialog {
    ImageView img;
    private Context mContext;
//    private NetLoadingDialog sNetLoadingDialog;

    public NetLoadingDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public NetLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;

    }

    public NetLoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;

    }

   /* public NetLoadingDialog show(Context context, boolean cancelable, OnCancelListener cancelListener) {
        if(sNetLoadingDialog == null)
            sNetLoadingDialog = new NetLoadingDialog(context, cancelable, cancelListener);
        if(sNetLoadingDialog.isShowing())
            return sNetLoadingDialog;
        sNetLoadingDialog.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                    dialog.cancel();
                }
                return false;
            }
        });
        sNetLoadingDialog.setCanceledOnTouchOutside(true);
        sNetLoadingDialog.setCancelable(true);
        sNetLoadingDialog.show();
        return sNetLoadingDialog;
    }

    @Override
    public void show() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        super.show();
        fullScreenImmersive(getWindow().getDecorView());
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }*/

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_dialog_net_loading);
        WindowManager.LayoutParams lp;
        lp = getWindow().getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.dimAmount = 0; // 去背景遮盖
        lp.alpha = 1.0f;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
   /*     lp.width = Utils.dp2px(mContext,280);
        lp.height = Utils.dp2px(mContext,100);*/
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setAttributes(lp);
        img = (ImageView) findViewById(R.id.img);
        Glide.with(mContext).load(R.drawable.loading).into(img);
        // WImageLoader.getInstance().loadResImage(getContext(), com.ryan.baselibrary.R.drawable.loading,img);
    }


}
