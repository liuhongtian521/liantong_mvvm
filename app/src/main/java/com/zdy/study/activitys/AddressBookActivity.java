package com.zdy.study.activitys;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.AddressBookAdapter;
import com.zdy.study.cdatamodel.viewmodel.AddressBookViewModel;
import com.zdy.study.databinding.AddressBookActivityBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*通讯录 */
@Route(path = ARouterPath.AddressBookActivity)
public class AddressBookActivity extends BaseActivity {
    private AddressBookActivityBinding mDataBinding;
    private AddressBookViewModel viewModel;
    private List<AddressBookResponseBean.RecordsBean> list;
    private RecyclerView recyclerView;
    private AddressBookAdapter adapter;
    private String readStartTime; //埋点 开始时间

    @Override
    public void onInit() {
        //标题
        initTitle();
        seveStartTime();
        list = new ArrayList<>();
        viewModel.queryStudentInfoListByClass("1", "10000", "");
        initRecycleView();
    }

    private void initRecycleView() {
        recyclerView = mDataBinding.rvAddressBook;
        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new AddressBookAdapter(list, this);
        recyclerView.setLayoutManager(manager2);
        recyclerView.setAdapter(adapter);
        initRVListeners();
    }

    /*recycleView点击事件*/
    private void initRVListeners() {
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle =new Bundle();
            if (null!=list&&list.size()>=0){
                bundle.putString("studentImg",list.get(position).getStudentImg());
                bundle.putString("studentName",list.get(position).getStudentName());
                bundle.putString("studentPhone",list.get(position).getStudentPhone());
                bundle.putString("studentPost",list.get(position).getStudentPost());
                bundle.putString("classesName",list.get(position).getClassesName());
                startActivityByRouter(ARouterPath.AddressBookDetailsActivity, bundle);
            }
        });
    }

    private void initTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("通讯录");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void seveStartTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        readStartTime = simpleDateFormat.format(date);
    }
    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddressBookViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.address_book_activity);
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {

            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }

            if (null != listResult.getData()) {
                list.clear();
                list.addAll(listResult.getData().getRecords());
            }
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onMResume() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        //埋点记录
        viewModel.save("9", readStartTime, simpleDateFormat.format(date));
    }
}
