package com.zdy.study.activitys;

import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.adapter.ViewPager2Adapter;
import com.zdy.study.databinding.ActMainBinding;
import com.zdy.study.databinding.BookListMainBinding;
import com.zdy.study.fragments.CurrentClassFragment;
import com.zdy.study.fragments.DigitalClassesFragment;
import com.zdy.study.fragments.DiscussRoomFragment;
import com.zdy.study.fragments.MainFragment;
import com.zdy.study.fragments.RecommendedBookListFragment;
import com.zdy.study.fragments.SelectedTheoryFragment;

import java.util.ArrayList;
import java.util.List;

/*书单页面*/
@Route(path = ARouterPath.BookListActivity)
public class BookListActivity extends BaseActivity {
    private BookListMainBinding mDataBinding;
    private String[] tabTitle = {"推荐书单", "精选理论"};

    private List<Fragment> mFragments;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RecommendedBookListFragment recommendedBookListFragment = new RecommendedBookListFragment();
    private SelectedTheoryFragment selectedTheoryFragment = new SelectedTheoryFragment();

    @Override
    public void onInit() {
        initFragment();
     //   initPagerTab();
        initTop();
        initBottom();
    }

    private void initTop() {
        mDataBinding.tvLeft.requestFocus();
        mDataBinding.tvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHideShow(recommendedBookListFragment);
            }
        });
        mDataBinding.tvLeft.setOnFocusChangeListener((view, b) -> {
            FragmentHideShow(recommendedBookListFragment);
//            if (b) {
//                // 此处为得到焦点时的处理内容
////                mDataBinding.viewPager.setCurrentItem(0, true);
//                mDataBinding.tvLeft.setTextColor(getResources().getColor(R.color.app_black3));
//                mDataBinding.viewRedLeft.setVisibility(View.VISIBLE);
//            } else {
//                // 此处为失去焦点时的处理内容
//                mDataBinding.tvLeft.setTextColor(getResources().getColor(R.color.gray_select));
//                mDataBinding.viewRedLeft.setVisibility(View.GONE);
//            }

        });
        mDataBinding.tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHideShow(selectedTheoryFragment);
            }
        });
        mDataBinding.tvRight.setOnFocusChangeListener((view, b) -> {
            FragmentHideShow(selectedTheoryFragment);
//            if (b) {
//                // 此处为得到焦点时的处理内容
//                mDataBinding.tvRight.setTextColor(getResources().getColor(R.color.app_black3));
//                mDataBinding.viewRedRight.setVisibility(View.VISIBLE);
//     //           mDataBinding.viewPager.setCurrentItem(1, true);
//            } else {
//                // 此处为失去焦点时的处理内容
//                mDataBinding.tvRight.setTextColor(getResources().getColor(R.color.gray_select));
//                mDataBinding.viewRedRight.setVisibility(View.GONE);
//            }
        });
        int tab = getIntent().getExtras().getInt("tab");
        if (tab == 1)
            mDataBinding.tvRight.requestFocus();
        else
            mDataBinding.tvLeft.requestFocus();
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_layout_content, recommendedBookListFragment);
        transaction.commit();
    }

    private void FragmentHideShow(Fragment fg) {
        // show or hide fragments to improve the stablility and reduce costs
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_layout_content, fg);
        transaction.commit();
    }
//    public void initFragment() {
//        mFragments = new ArrayList<>();
//        mFragments.add(RecommendedBookListFragment.newInstance(tabTitle[0]));
//        mFragments.add(SelectedTheoryFragment.newInstance(tabTitle[1]));
//    }

    private void initPagerTab() {
        //实例化 FragmentPagerAdapter 并将 Fragment 列表传入
        ViewPager2Adapter adapter = new ViewPager2Adapter(this, mFragments);
//        mDataBinding.viewPager.setAdapter(adapter);
//        mDataBinding.viewPager.setOffscreenPageLimit(2);
//        mDataBinding.viewPager.setUserInputEnabled(false); //true:滑动，false：禁止滑动
//        mDataBinding.viewPager.setCurrentItem(0, false);
    }

    private void initBottom() {
//        mDataBinding.tvLeft.requestFocus();
//        mDataBinding.tvLeft.setOnFocusChangeListener((view, b) -> {
//            FragmentHideShow(recommendedBookListFragment);
////            mDataBinding.viewPager.setCurrentItem(0, true);
//        });
//        mDataBinding.tvRight.setOnFocusChangeListener((view, b) -> {
//            FragmentHideShow(selectedTheoryFragment);
////            mDataBinding.viewPager.setCurrentItem(1, true);
//        });


    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.book_list_main);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
