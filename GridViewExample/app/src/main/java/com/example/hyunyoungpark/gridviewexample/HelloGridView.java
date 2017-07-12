package com.example.hyunyoungpark.gridviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;



public class HelloGridView extends AppCompatActivity {

    GridView gv;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_ex);
        gv = (GridView)findViewById(R.id.gv1);
        gv.setAdapter(new ImageAdapter(this));

//use setOnItemClickListener on gridview and make a toast for item click event
    }
}
