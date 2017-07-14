package com.example.hyunyoungpark.assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class ActivityMain extends AppCompatActivity {


    TextView tvA, tvB, tvC, tvD, tvE, tvF, tvG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        tvA = (TextView) findViewById(R.id.LinerLayout);
        tvB = (TextView) findViewById(R.id.RelativeLayout);
        tvC = (TextView) findViewById(R.id.TableLayout);
        tvD = (TextView) findViewById(R.id.FrameLayout);
        tvE = (TextView) findViewById(R.id.ListView);
        tvF = (TextView) findViewById(R.id.GridView);
        tvG = (TextView) findViewById(R.id.RecyclerView);


    }

}
