package com.example.hyunyoungpark.prefrencesexample;

import android.os.Bundle;

/**
 * Created by hyunyoungpark on 2017-07-28.
 */

public class PreferenceFragment extends android.preference.PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
