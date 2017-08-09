package com.example.hyunyoungpark.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by hyunyoungpark on 2017-08-09.
 */

public class SleeperClass extends IntentService{

    public SleeperClass() {
        super("Sleeper");
    }
    long seconds;

    @Override
    protected void onHandleIntent(Intent intent) {
        seconds = intent.getExtras().getLong("seconds");
        long milliseconds = seconds * 1000;

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public  void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Thread is Destroyed", Toast.LENGTH_LONG).show();

    }
}
