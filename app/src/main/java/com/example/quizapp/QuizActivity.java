package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private Button submitButton;
    private int score;
    private RadioGroup numOneRadioGroup;
    private RadioGroup numTwoRadioGroup;
    private RadioGroup numFiveRadioGroup;

    private EditText editText;
    private CheckBox sherCheckbox;
    private CheckBox gaganCheckbox;
    private CheckBox puspaCheckbox;
    private CheckBox madavCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        sherCheckbox = findViewById(R.id.sher_checkbox);
        gaganCheckbox = findViewById(R.id.gagan_checkbox);
        puspaCheckbox = findViewById(R.id.puspa_checkbox);
        madavCheckbox = findViewById(R.id.madav_checkbox);
        numOneRadioGroup = findViewById(R.id.num_one_radio_group);
        numTwoRadioGroup = findViewById(R.id.num_two_radio_group);
        numFiveRadioGroup = findViewById(R.id.num_five_radio_group);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score = 0;

                if (numOneRadioGroup.getCheckedRadioButtonId() == R.id.king_radio){
                    score += 1;
                }

                if (numTwoRadioGroup.getCheckedRadioButtonId() == R.id.damascus_radio){
                    score += 1;
                }

                if (numFiveRadioGroup.getCheckedRadioButtonId() == R.id.seven_radio){
                    score += 1;
                }

                String userAnswer = editText.getText().toString();
                if (userAnswer.equalsIgnoreCase("Tribhuvan")){
                    score += 1;
                }

                if (sherCheckbox.isChecked() && puspaCheckbox.isChecked() && madavCheckbox.isChecked() && !gaganCheckbox.isChecked()){
                    score += 1;
                }

                Intent  intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score+"/5");
                startActivity(intent);
            }
        });
    }
}
