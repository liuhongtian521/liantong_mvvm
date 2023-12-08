package com.zdy.study.activitys;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BroadcastExpressResponBean;
import com.zdy.study.R;
import com.zdy.study.adapter.BroadcastExpressAdapter;
import com.zdy.study.cdatamodel.viewmodel.AddressBookViewModel;
import com.zdy.study.cdatamodel.viewmodel.BroadcastExpressViewModel;
import com.zdy.study.databinding.BroadcastExpressActivityBinding;

import java.util.ArrayList;
import java.util.List;

/*通讯录 */
@Route(path = ARouterPath.AddressBookActivity)
public class AddressBookActivity extends BaseActivity {
    private AddressBookViewModel viewModel;
    private List<BroadcastExpressResponBean.PageDataBean> list;
    private RecyclerView recyclerView;
    private BroadcastExpressAdapter adapter;
    @Override
    public void onInit() {
        //标题
//        mDataBinding.includeLayout.preferenceActivityTitleText.setText("通讯录");
//        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
//            finish();
//        });
        list = new ArrayList<>();
//        viewModel.queryContListByAudit("1", "10", "E8\u200C81\u200C94E6\u200C92\u200CAD_parent");
//        recyclerView = mDataBinding.rvBroadcastExpress;

        LinearLayoutManager manager2 = new LinearLayoutManager(this);//数字为行数或列数
        adapter = new BroadcastExpressAdapter(list);
        recyclerView.setLayoutManager(manager2);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onInitViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddressBookViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
      //  mDataBinding = DataBindingUtil.setContentView(this, R.layout.address_book_activity);
    }

    @Override
    public void onSubscribeViewModel() {

    }

    @Override
    public void onMResume() {

    }
}
