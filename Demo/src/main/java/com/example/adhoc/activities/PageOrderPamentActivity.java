package com.example.adhoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class PageOrderPamentActivity extends AdhocActivity {
    private int order;
    Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageorder_payment);
        order = getIntent().getIntExtra("order",0);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("order",order);
                switch (order){
                    case 0 :
                        // (第一步)登陆--商品--支付--交易成功
                        intent.setClass(PageOrderPamentActivity.this,PageOrderSuccessActivity.class);
                        break;
                    case 1 :
                        // (第一步)商品展示--登陆--支付--交易成功
                        intent.setClass(PageOrderPamentActivity.this,PageOrderSuccessActivity.class);
                        break;
                    case 2 :
                        // （第一步）商品展示--支付--登陆--交易成功
                        intent.setClass(PageOrderPamentActivity.this,PageOrderloginActivity.class);
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
