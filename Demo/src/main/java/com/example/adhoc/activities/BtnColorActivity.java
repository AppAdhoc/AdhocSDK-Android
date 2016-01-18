package com.example.adhoc.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.abtestdemo.MainActivity;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.abtestdemo.Toaster;
import com.example.adhoc.base.AdhocActivity;


public class BtnColorActivity extends AdhocActivity {

    private Button btnClick;
    private TextView tvTIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn_color);
        tvTIP = (TextView) findViewById(R.id.tv_tip);
        btnClick = (Button) findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdhocTracker.incrementStat(BtnColorActivity.this,"btn_color_clicks",1);
//                TODO --
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 获取模块开关
        // test getClient——id
        ExperimentFlags flags = AdhocTracker.getExperimentFlags(BtnColorActivity.this);
        // 'model01' 对应网站添加的产品模块名称
        boolean flag = flags.getBooleanFlag("btn_color",false);
        // 根据获取模块的值，开发不同的业务逻辑
        if (flag == false) {
//            Toaster.toast(BtnColorActivity.this, "has net flags is false");
            btnClick.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_btn_bg_a));
            btnClick.setText(getResources().getString(R.string.btn_select_A_text));
        } else {
//            Toaster.toast(BtnColorActivity.this, "has net flags is true");
            btnClick.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_btn_bg_b));
            btnClick.setText(getString(R.string.btn_select_B_text));
        }
        tvTIP.setText(flags.toString());
    }


}
