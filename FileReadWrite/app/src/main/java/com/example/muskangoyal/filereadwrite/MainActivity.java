package com.example.muskangoyal.filereadwrite;

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

    Button btnWrite,btnRead;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite=findViewById(R.id.button);
        btnRead=findViewById(R.id.button2);
        et=findViewById(R.id.editText);
        tv=findViewById(R.id.textView);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();

                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myfile = new File(dataDir,"file.txt");

                try {
                    FileOutputStream fos = new FileOutputStream(myfile,true);// if we write true it will append data
                    fos.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this,"File Not Found",Toast.LENGTH_SHORT).show();
                }catch (IOException ioe){
                    Toast.makeText(MainActivity.this,"Error while writing file",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myfile = new File(dataDir,"file.txt");

                try {
                    FileInputStream fis = new FileInputStream(myfile);
                    InputStreamReader isr= new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    StringBuilder sb = new StringBuilder();
                    String buffer = br.readLine();  //if the file is empty we do not go in loop
                    while (buffer != null){
                        sb.append(buffer);
                        buffer = br.readLine();  //as we come to the last line then we get null at end and it stops
                    }

                    String text = sb.toString();
                    tv.setText(text);


                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this,"File Not Found",Toast.LENGTH_SHORT).show();
                }catch (IOException ioe){
                    Toast.makeText(MainActivity.this,"Error while writing file",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
