package com.example.gsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class VerificationActivity extends AppCompatActivity {

    private String TAG = "Log_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        final EditText mEmail = findViewById(R.id.Email);
        Button mVerifyBtn = findViewById(R.id.vreify);

        final String Email = getIntent().getStringExtra("Email");

        mEmail.setText(Email);

        mVerifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                if(mAuth.getCurrentUser() != null){
                        mAuth.getCurrentUser().sendEmailVerification()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Log.d(TAG, "Email - "+FirebaseAuth.getInstance().getCurrentUser().getEmail() + "Activity - "+ this.toString() + " Email is sent");
                                        startActivity(new Intent(VerificationActivity.this, LoginActivity.class));
                                    }
                                });
                    }
                else {
                    Log.d(TAG, "Email - "+FirebaseAuth.getInstance().getCurrentUser().getEmail() + "Activity - "+ this.toString() + " Email not sent");
                }
                }
        });

    }
}
