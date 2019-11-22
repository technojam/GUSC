package com.example.gsc.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsc.Adapters.ListOfStudentAdapter;
import com.example.gsc.HelperClass.ListOfStudent;
import com.example.gsc.HelperClass.RegisterStudent;
import com.example.gsc.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RegisteredStudentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListOfStudentAdapter adapter;
    private ArrayList<RegisterStudent> mStudentList;
    private ProgressBar progressBar;
    private String mClubName;
    private TextView mErrorMessage;

    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_student);

        mClubName = getIntent().getStringExtra("clubname");
        database = FirebaseFirestore.getInstance();
        mErrorMessage = findViewById(R.id.error_message);

        mErrorMessage.setVisibility(View.GONE);

        progressBar = findViewById(R.id.progressbar);

        recyclerView = findViewById(R.id.Student_List_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStudentList = new ArrayList<>();
        adapter = new ListOfStudentAdapter(mStudentList, this);

        recyclerView.setAdapter(adapter);

        database.collection("Clubs")
                .document(mClubName)
                .collection("Registered Student")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        progressBar.setVisibility(View.GONE);

                        if(!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> mListOfStudent = queryDocumentSnapshots.getDocuments();

                            for(DocumentSnapshot d: mListOfStudent){

                                RegisterStudent listofstudent = d.toObject(RegisterStudent.class);
                                mStudentList.add(listofstudent);
                            }

                            adapter.notifyDataSetChanged();
                        }
                        else{

                            mErrorMessage.setVisibility(View.VISIBLE);

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisteredStudentActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
