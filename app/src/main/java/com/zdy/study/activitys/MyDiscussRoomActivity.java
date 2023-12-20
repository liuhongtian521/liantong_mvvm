package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.database.repository.DBRepository;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomListBean;
import com.askia.coremodel.datamodel.http.entities.consume.HttpLoginResult;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.DiscussRoomAdapter;
import com.zdy.study.adapter.DiscussRoomMyAdapter;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomViewModel;
import com.zdy.study.cdatamodel.viewmodel.UserInfoViewModel;
import com.zdy.study.databinding.ActivityMyDiscussRoomBinding;
import com.zdy.study.databinding.FragmentDiscussRoomBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.MyDiscussRoomActivity)
public class MyDiscussRoomActivity extends BaseActivity {
    private DiscussRoomViewModel mViewModel;
    private DiscussRoomMyAdapter adapter;
    private RecyclerView recyclerView;
    private ActivityMyDiscussRoomBinding mDataBinding;
    private List<DiscussRoomListBean.PageDataBean> list;
    private int page = 1;
    private String pageSize = "10";
    private String mMyId;

    @Override
    public void onInit() {
        list = new ArrayList<>();
        onInTitle("我的讨论室");
//        mDataBinding.currentText.setText(getArguments().getString("TITLE"));
        onInitInformation();
        mViewModel.pageListMyPad("1", "10");
        initRecycleView();
        initLoad();
    }

    private void onInitInformation() {
        HttpLoginResult httpLoginResult = DBRepository.QueryTVUserLoginData();
        mViewModel.queryClassesByPhone(httpLoginResult.getUser_name());//获取用户信息
    }

    private void onInTitle(String title) {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText(title);
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }

    private void initRecycleView() {
        recyclerView = mDataBinding.rvDiscuss;
        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new DiscussRoomMyAdapter(list, this);
        recyclerView.setLayoutManager(manager2);
        recyclerView.setAdapter(adapter);
        // initRVListeners();
    }

    private void initLoad() {
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                mViewModel.pageListMyPad(String.valueOf(page), pageSize);
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                mViewModel.pageListMyPad(String.valueOf(page), pageSize);
            }
        });
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(DiscussRoomViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_discuss_room);
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getPageListPadMyData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            if (null != listResult.getResult().getPageData() && listResult.getResult().getPageData().size() > 0) {
                list.clear();
                list.addAll(listResult.getResult().getPageData());
                for (DiscussRoomListBean.PageDataBean pageDataBean : list) {
                    pageDataBean.setMyId(mMyId);
                }
                adapter.notifyDataSetChanged();
                mDataBinding.lmView.setList(listResult.getResult().getPageData(), page);
            }


        });
        mViewModel.getmUserInfoLiveDataLiveData().observe(this, listResult -> {
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mMyId=listResult.getData().getId();
        });
    }

    @Override
    public void onMResume() {

    }
}
