package com.example.gsc;

public class StrudentInfo {

    String mName, mAdmissionNo, mEnrollNo, mContactNo, mWhatsappNo, memail;
    int mFee;

    public StrudentInfo() {
    }

    public StrudentInfo(String mName, String mAdmissionNo, String mEnrollNo, String mContactNo, String mWhatsappNo, String memail, int mFee) {
        this.mName = mName;
        this.mAdmissionNo = mAdmissionNo;
        this.mEnrollNo = mEnrollNo;
        this.mContactNo = mContactNo;
        this.mWhatsappNo = mWhatsappNo;
        this.memail = memail;
        this.mFee = mFee;
    }

    public String getmName() {
        return mName;
    }

    public String getmAdmissionNo() {
        return mAdmissionNo;
    }

    public String getmEnrollNo() {
        return mEnrollNo;
    }

    public String getmContactNo() {
        return mContactNo;
    }

    public String getmWhatsappNo() {
        return mWhatsappNo;
    }

    public String getMemail() {
        return memail;
    }

    public int getmFee() {
        return mFee;
    }
}
