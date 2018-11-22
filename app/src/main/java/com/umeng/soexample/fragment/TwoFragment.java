package com.umeng.soexample.fragment;

import android.support.v7.widget.RecyclerView;

import com.umeng.soexample.R;
import com.umeng.soexample.mvp.presenter.BaseFragmentPresenter;
import com.umeng.soexample.presenter.TwoFragmentPresneter;

import butterknife.BindView;


public class TwoFragment extends BaseFragmentPresenter<TwoFragmentPresneter> {
    @BindView(R.id.recyclerview3)
    RecyclerView recyclerView3;
    @Override
    public Class<TwoFragmentPresneter> getClassDeleGate() {
        return TwoFragmentPresneter.class;
    }

    @Override
    public void initWeight() {
        super.initWeight();
        deleGate.initView(recyclerView3);
    }

    public void itemClick() {
        deleGate.itemOnClick();
    }
}
