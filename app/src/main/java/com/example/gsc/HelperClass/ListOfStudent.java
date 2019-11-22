package com.example.gsc.HelperClass;

public class ListOfStudent {

    private String mNameOfStudent, mAdmissionNo;

    public ListOfStudent(){

    }

    public ListOfStudent(String mNameOfStudent, String mAdmissionNo) {
        this.mNameOfStudent = mNameOfStudent;
        this.mAdmissionNo = mAdmissionNo;
    }

    public String getmNameOfStudent() {
        return mNameOfStudent;
    }

    public String getmAdmissionNo() {
        return mAdmissionNo;
    }
}
