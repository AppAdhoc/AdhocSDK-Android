package com.example.adhoc.base;

import android.app.Application;

import com.adhoc.adhocsdk.AdhocTracker;

import java.util.HashMap;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AdhocTracker.init(this,"ADHOC_50000000000000ad80c23462");
    HashMap<String,String> map = new HashMap<>();
    map.put("key","value");
    AdhocTracker.setCustomStatParameter(this.getApplicationContext(),map);
}
}
