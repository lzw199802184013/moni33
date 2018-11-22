package com.umeng.soexample.fragment;

import com.umeng.soexample.mvp.presenter.BaseFragmentPresenter;
import com.umeng.soexample.presenter.FourFragmentPresneter;

public class FourFragment extends BaseFragmentPresenter<FourFragmentPresneter> {


    @Override
    public Class<FourFragmentPresneter> getClassDeleGate() {
        return FourFragmentPresneter.class;
    }

    @Override
    public void initWeight() {
        super.initWeight();
    }
}
