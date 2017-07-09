package com.example.ciccc_cirac.intentexampleb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

public class IntentexampleB extends AppCompatActivity {
    //1. declare all the controls
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentexample_b);
        //2. bind all the controls

        t1 = (TextView) findViewById(R.id.txtA);
        b1 = (Button) findViewById(R.id.btnA);

        //3. define the onclicklistner event
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http:\\www.google.com"));
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[] {"teyang610@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                i.putExtra(Intent.EXTRA_TEXT,"Body");
                startActivity(Intent.createChooser(i,"Send Email"));
            }
        });
    }
}
