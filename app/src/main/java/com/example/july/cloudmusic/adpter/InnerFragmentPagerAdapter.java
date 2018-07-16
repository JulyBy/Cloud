package com.example.july.cloudmusic.adpter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class InnerFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> innerFragmentList;
    private List<String> titleList;

    public InnerFragmentPagerAdapter(FragmentManager fm, List<Fragment> innerFragmentList, List<String> titleList) {
        super(fm);
        this.innerFragmentList = innerFragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return innerFragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return innerFragmentList.size();
    }
}
