package net.gfound.security.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import net.gfound.security.R;
import net.gfound.security.adapter.MainPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements
        ViewPager.OnPageChangeListener, View.OnClickListener {

    private RadioGroup navi;

    private MainPagerAdapter mAdapter;

    private ViewPager mPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);

        navi = (RadioGroup) findViewById(R.id.radio_group);
        findViewById(R.id.main_navi_jwbb).setOnClickListener(this);
        findViewById(R.id.main_navi_spjk).setOnClickListener(this);
        findViewById(R.id.main_navi_dzsp).setOnClickListener(this);
        findViewById(R.id.main_navi_bbs).setOnClickListener(this);
        mPager = (ViewPager) findViewById(R.id.pager);
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        JWBBFragment jwbbFragment = new JWBBFragment();
        SPJKFragment spjkFragment = new SPJKFragment();
        DZSPFragment dzspFragment = new DZSPFragment();
        BBSFragment bbsFragment = new BBSFragment();

        fragments.add(jwbbFragment);
        fragments.add(spjkFragment);
        fragments.add(dzspFragment);
        fragments.add(bbsFragment);

        mAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        mPager.isSaveEnabled();
        mPager.setAdapter(mAdapter);
//        mPager.set
        mPager.setOnPageChangeListener(this);
        navi.check(R.id.main_navi_jwbb);
    }
//
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        int item;
//        switch (checkedId) {
//            case R.id.main_navi_spjk:
//                item = 1;
//                break;
//            case R.id.main_navi_dzsp:
//                item = 2;
//                break;
//            case R.id.main_navi_bbs:
//                item = 3;
//                break;
//            case R.id.main_navi_jwbb:
//            default:
//                item = 0;
//                break;
//        }
//        mPager.setCurrentItem(item, true);
//    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switch(position) {
            case 1:
                navi.check(R.id.main_navi_spjk);
                break;
            case 2:
                navi.check(R.id.main_navi_dzsp);
                break;
            case 3:
                navi.check(R.id.main_navi_bbs);
                break;
            case 0:
            default:
                navi.check(R.id.main_navi_jwbb);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onClick(View v) {
        // TODO onClick
        switch(v.getId()){
            case R.id.main_navi_jwbb:
                mPager.setCurrentItem(0);
                break;
            case R.id.main_navi_spjk:
                mPager.setCurrentItem(1);
                break;
            case R.id.main_navi_dzsp:
                mPager.setCurrentItem(2);
                break;
            case R.id.main_navi_bbs:
                mPager.setCurrentItem(3);
                break;
        }
    }
}