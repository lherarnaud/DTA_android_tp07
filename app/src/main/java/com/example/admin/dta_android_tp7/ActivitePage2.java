package com.example.admin.dta_android_tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivitePage2 extends AppCompatActivity {

    private boolean hasNextQuestion;

    public ActivitePage2() {
        hasNextQuestion = true;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_page2);

        showResponse(getIntent());
    }

    private void showResponse(Intent intent) {
        TextView ctl_textView_question = (TextView)findViewById(R.id.answeredQuestion);
        TextView ctl_textView_answer = (TextView)findViewById(R.id.goodAnswer);
        TextView ctl_textView_currentScore = (TextView)findViewById(R.id.result_currentScore);
        Button ctl_button_continue = (Button)findViewById(R.id.button_continue);

        hasNextQuestion = intent.getBooleanExtra("hasNext", true);
        String progress = intent.getIntExtra("score", 0) + "/" + intent.getIntExtra("total", 0);

        ctl_textView_question.setText(intent.getStringExtra("question"));
        ctl_textView_answer.setText(intent.getStringExtra("answer"));
        ctl_textView_currentScore.setText(progress);
        ctl_button_continue.setText(hasNextQuestion ? R.string.text_continue : R.string.text_finish);
    }

    public void button_continue(View view) {
        Intent returnIntent = new Intent();

        returnIntent.putExtra("hasNextQuestion", hasNextQuestion);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
