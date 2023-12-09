package com.zdy.study.activitys;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.BaseResponseData;
import com.askia.coremodel.datamodel.http.entities.consume.StudyDictionaryBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.tabs.TabLayout;
import com.zdy.study.R;
import com.zdy.study.adapter.MainMenuAdapter;
import com.zdy.study.adapter.StudyMaterialsAdapter;
import com.zdy.study.cdatamodel.viewmodel.LoginViewModel;
import com.zdy.study.cdatamodel.viewmodel.StudyMaterialsViewModel;
import com.zdy.study.databinding.ActStudyMaterialsBinding;
import com.zdy.study.tools.WpsUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//学习资料
@Route(path = ARouterPath.STUDY_mATERIALS)
public class StudyMaterialsActivity extends BaseActivity {

    private ActStudyMaterialsBinding mDataBinding;
    private StudyMaterialsViewModel mViewModel;

    //
    private List<StuyMaterialsListBean.RecordsBean> dataList = new ArrayList<>();
    private StudyMaterialsAdapter adapter;

    private int pageNo = 1;
    private String pageSize = "10";
    private String fileName = "";
    private List<StudyDictionaryBean> list;
    private int pageTab = 0;

    @Override
    public void onInit() {
        list = new ArrayList<>();
        initDataList();
        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("学习资料");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });

        /*List<StuyMaterialsListBean.RecordsBean> list = new ArrayList<>();

        for (int i =0; i<10 ; i++){
            StuyMaterialsListBean.RecordsBean bean = new StuyMaterialsListBean.RecordsBean();
            bean.setCoursewareName("111");
            list.add(bean);

        }

        dataList.addAll(list);
        adapter.notifyDataSetChanged();*/


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initTab() {
        TabLayout.Tab tab2;
        View view;
        StudyDictionaryBean bean = new StudyDictionaryBean();
        bean.setDictValue("全部");
        list.add(0, bean);
        for (StudyDictionaryBean studyDictionaryBean : list) {
            tab2 = mDataBinding.tabLayout.newTab();
          //  tab2.setText(studyDictionaryBean.getDictValue());
            view = LayoutInflater.from(this).inflate(R.layout.tablayout_bg,null);
            TextView tv = (TextView) view.findViewById(R.id.tv_tablayout_name);
            tv.setText(studyDictionaryBean.getDictValue());
         //   mDataBinding.tabLayout.setBackgroundResource(R.drawable.red_select_bg);
            // 创建并配置子视图的布局参数
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // 子视图的宽度为包裹内容
                    ViewGroup.LayoutParams.MATCH_PARENT   // 子视图的高度为包裹内容
            );
            view.setLayoutParams(layoutParams);
           tab2.setCustomView(view);

            mDataBinding.tabLayout.addTab(tab2);
        }
//        TabLayout.Tab tab = mBinding.tlGoodsClassify.newTab();
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.widget_choose_icon_tab_bg, null);
//        TextView tv = (TextView) view.findViewById(R.id.choose_icon_tab_tv);
////            TextView tvc = (TextView) view.findViewById(R.id.tv_count);
//        tv.setText(name.getTypeName());
////            tvc.setText("2");
//        tab.setCustomView(view);

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
            if (!listResult.isSuccess()) {
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
        mViewModel.getmDictionaryLiveData().observe(this, listResult -> {
            if (listResult.isSuccess()) {
//                ToastUtils.showLong(listResult.getMessage().toString());
                list.clear();
                list.addAll(listResult.getData());
            }
            initTab();

        });
    }


    private void initDataList() {
        mViewModel.dictionary("CLASS_MATERIAL_TAG");
        mViewModel.queryLearningMaterials("", String.valueOf(pageNo), pageSize);
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
                String url = null;
                try {
                    url = new String(dataList.get(position).getLearningMaterialsUrl().getBytes(), "UTF-8");
                    url = URLDecoder.decode(url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                fileName = "zdy." + dataList.get(position).getLearningMaterialsType();

                /*WpsUtil wpsUtil = new WpsUtil(new WpsUtil.WpsInterface() {
                    @Override
                    public void doRequest(String filePath) {

                    }

                    @Override
                    public void doFinish() {

                    }
                }, "", url.trim().replace("\\", "/"), true, StudyManualActivity.this);
                wpsUtil.openDocument();*/

                String finalUrl = url;

                new Thread(() -> {
                    downloadFile1(finalUrl);
                }).start();

            }
        });
    }

    public void downloadFile1(String url) {
        try {
            //下载路径，如果路径无效了，可换成你的下载路径
            final long startTime = System.currentTimeMillis();
            Log.i("DOWNLOAD", "startTime=" + startTime);
            //下载函数
//            filename = timeSeconds+"zdy.apk";
            //获取文件名
            URL myURL = new URL(url);
            URLConnection conn = myURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            int fileSize = conn.getContentLength();//根据响应获取文件大小
            if (fileSize <= 0) throw new RuntimeException("无法获知文件大小 ");
            if (is == null) throw new RuntimeException("stream is null");
            File file1 = getExternalCacheDir();
            Log.i("DOWNLOAD", getExternalCacheDir().toString());
            if (!file1.exists()) {
                file1.mkdirs();
            }
            //把数据存入路径+文件名
            FileOutputStream fos = new FileOutputStream(file1 + fileName);
            byte buf[] = new byte[1024];
            int downLoadFileSize = 0;
            do {
                //循环读取
                int numread = is.read(buf);
                if (numread == -1) {
                    break;
                }
                fos.write(buf, 0, numread);
                downLoadFileSize += numread;

                DecimalFormat df = new DecimalFormat("0.00");//设置保留位数

                String ss = df.format((float) downLoadFileSize / fileSize);
//                Log.i("DOWNLOAD","download "+ss+"%");
                /*if (downLoadBack != null)
                    downLoadBack.downFileSize(ss);*/

                //更新进度条
            } while (true);
//            downLoadBack.complete(true);
//            startActivity(new Intent(this, PdfViewActivity.class));
            File file = new File(getExternalCacheDir() + fileName);
            WpsUtil.openDocWithSimple(file, this);
//            openDocWithSimple
            Log.i("DOWNLOAD", "download success");
            Log.i("DOWNLOAD", "totalTime=" + (System.currentTimeMillis() - startTime));

            is.close();
        } catch (Exception ex) {
//            downLoadBack.complete(false);
            Log.e("DOWNLOAD", "error: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void onMResume() {

    }
}
