package com.example.adhoc.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.base.AdhocActivity;
import com.example.adhoc.quote.AdapterB;
import com.example.adhoc.quote.AdapterDisplayA;
import com.example.adhoc.quote.GoodsBean;
import com.example.adhoc.quote.MultiColumnListView;

import java.io.IOException;
import java.util.ArrayList;


public class TestListActivity extends AdhocActivity {

    private MultiColumnListView lista;
    private ListView listb;
    private AdapterDisplayA aAdapter;
    private AdapterB bAdapter;

    private ArrayList<GoodsBean> data = new ArrayList<GoodsBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_test);

        initData();

        lista = (MultiColumnListView) findViewById(R.id.lista);
        listb = (ListView) findViewById(R.id.listb);

        aAdapter = new AdapterDisplayA(this,data);
        bAdapter = new AdapterB(this,data);


    }


    @Override
    protected void onStart() {
        super.onStart();
        // 获取模块开关
        ExperimentFlags flags = AdhocTracker.getInstance(TestListActivity.this).getExperimentFlags();
        // 'list_test' 对应网站添加的产品模块名称
        boolean defaultFlag = flags.getBooleanFlag("test_diff_list");
        // 根据获取模块的值，开发不同的业务逻辑
        if(defaultFlag){
            lista.setAdapter(aAdapter);
            lista.setVisibility(View.VISIBLE);
            listb.setVisibility(View.GONE);
        }else{
            listb.setAdapter(bAdapter);
            listb.setVisibility(View.VISIBLE);
            lista.setVisibility(View.GONE);
        }
    }

    private void initData() {

        GoodsBean gb1 = new GoodsBean();
        gb1.setGoodName("【百草味-紫薯花生180g】花生米 休闲零食坚果炒货 台湾风味");
        gb1.setImgName("img_01.jpg");
        gb1.setPrice("￥12.00");
        data.add(gb1);

        GoodsBean gb2 = new GoodsBean();
        gb2.setGoodName("【水娃】花生米 休闲零食坚果炒货 四川风味");
        gb2.setImgName("img_02.jpg");
        gb2.setPrice("￥19.00");
        data.add(gb2);
        GoodsBean gb3 = new GoodsBean();
        gb3.setGoodName("【恰恰】花生米 休闲零食坚果炒货 山东风味");
        gb3.setImgName("img_03.jpg");
        gb3.setPrice("￥18.00");
        data.add(gb3);
        GoodsBean gb4 = new GoodsBean();
        gb4.setGoodName("京东促销手提包");
        gb4.setImgName("img_04.jpg");
        gb4.setPrice("￥15.00");
        data.add(gb4);
        GoodsBean gb5 = new GoodsBean();
        gb5.setGoodName("t恤女短袖韩版小香风短款圆领打底衫宽");
        gb5.setImgName("img_05.jpg");
        gb5.setPrice("￥15.00");
        data.add(gb5);
    }


    public static class ViewHolder {
        public ImageView imageview;
        public TextView textview;
        public TextView price;
    }


    public static Drawable getDrawable(Context context, String name) {
        Drawable drawable = null;
        if (name.equals("")) {
            drawable = context.getResources().getDrawable(R.drawable.blue_drawable);
            return drawable;
        }
        // 遍历所有的多音字组合 找到map文件
        Bitmap bitmap = getBitMap(name, context);

        if (bitmap != null) {
            drawable = new BitmapDrawable(bitmap);
        } else {
            drawable = context.getResources().getDrawable(R.drawable.blue_drawable);
        }
        return drawable;
    }

    private static Bitmap getBitMap(String filename, Context context) {
        Bitmap map = null;
        try {
            map = BitmapFactory.decodeStream(context.getResources().getAssets().open(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (map != null) {
            return map;
        }
        return map;
    }

}



