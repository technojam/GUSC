package com.example.gsc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentTabAdapter extends FragmentPagerAdapter{
    public FragmentTabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new CoreEventTabFragment();
        else if (position == 1)
            return new ClubEventTabFragment();
            return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Core Events";
            case 1:
                return "Clubs Events";
        }
        return super.getPageTitle(position);
    }
}