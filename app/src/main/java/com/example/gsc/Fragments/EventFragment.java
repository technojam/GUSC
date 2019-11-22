package com.example.gsc.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gsc.Adapters.FragmentTabAdapter;
import com.example.gsc.R;
import com.google.android.material.tabs.TabLayout;

public class EventFragment extends Fragment {


    TabLayout mTabLayout;
    ViewPager mViewPager;
    FragmentPagerAdapter mfragmentPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState); }


    @Override

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_event,container,false);

        mTabLayout = rootView.findViewById(R.id.EventTab);
        mViewPager= rootView.findViewById(R.id.viewPager);

        mfragmentPagerAdapter = new FragmentTabAdapter(this.getChildFragmentManager());
        mViewPager.setAdapter(mfragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

       /* ArrayList<EventList> meventList = new ArrayList<>();

        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));

        mEventList = rootView.findViewById(R.id.eventRecyclerView);
        mEventList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEventList.setAdapter(new EventListAdapter(meventList,getActivity()));*/
        return rootView;
    }


}


