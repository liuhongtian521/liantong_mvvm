package com.zdy.study.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPager2Adapter extends FragmentStateAdapter {
    private List<Fragment> mFragments;
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        mFragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 每个页面对应的fragment


        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        // 有几个页面就返回几
        return mFragments.size();
    }
}
