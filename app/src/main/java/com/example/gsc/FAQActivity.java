package com.example.gsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    ExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        expandableListView = findViewById(R.id.faqListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new ExpandableAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {
        listGroup.add(getString(R.string.faq1));
        listGroup.add(getString(R.string.faq2));
        listGroup.add(getString(R.string.faq3));
        listGroup.add(getString(R.string.faq4));
        listGroup.add(getString(R.string.faq5));
        listGroup.add(getString(R.string.faq6));
        listGroup.add(getString(R.string.faq7));

        String[] array;
        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq1);
        for (String item : array){
            list1.add(item);
        }
        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq2);
        for (String item : array){
            list2.add(item);
        }
        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq3);
        for (String item : array){
            list3.add(item);
        }
        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq4);
        for (String item : array){
            list4.add(item);
        }
        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq5);
        for (String item : array){
            list5.add(item);
        }
        List<String> list6 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq6);
        for (String item : array){
            list6.add(item);
        }
        List<String> list7 = new ArrayList<>();
        array = getResources().getStringArray(R.array.faq7);
        for (String item : array) {
            list7.add(item);
        }

        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        listItem.put(listGroup.get(5),list6);
        listItem.put(listGroup.get(6),list7);

        adapter.notifyDataSetChanged();
    }
}
