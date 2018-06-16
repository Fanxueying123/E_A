package com.example.administrator.e_a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.e_a.ui.fragment.IndexFragment;
import com.example.administrator.e_a.ui.fragment.MeFragment;
import com.example.administrator.e_a.ui.fragment.MessageFragment;
import com.example.administrator.e_a.ui.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,BottomNavigationBar.OnTabSelectedListener{

    private ViewPager mViewPager;
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        mFragments=new ArrayList<>();
        mFragments.add(new IndexFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MeFragment());

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_index_selector,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.nav_video_selector,"视频"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));

        mViewPager.addOnPageChangeListener(this);
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    private void initView() {
        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        mBottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(int i) {
        mViewPager.setCurrentItem(i);
    }

    @Override
    public void onTabUnselected(int i) {

    }

    @Override
    public void onTabReselected(int i) {

    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
