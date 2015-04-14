package com.example.adhoc.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adhoc.adhocsdk.AdhocTracker;
import com.example.adhoc.abtestdemo.R;

import java.util.Random;


public class ClickAutoStatActivity extends ActionBarActivity {


    LinearLayout content;
    Button button2;

    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_tracking);
        content = (LinearLayout) findViewById(R.id.layout_content);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdhocTracker.getInstance(ClickAutoStatActivity.this).incrementStat("click01",1);
                // 页面中随意添加view
                if(Math.abs(random.nextInt(100))%2==0){

                    addButton();
                }else{
                    addTextView();
                }
            }
        });
    }
    // 添加button
    private void addButton() {

        final Button newBtn = getNewBtn();
        LinearLayout container = getContainer();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        Animation animation = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        LayoutAnimationController lac = new LayoutAnimationController(animation);
        container.setLayoutAnimation(lac);
        container.addView(newBtn, params);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 页面中的view的点击将自动统计到ADHOC后台
                Toast.makeText(ClickAutoStatActivity.this, "点击自动统计key:" + newBtn.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }

    // 添加Textview
    private void addTextView() {

        final TextView newTextView = getNewTextView();
        LinearLayout container = getContainer();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        Animation animation = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        LayoutAnimationController lac = new LayoutAnimationController(animation);
        container.setLayoutAnimation(lac);
        container.addView(newTextView, params);
        newTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClickAutoStatActivity.this, "点击自动统计key:" + newTextView.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }

    // 得到linearlayout
    private LinearLayout getContainer() {
        LinearLayout layout = null;

        View view = getLastView();

        if (view instanceof Button) {
            layout = new LinearLayout(this);
        } else {
            if (((ViewGroup)view).getChildCount() >= 3) {
                layout = new LinearLayout(this);
            } else {
                return (LinearLayout) view;
            }
        }

        content.addView(layout, new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return layout;
    }

    // 得到content最后一个view
    private View getLastView() {

        return content.getChildAt(content.getChildCount() - 1);
    }

    private Button getNewBtn() {

        Button button = new Button(this);
        button.setTextSize(getResources().getDimension(R.dimen.textsize_min));
        int id = getLastViewId();
        button.setId(id);
        button.setText("BUTTON" + id);
        return button;
    }
    // 新建一个TextView
    private TextView getNewTextView() {

        TextView textView = new TextView(this);
        textView.setTextSize(getResources().getDimension(R.dimen.textsize_min));
        textView.setBackgroundColor(getResources().getColor(android.R.color.black));
        int id = getLastViewId();
        textView.setId(id);
        textView.setText("TextView" + id);
        textView.setTextColor(getResources().getColor(android.R.color.white));
        return textView;
    }

    private int getLastViewId() {

        // 得到最后一个button的id
        int id = 1;

        View view = getLastView();
        if (view instanceof ViewGroup) {

            View viewLast = ((ViewGroup) view).getChildAt(((ViewGroup) view).getChildCount() - 1);
            return viewLast.getId() + 1;
        }

        return id;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_auto_tracking, menu);
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        AdhocTracker.getInstance(ClickAutoStatActivity.this).autoTracking(event);
        return super.dispatchTouchEvent(event);
    }
}
