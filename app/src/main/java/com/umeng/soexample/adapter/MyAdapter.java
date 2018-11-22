package com.umeng.soexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umeng.soexample.R;
import com.umeng.soexample.model.ShopBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ShopBean.DataBean> data1 = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.one_item1, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_title1.setText(data1.get(i).getSellerName());
        createRecyclerView2(myViewHolder.recyclerView2, data1.get(i).getList());
    }

    private void createRecyclerView2(RecyclerView recyclerView2, List<ShopBean.DataBean.ListBean> list) {
        MysAdapter mysAdapter = new MysAdapter(context, list);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        recyclerView2.setAdapter(mysAdapter);
        mysAdapter.setOnClickListener(new MysAdapter.OnClickListener() {
            @Override
            public void itemClick() {
                listener.itemClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public void setList(List<ShopBean.DataBean> list) {
        this.data1 = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title1)
        TextView tv_title1;
        @BindView(R.id.recyclerView2)
        RecyclerView recyclerView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //接口回调
    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        void itemClick();
    }
}
