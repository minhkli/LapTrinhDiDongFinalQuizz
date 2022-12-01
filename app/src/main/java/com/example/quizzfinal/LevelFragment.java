package com.example.quizzfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentLevelBinding;

public class LevelFragment extends Fragment {
    FragmentLevelBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLevelBinding.inflate(inflater, container, false);
        binding.levelEasy.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
        });
        binding.levelMedium.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
        });
        binding.levelHard.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
        });
        return binding.getRoot();
    }
}