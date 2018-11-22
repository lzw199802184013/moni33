package com.umeng.soexample.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.google.gson.Gson;
import com.umeng.soexample.R;
import com.umeng.soexample.adapter.MyAdapter;
import com.umeng.soexample.model.ShopBean;
import com.umeng.soexample.model.ShopsJsonBean;
import com.umeng.soexample.model.ShopsJsonUtils;
import com.umeng.soexample.mvp.view.AppDeleGate;
import com.umeng.soexample.net.HttpUtils;
import com.umeng.soexample.net.NetworkUtils;
import com.umeng.soexample.view.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class OneFragmentPresneter extends AppDeleGate {
    private Context context;
    private SearchView sv;
    private RecyclerView recyclerView1;
    private MyAdapter myAdapter;
    private List<ShopBean.DataBean> data1 = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.frgament_one;
    }

    @Override
    public void initData() {
        super.initData();
        doGet();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(context);
        recyclerView1.setAdapter(myAdapter);
        //接口回调
        myAdapter.setOnClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void itemClick() {
                if (context instanceof MainActivity) {
                    ((MainActivity) context).itemClick();
                }
            }
        });
        //判断网络
        if (NetworkUtils.isConnected(context)) {
            doGet();
        } else {
            //查询
            String datas = ShopsJsonUtils.getShopsJsonUtils().query().get(0).getDatas();
            doJson(datas);
            myAdapter.setList(data1);
        }

    }

    private void doGet() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", "71");
        HttpUtils.getHttpUtils().get("/product/getCarts", map).result(new HttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                doJson(data);
                myAdapter.setList(data1);
                ShopsJsonUtils.getShopsJsonUtils().delete();
                ShopsJsonBean shopsJsonBean = new ShopsJsonBean();
                shopsJsonBean.setDatas(data);
                //添加
                ShopsJsonUtils.getShopsJsonUtils().insert(shopsJsonBean);

            }

            @Override
            public void error(String error) {

            }
        });

    }

    private void doJson(String data) {
        Gson gson = new Gson();
        ShopBean shopBean = gson.fromJson(data, ShopBean.class);
        data1 = shopBean.getData();
    }

    @Override
    public void getContext(Context context) {
        this.context = context;
    }

    public void initView(SearchView sv, RecyclerView recyclerView1) {
        this.sv = sv;
        this.recyclerView1 = recyclerView1;
    }
}
