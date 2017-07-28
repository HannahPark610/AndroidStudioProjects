package com.example.hyunyoungpark.prefrencesexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hyunyoungpark on 2017-07-28.
 */

public class PreferenceActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().
                beginTransaction().
                replace(android.R.id.content, new PreferenceFragment()).commit();
    }
}
