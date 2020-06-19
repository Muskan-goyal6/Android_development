package com.example.muskangoyal.recyclerview;

import java.util.ArrayList;
import java.util.Random;

public class Course {

    String studentName;
    String course;
    int lectures;

    public Course(String studentName, String course, int lectures) {
        this.studentName = studentName;
        this.course = course;
        this.lectures = lectures;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getLectures() {
        return lectures;
    }


    public static final String [] students={
            "Muskan","Deepali","Srishti","Shreya","Roshita","Prarthana"
    };

    public static final String [] courseName ={
            "Android","Web Development","Python","Launchpad","Machine Learning","Crux"
    };

    public static ArrayList<Course> generateNRandomCourses (int n){
        ArrayList<Course> courses =new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<n;i++){
            Course course =new Course(
                  students[r.nextInt(6)],
                  courseName[r.nextInt(6)],
                  10+r.nextInt(10)
            );
            courses.add(course);
        }
        return courses;
    }
}
