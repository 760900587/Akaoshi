package com.example.abc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.abc.Fragment.BlankFragment1;
import com.example.abc.Fragment.BlankFragment2;
import com.example.abc.Fragment.BlankFragment3;
import com.example.abc.Fragment.BlankFragment4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);

        ArrayList<Fragment> fragments = new ArrayList<>();
        BlankFragment1 fragment1 = new BlankFragment1();
        BlankFragment2 fragment2 = new BlankFragment2();
        BlankFragment3 fragment3 = new BlankFragment3();
        BlankFragment4 fragment4 = new BlankFragment4();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        Vp_Adapter adapter = new Vp_Adapter(getSupportFragmentManager(), 0, fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("喜洋洋");
        tab.getTabAt(1).setText("美羊羊");
        tab.getTabAt(2).setText("懒洋洋");
        tab.getTabAt(3).setText("沸羊羊");
    }
}
