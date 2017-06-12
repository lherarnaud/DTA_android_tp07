package com.example.admin.dta_android_tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitePage2 extends AppCompatActivity {

    private boolean hasNextQuestion;
    private int score;

    public ActivitePage2() {
        hasNextQuestion = true;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_page2);

        // On récupère l'intent qui a lancé cette activité
        Intent intent = getIntent();

        hasNextQuestion = intent.getBooleanExtra("hasNext", true);
        score = intent.getIntExtra("score", 0);

        String questionText = intent.getStringExtra("question");
        String answerText = intent.getStringExtra("answer");
        TextView questionControl = (TextView)findViewById(R.id.answeredQuestion);
        TextView answerControl = (TextView)findViewById(R.id.goodAnswer);

        questionControl.setText(questionText);
        answerControl.setText(answerText);

        Button continueButton = (Button)findViewById(R.id.button_continue);
        continueButton.setText(hasNextQuestion ? R.string.text_continue : R.string.text_finish);

    }

    public void button_continue(View view) {
        if(hasNextQuestion) {
            finish();
        }
        else
        {
            Intent intent = new Intent(ActivitePage2.this, ActivitePage3.class);
            intent.putExtra("finalScore", score);
            startActivity(intent);
        }
    }
}
