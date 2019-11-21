package com.example.gsc;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClubEventTabFragment extends Fragment {

    RecyclerView mEventList;
    public ClubEventTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_club_event_tab_, container, false);

        ArrayList<EventList> meventList = new ArrayList<>();

        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));

        mEventList = view.findViewById(R.id.eventRecyclerView);
        mEventList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEventList.setAdapter(new EventListAdapter(meventList,getActivity()));
        return view;
    }

}
