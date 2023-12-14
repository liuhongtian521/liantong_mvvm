package com.zdy.study.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.askia.common.base.BaseFragment;
import com.zdy.study.R;
import com.zdy.study.databinding.SelectedTheoryFragmentBinding;

public class SelectedTheoryFragment extends BaseFragment {
    private SelectedTheoryFragmentBinding mDataBinding;
    @Override
    public void onInit() {

    }

    @Override
    public void onInitViewModel() {

    }
    public static SelectedTheoryFragment newInstance(String title) {
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        SelectedTheoryFragment fragment = new SelectedTheoryFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.selected_theory_fragment, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {

    }
}
