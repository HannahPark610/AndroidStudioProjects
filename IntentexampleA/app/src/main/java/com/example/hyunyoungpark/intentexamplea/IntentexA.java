package com.example.hyunyoungpark.intentexamplea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ciccc_cirac.intentexample.R;

/**
 * Created by CICCC-CIRAC on 7/7/2017.
 */

public class IntentexA extends AppCompatActivity {
    //1. declare all the controls
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentexample1);
        //2. bind all the controls

        t1 = (TextView) findViewById(R.id.txtA);
        b1 = (Button) findViewById(R.id.btnA);

        //3. define the onclicklistner event
        b1.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntentexA.this,IntentExB.class);
                startActivity(i);
            }
        });
    }


}
