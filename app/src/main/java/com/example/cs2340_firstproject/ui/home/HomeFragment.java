package com.example.cs2340_firstproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cs2340_firstproject.R;
import com.example.cs2340_firstproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView listView;
    private ClassAdapter adapter;
    private ArrayList<ClassItem> arrayOfClasses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Construct the data source
        arrayOfClasses = new ArrayList<>();
        // Create the adapter to convert the array to views
        adapter = new ClassAdapter(getActivity(), arrayOfClasses);
        // Attach the adapter to a ListView
        listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Set up the item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ClassItem classItem = arrayOfClasses.get(position);
                // TODO: Start a new Fragment or Activity, passing the ClassItem details
                // You can use a Bundle to pass the details or initiate a custom listener
            }
        });

        // Populate the classes
        loadClasses();

        return rootView;
    }

    private void loadClasses() {
        // TODO: Load your classes into the arrayOfClasses
        // For example:
        arrayOfClasses.add(new ClassItem("Mathematics", "10:00 AM - 11:00 AM", "Prof. Smith"));
        // Notify the adapter that the data set has changed to refresh the ListView
        adapter.notifyDataSetChanged();
    }
}