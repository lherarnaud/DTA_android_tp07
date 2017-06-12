package com.example.admin.dta_android_tp7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitePage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_page3);

        // On récupère l'intent qui a lancé cette activité
        Intent intent = getIntent();
        String score = String.valueOf(intent.getIntExtra("finalScore", 0));
        TextView result = (TextView)findViewById(R.id.result_finalScore);
        result.setText(score);
    }
}
