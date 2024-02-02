package com.example.cs2340_firstproject.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cs2340_firstproject.ui.home.ClassListViewModel;
import java.util.ArrayList;
import java.util.List;

public class ClassListViewModel extends ViewModel {
    private MutableLiveData<List<ClassItem>> classItemList = new MutableLiveData<>(new ArrayList<>());

    public void addClassItem(ClassItem newItem) {
        List<ClassItem> currentList = classItemList.getValue();
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        currentList.add(newItem);
        classItemList.setValue(currentList);
    }

    public LiveData<List<ClassItem>> getClassItemList() {
        return classItemList;
    }

    public void updateClassItem(int position, ClassItem updatedClass) {
        List<ClassItem> currentList = classItemList.getValue();
        if (currentList != null && position >= 0 && position < currentList.size()) {
            currentList.set(position, updatedClass);
            classItemList.setValue(currentList);
        }
    }

    public void deleteItems(List<ClassItem> itemsToDelete) {
        List<ClassItem> currentList = classItemList.getValue();
        if (currentList != null) {
            currentList.removeAll(itemsToDelete);
            classItemList.setValue(currentList); // This will update the LiveData and the UI
        }
    }

    public void removeClassItems(List<ClassItem> itemsToRemove) {
        List<ClassItem> currentItems = classItemList.getValue();
        if (currentItems != null) {
            currentItems.removeAll(itemsToRemove);
            classItemList.setValue(currentItems); // Update LiveData
        }
    }
}
