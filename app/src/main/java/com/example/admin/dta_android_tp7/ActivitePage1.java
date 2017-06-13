package com.example.admin.dta_android_tp7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ActivitePage1 extends AppCompatActivity {

    static final int CONTINUE_REQUEST = 1;  // The request code

    private int index;
    private int score;

    private VraiFaux currentQuestion;

    public ActivitePage1() {
        index = 0;
        score = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_page1);

        showNextQuestion();
    }


    private boolean hasNextQuestion() {
        return (index < VraiFaux.questions.length);
    }

    private VraiFaux getNextQuestion() {
        return (index < VraiFaux.questions.length ? VraiFaux.questions[index++] : null);
    }

    /**
     *  Show the next question if exists
     */
    private void showNextQuestion() {
        if(hasNextQuestion())
        {
            currentQuestion =  getNextQuestion();
            TextView ctl_textView_question = (TextView)findViewById(R.id.questionToAnswer);
            TextView ctl_textView_purpose1 = (TextView)findViewById(R.id.purpose1);
            TextView ctl_textView_purpose2 = (TextView)findViewById(R.id.purpose2);

            ctl_textView_question.setText(currentQuestion.getQuestion());
            ctl_textView_purpose1.setText(currentQuestion.getPurpose1());
            ctl_textView_purpose2.setText(currentQuestion.getPurpose2());

        }
    }

    public void answer_choice1(View view) {
        checkAnswer(true);
    }

    public void answer_choice2(View view) {
        checkAnswer(false);
    }

    /**
     *  Checks user response
     */
    private void checkAnswer(boolean yourAnswer) {
        if(currentQuestion != null) {

            boolean response = currentQuestion.getAnswer();
            boolean isGood = (response == yourAnswer);
            score += isGood ? 1 : 0;

            Intent intent = new Intent(ActivitePage1.this, ActivitePage2.class);
            intent.putExtra("question", currentQuestion.getQuestion());
            intent.putExtra("answer", response ? currentQuestion.getPurpose1() : currentQuestion.getPurpose2());
            intent.putExtra("good", isGood);
            intent.putExtra("hasNext", hasNextQuestion());
            intent.putExtra("score", score);
            intent.putExtra("total", index);

            startActivityForResult(intent, CONTINUE_REQUEST);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check which request we're responding to
        if (requestCode == CONTINUE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                // Tests if I have a next question
                if(data.getBooleanExtra("hasNextQuestion", false))
                {
                    showNextQuestion();
                }
                else
                {
                    // I finished the quizz, I will obtain my score
                    Intent intent = new Intent(ActivitePage1.this, ActivitePage3.class);
                    intent.putExtra("finalScore", score);
                    intent.putExtra("finalTotal", index);
                    startActivity(intent);
                }
            }
        }
    }

}
