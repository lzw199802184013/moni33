package com.umeng.soexample.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.abner.ming.MingUtils;
import com.abner.ming.ResultListener;
import com.abner.ming.UmengBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.soexample.R;
import com.umeng.soexample.mvp.view.AppDeleGate;
import com.umeng.soexample.net.SharedPreferencesUtils;
import com.umeng.soexample.view.MainActivity;


public class ThreeFragmentPresneter extends AppDeleGate {
    private Context context;
    private SimpleDraweeView iv;
    private Button share;

    @Override
    public int getLayoutId() {
        return R.layout.frgament_three;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void getContext(Context context) {
        this.context = context;
    }

    public void initView(SimpleDraweeView iv, Button share) {
        this.iv = iv;
        this.share = share;
    }

    public void initClick(View view) {
        switch (view.getId()) {
            case R.id.iv:
                MingUtils.login(((MainActivity) context), 0, new ResultListener() {
                    @Override
                    public void success(UmengBean umengBean) {
                        iv.setImageURI(umengBean.getIconurl());
                    }
                });
                break;
            case R.id.share:
                MingUtils.shared(((MainActivity) context), 0, "哇哇哇哇哇", "86565", "", "");
                break;

        }
    }

    public void onResume() {
        String iconurl = SharedPreferencesUtils.getString(context, "iconurl");
        if (!TextUtils.isEmpty(iconurl)) {
            iv.setImageURI(iconurl);
        } else {
            iv.setImageURI(String.valueOf(R.mipmap.ic_launcher));
        }

    }
}
