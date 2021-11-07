package com.example.tabview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem home,sports,business,technology,health,science;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;

    String api="7a9f22539ecd4168a794a3bb108a9516";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        home=findViewById(R.id.rvhome);
        sports=findViewById(R.id.rvsports);
        business=findViewById(R.id.rvbusiness);
        technology=findViewById(R.id.rvtechnology);
        health=findViewById(R.id.rvhealth);
        science=findViewById(R.id.rvscience);
        ViewPager viewPager=findViewById(R.id.fragementContainer);
        tabLayout =findViewById(R.id.tab);

        pagerAdapter =new pageAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 ||tab.getPosition()==4 || tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}