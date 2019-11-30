package com.example.ecochange;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Progresses.monthlyProgress;
import com.Progresses.weeklyProgress;
import com.Progresses.yearlyProgress;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab1, R.string.tab2,R.string.tab3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }



    @SuppressWarnings("deprecation")
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment fragment = new weeklyProgress();
                return fragment;

            case 1:
                Fragment fragment1 = new monthlyProgress();
                return fragment1;

            case 2:
                Fragment fragment2 = new yearlyProgress();
                return fragment2;

            default:
                Fragment fragment4 = null;
                return fragment4;
        }


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}
