package com.zdy.study.location;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;

/*进程保护*/
@SuppressLint("NewApi")
public class JobProtectService extends JobService {

    private JobScheduler mJobScheduler;

    public void init(Context context) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d("JobProtectService onStartCommand");
        //开启定时任务
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            JobInfo.Builder builder = new JobInfo.Builder(startId++,
                    new ComponentName(getPackageName(), JobProtectService.class.getName()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //android N之后时间必须在15分钟以上
                builder.setPeriodic(15 * 60 * 1000);
            } else {
                builder.setPeriodic(5 * 1000);
            }
            builder.setBackoffCriteria(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS, JobInfo.BACKOFF_POLICY_LINEAR);//线性重试方案
            builder.setRequiresCharging(true); // 设置是否充电情况下调度
            builder.setPersisted(true);  //设置设备重启后，是否重新执行任务
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY); //任意一种网络这个作业都会被执行
            if (mJobScheduler.schedule(builder.build()) <= 0) {
                LogUtils.d("工作失败");
            } else {
                LogUtils.d("工作成功");
            }
            init(getApplicationContext());
        }
        return START_STICKY;
    }


    @Override
    public boolean onStartJob(JobParameters params) {
        LogUtils.d("开始工作");
        startLocationService();
        upSign();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        startLocationService();
        upSign();
        return false;
    }

    private void startLocationService() {


    }

    int index = 0;
    ArrayList<HashMap<String, String>> arrayList;

    private void upSign() {
        index = 0;
         if (arrayList != null) {
            int ab =(arrayList.size()/30)+1;
            for (int num = 0; num <ab; num++) {
                int end = (num + 1) * 30;
                if (end > arrayList.size())
                    end = arrayList.size();
                if (num * 30 <= arrayList.size()) {

                 }
            }
        }

    }


}