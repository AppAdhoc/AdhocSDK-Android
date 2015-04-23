package com.example.adhoc.quote;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adhoc.abtestdemo.R;
import com.example.adhoc.activities.TestListActivity;

import java.util.ArrayList;

public class AdapterDisplayA extends BaseAdapter {
    Context context;
    private ArrayList<GoodsBean> data = null;
    int screenWidth = 0;
    public AdapterDisplayA(Context context, ArrayList<GoodsBean> data){
        this.context = context;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestListActivity.ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new TestListActivity.ViewHolder();
            convertView = View.inflate(context, R.layout.item_list, null);
            viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            viewHolder.textview = (TextView) convertView.findViewById(R.id.tv_goodsname);
            viewHolder.price = (TextView) convertView.findViewById(R.id.tv_price);
            convertView.setTag(viewHolder);
        }
        viewHolder = (TestListActivity.ViewHolder) convertView.getTag();

        RelativeLayout.LayoutParams layoutParams = null;
        GoodsBean gb = data.get(position);
        Drawable drawable = TestListActivity.getDrawable(context, gb.getImgName());
        viewHolder.imageview.setBackgroundDrawable(drawable);
        viewHolder.imageview.setScaleType(ImageView.ScaleType.CENTER);
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, getHeight(drawable));
        viewHolder.imageview.setLayoutParams(layoutParams);
        viewHolder.textview.setText(gb.getGoodName());
        viewHolder.price.setText(gb.getPrice());
        return convertView;
    }

    private int getHeight(Drawable drawable) {
        int height_ = 0;
        float density = context.getResources().getDisplayMetrics().density;
        int width = (int) (drawable.getIntrinsicWidth() * density);
        // 取 drawable 的长宽
        int height = (int) (drawable.getIntrinsicHeight() * density);
        return screenWidth / 2 * height / width;
    }

}