package com.example.quizzfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
    SendDataHome sendDataHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        binding.imgGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataHome.send("dialy");
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        binding.imgMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataHome.send("toanhoc");
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        binding.imgChem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataHome.send("hoahoc");
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        binding.imgHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataHome.send("lichsu");
                Navigation.findNavController(view).navigate(R.id.action_playFragment_to_levelFragment);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SendDataHome){
            sendDataHome = (SendDataHome) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sendDataHome = null;
    }
}