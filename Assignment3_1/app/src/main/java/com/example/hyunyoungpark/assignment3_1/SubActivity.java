package com.example.hyunyoungpark.assignment3_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        // 이전 액티비티로부터 넘어온 데이터를 꺼낸다.
     //   String title = getIntent().getStringExtra("title");
     //   String description = getIntent().getStringExtra("description");
     //   int color = getIntent().getIntExtra("color", Color.WHITE);
    }

    public void clicked1 (View v1) {

        finish();
    }
}