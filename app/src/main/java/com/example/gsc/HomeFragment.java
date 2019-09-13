package com.example.gsc;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toolbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import static java.net.Proxy.Type.HTTP;


public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_home,container,false);

        ImageButton mMenuBtn = view.findViewById(R.id.aboutmenu);
        mAuth = FirebaseAuth.getInstance();

        mMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(getActivity(), v);
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.about_menu, popup.getMenu());
                    popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.share:
                                Log.d("Log_test","Share button is clicked");
                                Intent mShareIntent = new Intent(Intent.ACTION_SEND);
                                mShareIntent.setType("text/plain");
                                mShareIntent.putExtra(Intent.EXTRA_SUBJECT,"Galgotias University Student Council");
                                String mMessage = "Hi I'm using galgotias university student council app and it helps me very much !! Try it !!";
                                mShareIntent.putExtra(Intent.EXTRA_TEXT, mMessage);
                                if(mShareIntent.resolveActivity(getActivity().getPackageManager()) != null){
                                    startActivity(mShareIntent);
                                }
                                break;
                            case R.id.contact:
                                Log.d("Log_test","Contact Us button is clicked");
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("*/*");
                                intent.putExtra(Intent.EXTRA_EMAIL, "singhra66@gmail.com");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Galgotias University Student Council App");
                                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                                    startActivity(intent);
                                }
                                break;
                            case R.id.about:
                                Log.d("Log_test","About button is clicked");
                                Dialog maboutdialog = new Dialog(getContext());
                                maboutdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                maboutdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                maboutdialog.setContentView(R.layout.about_dialog_layout);
                                maboutdialog.show();
                                break;
                            case R.id.logout:
                                Log.d("Log_test","logout button is clicked");

                                mAuth.signOut();
                                getActivity().finish();

                                Intent mintent =  new Intent(getActivity(),LoginActivity.class);
                                // to kill all activity stack
                                mintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                /*mintent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);*/
                               /* mintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );*/
                                startActivity(mintent);
                                getActivity().finish();
                                break;
                        }
                        Log.d("Log_test",getActivity().toString());
                        return false;
                    }
                });
            }
        });




//---------------------------------- For Constitution ----------------------------------------------
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

