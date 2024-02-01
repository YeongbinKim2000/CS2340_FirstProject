package com.example.cs2340_firstproject.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private ClassListViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(ClassListViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Construct the data source
        arrayOfClasses = new ArrayList<>();
        // Create the adapter to convert the array to views
        adapter = new ClassAdapter(getActivity(), viewModel.getClassItemList());
        // Attach the adapter to a ListView
        listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Set up the add, edit, and delete buttons
        Button addButton = rootView.findViewById(R.id.button_add);
        Button editButton = rootView.findViewById(R.id.button_edit);
        Button deleteButton = rootView.findViewById(R.id.button_delete);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        editButton.setOnClickListener(v -> {
            editClass();
        });

        deleteButton.setOnClickListener(v -> {
            deleteClass();
        });

        return rootView;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_class, null);

        final EditText editTextClassName = dialogView.findViewById(R.id.editTextClassName);
        final EditText editTextClassTime = dialogView.findViewById(R.id.editTextClassTime);
        final EditText editTextInstructorName = dialogView.findViewById(R.id.editTextInstructorName);

        builder.setView(dialogView)
                .setTitle("Add Class")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the entered information
                        String className = editTextClassName.getText().toString().trim();
                        String classTime = editTextClassTime.getText().toString().trim();
                        String instructorName = editTextInstructorName.getText().toString().trim();

                        // Validate the input
                        if (!className.isEmpty() && !classTime.isEmpty() && !instructorName.isEmpty()) {
                            // Add the new class to the ViewModel
                            ClassItem newClass = new ClassItem(className, classTime, instructorName);
                            viewModel.addClassItem(newClass);
                        } else {
                            Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            showDialog();
                        }
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void addClass() {
        adapter.notifyDataSetChanged();
    }

    private void editClass() {

    }

    private void deleteClass() {
        adapter.notifyDataSetChanged();
    }
}