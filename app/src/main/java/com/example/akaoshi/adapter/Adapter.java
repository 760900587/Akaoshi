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
import com.example.akaoshi.R;
import com.example.akaoshi.bean.Bean;


import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter {
    private ArrayList<Bean.DataBean.ListBean> listBeans;
    private Context context;
    private TextView title3;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    public Adapter(ArrayList<Bean.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    private int Item1 = 0;
    private int Item2 = 1;
    private int Item3 = 2;

    @Override
    public int getItemViewType(int position) {
        //获取集合
        Bean.DataBean.ListBean listBean = listBeans.get(position);
        //获取数组集合
        List<Bean.DataBean.ListBean.FilePathListBean> filePathList = listBean.getFilePathList();
        int size = filePathList.size();
        if (size == 0) {
            return Item1;
        } else if (size == 1) {
            return Item2;
        } else {
            return Item3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Item3) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_rcy3, parent, false);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        } else if (viewType == Item2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_rcy2, parent, false);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_rcy, parent, false);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

}

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Bean.DataBean.ListBean bean = listBeans.get(position);
        if (getItemViewType(position)==0){
                ViewHolder holder1= (ViewHolder) holder;
                holder1.title.setText(bean.getTitle());
        }else if (getItemViewType(position)==1){
                ViewHolder2 holder2 = (ViewHolder2) holder;
                holder2.title2.setText(bean.getTitle());
            Glide.with(context).load(bean.getFilePathList().get(0).getFilePath()).into(holder2.img);
        }else {
            ViewHolder3 holder3= (ViewHolder3) holder;
            holder3.title3.setText(bean.getTitle());
            Glide.with(context).load(bean.getFilePathList().get(0).getFilePath()).into(holder3.img1);
            Glide.with(context).load(bean.getFilePathList().get(1).getFilePath()).into(holder3.img2);
            Glide.with(context).load(bean.getFilePathList().get(2).getFilePath()).into(holder3.img3);
        }
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView title3;
        public ImageView img1;
        public ImageView img2;
        public ImageView img3;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.title3 = (TextView) rootView.findViewById(R.id.title3);
            this.img1 = (ImageView) rootView.findViewById(R.id.img1);
            this.img2 = (ImageView) rootView.findViewById(R.id.img2);
            this.img3 = (ImageView) rootView.findViewById(R.id.img3);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView title2;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title2 = (TextView) rootView.findViewById(R.id.title2);
        }

    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
