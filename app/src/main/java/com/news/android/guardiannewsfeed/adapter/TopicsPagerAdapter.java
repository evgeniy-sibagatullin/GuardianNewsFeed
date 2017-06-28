package com.news.android.guardiannewsfeed.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.news.android.guardiannewsfeed.R;
import com.news.android.guardiannewsfeed.fragment.FamilyFragment;
import com.news.android.guardiannewsfeed.fragment.HealthFragment;
import com.news.android.guardiannewsfeed.fragment.MusicFragment;
import com.news.android.guardiannewsfeed.fragment.SportFragment;

public class TopicsPagerAdapter extends FragmentPagerAdapter {

    private static final int TOPICS_COUNT = 4;
    private Context mContext;

    public TopicsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FamilyFragment();
            case 1:
                return new HealthFragment();
            case 2:
                return new MusicFragment();
            default:
                return new SportFragment();
        }
    }

    @Override
    public int getCount() {
        return TOPICS_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.family);
            case 1:
                return mContext.getString(R.string.health);
            case 2:
                return mContext.getString(R.string.music);
            default:
                return mContext.getString(R.string.sport);
        }
    }
}