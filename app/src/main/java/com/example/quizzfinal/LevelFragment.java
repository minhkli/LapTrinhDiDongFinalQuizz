package com.example.quizzfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentLevelBinding;

public class LevelFragment extends Fragment {
    FragmentLevelBinding binding;
    SendData sendData;
    SendDataHome sendDataHome;
    Bundle bundle;
    String monhoc = "";

    // get create dữ liệu
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {

        // get dữ liệu
        if (bundle != null) {
            Log.d("lod", getArguments().getString("monhoc"));
            monhoc = bundle.getString("monhoc");
        }

        // Inflate the layout for this fragment
        binding = FragmentLevelBinding.inflate(inflater, container, false);
        binding.levelEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
                sendData.sendLevel("de", monhoc);
            }
        });
        binding.levelMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
                sendData.sendLevel("trungbinh", monhoc);
            }
        });
        binding.levelHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_levelFragment_to_questionFragment);
                sendData.sendLevel("kho", monhoc);
            }
        });
        return binding.getRoot();
    }

    // set dữ liệu
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SendData) {
            sendData = (SendData) context;
        } else if (context instanceof SendDataHome) {
            sendDataHome = (SendDataHome) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sendData = null;
        sendDataHome = null;
    }
}