package com.umeng.soexample.fragment;

import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.soexample.R;
import com.umeng.soexample.mvp.presenter.BaseFragmentPresenter;
import com.umeng.soexample.presenter.ThreeFragmentPresneter;

import butterknife.BindView;
import butterknife.OnClick;

public class ThreeFragment extends BaseFragmentPresenter<ThreeFragmentPresneter> {
    @BindView(R.id.iv)
    SimpleDraweeView iv;
    @BindView(R.id.share)
    Button share;

    @Override
    public Class<ThreeFragmentPresneter> getClassDeleGate() {
        return ThreeFragmentPresneter.class;
    }

    @Override
    public void initWeight() {
        super.initWeight();
        deleGate.initView(iv,share);
    }
    @OnClick({R.id.iv,R.id.share})
    public  void click(View view){
        deleGate.initClick(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        deleGate.onResume();
    }
}
