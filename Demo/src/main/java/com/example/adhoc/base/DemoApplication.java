package com.example.adhoc.base;

import android.app.Application;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.config.AdhocConfig;

public class DemoApplication extends Application {

    private static final String ADHOC_KEY = "XXX";//xxx替换为adhoc的appkey

    @Override
    public void onCreate() {
        super.onCreate();
        AdhocConfig adhocConfig = new AdhocConfig.Builder()
                .appKey(ADHOC_KEY)
                .context(this)
                .enableDebugAssist(true)
                .build();

        AdhocTracker.init(adhocConfig);
    }
}
