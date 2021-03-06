package com.example.gsc.Activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    String TAG = "Log_test";

    EditText mEmailId, mPassword;
    Button mLoginBtn;
    TextView mSignUpbtn;
    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mEmailId = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.LoginBtn);
        mSignUpbtn = findViewById(R.id.SignUpBtn);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    if(user.isEmailVerified()){
                        Log.d(TAG, "Email - "+user.getEmail() + "  Activity - "+ this.toString() + "Verification - "+user.isEmailVerified()+" User loged in");
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }
                    else{
                        Log.d(TAG, "Email - "+user.getEmail() + "  Activity - "+ this.toString() + "Verification - "+user.isEmailVerified());
                    }

                }
                else {
                    Toast.makeText(LoginActivity.this,"Loggin to continue",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Email - " + "  Activity - "+ this.toString() + " Try again to login");
                }
            }
        };


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmailId.getText().toString();
                String password = mPassword.getText().toString();

                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setTitle("Login...");
                progressDialog.show();

                if (email.isEmpty()){
                    progressDialog.dismiss();
                    mEmailId.setError("Please enter mail Id");
                    mEmailId.requestFocus();
                }
                else if (password.isEmpty()){
                    progressDialog.dismiss();
                    mPassword.setError("Please enter password");
                    mPassword.requestFocus();
                }
                else if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))){
                    mFirebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        progressDialog.dismiss();
                                        Toast.makeText(LoginActivity.this,"Email or Password is Wrong",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        if(mFirebaseAuth.getCurrentUser() != null){
                                            if(mFirebaseAuth.getCurrentUser().isEmailVerified()){
                                                progressDialog.dismiss();
                                                Log.d(TAG, "Email - "+mFirebaseAuth.getCurrentUser().getEmail() + "  Activity - "+ this.toString() + "Verification - "+mFirebaseAuth.getCurrentUser().isEmailVerified()+" User loged in");
                                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                                finish();
                                            }
                                            else{
                                                progressDialog.dismiss();
                                                Log.d(TAG, "Email - "+mFirebaseAuth.getCurrentUser().getEmail() + "  Activity - "+ this.toString() + "Verification - "+mFirebaseAuth.getCurrentUser().isEmailVerified());
                                                new AlertDialog.Builder(LoginActivity.this)
                                                        .setTitle("Email not verified!")
                                                        .setMessage(mFirebaseAuth.getCurrentUser().getEmail() + "\nis not verified click on verify to verify your email")
                                                        .setNegativeButton("Cancel", null)
                                                        .setPositiveButton("Verify", new DialogInterface.OnClickListener() {

                                                            public void onClick(DialogInterface arg0, int arg1) {

                                                                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                                                                progressDialog.setTitle("Sending Email...");
                                                                progressDialog.show();

                                                                if(mFirebaseAuth.getCurrentUser() != null){
                                                                    mFirebaseAuth.getCurrentUser().sendEmailVerification()
                                                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                @Override
                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                    progressDialog.dismiss();
                                                                                    Log.d(TAG, "Email - "+FirebaseAuth.getInstance().getCurrentUser().getEmail() + "Activity - "+ this.toString() + " Email is sent");
                                                                                    Toast.makeText(LoginActivity.this, "Email Sent Successfully! Check Your Mail", Toast.LENGTH_SHORT).show();
                                                                                }
                                                                            });
                                                                }
                                                                else {
                                                                    progressDialog.dismiss();
                                                                    Toast.makeText(LoginActivity.this, "Network Problem! Try Again", Toast.LENGTH_SHORT).show();
                                                                    Log.d(TAG, "Email - "+FirebaseAuth.getInstance().getCurrentUser().getEmail() + "Activity - "+ this.toString() + " Email not sent");
                                                                }
                                                            }
                                                        }).create().show();
                                            }

                                        }
                                    }
                                }
                            });
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"Network Error! Please Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(authStateListener);
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finishAffinity();
                    }
                }).create().show();
    }

}
