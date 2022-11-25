package com.example.quizzfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentPlayBinding;

public class PlayFragment extends Fragment {
    FragmentPlayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        binding.imageGeo.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
        });
        binding.imageMath.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
        });
        binding.imageChem.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
        });
        binding.imageHistory.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
        });
        return binding.getRoot();
    }
}