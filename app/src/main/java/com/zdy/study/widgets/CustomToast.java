package com.zdy.study.widgets;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zdy.study.R;


/**
 * Create bt she:
 *
 * @date 2019/10/18
 */
public class CustomToast {


    Toast toast;
    Context mContext;
    TextView toastTextField;

    TextView txt_had,txt_null;



    public CustomToast(Context context) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.BOTTOM, 0, 16);// 位置居中设置

        View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast_againshow, null);
        toastTextField = (TextView) toastRoot.findViewById(R.id.toast_text);
        txt_had=toastRoot.findViewById(R.id.txt_had);
        txt_null=toastRoot.findViewById(R.id.txt_null);
        toast.setView(toastRoot);
    }

    public static CustomToast makeTest(Context context) {
        CustomToast toastCustom = new CustomToast(context);
        return toastCustom;
    }

    public void show(String name) {
        toastTextField.setText(name);
        toast.show();
    }

    public void nullhave(String name){
        toastTextField.setText(name);
        txt_had.setVisibility(View.GONE);
        txt_null.setVisibility(View.VISIBLE);
        toast.show();
    }


}
