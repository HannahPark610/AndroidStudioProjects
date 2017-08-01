package com.example.hyunyoungpark.prefrencesexample;


import android.preference.PreferenceFragment;
import android.os.Bundle;


// Subclass of PreferenceFragment for managing app settings
public class SettingsActivityFragment extends PreferenceFragment {
    // creates preferences GUI from preferences.xml file in res/xml

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
