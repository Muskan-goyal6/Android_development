package com.example.muskangoyal.asynctasks;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="async";
    Button btn;
    ConstraintLayout clback;
    ListView lvitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        clback=findViewById(R.id.clback);
        lvitems=findViewById(R.id.lvitems);
        String [] items = new String[]{
                "red","pink","yellow",
                "blue","orange","black",
                "purple","white"
        };

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );

        lvitems.setAdapter(itemAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //waitNsecs(10);
               // clback.setBackgroundColor(Color.YELLOW);
               // Log.d(TAG,"onClick:"+System.currentTimeMillis());//shows the time elasped since device is on (in nano seconds)
                Handler handler= new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                      Log.d(TAG,"we have waited 5 seconds");
                      clback.setBackgroundColor(Color.MAGENTA);
                    }
                };
                handler.postDelayed(runnable,5000);
            }
        });
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
