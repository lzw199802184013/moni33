package com.umeng.soexample.fragment;

import com.umeng.soexample.mvp.presenter.BaseFragmentPresenter;
import com.umeng.soexample.presenter.FiveFragmentPresneter;

public class FiveFragment extends BaseFragmentPresenter<FiveFragmentPresneter> {


    @Override
    public Class<FiveFragmentPresneter> getClassDeleGate() {
        return FiveFragmentPresneter.class;
    }

    @Override
    public void initWeight() {
        super.initWeight();
    }
}
