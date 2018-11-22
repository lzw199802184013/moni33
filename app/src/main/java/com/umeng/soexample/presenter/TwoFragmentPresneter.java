package com.umeng.soexample.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.umeng.soexample.R;
import com.umeng.soexample.adapter.MyssAdapter;
import com.umeng.soexample.model.ShopsBean;
import com.umeng.soexample.model.ShopsBeanUtils;
import com.umeng.soexample.mvp.view.AppDeleGate;

import java.util.ArrayList;
import java.util.List;



public class TwoFragmentPresneter extends AppDeleGate {
    private Context context;
    private RecyclerView recyclerView3;
    private MyssAdapter myssAdapter;
    private List<ShopsBean> list = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.frgament_two;
    }

    @Override
    public void initData() {
        super.initData();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView3.setLayoutManager(staggeredGridLayoutManager);
        myssAdapter = new MyssAdapter(context);
        recyclerView3.setAdapter(myssAdapter);
        list = ShopsBeanUtils.getShopsBeanUtils().query();
        //查询
        myssAdapter.setList(list);

    }

    @Override
    public void getContext(Context context) {
        this.context = context;
    }

    //接口回传
    public void itemOnClick() {
        list = ShopsBeanUtils.getShopsBeanUtils().query();
        myssAdapter.setList(list);
//        Log.i("王武我", list + "");
    }

    public void initView(RecyclerView recyclerView3) {
        this.recyclerView3 = recyclerView3;
    }
}
