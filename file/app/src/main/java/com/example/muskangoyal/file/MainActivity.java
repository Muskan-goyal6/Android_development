package com.example.muskangoyal.file;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    TextView textView;
    Button btnwrite,btnread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        textView=findViewById(R.id.textView);
        btnwrite = findViewById(R.id.btnwrite);
        btnread=findViewById(R.id.btnread);

        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = et1.getText().toString();
                File datadir = ContextCompat.getDataDir(MainActivity.this);
                File myfile = new File(datadir,"myfile.txt");

                try{
                    FileOutputStream fos = new FileOutputStream(myfile,true);
                    fos.write(text.getBytes());
                }catch (FileNotFoundException fnfe){
                    Toast.makeText(MainActivity.this,"file not found",Toast.LENGTH_SHORT).show();
                }catch (IOException ioe){
                    Toast.makeText(MainActivity.this,"error while writing file",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File datadir = ContextCompat.getDataDir(MainActivity.this);
                File myfile = new File(datadir,"myfile.txt");
                try{

                    FileInputStream fis = new FileInputStream(myfile);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    StringBuilder sb = new StringBuilder();
                    String buffer=br.readLine();
                    while (buffer!=null){
                        sb.append(buffer);
                        buffer = br.readLine();
                    }
                    String text =sb.toString();
                    textView.setText(text);

                }catch (FileNotFoundException fnfe){
                    Toast.makeText(MainActivity.this,"file not found",Toast.LENGTH_SHORT).show();
                }catch (IOException ioe){
                    Toast.makeText(MainActivity.this,"error while writing file",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
