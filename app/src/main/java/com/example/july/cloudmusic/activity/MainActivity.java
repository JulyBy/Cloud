package com.example.july.cloudmusic.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.july.cloudmusic.adpter.MyFragmentPagerAdapter;
import com.example.july.cloudmusic.fragment.AccountFragment;
import com.example.july.cloudmusic.fragment.FindFragment;
import com.example.july.cloudmusic.fragment.FriendsFragment;
import com.example.july.cloudmusic.fragment.MyMusicFragment;
import com.example.july.cloudmusic.fragment.VideoFragment;
import com.example.july.cloudmusic.R;
import com.winton.bottomnavigationview.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;
    NavigationView mNV;
    List<NavigationView.Model> tabs = new ArrayList<>();
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNV = findViewById(R.id.nv);
        viewPager = findViewById(R.id.view_pager_external);


        initListener();
        initTab();
        initData();
    }

    private void initTab(){
        tabs.add(new NavigationView.Model.Builder(R.mipmap.findselect,R.mipmap.find).title("发现").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.videoselect,R.mipmap.video).title("视频").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.mymusicselect,R.mipmap.mymusic).title("我的").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.friendselect,R.mipmap.friends).title("朋友").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.accountselect,R.mipmap.account).title("账号").build());
        mNV.setItems(tabs);
        mNV.build();
        mNV.check(0);
    }

    private void initListener(){
        mNV.setOnTabSelectedListener(new NavigationView.OnTabSelectedListener() {
            @Override
            public void selected(int i, NavigationView.Model model) {

                /*当某第i个tab被选中的时候，将ViewPager的第i个fragment显示在当前界面上*/

                /**
                 * 其实，这里不存在绑定底栏tab与ViewPager各个元素，
                 * 只是在第i个tab被check的时候，此时将ViewPager的第i个fragment显示在当前界面上
                 */
                viewPager.setCurrentItem(i);
            }

            @Override
            public void unselected(int i, NavigationView.Model model) {

            }
        });
    }

    private void initData(){
        /**
         * 通过Fragment作为ViewPager的数据源
         */
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(FindFragment.newInstance(null));
        fragmentList.add(new VideoFragment());
        fragmentList.add(new MyMusicFragment());
        fragmentList.add(new FriendsFragment());
        fragmentList.add(new AccountFragment());

        /**
         * 初始化ViewPager
         */

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);

        viewPager.setAdapter(myFragmentPagerAdapter);
    }
}

