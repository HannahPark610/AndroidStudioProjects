package com.example.hyunyoungpark.facebookintegrationdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.btn_share);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent
                        (Intent.ACTION_SEND);
                Uri img = Uri.parse(
                        "android.resource://com.example.hyunyoungpark.facebookintegrationdemo/*");
                try {
                    InputStream is = getContentResolver()
                            .openInputStream(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                shareIntent.setType("image/jpeg");
                shareIntent.putExtra(Intent.EXTRA_STREAM,img);
                startActivity(Intent.createChooser(shareIntent, "SHARING USING"));
            }
        });
    }
}
