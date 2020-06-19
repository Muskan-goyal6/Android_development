package com.example.muskangoyal.jobsheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class DemoJob extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Toast.makeText(this,"Hello i am scheduled job",Toast.LENGTH_SHORT).show();

        //execute an async job

        //jobFinished(jobParameters,false);

        return false ;// writing here true means that the job is still going on , so don't finish this service just yet
        // for async job we have to return true here and call jobfinish() to tell system manually when the job is finished
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
