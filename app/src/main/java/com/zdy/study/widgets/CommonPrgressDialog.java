package com.zdy.study.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zdy.study.R;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;


public class CommonPrgressDialog extends Dialog {
    View mView;
    private ProgressBar mProgressBar;
    private TextView mTvTitle;
    private TextView mTvDes;
    private TextView mTvCancel;

    private Callback mCallback;

    private Context mContext;
    //    style引用style样式
    public CommonPrgressDialog(Context context) {
        super(context, R.style.DialogTheme);
        mView = getLayoutInflater().inflate(R.layout.common_progress_dialog, null);
        mContext = context;
        setContentView(mView);

        mProgressBar = mView.findViewById(R.id.progress_bar);
        mTvTitle = mView.findViewById(R.id.tv_title);
        mTvDes = mView.findViewById(R.id.tv_des);
        mTvCancel = mView.findViewById(R.id.tv_cancel);
        setCanceledOnTouchOutside(false);

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }


    @Override
    public void show() {
        mProgressBar.setProgress(0);
        mTvCancel.setVisibility(View.INVISIBLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

        super.show();

        fullScreenImmersive(getWindow().getDecorView());
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    public void showWithCancel(Callback callback)
    {
        this.show();
        this.mCallback = callback;
        mTvCancel.setVisibility(View.VISIBLE);
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback != null)
                {
                    new QMUIDialog.MessageDialogBuilder(mContext)
                            .setTitle("是否取消")
                            .setCancelable(true)
                            .setCanceledOnTouchOutside(true)
                            .addAction("确定取消", new QMUIDialogAction.ActionListener() {
                                @Override
                                public void onClick(QMUIDialog dialog, int index) {
                                    dialog.dismiss();
                                    mCallback.onCancel();
                                }
                            })
                            .addAction("继续上传", new QMUIDialogAction.ActionListener() {
                                @Override
                                public void onClick(QMUIDialog dialog, int index) {
                                    dialog.dismiss();
                                }
                            })
                            .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
                }
            }
        });
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


    public void setProgress(int a) {
        mProgressBar.setProgress(a);
    }

    public void setTitle(String s) {
        mTvTitle.setText(s);
    }

    public void setDes(String s) {
        mTvDes.setText(s);
    }

    public interface Callback{
        void onCancel();
    }
}
