package com.example.gsc;

public class EventList {

    private int mClubLogo;
    private String mEventsList;

    public EventList(int clubLogo, String EventsList) {
        mClubLogo = clubLogo;
        mEventsList = EventsList;
    }

    public int getmclubLogo() {
        return mClubLogo;
    }

    public String getmEventsList() {
        return mEventsList;
    }
}
