package com.example.cs2340_firstproject.ui.home;

import androidx.lifecycle.ViewModel;
import com.example.cs2340_firstproject.ui.home.ClassListViewModel;
import java.util.ArrayList;
import java.util.List;

public class ClassListViewModel extends ViewModel {
    private List<ClassItem> classItemList = new ArrayList<>();

    public List<ClassItem> getClassItemList() {
        return classItemList;
    }

    public void addClassItem(ClassItem classItem) {
        classItemList.add(classItem);
    }
}
