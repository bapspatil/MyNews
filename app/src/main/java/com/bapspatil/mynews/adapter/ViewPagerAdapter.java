package com.bapspatil.mynews.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bapspatil.mynews.ui.MainFragment;
import com.bapspatil.mynews.util.Constants;

/*
 ** Created by Bapusaheb Patil {@link https://bapspatil.com}
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Constants.SECTIONS[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(Constants.SECTIONS[position]);
    }

    @Override
    public int getCount() {
        return Constants.SECTIONS.length;
    }
}
