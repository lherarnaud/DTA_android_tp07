package com.example.admin.dta_android_tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitePage1 extends AppCompatActivity {

    private int index;
    private int score;

    private VraiFaux currentQuestion;

    public ActivitePage1() {
        index = 0;
        score = 0;
    }

    private VraiFaux questions[] = new VraiFaux[] {
            new VraiFaux("La nuit, il fait :", "jour", "noir", false),
            new VraiFaux("Java est un langage :", "à prototype", "objet", false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_page1);

        setNextQuestion();
        showNextQuestion();
    }

    public void answer_choice1(View view) {
        checkAnswer(true);
    }

    public void answer_choice2(View view) {
        checkAnswer(false);
    }

    private void checkAnswer(boolean yourAnswer) {
        Log.d("BUTTON", "Button "+yourAnswer);

        VraiFaux current = currentQuestion;
        if(current != null) {
            boolean goodAnswer = current.getAnswer();
            boolean isGood = (goodAnswer == yourAnswer);
            if (isGood) {
                score++;
            }

            setNextQuestion();

            Intent intent = new Intent(ActivitePage1.this, ActivitePage2.class);
            intent.putExtra("question", current.getQuestion());
            intent.putExtra("answer", goodAnswer ? current.getPurpose1() : current.getPurpose2());
            intent.putExtra("good", isGood);

            if(currentQuestion != null) {
                intent.putExtra("hasNext", true);
                startActivity(intent);
                showNextQuestion();
            } else {
                intent.putExtra("hasNext", false);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        }
    }

    private void setNextQuestion() {
        currentQuestion = (index < questions.length ? questions[index++] : null);
    }

    private void showNextQuestion() {
        if(currentQuestion != null) {
            TextView questionText = (TextView)findViewById(R.id.questionToAnswer);
            TextView purpose1Text = (TextView)findViewById(R.id.purpose1);
            TextView purpose2Text = (TextView)findViewById(R.id.purpose2);

            questionText.setText(currentQuestion.getQuestion());
            purpose1Text.setText(currentQuestion.getPurpose1());
            purpose2Text.setText(currentQuestion.getPurpose2());

        }
    }

}
