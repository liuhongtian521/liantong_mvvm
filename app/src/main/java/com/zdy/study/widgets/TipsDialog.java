package com.zdy.study.widgets;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.zdy.study.R;


public class TipsDialog extends Dialog implements View.OnClickListener {
    private TextView tv_tips1,tv_tips2,tv_cannel,tv_confirm;
    private String tips1,tips2,cancel,confirm;
    private OnCancelListener cancelListener;
    private OnConfirmListener confirmListener;
    private int visibility = View.VISIBLE;

    public TipsDialog(@NonNull Context context) {
        super(context);
    }

    public TipsDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public TipsDialog setTips1(String tips1) {
        this.tips1 = tips1;
        return this;
    }

    public TipsDialog setTips2(String tips2) {
        this.tips2 = tips2;
        return this;
    }

    public TipsDialog setCancel(String cancel,OnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener=listener;
        return this;
    }

    public TipsDialog setConfirm(String confirm,OnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener=listener;
        return this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_tips);
        //设置宽度，固定代码
        WindowManager m=getWindow().getWindowManager();
        Display d=m.getDefaultDisplay();
        WindowManager.LayoutParams p=getWindow().getAttributes();
        Point size=new Point();
        d.getSize(size);
        p.width=(int)(size.x*0.8);//设置dialog的宽度为当前手机屏幕宽度*0.8
        getWindow().setAttributes(p);
        tv_tips1= (TextView) findViewById(R.id.tv_tips1);
        tv_tips2= (TextView) findViewById(R.id.tv_tips2);
        tv_cannel= (TextView) findViewById(R.id.tv_cannel);
        tv_confirm= (TextView) findViewById(R.id.tv_confirm);
        tv_cannel.setVisibility(visibility);
        if(!TextUtils.isEmpty(tips1)){//不为空
            tv_tips1.setText(tips1);
        }
        if(!TextUtils.isEmpty(tips2)){//不为空
            tv_tips2.setText(tips2);
            tv_tips2.setVisibility(View.VISIBLE);
        }else
            tv_tips2.setVisibility(View.GONE);
        if(!TextUtils.isEmpty(cancel)){//不为空
            tv_cannel.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){//不为空
            tv_confirm.setText(confirm);
        }
        tv_cannel.setOnClickListener(this);
        tv_confirm.setOnClickListener(this);
        tv_confirm.requestFocus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cannel:
                if(cancelListener!=null){
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if(confirmListener!=null){
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public TipsDialog setCancelVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public interface OnCancelListener{
        void onCancel(Dialog dialog);
    }

    public interface OnConfirmListener{
        void onConfirm(Dialog dialog);
    }

}
