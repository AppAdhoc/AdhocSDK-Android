package com.example.adhoc.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        AdhocTracker.incrementStat(PageOrderSuccessActivity.this,"buy_success",1);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tracking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
