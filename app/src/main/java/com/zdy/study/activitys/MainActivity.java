package com.zdy.study.activitys;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;

import android.util.Log;
import android.widget.RadioButton;

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

    private RadioButton lastRb = null;//上一次选中RadioButton
    private String mCurrentPage = "0";

    @Override
    public void onInit() {
        initFragment();
//        initPagerTab();
        initBottom();
        checkUpdate();
    }

    private void checkUpdate() {
        new UpdateChecker("c2cad66e174bff947b8e2067c57d4eec", this)
                .check("bc7efbffa17e035b23efe34cd4114f85",
                        BuildConfig.VERSION_CODE + "",
                        null,
                        "13045503e2bd7dacbbba370db0393dd3",
                        new UpdateChecker.Callback() {
                            @Override
                            public void result(UpdateChecker.UpdateInfo updateInfo) {

//                                Toast.makeText(reactContext,updateInfo.buildBuildVersion,Toast.LENGTH_LONG).show();
                                Log.i("DOWNLOAD", updateInfo.buildBuildVersion.toString());
                            }

                            @Override
                            public void error(String message) {
                                Log.i("DOWNLOAD", message);
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
        transaction.commitAllowingStateLoss();
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
        lastRb = mDataBinding.rbSzbj;
        mDataBinding.rbSzbj.requestFocus();
        mDataBinding.rbSzbj.setOnFocusChangeListener((view, b) -> {
            if (b) {
                mCurrentPage = "0";
                FragmentHideShwo(digitalClassesFragment);
//                mDataBinding.viewPager.setCurrentItem(0, true);
                rbSelected(mDataBinding.rbSzbj, R.mipmap.ic_tab_banji_select);
            }

        });
        mDataBinding.rbXxzs.setOnFocusChangeListener((view, b) -> {
            if (b) {
                mCurrentPage = "1";
                FragmentHideShwo(mainFragment);
//            mDataBinding.viewPager.setCurrentItem(1, true);
                rbSelected(mDataBinding.rbXxzs, R.mipmap.ic_tab_zhushou_select);
            }
        });
        mDataBinding.rbTl.setOnFocusChangeListener((view, b) -> {
            if (b) {
                mCurrentPage = "2";
                FragmentHideShwo(discussRoomFragment);
//            mDataBinding.viewPager.setCurrentItem(2, true);
                rbSelected(mDataBinding.rbTl, R.mipmap.ic_tab_banji_select);
            }
        });
        mDataBinding.rbGr.setOnFocusChangeListener((view, b) -> {
            if (b) {
                mCurrentPage = "3";
                FragmentHideShwo(mineFragment);
//            mDataBinding.viewPager.setCurrentItem(3, true);
                rbSelected(mDataBinding.rbGr, R.mipmap.ic_tab_geren_select);
            }
        });

    }

    //设置选中效果
    private void rbSelected(RadioButton rbSel, int leftDra) {
        if (lastRb != null)
            setTabUnSelect(lastRb);//将上此选中 设置为未选择
        rbSel.setBackgroundResource(R.drawable.shape_4_red);
        // 使用代码设置drawableleft
        Drawable drawable = getResources().getDrawable(leftDra);
        // 这一步必须要做，否则不会显示。
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        rbSel.setCompoundDrawables(drawable, null, null, null);
        rbSel.setTextColor(getResources().getColor(R.color.white));
        lastRb = rbSel;
    }

    //将上此选中 设置为未选择
    private void setTabUnSelect(RadioButton rbSel) {
        Drawable drawable = null;
        switch (rbSel.getId()) {
            case R.id.rb_szbj:
                // 使用代码设置drawableleft
                drawable = getResources().getDrawable(R.mipmap.ic_tab_banji_unselect);
                break;
            case R.id.rb_xxzs:
                // 使用代码设置drawableleft
                drawable = getResources().getDrawable(R.mipmap.ic_tab_zushou_unselect);
                break;
            case R.id.rb_tl:
                // 使用代码设置drawableleft
                drawable = getResources().getDrawable(R.mipmap.ic_tab_taolun_unselect);
                break;
            case R.id.rb_gr:
                // 使用代码设置drawableleft
                drawable = getResources().getDrawable(R.mipmap.ic_tab_geren_unselect);
                break;
        }
        // 这一步必须要做，否则不会显示。
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        rbSel.setCompoundDrawables(drawable, null, null, null);
        rbSel.setTextColor(getResources().getColor(R.color.txt_main_tab));
        rbSel.setBackgroundResource(R.drawable.shape_4_e6e6e6);
    }

    public void showdiscussRoom() {
        mDataBinding.rbTl.requestFocus();
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
