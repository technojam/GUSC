package com.example.gsc;

public class ClubList {

    private int mClubLogo;
    private String mClubName, mClubAbout;

    public ClubList(int ClubLogo, String ClubName, String ClubAbout){
        mClubLogo = ClubLogo;
        mClubName = ClubName;
        mClubAbout = ClubAbout;
    }

    public int getmClubLogo(){return mClubLogo;}
    public  String getmClubName(){return mClubName;}
    public  String getmClubAbout(){return  mClubAbout;}
}
