package com.example.gsc;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

//----------------------------------- Variables ----------------------------------------------------

   private EditText mName, mAdmissionNo, mEnrollmentNo, mContactNo, mWhatsappNo, mEmailId;
   private Button mRegisterBtn, mSelectClubbtn;
   private TextView mFee, mSelectedeClubs;
   private int mTotlaFee;
   private String mClubName, Uid;

   private FirebaseFirestore database;
   private FirebaseAuth mAuth;

   private String[] mClubsList;
   private boolean[] checkedClubs;
    /*ArrayList<Integer> mClubs = new ArrayList<>();
    DatabaseReference databaseStudent;*/


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
        /*mSelectClubbtn = findViewById(R.id.selectClub);*/
        mSelectedeClubs = findViewById(R.id.clubsSelected);
        mFee = findViewById(R.id.Fee);
        mTotlaFee = 0;

        mClubsList = getResources().getStringArray(R.array.Clubs);
        checkedClubs = new boolean[mClubsList.length];

        mClubName = getIntent().getStringExtra("clubname");
        Log.d("Log_test", "onCreate: " + mClubName);
//--------------------------------------------------------------------------------------------------


//--------------------------------- To Select Clubs ------------------------------------------------
       /* mSelectClubbtn.setOnClickListener(new View.OnClickListener() {
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
        });*/

        mSelectedeClubs.setText(mClubName);
        mFee.setText("Rs. 30.00");
//--------------------------------------------------------------------------------------------------

//------------------------------------ Firebase ----------------------------------------------------

        database = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString().trim();
                String admission_No = mAdmissionNo.getText().toString().trim();
                String enroll_No = mEnrollmentNo.getText().toString().trim();
                String contact_No = mContactNo.getText().toString().trim();
                String whatsapp_No = mWhatsappNo.getText().toString().trim();
                String emailId = mEmailId.getText().toString().trim();

                Uid = mAuth.getUid();

                if(database.collection("Clubs").document(mClubName).collection("Registered Student").document(Uid).getId().equals(Uid)) {
                    Toast.makeText(RegistrationActivity.this, "Already Registered", Toast.LENGTH_SHORT).show();
                }
                else if (!validateInput(name, admission_No, enroll_No, contact_No, whatsapp_No, emailId)) {

                    DocumentReference dbReference = collectionReference("Clubs", mClubName, "Registered Student").document(Uid);

                    RegisterStudent mRegisterStudent = new RegisterStudent(
                            name,
                            admission_No,
                            enroll_No,
                            emailId,
                            mClubName,
                            Integer.parseInt(contact_No),
                            Integer.parseInt(whatsapp_No)
                    );

                    dbReference.set(mRegisterStudent)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                }
            }
        });

    }
//-------------------------------- Add Student to Firebase -----------------------------------------

    private CollectionReference collectionReference(String collection, String document, String doc_collection){

        CollectionReference databaseRegisterStudent = database.collection(collection)
                .document(document)
                .collection(doc_collection);

        return databaseRegisterStudent;
    }

//--------------------------------------Validation--------------------------------------------------

    private boolean validateInput(String name, String admissionNo, String enrollmentNo, String contactNo, String whatssppNo, String email){
        if(TextUtils.isEmpty(name)){
            mName.setError("Name Required");
            mName.requestFocus();
            return true;
        }
        if(TextUtils.isEmpty(admissionNo)){
            mAdmissionNo.setError("Admission No. Required");
            mAdmissionNo.requestFocus();
            return true;
        }
        if(TextUtils.isEmpty(enrollmentNo)){
            mEnrollmentNo.setError("Enrollment No. Required");
            mEnrollmentNo.requestFocus();
            return true;
        }
        if(TextUtils.isEmpty(contactNo)){
            mContactNo.setError("Contact Required");
            mContactNo.requestFocus();
            return true;
        }
        if(TextUtils.isEmpty(whatssppNo)){
            mWhatsappNo.setError("Whatsapp No. Required");
            mWhatsappNo.requestFocus();
            return true;
        }
        if(TextUtils.isEmpty(email)){
            mEmailId.setError("Email Required");
            mEmailId.requestFocus();
            return true;
        }
        return false;
    }
}
