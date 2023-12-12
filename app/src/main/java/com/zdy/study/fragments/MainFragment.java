package com.zdy.study.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFiveBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFourBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseThirdBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseTwoBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.BookAdapter;
import com.zdy.study.adapter.CourseQueryAdapter;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.cdatamodel.viewmodel.MainFragmentViewModel;
import com.zdy.study.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment {
    FragmentMainBinding mFragmentMainBinding;
    private MainFragmentViewModel mViewModel;
    private List<MainFragmentResponseBean.PageDataBean> list;
    private List<MainFragmentResponseTwoBean.PageDataBean> list2;
    private List<MainFragmentResponseThirdBean.PageDataBean> list3;
    private List<MainFragmentResponseFourBean.PageDataBean> list4;
    private List<MainFragmentResponseFiveBean.PageDataBean> list5;
    private List<BooksRespponseBean.PageDataBean> list6;
    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    public void onInit() {
        //第一个接口
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        //联播速递
        mViewModel.queryHotAndTopContListByAudit("1", "3", "E8\u200C81\u200C94E6\u200C92\u200CAD_parent");
        //国际视野
        mViewModel.queryHotAndTopContListByAudit2("1", "2", "INTERNATIONAL_VIEW");
        //实践案列
        mViewModel.queryHotAndTopContListByAudit3("1", "2", "1384703677503217665");
        //精选理论
        mViewModel.queryHotAndTopContListByAudit4("1", "2", "1384060802717294593");
        //1384698467028410369  //操作技巧
        mViewModel.queryHotAndTopContListByAudit5("1", "2", "1384698467028410369");
        //书单
        mViewModel.padList("1", "10");
        initRvListener();
    }

    private void initRvListener() {
        recyclerView = mFragmentMainBinding.rvRecommendedBookList;
        //上方recycleView
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());//数字为行数或列数
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置为横向滑动
        adapter = new BookAdapter(list6, getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(getActivity()).get(MainFragmentViewModel.class);
    }

    public static MainFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mFragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mFragmentMainBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getPageListPadData1().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.addAll(listResult.getResult().getPageData());
                mFragmentMainBinding.ivBroadcastSpeedName.setText(list.get(0).getContName());
                mFragmentMainBinding.ivBroadcastSpeedNameRight.setText(list.get(1).getContName());
                mFragmentMainBinding.ivBroadcastSpeedNameRight1.setText(list.get(2).getContName());
            }


        });
        //INTERNATIONAL_VIEW   //国际视野吴冬
        mViewModel.getPageListPadData2().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list2.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list2.addAll(listResult.getResult().getPageData());
                if (list2.size() > 0) {
                    mFragmentMainBinding.tvInternationalPerspective.setText(list2.get(0).getContName());
                    mFragmentMainBinding.viewCircle.setVisibility(View.VISIBLE);
                }
                if (list2.size() > 1) {
                    mFragmentMainBinding.tvInternationalPerspective1.setText(list2.get(1).getContName());
                    mFragmentMainBinding.viewCircle12.setVisibility(View.VISIBLE);
                }


            }


        });
        //1384703677503217665    //实践案例
        mViewModel.getPageListPadData3().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list3.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list3.addAll(listResult.getResult().getPageData());
                if (list3.size() > 0) {
                    mFragmentMainBinding.tvPracticalCases.setText(list3.get(0).getContName());
                    mFragmentMainBinding.viewCircle1.setVisibility(View.VISIBLE);
                }
                if (list3.size() > 1) {
                    mFragmentMainBinding.tvPracticalCases2.setText(list3.get(1).getContName());
                    mFragmentMainBinding.viewCircle3.setVisibility(View.VISIBLE);
                }


            }


        });
        //1384060802717294593 //精选理论
        mViewModel.getPageListPadData4().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list4.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list4.addAll(listResult.getResult().getPageData());
                if (list4.size() > 0) {
                    mFragmentMainBinding.tvSelectedTheory.setText(list4.get(0).getContName());
                    mFragmentMainBinding.viewCircle7.setVisibility(View.VISIBLE);
                }
                if (list4.size() > 1) {
                    mFragmentMainBinding.tvSelectedTheory2.setText(list4.get(1).getContName());
                    mFragmentMainBinding.viewCircle8.setVisibility(View.VISIBLE);
                }


            }


        }); // 1384698467028410369  //操作技巧
        mViewModel.getPageListPadData5().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list5.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list5.addAll(listResult.getResult().getPageData());
                if (list4.size() > 0) {
                    mFragmentMainBinding.tvOperatingSkills.setText(list5.get(0).getContName());
                    mFragmentMainBinding.viewCircle9.setVisibility(View.VISIBLE);
                }
                if (list4.size() > 1) {
                    mFragmentMainBinding.tvOperatingSkills1.setText(list5.get(1).getContName());
                    mFragmentMainBinding.viewCircle10.setVisibility(View.VISIBLE);
                }


            }


        });
        mViewModel.getPageListPadData6().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list6.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list6.addAll(listResult.getResult().getPageData());
                adapter.notifyDataSetChanged();
            }


        });

    }
}
