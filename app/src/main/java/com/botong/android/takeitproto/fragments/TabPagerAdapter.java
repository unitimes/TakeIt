package com.botong.android.takeitproto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.botong.android.takeitproto.R;

import java.util.ArrayList;

/**
 * Created by cob_macpro on 2015. 1. 27..
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter implements ActionBar.TabListener, ViewPager.OnPageChangeListener{

    private Context context;
    private ActionBar actionBar;
    private ViewPager viewPager;

    private class TabInfo {
        private Class<?> clss;
        private Bundle args;

        TabInfo(Class<?> _class, Bundle args) {
            clss = _class;
            this.args = args;
        }
    }

    public TabPagerAdapter(ActionBarActivity act, ViewPager viewPager) {
        super(act.getSupportFragmentManager());
        this.context = act;
        this.actionBar = act.getSupportActionBar();
        this.viewPager = viewPager;
        viewPager.setAdapter(this);
        viewPager.setOnPageChangeListener(this);
    }

    public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
        TabInfo info =  new TabInfo(clss, args);
        tab.setTag(info);
        tab.setTabListener(this);
        actionBar.addTab(tab);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return actionBar.getTabCount();
    }

    @Override
    public Fragment getItem(int position) {
        TabInfo info = (TabInfo) actionBar.getTabAt(position).getTag();
        return Fragment.instantiate(context, info.clss.getName(), info.args);
    }

    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
//        int[] strId = {R.string.write, R.string.real_time, R.string.weather, R.string.my};
        actionBar.setTitle(actionBar.getTabAt(position).getText());
    }

    //override ViewPager.OnPageChangeListener
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //override ViewPager.OnPageChangeListener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
