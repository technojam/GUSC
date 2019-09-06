package com.example.gsc;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_home,container,false);

       //For Constitution
        LinearLayout mConstitution= view.findViewById(R.id.constitution);

        mConstitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ConstitutionActivity.class));

            }
        });

        //For What We do
        LinearLayout mWhatWeDo = view.findViewById(R.id.What_we_do);

        mWhatWeDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),WhatWeDoActivity.class));
            }
        });

        //For Hierarchy;

        LinearLayout mHierarchy = view.findViewById(R.id.Hierarchy);

        mHierarchy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HierarchyActivity.class));
            }
        });

        //For FAQ
        LinearLayout mFAQ = view.findViewById(R.id.F_A_Q);
        mFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),FAQActivity.class));
            }
        });

        Button mRegistration = view.findViewById(R.id.registrationbtn);

        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RegistrationActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

