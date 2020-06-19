package com.example.muskangoyal.customadapterlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Teacher> teachers= Teacher.get10Randomteachers();
    ListView lvTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTeachers = findViewById(R.id.lvTeachers);

        TeacherAdapter teacherAdapter =new TeacherAdapter();
        lvTeachers.setAdapter(teacherAdapter);
    }

    class TeacherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return teachers.size();
        }

        @Override
        public Teacher getItem(int position) {
            return teachers.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            View itemview= getLayoutInflater().inflate(
                    R.layout.list_item_teacher,
                    parent,
                    false
            );

            TextView tvName= itemview.findViewById(R.id.tvName);
            TextView tvCourse =itemview.findViewById(R.id.tvCourse);
            tvName.setText(getItem(position).getName());
            tvCourse.setText(getItem(position).getCourse());

            return itemview;
        }
    }
}
