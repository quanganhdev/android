package com.example.apnhac.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class mainviewpaperadater extends FragmentPagerAdapter {
    private   ArrayList<Fragment> fragments = new ArrayList<>();
    private  ArrayList<String> arraytitle = new ArrayList<>();
    public mainviewpaperadater(@NonNull FragmentManager fm) {
        super(fm);
    }

//    public mainviewpaperadater(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    public void addfragment(Fragment fragment , String title){
        fragments.add(fragment);
        arraytitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
