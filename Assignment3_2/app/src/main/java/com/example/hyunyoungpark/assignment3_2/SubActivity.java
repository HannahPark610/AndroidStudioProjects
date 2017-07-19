package com.example.hyunyoungpark.assignment3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hyunyoungpark on 2017-07-19.
 */

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);

        String savedExtra = getIntent().getStringExtra("MENU");
        TextView myText = (TextView) findViewById(R.id.linertextID);
        myText.setText(savedExtra);

        Button b = (Button)findViewById(R.id.Previous);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
