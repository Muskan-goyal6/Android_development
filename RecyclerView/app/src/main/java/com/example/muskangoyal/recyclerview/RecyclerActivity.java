package com.example.muskangoyal.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    public static final String TAG= "RV";

    ArrayList<Course> courses =Course.generateNRandomCourses(100);
    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rvCourses=findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        //rvCourses.setLayoutManager(new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false));

        CourseRecyclerAdapter courseRecyclerAdapter =new CourseRecyclerAdapter(courses);
        rvCourses.setAdapter(courseRecyclerAdapter);
    }
}
