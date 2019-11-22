package com.example.gsc.HelperClass;

public class RegisterStudent {

    private String mName, mAdmissionNo, mEnrollmentNo, mEmailId, mClubName;
    private Long mContactNo, mWhatsappNo;

    public RegisterStudent(){

    }

    public RegisterStudent(String mName, String mAdmissionNo, String mEnrollmentNo, String mEmailId, String mClubName, Long mContactNo, Long mWhatsappNo) {
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

    public Long getmContactNo() {
        return mContactNo;
    }

    public Long getmWhatsappNo() {
        return mWhatsappNo;
    }
}
