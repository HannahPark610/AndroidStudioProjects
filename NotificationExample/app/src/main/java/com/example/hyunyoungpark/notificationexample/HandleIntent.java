package com.example.hyunyoungpark.notificationexample;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by hyunyoungpark on 2017-08-25.
 */

public class HandleIntent extends IntentService {
    public HandleIntent()
    {
        super("HandelIntent");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        HandleAction.executeTask(this, action);
    }
}
