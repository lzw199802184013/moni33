package com.umeng.soexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.soexample.R;
import com.umeng.soexample.model.ShopsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyssAdapter extends RecyclerView.Adapter<MyssAdapter.MyViewHolder> {
    private Context context;
    private List<ShopsBean> list = new ArrayList<>();
    public MyssAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyssAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.one_item2, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyssAdapter.MyViewHolder myViewHolder, final int i) {
        String images = list.get(i).getImages();
        String[] split = images.split("[|]");
        myViewHolder.sd1.setImageURI(split[0]);
        myViewHolder.tv_title2.setText(list.get(i).getTitle());
        myViewHolder.tv_price.setText("￥:" + list.get(i).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<ShopsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sd1)
        SimpleDraweeView sd1;
        @BindView(R.id.tv_title2)
        TextView tv_title2;
        @BindView(R.id.tv_price)
        TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
