package com.example.gsc;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.ClubHolder> {

    private ArrayList<ClubList> clubList;
    Context context;

    public ClubListAdapter(ArrayList<ClubList> Photo, Context context){
        this.clubList = Photo;
        this.context = context;
    }

    @NonNull
    @Override
    public ClubHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.club_list_activity, viewGroup, false);
        return new ClubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClubHolder clubHolder, int i) {
        final ClubList mClub = clubList.get(i);

        clubHolder.mClubLogo.setImageResource(mClub.getmClubLogo());
        clubHolder.ClubName.setText(mClub.getmClubName());

        clubHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Club is clicked");
                Intent intent = new Intent(context,ClubActivity.class);
                intent.putExtra("clubLogo",mClub.getmClubLogo());
                intent.putExtra("AboutClub",mClub.getmClubAbout());
                intent.putExtra("ClubName",mClub.getmClubName());
                intent.putExtra("Head1",mClub.getmHead1());
                intent.putExtra("Head2",mClub.getmHead2());
                intent.putExtra("Email1",mClub.getmEmail1());
                intent.putExtra("Email2",mClub.getmEmail2());
                intent.putExtra("Phone1",mClub.getmPhoneno1());
                intent.putExtra("Phone2",mClub.getmPhoneno2());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    public class ClubHolder extends RecyclerView.ViewHolder{

       ImageView mClubLogo;
       TextView ClubName,ClubAbout;
       View rootView;

        public ClubHolder(@NonNull View itemView) {
            super(itemView);

            rootView = itemView;
            mClubLogo = itemView.findViewById(R.id.clubLogo);
            ClubName = itemView.findViewById(R.id.clubName);
            ClubAbout = itemView.findViewById(R.id.clubAbout);
        }
    }
}
