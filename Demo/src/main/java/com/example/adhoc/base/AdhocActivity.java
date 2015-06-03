package com.example.adhoc.base;

import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;

import com.adhoc.adhocsdk.AdhocTracker;


public class AdhocActivity extends ActionBarActivity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        AdhocTracker.autoTracking(this, event);

        return super.dispatchTouchEvent(event);
    }

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
