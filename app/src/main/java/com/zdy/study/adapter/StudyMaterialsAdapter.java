package com.zdy.study.adapter;

import android.view.View;

import androidx.core.view.ViewCompat;

import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zdy.study.R;

import java.util.List;

public class StudyMaterialsAdapter extends BaseQuickAdapter<StuyMaterialsListBean.RecordsBean, BaseViewHolder>  {

    private SMAdapterCallBack callBack;
    private View fouseView;
    private int fousePosition;

    public StudyMaterialsAdapter(List<StuyMaterialsListBean.RecordsBean> data, SMAdapterCallBack callBack){
        super(R.layout.item_study_materials, data);
        this.callBack =  callBack;
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, StuyMaterialsListBean.RecordsBean item) {
        baseViewHolder.setText(R.id.tv_title, item.getCoursewareName());
        if ("pdf".equals(item.getCoursewareType()))
            baseViewHolder.setImageResource(R.id.iv_type, R.mipmap.ic_stuy_pdf);
        else if("doc".equals(item.getCoursewareType())||"docx".equals(item.getCoursewareType()))
            baseViewHolder.setImageResource(R.id.iv_type, R.mipmap.ic_stuy_word);
        else if("ppt".equals(item.getCoursewareType())||"pptx".equals(item.getCoursewareType()))
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
