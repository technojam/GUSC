package com.example.gsc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {

    RecyclerView mEventList;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState); }


    @Override

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_event,container,false);

        ArrayList<EventList> meventList = new ArrayList<>();

        meventList.add(new EventList(R.drawable.galgotias_university,"Event Name"));
        meventList.add(new EventList(R.drawable.galgotias_university,"Event Nmae"));
        meventList.add(new EventList(R.drawable.galgotias_university,"Event Name"));
        meventList.add(new EventList(R.drawable.galgotias_university,"Event Nmae"));
        meventList.add(new EventList(R.drawable.galgotias_university,"Event Name"));
        meventList.add(new EventList(R.drawable.galgotias_university,"Event Nmae"));

        mEventList = rootView.findViewById(R.id.eventRecyclerView);
        mEventList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEventList.setAdapter(new EventListAdapter(meventList,getActivity()));
        return rootView;
    }

}


