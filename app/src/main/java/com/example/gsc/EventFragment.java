package com.example.gsc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class EventFragment extends Fragment {

    RecyclerView mEventList;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState); }


    @Override

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_event,container,false);

        ArrayList<EventList> meventList = new ArrayList<>();

        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));
        meventList.add(new EventList("Event Name"));

        mEventList = rootView.findViewById(R.id.eventRecyclerView);
        mEventList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEventList.setAdapter(new EventListAdapter(meventList,getActivity()));
        return rootView;
    }

}


