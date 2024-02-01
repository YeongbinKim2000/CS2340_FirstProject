package com.example.cs2340_firstproject.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs2340_firstproject.R;
import com.example.cs2340_firstproject.databinding.ClassItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ClassAdapter extends ArrayAdapter<ClassItem> {
    public ClassAdapter(Context context, List<ClassItem> classes) {
        super(context, 0, classes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.class_item, parent, false);
        }
        // Get the data item for this position
        ClassItem classItem = getItem(position);

        // Populate the data into the template view using the data object
        TextView courseNameTextView = convertView.findViewById(R.id.courseName);
        TextView timeTextView = convertView.findViewById(R.id.time);
        TextView instructorTextView = convertView.findViewById(R.id.textViewInstructor);
        // Set the text for TextViews
        courseNameTextView.setText(classItem.getCourseName());
        timeTextView.setText(classItem.getTime());
        instructorTextView.setText(classItem.getInstructor());
        // Return the completed view to render on screen
        return convertView;
    }

    public void addClass(ClassItem classItem) {
        add(classItem);
    }
}