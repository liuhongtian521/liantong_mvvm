package com.zdy.study.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.askia.coremodel.datamodel.http.entities.consume.HttpOrderFormResultInfo;
import com.zdy.study.R;

/**
 * Create bt she:
 *
 * @date 2020/12/23
 */
public class DialogConfirmation extends Dialog {
    Context context;
    TextView txtNmae, txtmoney;
    TextView back;
    Button sure;

    OnClickListener onClickListener;

    public DialogConfirmation(Context context) {
        super(context, R.style.DialogTheme);
        this.context = context;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setMsg(HttpOrderFormResultInfo.ResultBean resultBean) {
        txtNmae.setText(resultBean.getStudentName());
        txtmoney.setText(resultBean.getOrderMoney());
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirmation);
        txtNmae = findViewById(R.id.txt_account);
        txtmoney = findViewById(R.id.txt_money);

        back = findViewById(R.id.txt_quick);
        sure = findViewById(R.id.btn_sure);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.back();
            }
        });


        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.sure();
            }
        });
    }

    public interface OnClickListener {
        void sure();

        void back();
    }


}
