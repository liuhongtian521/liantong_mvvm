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
import com.zdy.study.databinding.FragmentCurrentClassBinding;


//CurrentClassFragment.java
public class CurrentClassFragment extends BaseFragment {

    private FragmentCurrentClassBinding mDataBinding;
    @Override
    public void onInit() {
        mDataBinding.currentText.setText(getArguments().getString("TITLE"));
    }

    @Override
    public void onInitViewModel() {
    }

    @Override
    public View onInitDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_class, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onSubscribeViewModel() {

    }

    public static CurrentClassFragment newInstance(String title){
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        CurrentClassFragment fragment = new CurrentClassFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
 
    /*private TextView mTextView;
 
    public static CurrentClassFragment newInstance(String title){
        Bundle arguments = new Bundle();
        arguments.putString("TITLE", title);
        CurrentClassFragment fragment = new CurrentClassFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
 
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_current_class, container, false);
 
        mTextView = (TextView) root.findViewById(R.id.current_text);
        mTextView.setText(getArguments().getString("TITLE"));
 
        return root;
    }*/
}