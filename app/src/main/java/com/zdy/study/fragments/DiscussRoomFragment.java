package com.zdy.study.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askia.common.base.BaseFragment;
import com.askia.common.util.ImageUtil;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.database.repository.SharedPreUtil;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.askia.coremodel.datamodel.http.entities.consume.UserInfoBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.AddressBookAdapter;
import com.zdy.study.adapter.DiscussRoomAdapter;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.databinding.FragmentCurrentClassBinding;
import com.zdy.study.databinding.FragmentDiscussRoomBinding;

import java.util.ArrayList;
import java.util.List;


//CurrentClassFragment.java
public class DiscussRoomFragment extends BaseFragment {

    private FragmentDiscussRoomBinding mDataBinding;
    private DiscussRoomViewModel mViewModel;
    private DiscussRoomAdapter adapter;
    private RecyclerView recyclerView;
    private List<DiscussRoomListBean.PageDataBean> list;
    private String mMyId;

    @Override
    public void onInit() {
        list = new ArrayList<>();
//        mDataBinding.currentText.setText(getArguments().getString("TITLE"));
        // onInitInformation();
        mViewModel.getPageListPad("1", "10");
        initRecycleView();
    }

    private void onInitInformation() {
        HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();
        mViewModel.queryClassesByPhone(httpLoginResult.getUser_name());//获取用户信息
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(getActivity()).get(DiscussRoomViewModel.class);
    }

    private void initRecycleView() {
        recyclerView = mDataBinding.rvDiscuss;
        GridLayoutManager manager2 = new GridLayoutManager(getActivity(),2);//数字为行数或列数
        adapter = new DiscussRoomAdapter(list, getActivity());
        recyclerView.setLayoutManager(manager2);
        recyclerView.setAdapter(adapter);
        // initRVListeners();
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_discuss_room, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        UserInfoBean infoResult = DBRepository.QueryTVUserInfoData();
        mMyId = infoResult.getId();
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getPageListPadData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.clear();
                list.addAll(listResult.getResult().getPageData());
                for (DiscussRoomListBean.PageDataBean pageDataBean : list) {
                    pageDataBean.setMyId(mMyId);
                }
                adapter.notifyDataSetChanged();
            }


        });
//        mViewModel.getmUserInfoLiveDataLiveData().observe(this, listResult -> {
//            if (!listResult.isSuccess()) {
//                ToastUtils.showLong(listResult.getMessage().toString());
//                return;
//            }
//            mMyId=listResult.getData().getId();
//        });
    }

    public static DiscussRoomFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        DiscussRoomFragment fragment = new DiscussRoomFragment();
        fragment.setArguments(arguments);
        return fragment;
    }


}