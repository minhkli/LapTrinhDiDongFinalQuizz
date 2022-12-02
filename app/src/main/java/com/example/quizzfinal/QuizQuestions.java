package com.example.quizzfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizQuestions extends AppCompatActivity {
    String question;
    Boolean answer;


    public QuizQuestions(String question, Boolean answer){
        question = question;
        this.answer = answer;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
