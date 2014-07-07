package net.gfound.security.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by wuhaijujn on 14-7-4.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentsList;

    public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
        super(fm);
        if(fragmentsList == null) {
            this.fragmentsList = new ArrayList<Fragment>();
        } else {
            this.fragmentsList = fragmentsList;
            System.out.println();
        }
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
