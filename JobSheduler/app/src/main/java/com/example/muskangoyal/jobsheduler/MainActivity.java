package com.example.muskangoyal.jobsheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int JOB_ID= 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scheduleJob (View view){

        JobScheduler jobScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);

        JobInfo jobInfo =new JobInfo.Builder(JOB_ID,new ComponentName(this,DemoJob.class))
                .setPeriodic(1200000)
                 .setPersisted(true)//run also after u reboot the phone
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)//run on wifi network
                .setRequiresCharging(false)//only when phone is charging
                .build();

        jobScheduler.schedule(jobInfo);

    }
}
