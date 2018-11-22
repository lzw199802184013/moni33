package com.umeng.soexample;

import android.app.Application;

import com.abner.ming.MyApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.soexample.model.ShopsBeanUtils;
import com.umeng.soexample.model.ShopsJsonUtils;

public class App extends MyApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ShopsBeanUtils.getShopsBeanUtils().init(this);
        ShopsJsonUtils.getShopsJsonUtils().init(this);
    }
}
