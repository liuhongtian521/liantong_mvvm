package com.askia.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askia.common.R;
import com.askia.common.widget.face.ShowFaceInfoAdapter;
import com.askia.coremodel.datamodel.face.faceserver.CompareResult;
import com.askia.coremodel.datamodel.face.faceserver.FaceServer;
import com.askia.coremodel.datamodel.http.entities.NameByString;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

/**
 * Create bt she:
 *
 * @date 2019/10/30
 */
public class FaceChooseDialog extends Dialog {

    Context context;
    List<CompareResult.Message> messasList;
    public OnClickBottomListener onClickBottomListener;

    CompareResult.Message chooseMessa = null;

    TextView txt_title;
    TextView btn_not;
    TextView btn_ok;

    LinearLayout ll_two, ll_three;
    RelativeLayout re_heard_one, re_heard_two, re_heard_three, re_heard_four, re_heard_five;
    ImageView img_heard_one, img_heard_two, img_heard_three, img_heard_four, img_heard_five;
    TextView txt_name_one, txt_name_two, txt_name_three, txt_name_four, txt_name_five;

    public FaceChooseDialog(Context context, List<CompareResult.Message> messasList) {
        super(context, R.style.ProgressDialogTheme);
        this.context = context;
        this.messasList = messasList;
    }

    public void setClick(OnClickBottomListener onClickBottomListener) {
        this.onClickBottomListener = onClickBottomListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_face_choose);
        setCanceledOnTouchOutside(false);
        initv();
        initEvent();
    }

    private void initEvent() {
        btn_not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBottomListener.onNegtiveClick();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chooseMessa != null)
                    onClickBottomListener.onPositiveClick(chooseMessa);
                else
                    onClickBottomListener.onNegtiveClick();
            }
        });

        re_heard_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTwoNew();
                re_heard_one.setBackgroundColor(context.getResources().getColor(R.color.bg_dialog));
                txt_name_one.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_yc));
                chooseMessa = messasList.get(0);
                setTxt_title();
            }
        });

        re_heard_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTwoNew();
                re_heard_two.setBackgroundColor(context.getResources().getColor(R.color.bg_dialog));
                txt_name_two.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_yc));
                chooseMessa = messasList.get(1);
                setTxt_title();
            }
        });

        re_heard_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThreeNew();
                re_heard_three.setBackgroundColor(context.getResources().getColor(R.color.bg_dialog));
                txt_name_three.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_yc));
                chooseMessa = messasList.get(0);
                setTxt_title();
            }
        });


        re_heard_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThreeNew();
                re_heard_four.setBackgroundColor(context.getResources().getColor(R.color.bg_dialog));
                txt_name_four.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_yc));
                chooseMessa = messasList.get(1);
                setTxt_title();
            }
        });
        re_heard_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThreeNew();
                re_heard_five.setBackgroundColor(context.getResources().getColor(R.color.bg_dialog));
                txt_name_five.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_yc));
                chooseMessa = messasList.get(2);
                setTxt_title();
            }
        });

    }


    private void setTxt_title() {
        String name = "";
        if (chooseMessa.getUserName().indexOf("_") == -1)
            name = chooseMessa.getUserName();
        else
            name = chooseMessa.getUserName().substring(0, chooseMessa.getUserName().indexOf("_"));
        txt_title.setText("已选择: " + name);
    }

    private void initv() {
        txt_title = findViewById(R.id.txt_title);
        btn_not = findViewById(R.id.btn_not);
        btn_ok = findViewById(R.id.btn_ok);

        ll_two = findViewById(R.id.ll_two);
        ll_three = findViewById(R.id.ll_three);

        re_heard_one = findViewById(R.id.re_heard_one);
        re_heard_two = findViewById(R.id.re_heard_two);

        re_heard_three = findViewById(R.id.re_heard_three);
        re_heard_four = findViewById(R.id.re_heard_four);
        re_heard_five = findViewById(R.id.re_heard_five);

        img_heard_one = findViewById(R.id.img_heard_one);
        img_heard_two = findViewById(R.id.img_heard_two);

        img_heard_three = findViewById(R.id.img_heard_three);
        img_heard_four = findViewById(R.id.img_heard_four);
        img_heard_five = findViewById(R.id.img_heard_five);

        txt_name_one = findViewById(R.id.txt_name_one);
        txt_name_two = findViewById(R.id.txt_name_two);

        txt_name_three = findViewById(R.id.txt_name_three);
        txt_name_four = findViewById(R.id.txt_name_four);
        txt_name_five = findViewById(R.id.txt_name_five);

//        DisplayMetrics dm = context.getResources().getDisplayMetrics();
//        int spanCount = (int) (dm.widthPixels / (context.getResources().getDisplayMetrics().density * 100 + 0.5f));

        if (messasList.size() == 2) {
            ll_two.setVisibility(View.VISIBLE);
            ll_three.setVisibility(View.GONE);
            setTwoTxt();
        } else {
            ll_three.setVisibility(View.VISIBLE);
            ll_two.setVisibility(View.GONE);
            setThreeTxt();
        }
    }

    private void setTwoTxt() {
        int num = 1;
        for (CompareResult.Message messa : messasList) {
            setUI(messa, num);
            num++;

        }
    }

    private void setThreeTxt() {
        int num = 3;
        for (CompareResult.Message messa : messasList) {
            setUI(messa, num);
            num++;

        }
    }

    private void setUI(CompareResult.Message messa, int index) {
        NameByString nameByString = new NameByString(messa.getUserName());
         File imgFile = new File(FaceServer.ROOT_PATH + File.separator + FaceServer.SAVE_IMG_DIR + File.separator + messa.getUserName() + FaceServer.IMG_JPG_SUFFIX);
         switch (index) {
            case 1:
                Glide.with(img_heard_one)
                        .load(imgFile)
                        .into(img_heard_one);
                txt_name_one.setText(nameByString.getName());
                break;
            case 2:
                Glide.with(img_heard_two)
                        .load(imgFile)
                        .into(img_heard_two);
                txt_name_two.setText(nameByString.getName());
                break;
            case 3:
                Glide.with(img_heard_three)
                        .load(imgFile)
                        .into(img_heard_three);
                txt_name_three.setText(nameByString.getName());
                break;
            case 4:
                Glide.with(img_heard_four)
                        .load(imgFile)
                        .into(img_heard_four);
                txt_name_four.setText(nameByString.getName());
                break;
            case 5:
                Glide.with(img_heard_five)
                        .load(imgFile)
                        .into(img_heard_five);
                txt_name_five.setText(nameByString.getName());
                break;
        }
    }

    private void setTwoNew() {
        re_heard_one.setBackground(null);
        re_heard_two.setBackground(null);

        txt_name_one.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_nc));
        txt_name_two.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_nc));
    }

    private void setThreeNew() {
        re_heard_three.setBackground(null);
        re_heard_four.setBackground(null);
        re_heard_five.setBackground(null);

        txt_name_three.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_nc));
        txt_name_four.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_nc));
        txt_name_five.setBackgroundColor(context.getResources().getColor(R.color.txt_dialog_nc));
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



    public interface OnClickBottomListener {
        /**
         * 点击确定按钮事件
         */
        public void onPositiveClick(CompareResult.Message messa);

        /**
         * 点击取消按钮事件
         */
        public void onNegtiveClick();
    }

    public void setlist(List<CompareResult.Message> messasList) {
        this.messasList = messasList;
    }
}
