package com.example.hyunyoungpark.assignment4_recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hyunyoungpark on 2017-07-28.
 */

public class JjeonActivity extends AppCompatActivity {


    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jjeon);

        Button b1 = (Button)findViewById(R.id.Previous);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CardActivity.class);
                startActivity(intent);
            }
        });

        Button b2 = (Button)findViewById(R.id.Next);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JjeonActivity.this, JjimdakActivity.class);
                startActivity(intent);
            }
        });
    }
}
