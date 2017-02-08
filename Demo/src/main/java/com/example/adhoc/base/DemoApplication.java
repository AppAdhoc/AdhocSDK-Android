package com.example.adhoc.base;

import android.app.Application;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.config.AdhocConfig;

public class DemoApplication extends Application {

    private static final String ADHOC_KEY = "ADHOC_50000000000000ad80c23462";

    @Override
    public void onCreate() {
        super.onCreate();
        AdhocConfig adhocConfig = new AdhocConfig.Builder()
                .appKey(ADHOC_KEY)
                .context(this)
                .addCustom("key","value")
                .build();

        AdhocTracker.init(adhocConfig);
    }
}
