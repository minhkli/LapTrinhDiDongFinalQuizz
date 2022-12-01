package com.example.quizzfinal;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.quizzfinal.databinding.FragmentLevelBinding;
import com.example.quizzfinal.databinding.FragmentPlayBinding;
import com.example.quizzfinal.databinding.FragmentQuestionBinding;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class QuestionFragment extends Fragment {
    public QuestionFragment() {
        super(R.layout.fragment_question);
    }
    FragmentQuestionBinding binding;

    private int count = 0;
    //private Button btnAnswer1;
    //private Button btnAnswer2;
    //private TextView txtQuestion;
    //private ProgressBar progressbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentQuestionBinding.inflate(inflater, container, false);

        AssetManager assetManager = getContext().getAssets();
        InputStream is = null;
        OutputStream os ;
        String text = "";

        try {
            is = assetManager.open("mathEasy");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        binding.textQuestion.setText(text);

        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = binding.progressBar.getProgress();
                binding.progressBar.setProgress(count + 1);
            }
        });
        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = binding.progressBar.getProgress();
                binding.progressBar.setProgress(count + 1);
            }
        });

        return binding.getRoot();
    }

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtQuestion = view.findViewById(R.id.textQuestion);

        //binding = FragmentQuestionBinding.inflate(getLayoutInflater());
        //View view1 = binding.getRoot();

        //Read Question text file
        AssetManager assetManager = getContext().getAssets();
        InputStream is = null;
        OutputStream os ;
        String text = "";

        try {
            is = assetManager.open("mathEasy");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        txtQuestion.setText(text);


        // Text Count Question
        btnAnswer1 = view.findViewById(R.id.button_true);
        btnAnswer2 = view.findViewById(R.id.button_false);
        progressbar = view.findViewById(R.id.progressBar);
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = progressbar.getProgress();
                progressbar.setProgress(count + 1);
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = progressbar.getProgress();
                progressbar.setProgress(count + 1);
            }
        });
    }*/
}