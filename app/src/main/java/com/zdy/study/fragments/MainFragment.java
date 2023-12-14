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

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.http.entities.consume.BooksRespponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFiveBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseFourBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseThirdBean;
import com.askia.coremodel.datamodel.http.entities.consume.MainFragmentResponseTwoBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.BookAdapter;
import com.zdy.study.adapter.CourseQueryAdapter;
import com.zdy.study.adapter.DiscussAdapter;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.cdatamodel.viewmodel.MainFragmentViewModel;
import com.zdy.study.databinding.FragmentMainBinding;
import com.zdy.study.tools.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment {
    FragmentMainBinding mFragmentMainBinding;
    private MainFragmentViewModel mViewModel;
    private List<MainFragmentResponseBean.PageDataBean> list;
    private List<MainFragmentResponseBean.PageDataBean> list1;
    private List<BroadcastExpressResponBean.PageDataBean> list3;
    private List<BooksRespponseBean.PageDataBean> list6;
    private List<DiscussResponseBean> discussResponseBeanList;
    private RecyclerView recyclerView;
    private RecyclerView discussionsRecyclerView;
    private BookAdapter adapter;
    private DiscussAdapter discussAdapter;

    @Override
    public void onInit() {
        //第一个接口
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        list3 = new ArrayList<>();
        discussResponseBeanList = new ArrayList<>();
        list6 = new ArrayList<>();
        //联播速递
        mViewModel.queryHotAndTopContListByAudit("1", "3", Constants.LBSD);
        //国际视野
        mViewModel.queryHotAndTopContListByAudit2("1", "2", Constants.GJSY);
        //实践案列
        mViewModel.queryHotAndTopContListByAudit3("1", "2", Constants.SJAL);
        //精选理论
        mViewModel.queryHotAndTopContListByAudit4("1", "2", Constants.JXLL);
        //1384698467028410369  //操作技巧
        mViewModel.queryHotAndTopContListByAudit5("1", "2", Constants.CZJQ);
        //书单
        mViewModel.padList("1", "10", "");
        mViewModel.queryHotRooms();
        initRvListener();
        initRvListener2();
        initOnLister();

    }

    private void initOnLister() {
        //联播点击更多
        mFragmentMainBinding.tvSimulcastMore.setOnClickListener(v -> {
            startActivityByRouter(ARouterPath.BroadcastExpressActivity);
        });
        //国际视野更多
        mFragmentMainBinding.tvInternationalPerspectiveMore.setOnClickListener(v -> {
            startActivityByRouter(ARouterPath.InternationalPerspectiveActivity);
        });
        //书单更多
        mFragmentMainBinding.tvBookList.setOnClickListener(v -> {
            startActivityByRouter(ARouterPath.BookListActivity);
        });
        mFragmentMainBinding.ivBroadcastSpeedName.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("keyId", "0");
            bundle.putSerializable("MainFragmentList", (Serializable) list3.get(0));
            startActivityByRouter(ARouterPath.BroadcastExpressActivity, bundle);
        });
        mFragmentMainBinding.ivBroadcastSpeedNameRight.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("keyId", "1");
            bundle.putSerializable("MainFragmentList", (Serializable) list3.get(1));
            startActivityByRouter(ARouterPath.BroadcastExpressActivity, bundle);
        });
        mFragmentMainBinding.ivBroadcastSpeedNameRight1.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("keyId", "2");
            bundle.putSerializable("MainFragmentList", (Serializable) list3.get(2));
            startActivityByRouter(ARouterPath.BroadcastExpressActivity, bundle);
        });
    }

    private void initRvListener() {
        recyclerView = mFragmentMainBinding.rvRecommendedBookList;
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());//数字为行数或列数
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置为横向滑动
        adapter = new BookAdapter(list6, getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("BookListDetails", list6.get(position));
            startActivityByRouter(ARouterPath.BookDetailsActivity, bundle);
        });
    }

    private void initRvListener2() {
        discussionsRecyclerView = mFragmentMainBinding.rvPopularDiscussions;
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());//数字为行数或列数
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置为横向滑动
        discussAdapter = new DiscussAdapter(discussResponseBeanList, getActivity());
        discussionsRecyclerView.setLayoutManager(manager);
        discussionsRecyclerView.setAdapter(discussAdapter);
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
        mFragmentMainBinding.setHandlers(this);
        return mFragmentMainBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getPageListPadData1().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list1.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list1.addAll(listResult.getResult().getPageData());
                mFragmentMainBinding.ivBroadcastSpeedName.setText(list1.get(0).getContName());
                mFragmentMainBinding.ivBroadcastSpeedNameRight.setText(list1.get(1).getContName());
                mFragmentMainBinding.ivBroadcastSpeedNameRight1.setText(list1.get(2).getContName());
            }
            list3.clear();
            for (MainFragmentResponseBean.PageDataBean pageDataBean : list1) {
                BroadcastExpressResponBean.PageDataBean bean = new BroadcastExpressResponBean.PageDataBean();
                BroadcastExpressResponBean.PageDataBean.ContVideoBean contVideoBean = new BroadcastExpressResponBean.PageDataBean.ContVideoBean();
                bean.setContName(pageDataBean.getContName());
                contVideoBean.setTimeLength(pageDataBean.getContVideo().getTimeLength());
                bean.setContVideo(contVideoBean);
                list3.add(bean);
            }


        });
        //INTERNATIONAL_VIEW   //国际视野吴冬
        mViewModel.getPageListPadData2().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.addAll(listResult.getResult().getPageData());
                if (list.size() > 0) {
                    mFragmentMainBinding.tvInternationalPerspective.setText(list.get(0).getContName());
                    mFragmentMainBinding.viewCircle.setVisibility(View.VISIBLE);
                }
                if (list.size() > 1) {
                    mFragmentMainBinding.tvInternationalPerspective1.setText(list.get(1).getContName());
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
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.addAll(listResult.getResult().getPageData());
                if (list.size() > 0) {
                    mFragmentMainBinding.tvPracticalCases.setText(list.get(0).getContName());
                    mFragmentMainBinding.viewCircle1.setVisibility(View.VISIBLE);
                }
                if (list.size() > 1) {
                    mFragmentMainBinding.tvPracticalCases2.setText(list.get(1).getContName());
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
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.addAll(listResult.getResult().getPageData());
                if (list.size() > 0) {
                    mFragmentMainBinding.tvSelectedTheory.setText(list.get(0).getContName());
                    mFragmentMainBinding.viewCircle7.setVisibility(View.VISIBLE);
                }
                if (list.size() > 1) {
                    mFragmentMainBinding.tvSelectedTheory2.setText(list.get(1).getContName());
                    mFragmentMainBinding.viewCircle8.setVisibility(View.VISIBLE);
                }


            }


        }); // 1384698467028410369  //操作技巧
        mViewModel.getPageListPadData5().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            list.clear();
            if (null != listResult.getResult() && null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.addAll(listResult.getResult().getPageData());
                if (list.size() > 0) {
                    mFragmentMainBinding.tvOperatingSkills.setText(list.get(0).getContName());
                    mFragmentMainBinding.viewCircle9.setVisibility(View.VISIBLE);
                }
                if (list.size() > 1) {
                    mFragmentMainBinding.tvOperatingSkills1.setText(list.get(1).getContName());
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
        mViewModel.getPageListPadData7().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            discussResponseBeanList.clear();
            if (null != listResult.getResult() && listResult.getResult().size() > 0) {
                discussResponseBeanList.addAll(listResult.getResult());
                discussAdapter.notifyDataSetChanged();
            }


        });

    }

    public void operationMoreClick(View view) {
        startActivityByRouter(ARouterPath.OpreationActivity);
    }

    public void operationFirstClick(View view) {
        MainFragmentResponseBean.PageDataBean pageDataBean = mViewModel.getPageListPadData5().getValue().getResult().getPageData().get(0);
        Bundle bundle = new Bundle();
        bundle.putSerializable("operationData", pageDataBean);
        startActivityByRouter(ARouterPath.OpreationActivity, bundle);
    }

    public void operationSecondClick(View view) {
        MainFragmentResponseBean.PageDataBean pageDataBean = mViewModel.getPageListPadData5().getValue().getResult().getPageData().get(1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("operationData", pageDataBean);
        startActivityByRouter(ARouterPath.OpreationActivity, bundle);
    }
}
