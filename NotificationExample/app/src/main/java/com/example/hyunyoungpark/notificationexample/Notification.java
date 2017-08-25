package com.example.hyunyoungpark.notificationexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void testNotification(View view)
    {
        NotificationUtil.reminderUser(this);
    }
}
