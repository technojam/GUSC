package com.example.gsc.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.gsc.Adapters.ExpandableAdapter;
import com.example.gsc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstitutionActivity extends AppCompatActivity  {
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    ExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constitution);

        // This is used to open only one Expandable View
        expandableListView = (ExpandableListView) findViewById(R.id.expendableListView);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousItem = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousItem){
                    expandableListView.collapseGroup(previousItem);
                    previousItem=groupPosition;
                }
            }
        });


        expandableListView = findViewById(R.id.expendableListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new ExpandableAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {
        listGroup.add(getString(R.string.Constitution_Preamble));
        listGroup.add(getString(R.string.Constitution_Declaration));
        listGroup.add(getString(R.string.Constitution_Membership));
        listGroup.add(getString(R.string.Constitution_CouncilsCoreTeam));
        listGroup.add(getString(R.string.Constitution_The_Executive));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Constitution_Preamble);
        for (String item : array){
            list1.add(item);
        }
        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Constitution_Declaration);
        for (String item : array){
            list2.add(item);
        }
        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Constitution_Membership);
        for (String item : array){
            list3.add(item);
        }
        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Constitution_CouncilsCoreTeam);
        for (String item : array){
            list4.add(item);
        }
        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.Constitution_The_Executive);
        for (String item : array){
            list5.add(item);
        }

        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        adapter.notifyDataSetChanged();

    }

}
