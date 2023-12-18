package com.zdy.study.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.UserInfoViewModel;
import com.zdy.study.databinding.FragmentCurrentClassBinding;
import com.zdy.study.databinding.FragmentMineBinding;


//CurrentClassFragment.java
public class MineFragment extends BaseFragment {

    private FragmentMineBinding mDataBinding;
    private UserInfoViewModel viewModel;
    @Override
    public void onInit() {
        HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();

//        showLogadingDialog();
        viewModel.queryClassesByPhone(httpLoginResult.getUser_name());
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(getActivity()).get(UserInfoViewModel.class);
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getmUserInfoLiveDataLiveData().observe(this, listResult -> {
            showLogadingDialog();
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }

        });
    }

    public static MineFragment newInstance(String title){
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        MineFragment fragment = new MineFragment();
        fragment.setArguments(arguments);
        return fragment;
    }



}