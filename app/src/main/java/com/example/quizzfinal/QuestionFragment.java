package com.example.quizzfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
    private int count = 0;
    private Button btnQuestion;
    private TextView textQuestion;

    private static final String COUNT_KEY = "COUNT_KEY";

    private String getPhrase() {
        if (count == 0)
            return " ";
        else
            return count + " /5";
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }
}