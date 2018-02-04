package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hatchi on 2018-02-01.
 */

public class QuizMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);
        Intent intent = getIntent();
        String message = intent.getStringExtra("result");

        TextView last = (TextView) findViewById(R.id.Score_message);
        last.setText(message);

        Button button = (Button)findViewById(R.id.restart);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent = new Intent(QuizMessage.this, MainActivity.class);
                startActivity(restartIntent);
            }
        });
    }
}
