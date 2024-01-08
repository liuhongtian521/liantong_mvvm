package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.InternationalPerspectiveDetailsViewModel;
import com.zdy.study.databinding.BookDetailsActivityBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

@Route(path = ARouterPath.BookDetailsActivity)
public class BookDetailsActivity extends BaseActivity {
    private BooksRespponseBean.PageDataBean dataBean;
    private BookDetailsActivityBinding detailsActivityBinding;
    private InternationalPerspectiveDetailsViewModel viewModel;
    String argContId;
    String key;
    private String readStartTime; //埋点 开始时间

    @Override
    public void onInit() {
        onInTitle("图书详情");
        key = getIntent().getExtras().getString("key");
        argContId = getIntent().getExtras().getString("INTERNATIONAL_VIEW");
        inItLayout();
        seveStartTime();
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
        viewModel = ViewModelProviders.of(this).get(InternationalPerspectiveDetailsViewModel.class);
    }

    private void onInTitle(String title) {
        detailsActivityBinding.includeLayout.preferenceActivityTitleText.setText(title);
        detailsActivityBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void seveStartTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        readStartTime = simpleDateFormat.format(date);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        //埋点记录
        viewModel.addReadTime(argContId, "", key, readStartTime, simpleDateFormat.format(date));
    }
}
