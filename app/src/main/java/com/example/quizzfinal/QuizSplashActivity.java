package com.example.quizzfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class QuizSplashActivity extends AppCompatActivity {

    public static ArrayList<QuizQuestions> listofQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question);

        listofQ=new ArrayList<>();
        listofQ.add(new QuizQuestions("Ha Noi la thanh pho?",true));
        listofQ.add(new QuizQuestions("Co 63 tinh thanh tren ca nuoc?",true));
        listofQ.add(new QuizQuestions("Co tat ca 5 dai duong?",true));
        listofQ.add(new QuizQuestions("Ho Chi Minh la thu do cua Viet Nam?",false));
        listofQ.add(new QuizQuestions("Ca Mau nam o phia Bac?",false));



    }
}