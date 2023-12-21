package com.zdy.study.activitys;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zdy.study.cdatamodel.viewmodel.UserInfoViewModel;
import com.zdy.study.databinding.ActivityUserInfoBinding;
import com.zdy.study.R;

@Route(path = ARouterPath.USERINFO_ACTIVIGY)
public class UserInfoActivity extends BaseActivity {


    private ActivityUserInfoBinding binding;
//    private UserInfoViewModel viewModel;
    @Override
    public void onInit() {
        //标题
        binding.includeLayout.preferenceActivityTitleText.setText("个人信息");
        HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();
        UserInfoBean infoResult = DBRepository.QueryTVUserInfoData();
        setHeardImg(httpLoginResult.getAvatar());//设置头像
//        viewModel.queryClassesByPhone(httpLoginResult.getUser_name());//获取用户信息
        binding.tvInfoName.setText(infoResult.getStudentName());//设置昵称
        binding.tvInfoZhiwu.setText(infoResult.getStudentPost());//设置职位
        binding.tvInfoClass.setText(infoResult.getClassesName());//设置班级名称
    }

    private void setHeardImg(String url){
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_mine_header)//图片加载出来前，显示的图片
                .fallback( R.mipmap.ic_mine_header) //url为空的时候,显示的图片
                .error(R.mipmap.ic_mine_header)//图片加载失败后，显示的图片
                .circleCropTransform();
        Glide.with(this).asBitmap().load(url).apply(options)
                .into(binding.ivInfoHeader);
    }

    @Override
    public void onInitViewModel() {
//        viewModel = ViewModelProviders.of(this).get(UserInfoViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);
    }

    @Override
    public void onSubscribeViewModel() {
        /*viewModel.getmUserInfoLiveDataLiveData().observe(this, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            binding.tvInfoName.setText(listResult.getData().getStudentName());//设置昵称
            binding.tvInfoZhiwu.setText(listResult.getData().getStudentPost());//设置职位
            binding.tvInfoClass.setText(listResult.getData().getClassesName());//设置班级名称
        });*/
    }

    @Override
    public void onMResume() {

    }
}
