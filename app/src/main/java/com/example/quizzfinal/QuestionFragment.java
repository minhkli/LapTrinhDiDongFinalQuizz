package com.example.quizzfinal;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
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
import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.Util;

public class QuestionFragment extends Fragment{
    public QuestionFragment() {
        super(R.layout.fragment_question);
    }
    FragmentQuestionBinding binding;
    private int count = 0;
    private SendResult sendResult;
    private Bundle bundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    List<Question> list;
    String json = "";

    String cap = "", monhoc = "";
    private int index = 0;
    private int result = 0;

    // ánh xạ set view
    public void init(int i) {
        binding.textQuestion.setText(list.get(i).getQuestion());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // get dữ liệu
        if (bundle != null) {
            Log.d("lod", getArguments().getString("mess"));
            cap = bundle.getString("mess");
            monhoc = bundle.getString("monhoc");
        }

        System.out.println(cap);

        binding = FragmentQuestionBinding.inflate(inflater, container, false);

        if (cap.equals("de") && monhoc.equals("hoa")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.hoahoc_de);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("trungbinh") && monhoc.equals("hoahoc")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.hoahoc_trungbinh);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("kho") && monhoc.equals("hoa")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.hoahoc_kho);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("de") && monhoc.equals("dialy")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.dialy_de);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("trungbinh") && monhoc.equals("dialy")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.dialy_trungbinh);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("kho") && monhoc.equals("dialy")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.dialy_kho);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("de") && monhoc.equals("toanhoc")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.toanhoc_de);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("trungbinh") && monhoc.equals("toanhoc")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.toanhoc_trungbinh);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("kho") && monhoc.equals("toanhoc")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.toanhoc_kho);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("de") && monhoc.equals("lichsu")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.lichsu_de);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("trungbinh") && monhoc.equals("lichsu")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.lichsu_trungbinh);
            list = Read.getList(json);
            init(index);
        } else if (cap.equals("kho") && monhoc.equals("lichsu")) {
            json = Read.getJsonFromAssets(getContext(), R.raw.lichsu_kho);
            list = Read.getList(json);
            init(index);
        }


        /*AssetManager assetManager = getContext().getAssets();
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
        binding.textQuestion.setText(text);*/

        // Add cau hoi - Nguyen

        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.buttonTrue.getText().toString().equals(list.get(index).getCorrect())) {
                    result++;
                }
                count = binding.progressBar.getProgress();
                binding.progressBar.setProgress(count + 1);
                if (count == 5) {
                    Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_resultFragment);
                }
            }
        });

        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = binding.progressBar.getProgress();
                binding.progressBar.setProgress(count + 1);
                if (count == 5) {
                    Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_resultFragment);
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SendResult) {
            sendResult = (SendResult) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sendResult = null;
    }
}