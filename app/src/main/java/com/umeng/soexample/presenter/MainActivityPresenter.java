package com.umeng.soexample.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.umeng.soexample.R;
import com.umeng.soexample.fragment.FiveFragment;
import com.umeng.soexample.fragment.FourFragment;
import com.umeng.soexample.fragment.OneFragment;
import com.umeng.soexample.fragment.ThreeFragment;
import com.umeng.soexample.fragment.TwoFragment;
import com.umeng.soexample.mvp.view.AppDeleGate;
import com.umeng.soexample.view.MainActivity;

import java.util.ArrayList;
import java.util.List;



public class MainActivityPresenter extends AppDeleGate {
    private Context context;
    private ViewPager vp_view;
    private TabLayout tablayout;
    private String[] mTitle = {"首页", "分类", "发现", "购物车", "我的"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();

        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        fragments.add(new FiveFragment());
//        vp_view.setOffscreenPageLimit(4);
        vp_view.setAdapter(new FragmentPagerAdapter(((MainActivity) context).getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position];
            }
        });
        tablayout.setupWithViewPager(vp_view);

        vp_view.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 1) {
                    itemOnClick();
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void getContext(Context context) {
        this.context = context;
    }

    public void initView(ViewPager vp_view, TabLayout tablayout) {
        this.vp_view = vp_view;
        this.tablayout = tablayout;
    }

    public void itemOnClick() {
        Fragment fragment = fragments.get(1);
        if (fragment instanceof TwoFragment) {
            ((TwoFragment) fragment).itemClick();
        }
    }



}
