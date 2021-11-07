package com.example.tabview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {
    int tabcount;

    public pageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new homefragment();
            case 1:
                return  new sportsfragment();
            case 2:
                return new sciencefragment();
            case 3:
                return  new businessfragment();
            case 4:
                return new technologyfragemnt();
            case 5:
                return  new healthfragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return  tabcount;
    }
}
