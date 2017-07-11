package com.example.hyunyoungpark.assignment1_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class Assignment1_1 extends AppCompatActivity {

    Button buttonA3;
    Button buttonA2;
    Button buttonA1;
    Button buttonB3;
    Button buttonB2;
    Button buttonB1;
    Button buttonReset;
    TextView tvA, tvB;
    int scoreA = 0;
    int scoreB = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1_1);
        tvA = (TextView) findViewById(R.id.textViewA1);
        tvB = (TextView) findViewById(R.id.textViewB1);

        buttonA3 = (Button) findViewById(R.id.buttonA3);
        buttonB3 = (Button) findViewById(R.id.buttonB3);
        buttonA2 = (Button) findViewById(R.id.buttonA2);
        buttonB2 = (Button) findViewById(R.id.buttonB2);
        buttonA1 = (Button) findViewById(R.id.buttonA1);

        buttonA3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                scoreA = scoreA + 3;
                tvA.setText(String.valueOf(scoreA));

            }

        });
        buttonB3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                scoreB = scoreB + 3;
                tvB.setText(String.valueOf(scoreB));

            }

        });
        buttonA2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                scoreA = scoreA + 2;
                tvA.setText(String.valueOf(scoreA));

            }

        });
        buttonB2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                scoreB = scoreB + 2;
                tvB.setText(String.valueOf(scoreB));
            }

        });

    }

}