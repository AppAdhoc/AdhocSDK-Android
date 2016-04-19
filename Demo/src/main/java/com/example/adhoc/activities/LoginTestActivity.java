package com.example.adhoc.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class LoginTestActivity extends AdhocActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_test);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(listener);

        findViewById(R.id.iv_qzone).setOnClickListener(listener);
        findViewById(R.id.iv_tencent).setOnClickListener(listener);
        findViewById(R.id.iv_weibo).setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AdhocTracker.incrementStat(LoginTestActivity.this, "login_click", 1);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        // 获取模块开关
        ExperimentFlags flags = AdhocTracker.getExperimentFlags(LoginTestActivity.this);
        // 'model01' 对应网站添加的产品模块名称
        boolean flag = flags.getBooleanFlag("login_test",false);
        // 根据获取模块的值，开发不同的业务逻辑
        if (flag == false) {
            findViewById(R.id.layout_other).setVisibility(View.GONE);
        } else {
            findViewById(R.id.layout_other).setVisibility(View.VISIBLE);
        }
    }



}
