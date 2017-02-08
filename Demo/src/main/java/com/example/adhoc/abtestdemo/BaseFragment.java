package com.example.adhoc.abtestdemo;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by dongyuangui on 15-6-1.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BaseFragment extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
