package com.example.gsc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

//----------------------------------- Variables ----------------------------------------------------

    EditText mName, mAdmissionNo, mEnrollmentNo, mContactNo, mWhatsappNo, mEmailId, mSelectedeClubs;
    Button mRegisterBtn,mSelectClubbtn;
    TextView mFee;
    int mTotlaFee;


    String[] mClubsList;
    boolean[] checkedClubs;
    ArrayList<Integer> mClubs = new ArrayList<>();
    DatabaseReference databaseStudent;

//--------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

//------------------------------------ initial Values ----------------------------------------------

        mName = findViewById(R.id.Name);
        mAdmissionNo = findViewById(R.id.AdmissionNo);
        mEnrollmentNo = findViewById(R.id.EnrollNo);
        mContactNo = findViewById(R.id.ContactNo);
        mWhatsappNo = findViewById(R.id.WhatsappNo);
        mEmailId = findViewById(R.id.EmailId);
        mRegisterBtn = findViewById(R.id.registerbtn);
        mSelectClubbtn = findViewById(R.id.selectClub);
        mSelectedeClubs = findViewById(R.id.clubsSelected);
        mFee = findViewById(R.id.Fee);
        mTotlaFee = 0;

        mClubsList = getResources().getStringArray(R.array.Clubs);
        checkedClubs = new boolean[mClubsList.length];
//--------------------------------------------------------------------------------------------------


//--------------------------------- To Select Clubs ------------------------------------------------
        mSelectClubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(RegistrationActivity.this);
                mBuilder.setTitle("Select Clubs");
                mBuilder.setMultiChoiceItems(mClubsList, checkedClubs, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (isChecked) {
                            mClubs.add(position);
                            Log.d("Log_test", String.format("Index - %d, Size - %d", position, mClubs.size()));
                        } else if (mClubs.contains(position)) {
                            mClubs.remove(Integer.valueOf(position));
                            Log.d("Log_test", String.format("Index - %d, Size - %d", position, mClubs.size()));
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mClubsSelected = "";
                        int mPerFee = 30;
                        if (mClubs.size() <= 3) {
                            for (int i = 0; i < mClubs.size(); i++) {
                                mClubsSelected = mClubsSelected + mClubsList[mClubs.get(i)];
                                mTotlaFee = (mPerFee * mClubs.size());
                                if (i != mClubs.size() - 1) {
                                    mClubsSelected = mClubsSelected + ", ";
                                }
                            }
                            mSelectedeClubs.setText(mClubsSelected);
                            mFee.setText(String.format("Rs " + mTotlaFee));
                        } else {
                            Toast.makeText(RegistrationActivity.this, "max 3 clus can select", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < checkedClubs.length; i++) {
                                checkedClubs[i] = false;
                                mClubs.clear();
                                mSelectedeClubs.setText("No Clubs Selected");
                                mFee.setText("Rs 0.0");
                            }

                        }
                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedClubs.length; i++) {
                            checkedClubs[i] = false;
                            mClubs.clear();
                            mSelectedeClubs.setText("No Clubs Selected");
                            mFee.setText("Rs 0.0");
                        }
                        dialog.dismiss();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
//--------------------------------------------------------------------------------------------------

//------------------------------------ Firebase ----------------------------------------------------

        databaseStudent = FirebaseDatabase.getInstance().getReference("Students");

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference userNameRef = rootRef.child("Students").child("mAdmissionNo");
                ValueEventListener eventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (!dataSnapshot.exists()) {
                            addStudent();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("Log_test", databaseError.getMessage());
                    }
                };
                userNameRef.addListenerForSingleValueEvent(eventListener);
            }
        });

    }

//-------------------------------- Add Student to Firebase -----------------------------------------

    private void addStudent(){
        String name = mName.getText().toString().trim();
        String admission_No = mAdmissionNo.getText().toString().trim();
        String enroll_No = mEnrollmentNo.getText().toString().trim();
        String contact_No = mContactNo.getText().toString().trim();
        String whatsapp_No = mWhatsappNo.getText().toString().trim();
        String emailId = mEmailId.getText().toString().trim();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(admission_No) && !TextUtils.isEmpty(enroll_No) && !TextUtils.isEmpty(contact_No) && !TextUtils.isEmpty(whatsapp_No) && !TextUtils.isEmpty(emailId)){

            StrudentInfo mstudent = new StrudentInfo(name, admission_No, enroll_No, contact_No, whatsapp_No, emailId, mTotlaFee);

            databaseStudent.child(admission_No).setValue(mstudent);
            
        }
        else {
            Toast.makeText(RegistrationActivity.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
        }
    }
}
