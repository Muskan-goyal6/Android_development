package com.example.muskangoyal.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btntask = findViewById(R.id.btntask);
        btntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(),Main2Activity.class);

                //schedule a task that will run 5 mins from now and start my app
                PendingIntent pi= PendingIntent.getActivity(getBaseContext(),123,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager =  (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+60000,pi);

                //setting repeating alarms

                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime()+60000,
                        60000,pi);

                // the tigger time(triggerAtMillis) = current time + the time delay for scheduling the alarms
            }
        });

//        PendingIntent pi = PendingIntent.getActivity(
//                this,
//                112,
//                startActIntent,
//                PendingIntent.FLAG_ONE_SHOT
//        );

//        am.setRepeating(
//                AlarmManager.RTC,
//                System.currentTimeMillis() + (60 * 1000),
//                2 * 60 * 1000,
//                pi
//        );
//        am.set(
//                AlarmManager.RTC,
//                System.currentTimeMillis() + (60 * 1000),
//                pi
//        );


    }
}
