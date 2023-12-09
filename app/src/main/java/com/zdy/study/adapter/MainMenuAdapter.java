package com.zdy.study.adapter;

import android.graphics.Color;
import android.view.View;

import com.askia.common.base.ARouterPath;
import com.askia.coremodel.datamodel.database.db.consume.ShoppingRecord;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class MainMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder>  {

    public MainMenuAdapter(List<String> data){
        super(R.layout.item_main_menu, data);

    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, String item) {
        baseViewHolder.setText(R.id.tv_menu, item);
        FCLinearLayout layout = baseViewHolder.getView(R.id.fcll);
        layout.setScale(1.25f);
        int position = baseViewHolder.getAdapterPosition();
        switch (position){
            case 0:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_kccx);
                break;
            case 1:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_dzkj);
                break;
            case 2:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_xxzl);
                break;
            case 3:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_xysc);
                break;
            case 4:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_lbkd);
                break;
            case 5:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_tjsd);
                break;
            case 6:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_zyfw);
                break;
            case 7:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_item_txl);
                break;
        }
    }

}
