package com.umeng.soexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.soexample.R;
import com.umeng.soexample.model.ShopBean;
import com.umeng.soexample.model.ShopsBean;
import com.umeng.soexample.model.ShopsBeanUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MysAdapter extends RecyclerView.Adapter<MysAdapter.MyViewHolder> {
    private Context context;
    private List<ShopBean.DataBean.ListBean> list;

    public MysAdapter(Context context, List<ShopBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MysAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.one_item2, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MysAdapter.MyViewHolder myViewHolder, final int i) {
        String images = list.get(i).getImages();
        String[] split = images.split("[|]");
        myViewHolder.sd1.setImageURI(split[0]);
        myViewHolder.tv_title2.setText(list.get(i).getTitle());
        myViewHolder.tv_price.setText("￥:" + list.get(i).getPrice() + "");
        //点击
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopsBean shopsBean = new ShopsBean();
                shopsBean.setImages(list.get(i).getImages());
                shopsBean.setTitle(list.get(i).getTitle());
                shopsBean.setPrice("￥:" + list.get(i).getPrice() + "");
                ShopsBeanUtils.getShopsBeanUtils().insert(shopsBean);
                Log.i("嗷嗷嗷", shopsBean + "");

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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

    //接口回调
    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        void itemClick();
    }
}
