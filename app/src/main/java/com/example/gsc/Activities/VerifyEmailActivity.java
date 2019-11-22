package com.example.gsc.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class VerifyEmailActivity extends AppCompatActivity {


    LinearLayout mWarningBox;
    TextView mWarningBoxText;
    TextView mEmailToVerify;
    Button mVerifyButton, mStartButton;
    FirebaseAuth mFirebaseAuth;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email);

        mWarningBox = findViewById(R.id.warningbox);
        mWarningBoxText = findViewById(R.id.warningboxtext);
        mEmailToVerify = findViewById(R.id.email_to_verify);
        mVerifyButton = findViewById(R.id.verify_btn);


        email = getIntent().getStringExtra("Email");
        mEmailToVerify.setText(email);


        // firebase email varification

        mFirebaseAuth = FirebaseAuth.getInstance();



      /*  if(!(mFirebaseAuth.getCurrentUser().isEmailVerified())){
            mWarningBox.setBackgroundResource(R.drawable.warning_green);
            mWarningBoxText.setText("Email Verified");
            mStartButton.setVisibility(View.VISIBLE);
            mStartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(VerifyEmailActivity.this,MainActivity.class));
                    finish();
                }
            });*/

        Log.d("Log_test", "onCreate: " + mFirebaseAuth.getCurrentUser().getEmail());
            mVerifyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFirebaseAuth.getCurrentUser().sendEmailVerification()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(VerifyEmailActivity.this, "Verification Email Sent", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(VerifyEmailActivity.this,LoginActivity.class));
                            finish();
                        }
                    });
                }
            });
        }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}



