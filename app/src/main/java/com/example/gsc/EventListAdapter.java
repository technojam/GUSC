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

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventHolder> {

    private ArrayList<EventList> eventList;
    Context context;

    public EventListAdapter(ArrayList<EventList> Photo , Context context) {
        this.eventList=Photo;
        this.context=context;
    }


    @NonNull
    @Override
    public EventListAdapter.EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_list_activity, viewGroup,false);
        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdapter.EventHolder eventHolder, int i) {

        EventList mEvent = eventList.get(i);

        eventHolder.EventsList.setText(mEvent.getmEventsList());

        eventHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Event is Clicked");
                Intent intent = new Intent(context,EventActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder{

        TextView EventsList;
        View rootView;

        public EventHolder(@NonNull View itemView) {
            super(itemView);

            rootView = itemView;
            EventsList = itemView.findViewById(R.id.EventsList);

        }
    }
}
