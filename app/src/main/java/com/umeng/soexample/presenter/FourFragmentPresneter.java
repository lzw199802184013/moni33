package com.umeng.soexample.presenter;

import android.content.Context;

import com.umeng.soexample.R;
import com.umeng.soexample.mvp.view.AppDeleGate;



public class FourFragmentPresneter extends AppDeleGate {
    private Context context;

    @Override
    public int getLayoutId() {
        return R.layout.frgament_four;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void getContext(Context context) {
        this.context = context;
    }
}
