package com.zdy.study.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.askia.common.base.BaseFragment;
import com.askia.common.util.ImageUtil;
import com.askia.coremodel.datamodel.database.repository.SharedPreUtil;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.databinding.FragmentCurrentClassBinding;
import com.zdy.study.databinding.FragmentDiscussRoomBinding;


//CurrentClassFragment.java
public class DiscussRoomFragment extends BaseFragment {

    private FragmentDiscussRoomBinding mDataBinding;
    private DiscussRoomViewModel mViewModel;
    @Override
    public void onInit() {
//        mDataBinding.currentText.setText(getArguments().getString("TITLE"));
        mViewModel.getPageListPad("1","10");
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(getActivity()).get(DiscussRoomViewModel.class);
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_discuss_room, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getPageListPadData().observe(this, listResult -> {
            /*if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            ToastUtils.showLong(listResult.getMessage().toString());*/

        });
    }

    public static DiscussRoomFragment newInstance(String title){
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        DiscussRoomFragment fragment = new DiscussRoomFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
 

}