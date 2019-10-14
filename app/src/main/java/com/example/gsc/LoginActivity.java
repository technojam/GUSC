package com.example.gsc;

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
                if (email.isEmpty()){
                    mEmailId.setError("Please enter mail Id");
                    mEmailId.requestFocus();
                }
                else if (password.isEmpty()){
                    mPassword.setError("Please enter password");
                    mPassword.requestFocus();
                }
                else if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))){
                    mFirebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this,"Email or Password is Wrong",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Log.d("Log_test","sign in with email is Success");
                                        if(mFirebaseAuth.getCurrentUser() != null){
                                            if(mFirebaseAuth.getCurrentUser().isEmailVerified()){
                                                Log.d(TAG, "Email - "+mFirebaseAuth.getCurrentUser().getEmail() + "  Activity - "+ this.toString() + "Verification - "+mFirebaseAuth.getCurrentUser().isEmailVerified()+" User loged in");
                                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                                finish();
                                            }
                                            else{
                                                Log.d(TAG, "Email - "+mFirebaseAuth.getCurrentUser().getEmail() + "  Activity - "+ this.toString() + "Verification - "+mFirebaseAuth.getCurrentUser().isEmailVerified());
                                                Intent intent = new Intent(LoginActivity.this, VerificationActivity.class);
                                                intent.putExtra("Email", mFirebaseAuth.getCurrentUser().getEmail());
                                                startActivity(intent);
                                            }

                                        }
                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(LoginActivity.this,"Error! Please Try Again",Toast.LENGTH_SHORT).show();
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
