package com.example.muskangoyal.customadapterlist;

import java.util.ArrayList;

public class Teacher {

    String name;
    String course;

    public Teacher(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public static ArrayList <Teacher> get10Randomteachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();{
            teachers.add(new Teacher("muskan","android"));
            teachers.add(new Teacher("drishti","web"));
            teachers.add(new Teacher("rishabh","c++"));
            teachers.add(new Teacher("srishti","python"));
            teachers.add(new Teacher("prarthana","node.js"));
            teachers.add(new Teacher("gaurav","java"));
            teachers.add(new Teacher("shreya","machine l"));
            teachers.add(new Teacher("nitin","kotlin"));
            teachers.add(new Teacher("deepali","git"));
            teachers.add(new Teacher("aastha","blockchain"));
        }
        return teachers;
    }
}
