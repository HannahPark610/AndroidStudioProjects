package com.example.hyunyoungpark.prefrencesexample;

import android.os.Bundle;
import android.support.annotation.Nullable;


public class PreferenceFragment extends android.preference.PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
