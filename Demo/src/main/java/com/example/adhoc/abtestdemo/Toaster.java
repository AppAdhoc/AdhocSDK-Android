package com.example.adhoc.abtestdemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dongyuangui on 15-4-21.
 */
public class Toaster {
    public static void toast(Context context,String str){

        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
