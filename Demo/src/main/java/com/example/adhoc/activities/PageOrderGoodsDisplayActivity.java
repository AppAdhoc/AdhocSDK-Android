package com.example.adhoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class PageOrderGoodsDisplayActivity extends AdhocActivity {

    private int order;
    Button btnBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageorder_goods_display);
        order = getIntent().getIntExtra("order",0);

        btnBuy = (Button) findViewById(R.id.btn_buy);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("order", order);
                switch (order) {
                    case 0:
                        // (第一步)登陆--商品--支付--交易成功
                        intent.setClass(PageOrderGoodsDisplayActivity.this, PageOrderPamentActivity.class);
                        break;
                    case 1:
                        // (第一步)商品展示--登陆--支付--交易成功
                        intent.setClass(PageOrderGoodsDisplayActivity.this, PageOrderloginActivity.class);
                        break;
                    case 2:
                        // （第一步）商品展示--支付--登陆--交易成功
                        intent.setClass(PageOrderGoodsDisplayActivity.this, PageOrderPamentActivity.class);
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
