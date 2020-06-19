package com.example.muskangoyal.buttononclickfunc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG ="Button";
    Button button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.button2);
        button3=findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"second button clicked");
            }
        });
        button3.setOnClickListener(this);
    }

    public void onButtonClick(View view){
        Log.d(TAG,"button is clicked");
    }

    @Override
    public void onClick(View view) {
      Log.d(TAG,"third button clicked");
    }
}
