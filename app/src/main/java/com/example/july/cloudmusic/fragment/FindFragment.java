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

public class FindFragment extends Fragment{

    SmartTabLayout viewPagerTab;
    ViewPager innerViewPager;

    public static FindFragment newInstance(Bundle params){
        FindFragment fragment  = new FindFragment();
        if(params != null){
            fragment.setArguments(params);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,false);
        innerViewPager = view.findViewById(R.id.view_pager_inner);
        viewPagerTab = view.findViewById(R.id.view_pager_tab);
        initData();
        return view;
    }

    private void initData(){

//        InnerFragmentPagerAdapter innerFragmentPagerAdapter = new InnerFragmentPagerAdapter(getFragmentManager(),innerFragmentList,titleList);

        /**
         * 初始化适配器adapter，并绑定数据源
         */
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getFragmentManager(), FragmentPagerItems.with(getContext())
                .add(R.string.find_recommend, RecommendFragment.class)
                .add(R.string.find_broadcaster, BroadcasterFragment.class)
                .create());

        /**
         * 给ViewPager设置适配器
         */
        innerViewPager.setAdapter(adapter);

        /**
         * 给SmartTab是被ViewPager
         */
        viewPagerTab.setViewPager(innerViewPager);
    }

}
