package com.example.quizzfinal;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentLevelBinding;

public class LevelFragment extends Fragment {
    FragmentLevelBinding binding;
    TeamModelView viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLevelBinding.inflate(inflater, container, false);
        binding.levelEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setLevel(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
            }
        });
        binding.levelMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setLevel(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
            }
        });
        binding.levelHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setLevel(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
            }
        });

        viewModel = new ViewModelProvider(requireActivity()).get(TeamModelView.class);
        return binding.getRoot();
    }
}