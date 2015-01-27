package com.botong.android.takeitproto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.botong.android.takeitproto.fragments.MyPageFragment;
import com.botong.android.takeitproto.fragments.RealTimeFragment;
import com.botong.android.takeitproto.fragments.TabPagerAdapter;
import com.botong.android.takeitproto.fragments.WeatherFragment;
import com.botong.android.takeitproto.fragments.WriteFragment;


public class WriteHomeActivity extends ActionBarActivity {

    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private ActionBar actionBar;

    public ViewPager getViewPager() {
        return viewPager;
    }

    public TabPagerAdapter getTabPagerAdapter() {
        return tabPagerAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = new ViewPager(this);
        viewPager.setId(R.id.pagerMain);
        setContentView(viewPager);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabPagerAdapter = new TabPagerAdapter(this, viewPager);

        tabPagerAdapter.addTab(actionBar.newTab().setText(R.string.write), WriteFragment.class, null);
        tabPagerAdapter.addTab(actionBar.newTab().setText(R.string.real_time), RealTimeFragment.class, null);
        tabPagerAdapter.addTab(actionBar.newTab().setText(R.string.weather), WeatherFragment.class, null);
        tabPagerAdapter.addTab(actionBar.newTab().setText(R.string.my), MyPageFragment.class, null);

        actionBar.setTitle(R.string.write);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_write_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
