package com.example.adhoc.activities;

import android.os.Bundle;

import com.adhoc.adhocsdk.AdhocTracker;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class PageOrderSuccessActivity extends AdhocActivity {
    private int order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageorder_success);
        order = getIntent().getIntExtra("order",0);
        findViewById(R.id.tv_compelete);
        AdhocTracker.track("buy_success",1);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
