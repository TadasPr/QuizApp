package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

/**
 * Created by Hatchi on 2018-01-23.
 */

public class Start_Activity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(Start_Activity.this, MainActivity.class);

                Start_Activity.this.startActivity(intent);
                Start_Activity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


}
