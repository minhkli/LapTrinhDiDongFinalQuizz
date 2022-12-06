package com.example.quizzfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment{
    public QuestionFragment() {
        super(R.layout.fragment_question);
    }
    FragmentQuestionBinding binding;
    private int count = 0;
    private TeamModelView viewModel;
    private Integer score = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentQuestionBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(TeamModelView.class);
        loadQuestion();
        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = binding.progressBar.getProgress();
                binding.progressBar.setProgress(count + 1);
                AppCompatButton button = (AppCompatButton) view;
                checkAnswer(button);
                if (count == 4) {
                    viewModel.setScore(score);
                    Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_resultFragment);
                }
                else {
                    switchQuestion();
                }
            }
        });
        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = binding.progressBar.getProgress();
                binding.progressBar.setProgress(count + 1);
                checkAnswer(binding.buttonFalse);
                if (count == 4) {
                    viewModel.setScore(score);
                    Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_resultFragment);
                } else {
                    switchQuestion();
                }
            }
        });


        return binding.getRoot();
    }

    private void loadQuestion () {
        switch (MainActivity.getTopic()) {
            case "ĐỊA LÝ":
                if (MainActivity.getLevel().equals("Dễ")) binding.textQuestion.setText(DiaQues.easy_question[count]);
                else if (MainActivity.getLevel().equals("Trung Bình")) binding.textQuestion.setText(DiaQues.medium_question[count]);
                else binding.textQuestion.setText(DiaQues.hard_question[count]);
                break;
            case "TOÁN HỌC":
                if (MainActivity.getLevel().equals("Dễ")) binding.textQuestion.setText(ToanQues.easy_question[count]);
                else if (MainActivity.getLevel().equals("Trung Bình")) binding.textQuestion.setText(ToanQues.medium_question[count]);
                else binding.textQuestion.setText(ToanQues.hard_question[count]);
                break;
            case "HÓA HỌC":
                if (MainActivity.getLevel().equals("Dễ")) binding.textQuestion.setText(HoaQues.easy_question[count]);
                else if (MainActivity.getLevel().equals("Trung Bình")) binding.textQuestion.setText(HoaQues.medium_question[count]);
                else binding.textQuestion.setText(HoaQues.hard_question[count]);
                break;
            case "LỊCH SỬ":
                if (MainActivity.getLevel().equals("Dễ")) binding.textQuestion.setText(LichsuQues.easy_question[count]);
                else if (MainActivity.getLevel().equals("Trung Bình")) binding.textQuestion.setText(LichsuQues.medium_question[count]);
                else binding.textQuestion.setText(LichsuQues.hard_question[count]);
                break;
        }
    }

    private void switchQuestion() {
        count++;
        loadQuestion();
    }

    private void checkAnswer(AppCompatButton button) {
        switch (MainActivity.getTopic()) {
            case "ĐỊA LÝ":
                if (MainActivity.getLevel().equals("Dễ") && button.getText().equals(DiaQues.easy_correct[count]))
                    score++;
                else if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(DiaQues.medium_correct[count]))
                    score++;
                else  if (MainActivity.getLevel().equals("Khó") && button.getText().equals(DiaQues.hard_correct[count]))
                    score++;
                break;
            case "TOÁN HỌC":
                if (MainActivity.getLevel().equals("Dễ") && button.getText().equals(ToanQues.easy_correct[count]))
                    score++;
                else if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(ToanQues.medium_correct[count]))
                    score++;
                else  if (MainActivity.getLevel().equals("Khó") && button.getText().equals(ToanQues.hard_correct[count]))
                    score++;
                break;
            case "HOÁ HỌC":
                if (MainActivity.getLevel().equals("Dễ") && button.getText().equals(HoaQues.easy_correct[count]))
                    score++;
                else if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(HoaQues.medium_correct[count]))
                    score++;
                else  if (MainActivity.getLevel().equals("Khó") && button.getText().equals(HoaQues.hard_correct[count]))
                    score++;
                break;
            case "LỊCH SỬ":
                if (MainActivity.getLevel().equals("Dễ") && button.getText().equals(LichsuQues.easy_correct[count]))
                    score++;
                else if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(LichsuQues.medium_correct[count]))
                    score++;
                else  if (MainActivity.getLevel().equals("Khó") && button.getText().equals(LichsuQues.hard_correct[count]))
                    score++;
                break;
        }
    }
}