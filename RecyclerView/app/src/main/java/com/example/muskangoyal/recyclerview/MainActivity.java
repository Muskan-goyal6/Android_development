package com.example.muskangoyal.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG= "recycle";
    ListView lvCourses;
    ArrayList<Course> courses=Course.generateNRandomCourses(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses=findViewById(R.id.lvCourses);
        CouseAdapter couseAdapter=new CouseAdapter();
        lvCourses.setAdapter(couseAdapter);
    }

    class CouseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int i) {
            return courses.get(i);
        }

        @Override
        public long  getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup parent) {

             CourseViewHolder holder;
            // for efficiency in a recycle view
            if(convertview ==null){
                convertview= getLayoutInflater().inflate(
                       R.layout.list_item_course,
                        parent,
                        false
           );
            holder=new CourseViewHolder(convertview);
            convertview.setTag(holder);
            }else{
                holder=(CourseViewHolder) convertview.getTag();
            }


            Course course = getItem(i);
           holder.tvStudent.setText(course.getStudentName());
            holder.tvCourse.setText(course.getCourse());
            holder.tvLecture.setText(String.valueOf(course.getLectures()));
            return convertview;
        }

        class CourseViewHolder{
            TextView tvStudent,tvCourse,tvLecture;

            CourseViewHolder(View convertview){
                 tvStudent=convertview.findViewById(R.id.tvStudent);
                 tvCourse=convertview.findViewById(R.id.tvCourse);
                 tvLecture=convertview.findViewById(R.id.tvLecture);

            }
        }
    }
}
