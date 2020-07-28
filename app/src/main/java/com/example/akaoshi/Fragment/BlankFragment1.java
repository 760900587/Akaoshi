package com.example.akaoshi.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.akaoshi.Fragment.Fragment.Fragment1;
import com.example.akaoshi.Fragment.Fragment.Fragment2;
import com.example.akaoshi.Fragment.Fragment.Fragment3;
import com.example.akaoshi.R;
import com.example.akaoshi.View.MainView;
import com.example.akaoshi.adapter.My_Adatapter;
import com.example.akaoshi.adapter.Vp_Adapter;
import com.example.akaoshi.base.BaseFragment;
import com.example.akaoshi.bean.Bean;
import com.example.akaoshi.presenter.MainPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends BaseFragment<MainPresenter> implements MainView {


    @BindView(R.id.rcy)
    RecyclerView rcy;
    @BindView(R.id.tab1)
    TabLayout tab1;
    @BindView(R.id.vp1)
    ViewPager vp1;
    private ArrayList<Bean.DataBean.ActiondataBean> beans;
    private My_Adatapter adatapter;

    public BlankFragment1() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
//    }

    @Override
    protected void initPresenter() {
        mPresemter = new MainPresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresemter.getData();
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcy.setLayoutManager(layoutManager);
        beans = new ArrayList<>();
        adatapter = new My_Adatapter(beans, getActivity());
        rcy.setAdapter(adatapter);
        //创建fragment集合
        ArrayList<Fragment> fragments = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        BlankFragment4 fragment4 = new BlankFragment4();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        Vp_Adapter vp_adapter = new Vp_Adapter(getChildFragmentManager(), 0, fragments);
        vp1.setAdapter(vp_adapter);
        tab1.setupWithViewPager(vp1);
        tab1.getTabAt(0).setText("热门");
        tab1.getTabAt(1).setText("关注");
        tab1.getTabAt(2).setText("我的");
        tab1.getTabAt(3).setText("首页");
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_blank_fragment1;
    }

    @Override
    public void setData(Bean bean) {
        beans.addAll(bean.getData().getActiondata());
        adatapter.notifyDataSetChanged();
    }

    @Override
    public void ShowTosat(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
}
