package com.example.hyunyoungpark.flagquizapp;

import android.preference.PreferenceFragment;
import android.os.Bundle;


public class SettingsActivityFragment extends PreferenceFragment {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
