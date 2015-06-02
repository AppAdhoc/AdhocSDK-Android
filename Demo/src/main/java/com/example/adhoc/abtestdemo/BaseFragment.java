package com.example.adhoc.abtestdemo;

import android.app.Fragment;
import android.os.Bundle;

import com.adhoc.adhocsdk.AdhocTracker;

/**
 * Created by dongyuangui on 15-6-1.
 */
public class BaseFragment extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdhocTracker.onFragmentCreate(getActivity(),this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AdhocTracker.onFragmentDestory(getActivity(),this);
    }
}
