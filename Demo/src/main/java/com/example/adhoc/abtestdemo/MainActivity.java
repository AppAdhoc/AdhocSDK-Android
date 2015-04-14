package com.example.adhoc.abtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.adhoc.adhocsdk.AdhocConstants;
import com.adhoc.utils.Toaster;
import com.adhoc.volley.Request;
import com.adhoc.volley.RequestQueue;
import com.adhoc.volley.Response;
import com.adhoc.volley.VolleyError;
import com.adhoc.volley.toolbox.JsonObjectRequest;
import com.adhoc.volley.toolbox.Volley;
import com.example.adhoc.activities.ClickAutoStatActivity;
import com.example.adhoc.activities.FlagTestActivity;
import com.example.adhoc.activities.TrackingActivity;
import com.example.adhoc.base.AdhocActivity;

import org.json.JSONObject;


public class MainActivity extends AdhocActivity{

    RequestQueue rq = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq =  Volley.newRequestQueue(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 模块开关例子
                startActivity(new Intent(MainActivity.this, FlagTestActivity.class));

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
        findViewById(R.id.btn001).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 // TEST
                JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, AdhocConstants.ADHOC_SERVER_URL,null,new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toaster.toast(MainActivity.this,response.toString());
                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toaster.toast(MainActivity.this,error.toString());
                    }
                });
                jr.setShouldCache(false);
                rq.add(jr);

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
