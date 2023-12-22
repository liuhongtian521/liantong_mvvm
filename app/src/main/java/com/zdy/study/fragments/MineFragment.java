package com.zdy.study.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zdy.study.R;
import com.zdy.study.adapter.MainMenuAdapter;
import com.zdy.study.adapter.MineMenuAdapter;
import com.zdy.study.cdatamodel.viewmodel.UserInfoViewModel;
import com.zdy.study.databinding.FragmentCurrentClassBinding;
import com.zdy.study.databinding.FragmentMineBinding;

import java.util.ArrayList;


//CurrentClassFragment.java
public class MineFragment extends BaseFragment {

    private FragmentMineBinding mDataBinding;
//    private UserInfoViewModel viewModel;

    @Override
    public void onInit() {


        initList();
    }

    private void setHeardImg(String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_mine_header)//图片加载出来前，显示的图片
                .fallback(R.mipmap.ic_mine_header) //url为空的时候,显示的图片
                .error(R.mipmap.ic_mine_header)//图片加载失败后，显示的图片
                .circleCropTransform();
        Glide.with(getActivity()).load(url).apply(options).
                into(mDataBinding.ivMineHeader);
    }

    @Override
    public void onInitViewModel() {
//        viewModel = ViewModelProviders.of(getActivity()).get(UserInfoViewModel.class);
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        mDataBinding.setHandlers(this);
        return mDataBinding.getRoot();
    }

    private void initList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("个人信息");
        list.add("我的收藏");
        list.add("我的讨论室");
        list.add("话题与讨论");
        list.add("阅读记录");
        list.add("设置");
        MineMenuAdapter adapter = new MineMenuAdapter(list);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);//第二个参数为网格的列数
        mDataBinding.rvMineMenu.setLayoutManager(layoutManager);
        mDataBinding.rvMineMenu.setAdapter(adapter);
        mDataBinding.rvMineMenu.setItemAnimator(null);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            String url = "";
            switch (position) {
                case 0:
                    url = ARouterPath.USERINFO_ACTIVIGY;
                    break;
                case 1:
                    url = ARouterPath.MyCollectionActivity;
                    break;
                case 2:
                    url = ARouterPath.MyDiscussRoomActivity;
                    break;
                case 3:
                    url = ARouterPath.TopicPostedActivity;
                    break;
                case 4:
                    url = ARouterPath.HistoryActivityActivity;
                    break;
                case 5:
                    startActivityByRouter(ARouterPath.SettingActivity);
                    return;
            }
            if (TextUtils.isEmpty(DBRepository.QueryTVUserLoginData().getAccess_token())) {
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                startActivityByRouter(ARouterPath.LOGIN_ACTIVITY, bundle);
            } else {
                startActivityByRouter(url);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();
        if (TextUtils.isEmpty(httpLoginResult.getAccess_token())) {
            mDataBinding.tvMineName.setText("未登录");
            mDataBinding.tvClassName.setVisibility(View.GONE);
        }else {
            UserInfoBean infoResult = DBRepository.QueryTVUserInfoData();
            mDataBinding.tvClassName.setVisibility(View.VISIBLE);
            setHeardImg(httpLoginResult.getAvatar());//设置头像
//            viewModel.queryClassesByPhone(httpLoginResult.getUser_name());//获取用户信息
            mDataBinding.tvMineName.setText(infoResult.getStudentName());//设置昵称
            mDataBinding.tvClassName.setText(infoResult.getClassesName());//设置班级名
        }
    }

    public void goToLogin(View view){
        HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();
        if (TextUtils.isEmpty(httpLoginResult.getAccess_token())) {
            startActivityByRouter(ARouterPath.LOGIN_ACTIVITY);
        }
    }

    @Override
    public void onSubscribeViewModel() {
        /*viewModel.getmUserInfoLiveDataLiveData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mDataBinding.tvMineName.setText(listResult.getData().getStudentName());//设置昵称
            mDataBinding.tvClassName.setText(listResult.getData().getClassesName());//设置班级名
        });*/
    }

    public static MineFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        MineFragment fragment = new MineFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

}