package com.example.fragment;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class PreferenceFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preference_fragment_layout);
    }
}
