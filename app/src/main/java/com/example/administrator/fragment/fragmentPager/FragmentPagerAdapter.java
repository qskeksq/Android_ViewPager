package com.example.administrator.fragment.fragmentPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017-10-12.
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> datas;

    public FragmentPagerAdapter(FragmentManager fm, List<Fragment> datas) {
        super(fm);
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
