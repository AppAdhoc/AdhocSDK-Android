package com.example.adhoc.base;

import android.app.Application;

import com.adhoc.adhocsdk.AdhocTracker;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AdhocTracker.initalize(this.getApplicationContext());
        AdhocTracker.setEnableDebugMode(true);
    }
}
