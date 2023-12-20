package com.zdy.study.activitys;


import android.annotation.SuppressLint;
import android.view.View;

import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.transition.LeanbackTransitionHelper;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.zdy.study.BuildConfig;
import com.zdy.study.R;
import com.zdy.study.adapter.ViewPager2Adapter;
import com.zdy.study.databinding.ActMainBinding;
import com.zdy.study.fragments.DigitalClassesFragment;
import com.zdy.study.fragments.DiscussRoomFragment;
import com.zdy.study.fragments.MainFragment;
import com.zdy.study.fragments.MineFragment;
import com.zdy.study.uitls.UpdateChecker;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {
    private ActMainBinding mDataBinding;
    private String[] tabTitle = {"数字班级", "学习助手", "讨论", "个人"};

    private List<Fragment> mFragments;

    private DigitalClassesFragment digitalClassesFragment = new DigitalClassesFragment();
    private MainFragment mainFragment = new MainFragment();
    private DiscussRoomFragment discussRoomFragment = new DiscussRoomFragment();
    private MineFragment mineFragment = new MineFragment();

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment currentFragment;

    @Override
    public void onInit() {
        initFragment();
//        initPagerTab();
        initBottom();
//        checkUpdate();
    }

    private void checkUpdate(){
        new UpdateChecker("c2cad66e174bff947b8e2067c57d4eec",this)
                .check("bc7efbffa17e035b23efe34cd4114f85",
                        BuildConfig.VERSION_CODE+"",
                        null,
                        "",
                        new UpdateChecker.Callback() {
                            @Override
                            public void result(UpdateChecker.UpdateInfo updateInfo) {

//                                Toast.makeText(reactContext,updateInfo.buildBuildVersion,Toast.LENGTH_LONG).show();
                                Log.i("DOWNLOAD",updateInfo.buildBuildVersion.toString());
                            }

                            @Override
                            public void error(String message) {
                                Log.i("DOWNLOAD",message);
                            }
                        }
                );
    }

    @Override
    public void onInitViewModel() {

    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_main);
    }

    /*private void initFragment(){
        mFragments = new ArrayList<>();
        mFragments.add(DigitalClassesFragment.newInstance(tabTitle[0]));
        mFragments.add(MainFragment.newInstance(tabTitle[1]));
        mFragments.add(DiscussRoomFragment.newInstance(tabTitle[2]));
        mFragments.add(CurrentClassFragment.newInstance(tabTitle[3]));
//        mFragments.add(CurrentClassFragment.newInstance(tabTitle[4]));
    }*/

    //设置默认fragment
    private void initFragment() {
//        mDataBinding.rbGoods.setChecked(true);//设置商品总览tab选中
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
//        transaction.show(digitalClassesFragment);
        transaction.replace(R.id.main_layout_content, digitalClassesFragment);
//        transaction.hide(shoppingCartFragment);
//        transaction.hide(telephoneFragment);
        transaction.commit();
//        currentFragment = digitalClassesFragment;
    }

    private void FragmentHideShwo(Fragment fg) {
        // show or hide fragments to improve the stablility and reduce costs
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_layout_content, fg);
        transaction.commit();
    }

    private void initPagerTab() {
        //实例化 FragmentPagerAdapter 并将 Fragment 列表传入
        /*ViewPager2Adapter adapter = new ViewPager2Adapter(this, mFragments);
        mDataBinding.viewPager.setAdapter(adapter);
        mDataBinding.viewPager.setOffscreenPageLimit(2);
        mDataBinding.viewPager.setUserInputEnabled(false); //true:滑动，false：禁止滑动
        mDataBinding.viewPager.setCurrentItem(0,false);*/
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


    @SuppressLint("SuspiciousIndentation")
    private void initBottom() {
        mDataBinding.rbSzbj.requestFocus();
        mDataBinding.rbSzbj.setOnFocusChangeListener((view, b) -> {
            if (b) FragmentHideShwo(digitalClassesFragment);
//            mDataBinding.viewPager.setCurrentItem(0, true);
        });
        mDataBinding.rbXxzs.setOnFocusChangeListener((view, b) -> {
            if (b) FragmentHideShwo(mainFragment);
//            mDataBinding.viewPager.setCurrentItem(1, true);
        });
        mDataBinding.rbTl.setOnFocusChangeListener((view, b) -> {
            if (b) FragmentHideShwo(discussRoomFragment);
//            mDataBinding.viewPager.setCurrentItem(2, true);
        });
        mDataBinding.rbGr.setOnFocusChangeListener((view, b) -> {
            if (b)
                FragmentHideShwo(mineFragment);
//            mDataBinding.viewPager.setCurrentItem(3, true);
        });

    }

    public void showdiscussRoom(){
      //  mDataBinding.rbTl.

      //  FragmentHideShwo(digitalClassesFragment);
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
