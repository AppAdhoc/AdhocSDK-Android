package com.example.adhoc.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.adhoc.adhocsdk.AdhocTracker;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class TrackingActivity extends AdhocActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        TextView tv_tracking = (TextView) findViewById(R.id.tv_tracking);
        tv_tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 统计key：‘payment’ value：123. "Payment" 为ADHOC 网站后台定义。
                AdhocTracker.getInstance(TrackingActivity.this).incrementStat("Payment",123);
                Toast.makeText(TrackingActivity.this,"上报统计信息到ADHOC后台",Toast.LENGTH_LONG).show();
            }
        });

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
