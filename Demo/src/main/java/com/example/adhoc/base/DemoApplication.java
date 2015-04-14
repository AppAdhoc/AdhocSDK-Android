package com.example.adhoc.base;
import android.app.Application;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.utils.T;

public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        T.i("oncreate appContext");
        AdhocTracker.getInstance(this).getExperimentFlags();
        super.onCreate();
    }
}
