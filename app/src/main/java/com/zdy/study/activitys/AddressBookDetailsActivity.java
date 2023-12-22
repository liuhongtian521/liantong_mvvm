package com.zdy.study.activitys;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.AddressBookDetailsViewModel;
import com.zdy.study.cdatamodel.viewmodel.AddressBookViewModel;
import com.zdy.study.databinding.AddressBookDetailsActivityBinding;

/*通訊詳情*/
@Route(path = ARouterPath.AddressBookDetailsActivity)
public class AddressBookDetailsActivity extends BaseActivity {
    private AddressBookDetailsActivityBinding mDataBinding;
    private AddressBookDetailsViewModel viewModel;

    @Override
    public void onInit() {
        initTitle();
        Bundle bundle = getIntent().getExtras();
        setHeardImg(bundle.getString("studentImg"));
//        Glide.with(this).load(bundle.getString("studentImg")).into(mDataBinding.ivHead);
        mDataBinding.tvCareer.setText(bundle.getString("studentPost"));
        mDataBinding.tvTelephoneNumber.setText(bundle.getString("studentPhone"));
        mDataBinding.tvClass.setText(bundle.getString("classesName"));
        mDataBinding.tvStudentName.setText(bundle.getString("studentName"));

    }

    private void setHeardImg(String url){
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_mine_header)//图片加载出来前，显示的图片
                .fallback( R.mipmap.ic_mine_header) //url为空的时候,显示的图片
                .error(R.mipmap.ic_mine_header)//图片加载失败后，显示的图片
                .circleCropTransform();
        Glide.with(this).asBitmap().load(url).apply(options)
                .into(mDataBinding.ivHead);
    }

    private void initTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("个人信息");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddressBookDetailsViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.address_book_details_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
