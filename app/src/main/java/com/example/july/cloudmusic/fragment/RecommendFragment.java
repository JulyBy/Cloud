package com.example.july.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.july.cloudmusic.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class RecommendFragment extends Fragment {

    ViewPager circleViewPager;
    SmartTabLayout circleTab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_recommend,null);
        circleViewPager = view.findViewById(R.id.circle_img);
        circleTab = view.findViewById(R.id.circle_tab);
        initCircleData();
        return view;
    }

    /**
     * add()第一个参数怎么写
     */
    private void initCircleData(){
        FragmentPagerItemAdapter circleAdapter = new FragmentPagerItemAdapter(
                getFragmentManager(), FragmentPagerItems.with(getContext())
                .add(R.string.find_recommend,OneCircleImgFragment.class)
                .add(R.string.find_broadcaster,TwoCircleImgFragment.class)
                .add(R.string.find_broadcaster,ThreeCircleImgFragment.class)
                .create());
        circleViewPager.setAdapter(circleAdapter);
       // circleTab.setViewPager(circleViewPager);
    }

}
