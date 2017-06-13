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
        TextView ctl_textView_result = (TextView)findViewById(R.id.result_finalScore);

        String progress = intent.getIntExtra("finalScore", 0) + "/" + intent.getIntExtra("finalTotal", 0);
        ctl_textView_result.setText(progress);
    }
}
