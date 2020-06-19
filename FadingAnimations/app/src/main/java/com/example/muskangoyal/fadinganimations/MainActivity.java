package com.example.muskangoyal.fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView jerry,pikachu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jerry= findViewById(R.id.jerry);
        pikachu=findViewById(R.id.pikachu);


        jerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // jerry.animate().alpha(0f).setDuration(2000);
                //pikachu.animate().alpha(1f).setDuration(2000);
                //jerry.animate().translationXBy(1000f).setDuration(2000);
                jerry.animate().rotation(360).setDuration(1000);
            }
        });
    }
}
