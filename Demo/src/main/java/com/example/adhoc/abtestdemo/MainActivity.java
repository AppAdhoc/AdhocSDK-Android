package com.example.adhoc.abtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.adhoc.activities.BtnColorActivity;
import com.example.adhoc.activities.ClickAutoStatActivity;
import com.example.adhoc.activities.FlagTestActivity;
import com.example.adhoc.activities.TrackingActivity;
import com.example.adhoc.base.AdhocActivity;



public class MainActivity extends AdhocActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块开关例子
                startActivity(new Intent(MainActivity.this, FlagTestActivity.class));

            }
        });
        findViewById(R.id.btn_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块开关例子
                startActivity(new Intent(MainActivity.this, BtnColorActivity.class));

            }
        });

        findViewById(R.id.btn_track).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 统计计数例子
                startActivity(new Intent(MainActivity.this, TrackingActivity.class));

            }
        });
        findViewById(R.id.btn_autotrack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 点击自动统计例子
                startActivity(new Intent(MainActivity.this, ClickAutoStatActivity.class));

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
