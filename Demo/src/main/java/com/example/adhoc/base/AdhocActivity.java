package com.example.adhoc.base;

import android.support.v7.app.ActionBarActivity;

import com.adhoc.adhocsdk.AdhocTracker;


public class AdhocActivity extends ActionBarActivity {

    @Override
    protected void onResume() {
        super.onResume();
        AdhocTracker.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AdhocTracker.onPause(this);
    }

}
