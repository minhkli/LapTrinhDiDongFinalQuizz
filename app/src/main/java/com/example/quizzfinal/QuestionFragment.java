package com.example.quizzfinal;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class QuestionFragment extends Fragment {
    public QuestionFragment() {
        super(R.layout.fragment_question);
    }

    private int count = 0;
    private Button btnQuestion;
    private TextView txtQuestion;

    private static final String COUNT_KEY = "COUNT_KEY";

    private String getPhrase() {
        if (count == 0)
            return " ";
        else
            return count + " /5";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtQuestion = view.findViewById(R.id.textQuestion);

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
    }
}