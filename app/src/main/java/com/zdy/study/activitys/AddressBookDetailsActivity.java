package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
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
        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("通讯录");
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
