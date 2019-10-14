package com.example.gsc;

public class RegisterStudent {

    private String mName, mAdmissionNo, mEnrollmentNo, mEmailId, mClubName;
    private int mContactNo, mWhatsappNo;

    public RegisterStudent(){

    }

    public RegisterStudent(String mName, String mAdmissionNo, String mEnrollmentNo, String mEmailId, String mClubName, int mContactNo, int mWhatsappNo) {
        this.mName = mName;
        this.mAdmissionNo = mAdmissionNo;
        this.mEnrollmentNo = mEnrollmentNo;
        this.mEmailId = mEmailId;
        this.mClubName = mClubName;
        this.mContactNo = mContactNo;
        this.mWhatsappNo = mWhatsappNo;
    }

    public String getmName() {
        return mName;
    }

    public String getmAdmissionNo() {
        return mAdmissionNo;
    }

    public String getmEnrollmentNo() {
        return mEnrollmentNo;
    }

    public String getmEmailId() {
        return mEmailId;
    }

    public String getmClubName() {
        return mClubName;
    }

    public int getmContactNo() {
        return mContactNo;
    }

    public int getmWhatsappNo() {
        return mWhatsappNo;
    }
}
