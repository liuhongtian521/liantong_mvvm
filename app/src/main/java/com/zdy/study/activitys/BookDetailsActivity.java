package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.databinding.BookDetailsActivityBinding;

@Route(path = ARouterPath.BookDetailsActivity)
public class BookDetailsActivity extends BaseActivity {
    private BooksRespponseBean.PageDataBean dataBean;
    private BookDetailsActivityBinding detailsActivityBinding;

    @Override
    public void onInit() {
        onInTitle("图书详情");
        inItLayout();
    }

    private void inItLayout() {
        dataBean = new BooksRespponseBean.PageDataBean();
        dataBean = (BooksRespponseBean.PageDataBean) getIntent().getExtras().getSerializable("BookListDetails");
        //图片
        Glide.with(this).load(dataBean.getCoverUrl()).into(detailsActivityBinding.ivBookName);
        detailsActivityBinding.tvBookName.setText(dataBean.getBookName());
        detailsActivityBinding.tvContentBook.setText("作者：" + dataBean.getAuthorName());
        detailsActivityBinding.tvContent2.setText(dataBean.getBriefIntroduction());
        detailsActivityBinding.tvContent3.setText(dataBean.getChapterContent());
    }

    @Override
    public void onInitViewModel() {

    }

    private void onInTitle(String title) {
        detailsActivityBinding.includeLayout.preferenceActivityTitleText.setText(title);
        detailsActivityBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onInitDataBinding() {
        detailsActivityBinding = DataBindingUtil.setContentView(this, R.layout.book_details_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
