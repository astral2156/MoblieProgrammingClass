package com.example.a13.myapplication;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public PagerAdapter(android.support.v4.app.FragmentManager fm, int NumOfTabs){
        super(fm);
        this.mNumOfTabs =NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Frag1 frag1 = new Frag1();
                return frag1;
            case 1:
                Frag1 frag2 = new Frag1();
                return frag2;
            case 2:
                Frag1 frag3 = new Frag1();
                return frag3;
            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
