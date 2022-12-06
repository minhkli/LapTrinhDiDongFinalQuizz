package com.example.quizzfinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentLevelBinding;
import com.example.quizzfinal.databinding.FragmentPlayBinding;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class PlayFragment extends Fragment {
    FragmentPlayBinding binding;
    private TeamModelView viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        binding.imgGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setTopic(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        binding.imgMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setTopic(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        binding.imgChem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setTopic(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        binding.imgHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatButton button = (AppCompatButton) view;
                viewModel.setTopic(button.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        viewModel = new ViewModelProvider(requireActivity()).get(TeamModelView.class);
        return binding.getRoot();
    }
}