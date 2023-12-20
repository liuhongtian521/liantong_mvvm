package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.AddressBookResponseBean;
import com.askia.coremodel.datamodel.http.entities.consume.TopicResponseBean;
import com.blankj.utilcode.util.ToastUtils;
import com.zdy.study.R;
import com.zdy.study.adapter.AddressBookAdapter;
import com.zdy.study.adapter.TopicAdapter;
import com.zdy.study.cdatamodel.viewmodel.AddressBookViewModel;
import com.zdy.study.cdatamodel.viewmodel.StudyMaterialsViewModel;
import com.zdy.study.cdatamodel.viewmodel.TopicPostedViewModel;
import com.zdy.study.databinding.ActivityTopicPostedBinding;
import com.zdy.study.databinding.AddressBookActivityBinding;
import com.zdy.study.tools.Constants;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.TopicPostedActivity)
public class TopicPostedActivity extends BaseActivity {
    private TopicPostedViewModel mViewModel;
    private ActivityTopicPostedBinding mDataBinding;
    private List<TopicResponseBean.PageDataBean> list;
    private RecyclerView recyclerView;
    private TopicAdapter adapter;
    private int page = 1;
    private String pageSize = "10";
    @Override
    public void onInit() {
        //标题
        initTitle();
        list = new ArrayList<>();
        mViewModel.queryStudentHandbook("1","10");
        initLoad();
        initRecycleView();
    }
    private void initRecycleView() {
        recyclerView = mDataBinding.rvWeb;
        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new TopicAdapter(list, this);
        recyclerView.setLayoutManager(manager2);
        recyclerView.setAdapter(adapter);
    }
    private void initTitle() {
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("我发表的话题");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
    }
    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(TopicPostedViewModel.class);
    }
    private void initLoad() {
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                mViewModel.queryStudentHandbook(String.valueOf(page), pageSize);
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                mViewModel.queryStudentHandbook(String.valueOf(page), pageSize);
            }
        });
    }
    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_topic_posted);
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getmMaterialsLiveData().observe(this, listResult -> {

            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mDataBinding.lmView.setList(listResult.getResult().getPageData(), page);
            if (null != listResult.getResult()) {
                list.clear();
                list.addAll(listResult.getResult().getPageData());
            }
            adapter.notifyDataSetChanged();
        });


    }

    @Override
    public void onMResume() {

    }
}
