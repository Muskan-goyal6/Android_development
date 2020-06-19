package com.example.muskangoyal.asynctasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsyncTaskActivity extends AppCompatActivity {
    public static final String TAG= "AT2";

    Button btn, btn2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);
        btn2=findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r= new Random();
                tv.setText(String.valueOf(r.nextInt(100)));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            CountTask countTask =new CountTask();
            countTask.execute(5);//this execution happens on a background thread
            //countTask.doInBackground(5);//we should never call doinbackground directly
            }
        });

    }

    class CountTask extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG,"started");
            int n= integers[0];
           // waitNsecs(n);
            for(int i=0;i<n;i++){
                wait1sec();
                publishProgress(i);
                //we cannot do settext here as its a background thread not main thread
            }
            Log.d(TAG,"ended");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText(String.valueOf(values[0]));
        }
    }

    void wait1sec(){
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis()< startTime+ 1000);
    }

    void waitNsecs(int n){
        for(int i=0;i<n;i++){
            wait1sec();
        }
    }
}
