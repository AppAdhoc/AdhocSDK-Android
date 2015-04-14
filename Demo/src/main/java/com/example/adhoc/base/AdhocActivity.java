package com.example.adhoc.base;

import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;

import com.adhoc.adhocsdk.AdhocTracker;


public class AdhocActivity extends ActionBarActivity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        AdhocTracker.getInstance(this).autoTracking(event);

        return super.dispatchTouchEvent(event);
    }
}
