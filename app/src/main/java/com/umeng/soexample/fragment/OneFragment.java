package com.umeng.soexample.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.umeng.soexample.R;
import com.umeng.soexample.mvp.presenter.BaseFragmentPresenter;
import com.umeng.soexample.presenter.OneFragmentPresneter;

import butterknife.BindView;

public class OneFragment extends BaseFragmentPresenter<OneFragmentPresneter> {
    @BindView(R.id.sv)
    SearchView sv;
    @BindView(R.id.recyclerView1)
    RecyclerView recyclerView1;

    @Override
    public Class<OneFragmentPresneter> getClassDeleGate() {
        return OneFragmentPresneter.class;
    }

    @Override
    public void initWeight() {
        super.initWeight();
        deleGate.initView(sv, recyclerView1);
    }
}
