package com.example.muskangoyal.listviewstringarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names= new String[]{
            "muskan",
            "prarthana",
            "drishti",
            "shreya",
            "roshita",
            "saksham",
            "sejal",
            "udit",
            "deepali",
            "abhishek",
            "srishti",
            "diksha",
            "sagrika"
    };
    ListView lvnames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvnames=findViewById(R.id.lvnames);

        ArrayAdapter<String> namesadapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
        );
        lvnames.setAdapter(namesadapter);
    }
}
