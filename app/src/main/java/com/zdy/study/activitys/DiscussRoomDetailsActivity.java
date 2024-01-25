package com.zdy.study.activitys;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.DiscussRoomDetailsResponse;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.zdy.study.R;
import com.zdy.study.adapter.DiscussRoomDetailsAdapter;
import com.zdy.study.adapter.HistoryAdapter;
import com.zdy.study.cdatamodel.viewmodel.DiscussRoomDetailsViewModel;
import com.zdy.study.cdatamodel.viewmodel.EBookViewModel;
import com.zdy.study.databinding.ActivityDiscussRoomDetailsBinding;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.DiscussRoomDetailsActivity)
public class DiscussRoomDetailsActivity extends BaseActivity {
    private ActivityDiscussRoomDetailsBinding mDataBinding;
    private RecyclerView mRecyclerView;
    private DiscussRoomDetailsAdapter adapter;
    private DiscussRoomDetailsViewModel viewModel;
    private List<DiscussRoomDetailsResponse.PageDataBean> mList;
    private int page = 1;
    private String pageSize = "4";
    private String mRoomId;

    @Override
    public void onInit() {
        mDataBinding.tvDfdsf.setText(getIntent().getStringExtra("roomName"));

        if ("true".equals(getIntent().getStringExtra("true"))) {
            mDataBinding.tvMyCreate.setVisibility(View.VISIBLE);
        } else {
            mDataBinding.tvMyCreate.setVisibility(View.GONE);
        }
        mDataBinding.tvPerson.setText(getIntent().getStringExtra("followCount") + "人关注");
        mDataBinding.subject.setText(getIntent().getStringExtra("topicCount") + "话题");
        mDataBinding.tvContent.setText(getIntent().getStringExtra("roomIntroduction"));
        mDataBinding.tvNameNumber.setText("共" + getIntent().getStringExtra("userCount") + "人参与");
        mRoomId = getIntent().getStringExtra("roomId");
        inItList();
        inItRecycleView();
        if (!"".equals(mRoomId)) {
            viewModel.pageTopicListPAD(String.valueOf(page), pageSize, mRoomId);
        }

    }

    private void initLoad() {
        mDataBinding.lmView.setPageSize(Integer.parseInt(pageSize));//设置页面条数
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                page++;
                showNetDialog();
                viewModel.pageTopicListPAD(String.valueOf(page), pageSize, mRoomId);
            }

            @Override
            public void previousPage() {
                page--;
                showNetDialog();
                viewModel.pageTopicListPAD(String.valueOf(page), pageSize, mRoomId);
            }
        });
    }

    private void inItList() {
        mList = new ArrayList<>();
    }

    public void inItRecycleView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//第二个参数为网格的列数
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new DiscussRoomDetailsAdapter(mList, this);
        mDataBinding.rvDiscuss.setLayoutManager(layoutManager);
        mDataBinding.rvDiscuss.setAdapter(adapter);
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(DiscussRoomDetailsViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_discuss_room_details);
    }

    @Override
    public void onSubscribeViewModel() {
        viewModel.getPageListPadData().observe(this, listResult -> {
            dismissNetDialog();
            if (!listResult.isSuccess()) {
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            mDataBinding.lmView.setVisibility(View.VISIBLE);
            mDataBinding.lmView.setList(listResult.getResult().getPageData(), page);
            mList.clear();
            mList.addAll(listResult.getResult().getPageData());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onMResume() {

    }
}
