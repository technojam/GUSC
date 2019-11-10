package com.example.gsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateEventActivity extends AppCompatActivity {

    private EditText mEventName, mEventDate;
    private ImageView mEventCoverPic;
    private Button mCreateEvent;

    private FirebaseFirestore database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

      mEventName = findViewById(R.id.eventname);
      mEventDate = findViewById(R.id.eventdata);
      mEventCoverPic = findViewById(R.id.coverpic);
      mCreateEvent = findViewById(R.id.createbtn);

      final String mClubName = getIntent().getStringExtra("clubname");

      database = FirebaseFirestore.getInstance();
      mAuth = FirebaseAuth.getInstance();

      mCreateEvent.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String EventName = mEventName.getText().toString().trim();
              String EventDate = mEventDate.getText().toString().trim();

              DocumentReference dbReference = collectionReference("Clubs", mClubName, "Events").document(EventName);

              CreateEvent mCreateEvent = new CreateEvent(EventName, EventDate);

              final ProgressDialog progressDialog = new ProgressDialog(CreateEventActivity.this);
              progressDialog.setTitle("Uploading...");
              progressDialog.show();

              dbReference.set(mCreateEvent)

                      .addOnSuccessListener(new OnSuccessListener<Void>() {
                          @Override
                          public void onSuccess(Void aVoid) {
                              progressDialog.dismiss();
                              Toast.makeText(CreateEventActivity.this, "Event Created Successful", Toast.LENGTH_SHORT).show();
                          }
                      })
                      .addOnFailureListener(new OnFailureListener() {
                          @Override
                          public void onFailure(@NonNull Exception e) {
                              progressDialog.dismiss();
                              Toast.makeText(CreateEventActivity.this, "Event Not Created", Toast.LENGTH_SHORT).show();
                          }
                      });
          }
      });
    }

    private CollectionReference collectionReference(String collection, String document, String doc_collection){

        CollectionReference databaseRegisterStudent = database.collection(collection)
                .document(document)
                .collection(doc_collection);

        return databaseRegisterStudent;
    }

}
