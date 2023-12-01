package com.zdy.study.activitys;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.transition.LeanbackTransitionHelper;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.R;
import com.zdy.study.adapter.ViewPager2Adapter;
import com.zdy.study.databinding.ActMainBinding;
import com.zdy.study.fragments.CurrentClassFragment;
import com.zdy.study.fragments.DigitalClassesFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {
    private ActMainBinding mDataBinding;
    private String[] tabTitle = {"数字班级", "学习助手", "讨论", "个人"};

    private List<Fragment> mFragments;


    @Override
    public void onInit() {
        initFragment();
        initPagerTab();
        initBottom();
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_main);
    }

    private void initFragment(){
        mFragments = new ArrayList<>();
        mFragments.add(DigitalClassesFragment.newInstance(tabTitle[0]));
        mFragments.add(CurrentClassFragment.newInstance(tabTitle[1]));
        mFragments.add(CurrentClassFragment.newInstance(tabTitle[2]));
        mFragments.add(CurrentClassFragment.newInstance(tabTitle[3]));
//        mFragments.add(CurrentClassFragment.newInstance(tabTitle[4]));
    }

    private void initPagerTab(){
        //实例化 FragmentPagerAdapter 并将 Fragment 列表传入
        ViewPager2Adapter adapter = new ViewPager2Adapter(this, mFragments);
        mDataBinding.viewPager.setAdapter(adapter);
        mDataBinding.viewPager.setOffscreenPageLimit(2);
        mDataBinding.viewPager.setUserInputEnabled(false); //true:滑动，false：禁止滑动
        mDataBinding.viewPager.setCurrentItem(0,false);
        //TabLayout 和 Viewpager2 关联
        /*TabLayoutMediator tabm = new TabLayoutMediator(mDataBinding.tabLayout, mDataBinding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab, null);
                ImageView imageView = (ImageView)view.findViewById(R.id.tabImageView);
                TextView textView = (TextView)view.findViewById(R.id.tabTextView);
                textView.setText(tabTitle[position]);
                imageView.setImageResource(mImages[position]);
                tab.setCustomView(view);
//                tab.setText(tabTitle[position]);
//                tab.setIcon(mImages[position]);
            }
        });
        tabm.attach();*/
    }


    private void initBottom(){
        mDataBinding.rbSzbj.requestFocus();
        mDataBinding.rbSzbj.setOnFocusChangeListener((view, b) -> {
//            FragmentHideShwo(fragment);
            mDataBinding.viewPager.setCurrentItem(0, true);
        });
        mDataBinding.rbXxzs.setOnFocusChangeListener((view, b) -> {
//            FragmentHideShwo(fragment1);
            mDataBinding.viewPager.setCurrentItem(1, true);
        });
        mDataBinding.rbTl.setOnFocusChangeListener((view, b) -> {
//            FragmentHideShwo(fragment2);
            mDataBinding.viewPager.setCurrentItem(2, true);
        });
        mDataBinding.rbGr.setOnFocusChangeListener((view, b) -> {
//            FragmentHideShwo(fragment3);
            mDataBinding.viewPager.setCurrentItem(3, true);
        });

    }

    /*private void FragmentHideShwo(Fragment fg){
        // show or hide fragments to improve the stablility and reduce costs
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        if(!fg.isAdded()){
            transaction.hide(currentFragment);
            transaction.add(R.id.main_layout_content,fg);
        }else{
            transaction.hide(currentFragment);
            transaction.show(fg);
        }
        currentFragment=fg;
        transaction.commit();
    }*/

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
