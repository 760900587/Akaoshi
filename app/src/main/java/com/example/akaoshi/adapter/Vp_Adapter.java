package com.example.akaoshi.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Vp_Adapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> list;

    public Vp_Adapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> list) {
        super(fm, behavior);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
