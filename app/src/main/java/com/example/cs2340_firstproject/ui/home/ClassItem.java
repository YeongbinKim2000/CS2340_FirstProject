package com.example.cs2340_firstproject.ui.home;

import android.text.TextUtils;

import java.util.LinkedHashSet;

public class ClassItem {
    private String courseName;
    private String time;
    private String instructor;
    private boolean isSelected;
    private LinkedHashSet<String> daysOfWeek;

    // Constructor
    public ClassItem(String courseName, String time, String instructor, LinkedHashSet<String> daysOfWeek) {
        this.courseName = courseName;
        this.time = time;
        this.instructor = instructor;
        this.daysOfWeek = daysOfWeek;
    }

    // Getter and setter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Getter and setter for time
    public String getTime() {
        return time;
    }

    // Getter and setter for instructor
    public String getInstructor() {
        return instructor;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public LinkedHashSet<String> getDaysOfWeek() {
        return daysOfWeek;
    }
}
