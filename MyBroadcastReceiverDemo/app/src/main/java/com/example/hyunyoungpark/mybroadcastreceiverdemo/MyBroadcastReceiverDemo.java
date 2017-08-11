package com.example.hyunyoungpark.mybroadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiverDemo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("com.example.hyunyoungpark.mybroadcastreceiverdemo.MyBroadcastReceiverDemo.SOME_ACTION"))
            Toast.makeText(context,"SOME_ACTION is receivered",Toast.LENGTH_LONG).show();

        else {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConneted = activeNetwork!= null && activeNetwork.isConnectedOrConnecting();

            if(isConneted) {
                Toast.makeText(context,"NETWORK IS CONNECTED",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(context,"NETWORK IS CHANGED or DISCONNECTED",Toast.LENGTH_LONG).show();
            }
        }

    }
}
