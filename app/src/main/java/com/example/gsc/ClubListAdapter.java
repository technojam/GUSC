package com.example.gsc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

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
    public void onBindViewHolder(@NonNull ClubHolder clubHolder, int i) {
        ClubList mClub = clubList.get(i);

        clubHolder.mClubLogo.setImageResource(mClub.getmClubLogo());
        clubHolder.ClubName.setText(mClub.getmClubName());
        clubHolder.ClubAbout.setText(mClub.getmClubAbout());

        clubHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Club is clicked");
                Intent intent = new Intent(context,ClubActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    public class ClubHolder extends RecyclerView.ViewHolder{

       CircleImageView mClubLogo;
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
