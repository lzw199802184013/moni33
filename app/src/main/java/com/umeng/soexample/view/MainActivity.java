package com.umeng.soexample.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.umeng.socialize.UMShareAPI;
import com.umeng.soexample.R;
import com.umeng.soexample.mvp.presenter.BaseActivityPresenter;
import com.umeng.soexample.presenter.MainActivityPresenter;

import butterknife.BindView;


public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {
    @BindView(R.id.vp_view)
    ViewPager vp_view;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @Override
    public Class<MainActivityPresenter> getClassDeleGate() {
        return MainActivityPresenter.class;
    }

    @Override
    public void initWeight() {
        super.initWeight();
        deleGate.initView(vp_view, tablayout);
    }

    //刷新右边
    public void itemClick() {
        deleGate.itemOnClick();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
