package com.example.cs2340_firstproject.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import androidx.preference.PreferenceManager;

import com.example.cs2340_firstproject.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;

    private Switch switch1;
    private Switch switch2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        switch1 = binding.switch1;
        switch2 = binding.switch2;

        switch1.setChecked(true);
        switch2.setChecked(true);

        boolean classesSwitch = switch1.isChecked();
        boolean assignmentsSwitch = switch2.isChecked();


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("switch1_key", classesSwitch);
        editor.putBoolean("switch2_key", assignmentsSwitch);

        editor.apply();

        return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
