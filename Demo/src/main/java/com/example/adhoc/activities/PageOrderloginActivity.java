package com.example.adhoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class PageOrderloginActivity extends AdhocActivity {
    private int order;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageorder_login);
        order = getIntent().getIntExtra("order",0);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("order",order);
                switch(order){
                    case 0:
                        intent.setClass(PageOrderloginActivity.this,PageOrderGoodsDisplayActivity.class);
                        break;
                    case 1:
                        intent.setClass(PageOrderloginActivity.this,PageOrderPamentActivity.class);
                        break;
                    case 2:
                        intent.setClass(PageOrderloginActivity.this,PageOrderSuccessActivity.class);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
