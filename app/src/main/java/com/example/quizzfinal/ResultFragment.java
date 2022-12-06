package com.example.quizzfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizzfinal.databinding.FragmentResultBinding;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    TeamModelView viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false);
        binding.txtResult.setText(MainActivity.getScore().toString().trim() + " / 5");
        binding.complt.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_resultFragment_to_playFragment);
        });

        viewModel = new ViewModelProvider(requireActivity()).get(TeamModelView.class);
        return binding.getRoot();
    }
}