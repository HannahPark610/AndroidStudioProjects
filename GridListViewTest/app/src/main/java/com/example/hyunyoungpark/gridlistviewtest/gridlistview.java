package com.example.hyunyoungpark.gridlistviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;



public class gridlistview extends AppCompatActivity {

    GridView gv;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlistview);
        gv = (GridView)findViewById(R.id.gv1);
        gv.setAdapter(new ImageAdapter(this));

//use setOnItemClickListener on gridview and make a toast for item click event
    }
}
