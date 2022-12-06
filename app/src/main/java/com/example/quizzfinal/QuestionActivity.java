package com.example.quizzfinal;




import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question, qCount, timer;
    private Button option1,option2;
    private List<Question> questionList;
    private int quesNum;
    private CountDownTimer countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_list_item);

        question = findViewById(R.id.QuestionBT);
        qCount = findViewById(R.id.textView6);
        timer = findViewById(R.id.countdown);

        option1 = findViewById(R.id.TrueBT);
        option2 = findViewById(R.id.FalseBT);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);

        getQuestionList();
    }

    private void getQuestionList(){
        questionList = new ArrayList<>();
        //Add cau hoi
        questionList.add(new Question("Chung ta la ai?","Con Ga","Con vit",0));
        questionList.add(new Question("Chung ta la gi nao?","Cu Xu Hao","Cu Cai",0));
        questionList.add(new Question("Chung ta la ai3?","Con Ga","Con vit",0));
        questionList.add(new Question("Chung ta la ai4?","Con Ga","Con vit",0));
        questionList.add(new Question("Chung ta la ai5?","Con Ga","Con vit",0));

        setQuestion();

    }

    private void setQuestion()
    {
        timer.setText(String.valueOf(10));
        //Set cau hoi va dap an
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());

        //Set so luong cau hoi (VD: 1/6 2/6)
        qCount.setText(String.valueOf(1)+"/"+String.valueOf(questionList.size()));

        startTimer();

        quesNum = 0;

    }
    //Day la add sau 10s thi doi cau hoi
    //Cai nay thay duoc bang click xong next cung oke
    private void startTimer() {
        CountDownTimer countDown = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 10000)
                    timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };

        countDown.start();
    }

    @Override
    public void onClick(View v) {

        //Day la chon cau hoi nao thi nhan so tuong ung, gan cau hoi la 0 voi 1

        int selectedOption = 0;

        switch (v.getId()){
            case R.id.TrueBT:
                selectedOption = 1;
                break;

            case R.id.FalseBT:
                selectedOption = 2;
                break;
            default:

        }
        countDown.cancel();
        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view)
    {
        if(selectedOption == questionList.get(quesNum).getCorrectAns()){
            //Right Answer thi hien mau xanh
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

        }
        else
        {
            //Wrong Answer thi hien mau do
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            //Hien dap an tung truong hop dung sai khac nhau
            switch (questionList.get(quesNum).getCorrectAns())
            {
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        },2000);

    }

    private void changeQuestion() {
        if( quesNum < questionList.size()-1){

            quesNum++;
            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);

            //Day la in ra cau hoi thu bao nhieu tren tong so may cau
            qCount.setText(String.valueOf(quesNum+1) + "/" + String.valueOf(questionList.size()));

            timer.setText(String.valueOf(10));
            startTimer();

        }
        else{
            //Day la truong hop thua cai out luon (hinh nhu la the)
            //Intent intent = new Intent(TESTQuestionActivity.this,ScoreActivity.class);
            //startActivity(intent);
            QuestionActivity.this.finish();
        }
    }
    //Cai nay la sau khi chon moi cau den cau tiep theo thi la hieu ung chuyen canh sang cau moi, va them ca lay cau tiep theo luon
    private void playAnim(View view, final int value,int viewNum)
    {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(value == 0){
                            switch (viewNum)
                            {
                                case 0:
                                    ((TextView)view).setText(questionList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(questionList.get(quesNum).getOption1());
                                    break;
                                case 2:
                                    ((Button)view).setText(questionList.get(quesNum).getOption2());
                                    break;
                            }
                            if(viewNum !=0)
                                ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                            playAnim(view,1,viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}