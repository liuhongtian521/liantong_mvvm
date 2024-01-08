package com.zdy.study.activitys;

import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.askia.common.base.ARouterPath;
import com.askia.common.base.BaseActivity;
import com.askia.coremodel.datamodel.http.entities.consume.EBookListBean;
import com.askia.coremodel.datamodel.http.entities.consume.StuyMaterialsListBean;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zdy.study.R;
import com.zdy.study.adapter.EBookAdapter;
import com.zdy.study.adapter.StudyMaterialsAdapter;
import com.zdy.study.cdatamodel.viewmodel.EBookViewModel;
import com.zdy.study.cdatamodel.viewmodel.StudyMaterialsViewModel;
import com.zdy.study.databinding.ActEbookBinding;
import com.zdy.study.databinding.ActStudyMaterialsBinding;
import com.zdy.study.tools.WpsUtil;
import com.zdy.study.widgets.LoadMoreConstraintLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//电子课件
@Route(path = ARouterPath.EBOOK_ACTIVIGY)
public class EBookActivity extends BaseActivity {

    private ActEbookBinding mDataBinding;
    private EBookViewModel mViewModel;

    //
    private List<EBookListBean.RecordsBean> dataList = new ArrayList<>();
    private EBookAdapter adapter;

    private int pageNo = 1;
    private String pageSize = "10";
    private String fileName = "";
    private String readStartTime; //埋点 开始时间
    @Override
    public void onInit() {
        initDataList();
        initLoad();
        seveStartTime();//记录页面开始时间 埋点
        //标题
        mDataBinding.includeLayout.preferenceActivityTitleText.setText("电子课件");
        mDataBinding.includeLayout.preferenceActivityTitleImage.setOnClickListener(v -> {
            finish();
        });
        showNetDialog();
        mViewModel.queryCoursewareListByUser(String.valueOf(pageNo), pageSize);
    }

    private void seveStartTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        readStartTime = simpleDateFormat.format(date);
    }

    private void initLoad(){
        mDataBinding.lmView.setLoadLitetsner(new LoadMoreConstraintLayout.LoadLitetsner() {
            @Override
            public void nextPage() {
                pageNo ++;
                showNetDialog();
                mViewModel.queryCoursewareListByUser(String.valueOf(pageNo), pageSize);            }

            @Override
            public void previousPage() {
                pageNo --;
                showNetDialog();
                mViewModel.queryCoursewareListByUser(String.valueOf(pageNo), pageSize);
            }
        });
    }

    @Override
    public void onInitViewModel() {
        mViewModel = ViewModelProviders.of(this).get(EBookViewModel.class);
    }

    @Override
    public void onInitDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.act_ebook);
    }

    @Override
    public void onSubscribeViewModel() {
        mViewModel.getmMaterialsLiveData().observe(this, listResult -> {
            dismissNetDialog();
            mDataBinding.lmView.setList(listResult.getData().getRecords(), pageNo);
            dataList.clear();
            dataList.addAll(listResult.getData().getRecords());
            adapter.notifyDataSetChanged();
        });
    }


    private void initDataList(){

        adapter = new EBookAdapter(dataList, new EBookAdapter.SMAdapterCallBack() {
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
                    url = new String(dataList.get(position).getCoursewareUrl().getBytes(), "UTF-8");
                    url = URLDecoder.decode(url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                fileName = "/zdy."+dataList.get(position).getCoursewareType();
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
                showNetDialog();
                new Thread(() ->{
                    downloadFile1(finalUrl);
                }).start();
            }
        });
    }
    public void downloadFile1(String url) {
        try{
            //下载路径，如果路径无效了，可换成你的下载路径
            final long startTime = System.currentTimeMillis();
            Log.i("DOWNLOAD","startTime="+startTime);
            //下载函数
//            filename = timeSeconds+"zdy.apk";
            //获取文件名
            URL myURL = new URL(url);
            URLConnection conn = myURL.openConnection();
            conn.setRequestProperty("Accept-Encoding", "identity");
            conn.connect();
            InputStream is = conn.getInputStream();
            int fileSize = conn.getContentLength();//根据响应获取文件大小
            if (fileSize <= 0) throw new RuntimeException("无法获知文件大小 ");
            if (is == null) throw new RuntimeException("stream is null");
            File file1 = getExternalCacheDir();
            Log.i("DOWNLOAD",getExternalCacheDir().toString());
            if(!file1.exists()){
                file1.mkdirs();
            }
            //把数据存入路径+文件名
            FileOutputStream fos = new FileOutputStream(file1 + fileName);
            byte buf[] = new byte[1024];
            int downLoadFileSize = 0;
            do{
                //循环读取
                int numread = is.read(buf);
                if (numread == -1)
                {
                    break;
                }
                fos.write(buf, 0, numread);
                downLoadFileSize += numread;

                DecimalFormat df=new DecimalFormat("0.00");//设置保留位数

                String ss = df.format((float)downLoadFileSize/fileSize);
//                Log.i("DOWNLOAD","download "+ss+"%");
                /*if (downLoadBack != null)
                    downLoadBack.downFileSize(ss);*/

                //更新进度条
            } while (true);
//            downLoadBack.complete(true);
//            startActivity(new Intent(this, PdfViewActivity.class));
            dismissNetDialog();
            File file = new File(getExternalCacheDir() + fileName);
            WpsUtil.openDocWithSimple(file, this);
//            openDocWithSimple
            Log.i("DOWNLOAD","download success");
            Log.i("DOWNLOAD","totalTime="+ (System.currentTimeMillis() - startTime));

            is.close();
        } catch (Exception ex) {
//            downLoadBack.complete(false);
            Log.e("DOWNLOAD", "error: " + ex.getMessage(), ex);
        }
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
        mViewModel.save("2", readStartTime, simpleDateFormat.format(date));
    }
}
