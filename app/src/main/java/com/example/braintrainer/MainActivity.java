package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button1;
    TextView problemText;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofCorrectAnswer;
    TextView resultText;
    int score=0;
    int numberofQuestions;
    TextView scoreText;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextView timerText;
    Button button6;
    ConstraintLayout newCons;



    public void playAgain(View view){
        score = 0;
        numberofQuestions = 0;
        timerText.setText("30s");
        scoreText.setText(Integer.toString(score) + "/" + Integer.toString(numberofQuestions));

        newQuestion();
        button6.setVisibility(View.INVISIBLE);


        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long l) {
                timerText.setText(String.valueOf(l / 1000) + "s");

            }

            @Override
            public void onFinish() {
                resultText.setText("Done");
                button6.setVisibility(View.VISIBLE);

            }
        }.start();


    }


    public void chooseAnswer(View view) {
        if (Integer.toString(locationofCorrectAnswer).equals(view.getTag().toString())) {

            resultText.setText("Correct!");
            score++;
        } else {
            resultText.setText("Wrong :(");
        }
        numberofQuestions++;
        scoreText.setText(Integer.toString(score) + "/" + Integer.toString(numberofQuestions));
        newQuestion();




    }
     public void goButton(View view){
            try{ button1.setVisibility(View.INVISIBLE);
            newCons.setVisibility(View.VISIBLE);
            playAgain(findViewById(R.id.timerText));
        }
        catch(Exception e){
                Log.e("asdf",e.getLocalizedMessage());
        }


    }

    public void newQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(30);
        int b = rand.nextInt(30);

        problemText.setText(Integer.toString(a) + "+" + Integer.toString(b));
        locationofCorrectAnswer = rand.nextInt(4);
        answers.clear();


        for(int i=0; i<4; i++){
            if (i == locationofCorrectAnswer) {
                answers.add(a+b);
            }else {
                int wrongAnswer = rand.nextInt(60);
                while (wrongAnswer == a+b){
                    wrongAnswer = rand.nextInt(60);
                }
                answers.add(wrongAnswer);
            }
        }
        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        problemText = findViewById(R.id.problemText);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        resultText = findViewById(R.id.resultText);
        scoreText = findViewById(R.id.scoreText);
        button1 = findViewById(R.id.button1);
        timerText = findViewById(R.id.timerText);
        button6 = findViewById(R.id.button6);
        button1.setVisibility(View.VISIBLE);
        newCons = findViewById(R.id.newCons);







    }
}
