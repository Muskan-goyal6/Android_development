package com.example.muskangoyal.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {
    ArrayList<Course> courses;

    public CourseRecyclerAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li=(LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course_card,viewGroup,false);

        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int i) {
        Course course = courses.get(i);
        holder.tvLecture.setText(String.valueOf(course.getLectures()));
        holder.tvCourse.setText(course.getCourse());
        holder.tvStudent.setText(course.getStudentName());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView tvStudent,tvCourse,tvLecture;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudent=itemView.findViewById(R.id.tvStudent);
            tvCourse=itemView.findViewById(R.id.tvCourse);
            tvLecture=itemView.findViewById(R.id.tvLecture);
        }
    }
}
