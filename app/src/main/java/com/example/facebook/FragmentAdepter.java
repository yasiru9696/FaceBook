package com.example.facebook;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.facebook.FragmentOne;
import com.example.facebook.FragmentTwo;

public class FragmentAdepter extends FragmentPagerAdapter {

    public FragmentAdepter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return FragmentOne.newInstance();
            case 1: return FragmentTwo.newInstance();
            case 2: return FragmentThree.newInstance();


            default: return FragmentOne.newInstance();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        // return "Page" +(position);
        return null;
    }
}
