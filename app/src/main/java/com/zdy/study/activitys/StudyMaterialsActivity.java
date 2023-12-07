package com.zdy.study.activitys;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.MainMenuAdapter;
import com.zdy.study.adapter.StudyMaterialsAdapter;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.cdatamodel.viewmodel.StudyMaterialsViewModel;
import com.zdy.study.databinding.ActStudyMaterialsBinding;

import java.util.ArrayList;
import java.util.List;


@Route(path = ARouterPath.STUDY_mATERIALS)
public class StudyMaterialsActivity extends BaseActivity {

    private ActStudyMaterialsBinding mDataBinding;
    private StudyMaterialsViewModel mViewModel;

    //
    private List<StuyMaterialsListBean.RecordsBean> dataList = new ArrayList<>();
    private StudyMaterialsAdapter adapter;

    private int pageNo = 1;
    private String pageSize = "10";
    @Override
    public void onInit() {
        initRefresh();
        initDataList();

        List<StuyMaterialsListBean.RecordsBean> list = new ArrayList<>();

        for (int i =0; i<10 ; i++){
            StuyMaterialsListBean.RecordsBean bean = new StuyMaterialsListBean.RecordsBean();
            bean.setCoursewareName("111");
            list.add(bean);

        }

        dataList.addAll(list);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(StudyMaterialsViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_study_materials);
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getmMaterialsLiveData().observe(this, listResult -> {
            if(!listResult.isSuccess()){
                ToastUtils.showLong(listResult.getMessage().toString());
                return;
            }
            dataList.addAll(listResult.getData().getRecords());
            adapter.notifyDataSetChanged();

            /*if (pageNo == 1) {//page 1 刷新列表
                goodsListAdapter.setData(goodsData.getResult().getRecords());
                mBinding.srlResult.finishRefresh();
                if (goodsData.getResult().getRecords().size() > 0){//缺省页隐藏
                    mBinding.rvGoods.setVisibility(View.VISIBLE);
                    mBinding.ivQueshengShangpin.setVisibility(View.GONE);
                }else{                                            //缺省页显示
                    mBinding.rvGoods.setVisibility(View.GONE);
                    mBinding.ivQueshengShangpin.setVisibility(View.VISIBLE);
                }
            }else {           //page 其它  添加列表数据
                goodsListAdapter.addData(goodsData.getResult().getRecords());
                mBinding.srlResult.finishLoadMore();
            }
            goodsListAdapter.notifyDataSetChanged();
            //设置不能加载更多
            if(goodsData.getResult().getRecords().size() < pageSize)
                mBinding.srlResult.setEnableLoadMore(false);*/
        });
    }

    private void initRefresh(){
        /*mDataBinding.srlResult.setOnRefreshListener(refreshLayout -> {
            pageNo = 1;
            mDataBinding.srlResult.setEnableLoadMore(true); //可以加载更多
        });
        mDataBinding.srlResult.setOnLoadMoreListener(refreshLayout -> {
            pageNo ++;
//            mViewModel.queryCoursewareListByUser(String.valueOf(pageNo), pageSize);

            mDataBinding.srlResult.setEnableLoadMore(false);
        });*/
    }

    private void initDataList(){

        mViewModel.queryCoursewareListByUser(String.valueOf(pageNo), pageSize);
        adapter = new StudyMaterialsAdapter(dataList, new StudyMaterialsAdapter.SMAdapterCallBack() {
            @Override
            public void loadMore() {
                ToastUtils.showLong("sdfsdf");

            }
        });
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDataBinding.rlMaterials.setLayoutManager(mLayoutManager);
        mDataBinding.rlMaterials.setAdapter(adapter);
        mDataBinding.rlMaterials.setItemAnimator(null);
        /*mDataBinding.rlMaterials.setOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
            @Override
            public void onChildViewHolderSelected(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                ToastUtils.showLong(position);
            }
        });*/

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
    @Override
    public void onMResume() {

    }
}
