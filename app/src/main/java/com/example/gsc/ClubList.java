package com.example.gsc;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class ClubList {

    private int mClubLogo ;
    private String mPhoneno1,mPhoneno2,mClubName,mClubAbout,mHead1,mHead2,mEmail1,mEmail2;
    private int mClubHeadPic1, mClubHeadPic2;

    public ClubList(int ClubLogo, String ClubName, String ClubAbout, String Head1, String Head2, String Email1, String Email2, String Phone1, String Phone2, int mClubHeadPic1, int mClubHeadPic2){
        mClubLogo = ClubLogo;
        mClubName = ClubName;
        mClubAbout = ClubAbout;

        // null value
        String mDefaultValue = "xx";
        if (Head1.equals(mDefaultValue))
            mHead1 = null;
        else
            mHead1 = Head1;
        if (Head2.equals(mDefaultValue))
            mHead2 = null;
        else
            mHead2 = Head2;
        if (Email1.equals(mDefaultValue))
            mEmail1 = null;
        else
            mEmail1 = Email1;
        if (Email2.equals(mDefaultValue))
            mEmail2 = null;
        else
            mEmail2 = Email2;
        if (Phone1.equals(mDefaultValue))
            mPhoneno1 = null;
        else
            mPhoneno1 = Phone1;
        if (Phone2.equals(mDefaultValue))
            mPhoneno2 = null;
        else
            mPhoneno2 = Phone2;

        this.mClubHeadPic1 = mClubHeadPic1;
        this.mClubHeadPic2 = mClubHeadPic2;


    }


    public int getmClubHeadPic1() {
        return mClubHeadPic1;
    }

    public int getmClubHeadPic2() {
        return mClubHeadPic2;
    }

    public int getmClubLogo(){return mClubLogo;}
    public  String getmClubName(){return mClubName;}
    public  String getmClubAbout(){return  mClubAbout;}

    public String getmHead1(){return mHead1;}
    public String getmHead2(){return mHead2;}
    public String getmEmail1(){return mEmail1;}
    public String getmEmail2(){return mEmail2;}
    public String getmPhoneno1(){return mPhoneno1;}
    public String getmPhoneno2(){return mPhoneno2;}
}
