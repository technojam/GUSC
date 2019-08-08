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
import com.example.gsc.ClubList;
import java.util.ArrayList;

public class ClubFragment extends Fragment {

    RecyclerView mClubList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_club,container,false);

        // this is for club list.

        ArrayList<ClubList> mclublist = new ArrayList<>();

        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));
        mclublist.add(new ClubList(R.drawable.galgotias_university,"Galgotias Student Club","GSC"));

        mClubList = rootView.findViewById(R.id.clubRecyclerView);
        mClubList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClubList.setAdapter(new ClubListAdapter(mclublist,getActivity()));
        return rootView;
    }
}

