package com.zdy.study.adapter;

import android.view.View;

import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.SchoolServiceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class SchoolServiceAdapter extends BaseQuickAdapter<SchoolServiceBean.RecordsBean, BaseViewHolder>  {

    private SMAdapterCallBack callBack;
    private View fouseView;
    private int fousePosition;

    public SchoolServiceAdapter(List<SchoolServiceBean.RecordsBean> data, SMAdapterCallBack callBack){
        super(R.layout.item_study_materials, data);
        this.callBack =  callBack;
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, SchoolServiceBean.RecordsBean item) {
        baseViewHolder.setText(R.id.tv_title, item.getHospitalServiceName());
        if ("pdf".equals(item.getHospitalServiceType()))
            baseViewHolder.setImageResource(R.id.iv_type, R.mipmap.ic_stuy_pdf);
        else if("doc".equals(item.getHospitalServiceType())||"docx".equals(item.getHospitalServiceType()))
            baseViewHolder.setImageResource(R.id.iv_type, R.mipmap.ic_stuy_word);
        else if("ppt".equals(item.getHospitalServiceType())||"pptx".equals(item.getHospitalServiceType()))
            baseViewHolder.setImageResource(R.id.iv_type, R.mipmap.ic_stuy_exe);
        else
            baseViewHolder.setImageResource(R.id.iv_type, R.mipmap.ic_stuy_txt);


        /*baseViewHolder.getView(R.id.ll_smbg).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    // 此处为得到焦点时的处理内容
                    ViewCompat.animate(view)
                            .scaleX(1.10f)
                            .scaleY(1.10f)
                            .translationZ(1)
                            .start();
                    if (baseViewHolder.getAdapterPosition() % 9 ==0&&baseViewHolder.getAdapterPosition() !=0) {
                        fouseView = baseViewHolder.getConvertView();
                        fousePosition = baseViewHolder.getAdapterPosition();
                        callBack.loadMore();
                    }

                } else {
                    // 此处为失去焦点时的处理内容
                    ViewCompat.animate(view)
                            .scaleX(1)
                            .scaleY(1)
                            .translationZ(1)
                            .start();
                }
            }
        });*/
    }

    public interface SMAdapterCallBack{
        void loadMore();
    }

}
