package com.example.cs2340_firstproject.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("We need to insert a monthly calendar and add assignment and exam on each day.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}