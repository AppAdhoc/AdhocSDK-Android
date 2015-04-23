package com.example.adhoc.abtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.activities.BottomTestActivity;
import com.example.adhoc.activities.BtnColorActivity;
import com.example.adhoc.activities.ClickAutoStatActivity;
import com.example.adhoc.activities.FlagTestActivity;
import com.example.adhoc.activities.LoginTestActivity;
import com.example.adhoc.activities.PageOrderGoodsDisplayActivity;
import com.example.adhoc.activities.PageOrderloginActivity;
import com.example.adhoc.activities.TestListActivity;
import com.example.adhoc.base.AdhocActivity;

public class MainActivity extends AdhocActivity{

    Button pageOrder = null;
    ExperimentFlags flags = null;
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
                // 按钮颜色对比测试
                startActivity(new Intent(MainActivity.this, BtnColorActivity.class));

            }
        });

        findViewById(R.id.btn_autotrack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 点击自动统计例子
                startActivity(new Intent(MainActivity.this, ClickAutoStatActivity.class));

            }
        });
        findViewById(R.id.test_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 显示不同列表测试
                startActivity(new Intent(MainActivity.this, TestListActivity.class));

            }
        });
        findViewById(R.id.bottom_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 显示不同列表测试
                startActivity(new Intent(MainActivity.this, BottomTestActivity.class));

            }
        });
        findViewById(R.id.login_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 登录测试
                startActivity(new Intent(MainActivity.this, LoginTestActivity.class));

            }
        });

        pageOrder = (Button) findViewById(R.id.page_order);

        pageOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int order = flags.getIntegerFlag("order");
                Intent intent = new Intent();
                intent.putExtra("order",order);
                switch (order){
                    case 0 :
                        // (第一步)登陆--商品--支付--交易成功
                        intent.setClass(MainActivity.this,PageOrderloginActivity.class);
                        break;
                    case 1 :
                        // (第一步)商品展示--登陆--支付--交易成功
                        intent.setClass(MainActivity.this,PageOrderGoodsDisplayActivity.class);
                        break;
                    case 2 :
                        // （第一步）商品展示--支付--登陆--交易成功
                        intent.setClass(MainActivity.this,PageOrderGoodsDisplayActivity.class);
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
        flags = AdhocTracker.getInstance(this).getExperimentFlags();
        super.onStart();
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
