package com.example.muskangoyal.phonemessaging;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    ImageButton img1,img2;
    public static final String TAG ="sms";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        img1=findViewById(R.id.imageButton);
        img2=findViewById(R.id.imageButton2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = String.format("tel: %s", et1.getText().toString());
                Uri uri = Uri.parse(phoneNumber);
                Intent callIntent = new Intent(Intent.ACTION_DIAL,uri);
               // callIntent.setData(Uri.parse(phoneNumber));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                } else {
                    Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String smsNumber = String.format("smsto: %s",et1.getText().toString());
                String sms = et2.getText().toString();
                Uri uri = Uri.parse(smsNumber);
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
                //smsIntent.setData(Uri.parse(smsNumber));
                smsIntent.putExtra("sms_body", sms);

                if (smsIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(smsIntent);
                } else {
                    Log.d(TAG, "Can't resolve app for ACTION_SENDTO Intent");
                }
            }
        });
    }
}
