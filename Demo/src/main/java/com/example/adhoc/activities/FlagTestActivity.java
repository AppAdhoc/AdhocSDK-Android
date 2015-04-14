package com.example.adhoc.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class FlagTestActivity extends AdhocActivity {

    private Button btn01;
    private TextView tv01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flag_test);
        tv01 = (TextView) findViewById(R.id.tv01);
        btn01 = (Button) findViewById(R.id.btn01);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 获取模块开关
        ExperimentFlags flags = AdhocTracker.getInstance(FlagTestActivity.this).getExperimentFlags();
        if(flags!=null){
            // 'model01' 对应网站添加的产品模块名称
            boolean flag = flags.getBooleanFlag("module01");
            // 根据获取模块的值，开发不同的业务逻辑
            if(flag == false){
                Toast.makeText(FlagTestActivity.this,"has net flags is false" ,Toast.LENGTH_LONG).show();
                btn01.setBackgroundColor(getResources().getColor(android.R.color.white));
                btn01.setTextColor(getResources().getColor(android.R.color.black));
                btn01.setTextSize(getResources().getDimension(R.dimen.textsize));
                btn01.setText("实验版本A");
            }else{
                Toast.makeText(FlagTestActivity.this,"has net flags is true" ,Toast.LENGTH_LONG).show();
                btn01.setBackgroundColor(getResources().getColor(android.R.color.black));
                btn01.setTextColor(getResources().getColor(android.R.color.white));
                btn01.setTextSize(getResources().getDimension(R.dimen.textsize_small));
                btn01.setText("实验版本B");
            }
        }else{
            Toast.makeText(FlagTestActivity.this,"no net flags is null",Toast.LENGTH_LONG).show();
            btn01.setBackgroundColor(getResources().getColor(android.R.color.black));
            btn01.setTextColor(getResources().getColor(android.R.color.white));
            btn01.setTextSize(getResources().getDimension(R.dimen.textsize_small));
            btn01.setText("默认版本");
        }
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
