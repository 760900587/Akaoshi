package com.example.akaoshi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.akaoshi.R;
import com.example.akaoshi.bean.Bean;


import java.util.ArrayList;

public class My_Adatapter extends RecyclerView.Adapter {
    private ArrayList<Bean.DataBean.ActiondataBean> list;
    private Context context;
    private ImageView image;
    private TextView title;
    private TextView desc;
    private TextView time;

    public My_Adatapter(ArrayList<Bean.DataBean.ActiondataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcy1heng, parent, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder holder1= (ViewHolder) holder;
        Bean.DataBean.ActiondataBean bean = list.get(position);
        holder1.title.setText(bean.getTitle());
        holder1.desc.setText(bean.getLocation());
        holder1.time.setText(bean.getStartTime());
        Glide.with(context).load(bean.getCover()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder1.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView image;
        public TextView title;
        public TextView desc;
        public TextView time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.desc = (TextView) rootView.findViewById(R.id.desc);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }
}
