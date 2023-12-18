package com.zdy.study.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseFragment;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.MainMenuAdapter;
import com.zdy.study.databinding.FragmentCurrentClassBinding;
import com.zdy.study.databinding.FragmentDigtalClassesBinding;

import java.util.ArrayList;


//CurrentClassFragment.java
public class DigitalClassesFragment extends BaseFragment {

    private FragmentDigtalClassesBinding mDataBinding;

    @Override
    public void onInit() {
//        mDataBinding.currentText.setText(getArguments().getString("TITLE"));
        ArrayList<String> list = new ArrayList<>();
        list.add("课程查询");
        list.add("电子课件");
        list.add("学习资料");
        list.add("学员手册");
        list.add("联播快速");
        list.add("网络课程");
        list.add("在院服务");
        list.add("语音记事");
        list.add("通讯录");
        MainMenuAdapter adapter = new MainMenuAdapter(list);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);//第二个参数为网格的列数
        mDataBinding.rvMainMenu.setLayoutManager(layoutManager);
        mDataBinding.rvMainMenu.setAdapter(adapter);
        mDataBinding.rvMainMenu.setItemAnimator(null);
//        mDataBinding.rvMainMenu.setBindFragment(this);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            String url = "";
            switch (position) {
                //课程查询
                case 0:
                    url = ARouterPath.CourseQueryActivity;
                    break;
                case 1:
                    url = ARouterPath.EBOOK_ACTIVIGY;
                    break;
                case 2:
                    url = ARouterPath.STUDY_mATERIALS;
                    break;
                case 3:
                    url = ARouterPath.STUDY_MANUAL;
                    break;
                case 4:
                    url = ARouterPath.BroadcastExpressActivity;
//                    url = ARouterPath.OpreationActivity;
                    break;
                case 5:
                    url = ARouterPath.WebBasedCourseActivity;
                    break;
                case 6:
                    url = ARouterPath.SHCOOLSERVICE_ACTIVIGY;
                    break;
                case 7:
                    ToastUtils.showLong("暂未开放");
                    return;
                case 8:
                    url = ARouterPath.AddressBookActivity;
                    break;

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
    public void onInitViewModel() {
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_digtal_classes, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {

    }

    public static DigitalClassesFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        DigitalClassesFragment fragment = new DigitalClassesFragment();
        fragment.setArguments(arguments);
        return fragment;
    }


}