package com.example.cs2340_firstproject.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<ClassDetails>> classDetailsList;

    public HomeViewModel() {
        classDetailsList = new MutableLiveData<>();
        // Initialize the class details list here
    }

    public LiveData<List<ClassDetails>> getClassDetailsList() {
        return classDetailsList;
    }

    // Add methods for adding, editing, and deleting class details
    public void setClassDetailsList(List<ClassDetails> classDetailsList) {
        this.classDetailsList.setValue(classDetailsList);
    }

    public void addClassDetail(ClassDetails classDetail) {
        List<ClassDetails> currentList = classDetailsList.getValue();
        if (currentList != null) {
            currentList.add(classDetail);
            classDetailsList.setValue(currentList); // This will notify all observers
        }
    }

    // Method to edit an existing class
    public void editClassDetail(int index, ClassDetails classDetail) {
        List<ClassDetails> currentList = classDetailsList.getValue();
        if (currentList != null && index >= 0 && index < currentList.size()) {
            currentList.set(index, classDetail);
            classDetailsList.setValue(currentList); // This will notify all observers
        }
    }

    // Method to delete a class
    public void deleteClassDetail(int index) {
        List<ClassDetails> currentList = classDetailsList.getValue();
        if (currentList != null && index >= 0 && index < currentList.size()) {
            currentList.remove(index);
            classDetailsList.setValue(currentList); // This will notify all observers
        }
    }
}