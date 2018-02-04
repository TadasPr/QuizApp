package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int result;

    RadioGroup change_dir_3, rm_entry_4, script_entry_1, path_2, network_entry_2, content_1, pwd_3, gnu_2;
    EditText ssh_entry, userName;
    CheckBox ls_entry_1, ls_entry_2, ls_entry_3, ls_entry_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        values();


    }

    private void values(){

        change_dir_3 = (RadioGroup) findViewById(R.id. question_1);
        rm_entry_4 = (RadioGroup) findViewById(R.id. question_3);
        script_entry_1 = (RadioGroup) findViewById(R.id.question_4);
        path_2 = (RadioGroup) findViewById(R.id. question_6);
        network_entry_2 = (RadioGroup) findViewById(R.id.question_7);
        content_1 = (RadioGroup) findViewById(R.id.question_8);
        pwd_3 = (RadioGroup) findViewById(R.id.question_9);
        gnu_2 = (RadioGroup) findViewById(R.id.question_10);

        ssh_entry= (EditText) findViewById(R.id.ssh_entry);


        ls_entry_1 = (CheckBox) findViewById(R.id.ls_entry_1);
        ls_entry_3 = (CheckBox) findViewById(R.id.ls_entry_3);
        ls_entry_2 = (CheckBox) findViewById(R.id.ls_entry_2);
        ls_entry_4 = (CheckBox) findViewById(R.id.ls_entry_4);

        userName = (EditText) findViewById(R.id.name);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton();
            }
        });


    }
    private void giveError(){
        Toast.makeText(this, "Please select an answer!",Toast.LENGTH_LONG).show();
    }

    private void submitButton(){
        result = 0;

        if (change_dir_3.getCheckedRadioButtonId() == R.id.change_dir_3){
            result +=10;
        } else if (change_dir_3.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }

        String question_2 = ssh_entry.getText().toString().toLowerCase();
        if (question_2.equals("ssh")){
            result+=10;
        } else {
        result+=0;
    }

        if (rm_entry_4.getCheckedRadioButtonId() == R.id.rm_enter_4){
            result +=10;
        } else if (rm_entry_4.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }
        if (script_entry_1.getCheckedRadioButtonId() == R.id.scrip_entry_1){
            result +=10;
        } else if (change_dir_3.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }

        if (ls_entry_1.isChecked() && ls_entry_3.isChecked() && ls_entry_4.isChecked() && ls_entry_2.isChecked()){
            Toast.makeText(this, "Please select only Two answers!",Toast.LENGTH_LONG).show();
            return;
        }

        if (ls_entry_1.isChecked()){
            result+=5;
        }

        if (ls_entry_3.isChecked()){
            result+=5;
        }

        if (path_2.getCheckedRadioButtonId() == R.id.path_2){
            result +=10;
        } else if (path_2.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }
        if (network_entry_2.getCheckedRadioButtonId() == R.id.network_entry_2){
            result +=10;
        } else if (network_entry_2.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }
        if (content_1.getCheckedRadioButtonId() == R.id.content_1){
            result +=10;
        } else if (content_1.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }
        if (pwd_3.getCheckedRadioButtonId() == R.id.pwd_3){
            result +=10;
        } else if (pwd_3.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }
        if (gnu_2.getCheckedRadioButtonId() == R.id.gnu_2){
            result +=10;
        } else if (gnu_2.getCheckedRadioButtonId()== -1){
            giveError();
            return;
        }

        displayResult(result);

    }

    private void displayResult (int score){
        String name = userName.getText().toString();
        String message = name + "\nYour score: " + String.valueOf(score) + " of 100 points";
        Intent intent = new Intent(this, QuizMessage.class);
        intent.putExtra("result", message);
        this.startActivity(intent);
    }


}
