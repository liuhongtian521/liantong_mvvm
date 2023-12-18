package com.zdy.study.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;
import com.zdy.study.fcWidgets.FCLinearLayout;

import java.util.List;

public class MineMenuAdapter extends BaseQuickAdapter<String, BaseViewHolder>  {

    public MineMenuAdapter(List<String> data){
        super(R.layout.item_main_menu, data);

    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, String item) {
        baseViewHolder.setText(R.id.tv_menu, item);
        FCLinearLayout layout = baseViewHolder.getView(R.id.fcll);
        layout.setBigScale();
        int position = baseViewHolder.getAdapterPosition();
        switch (position){
            case 0:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_mine_grxx);
                break;
            case 1:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_mine_wdsc);
                break;
            case 2:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_mine_wdtls);
                break;
            case 3:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_mine_wdpl);
                break;
            case 4:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_mine_ydjl);
                break;
            case 5:
                baseViewHolder.setImageResource(R.id.iv_menu, R.mipmap.ic_mine_sz);
                break;
        }
    }

}
