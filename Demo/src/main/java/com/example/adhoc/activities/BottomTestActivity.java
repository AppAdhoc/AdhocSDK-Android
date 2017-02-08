package com.example.adhoc.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.adhoc.adhocsdk.AdhocTracker;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;


public class BottomTestActivity extends AdhocActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_test);

        setClickListener();

    }

    private void setClickListener() {

        LinearLayout layoutHistory = (LinearLayout) findViewById(R.id.layout_history);
        for(int i=0;i<layoutHistory.getChildCount();i++){
            View view = layoutHistory.getChildAt(i);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AdhocTracker.track("bottom_item_click", 1);
                }
            });
        }
        LinearLayout layoutOther = (LinearLayout) findViewById(R.id.layout_other);
        for(int i=0;i<layoutOther.getChildCount();i++){
            View view = layoutOther.getChildAt(i);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AdhocTracker.track("bottom_item_click",1);
                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        // 获取模块开关
        // 根据获取模块的值，开发不同的业务逻辑
        if(AdhocTracker.getFlag("test_bottom_recommend",false)){
            findViewById(R.id.layout_history).setVisibility(View.GONE);
            findViewById(R.id.layout_other).setVisibility(View.VISIBLE);
        }
    }
}

