package com.example.adhoc.base;

import android.app.Application;

import com.adhoc.adhocsdk.AdhocTracker;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AdhocTracker.init(this,"ADHOC_50000000000000ad80c23462");
    }
}
