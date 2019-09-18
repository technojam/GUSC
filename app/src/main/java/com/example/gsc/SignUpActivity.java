package com.example.gsc;

import android.content.Intent;
import androidx.annotation.NonNull;
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

public class SignUpActivity extends AppCompatActivity {

    EditText mEmail, mPassword, mconfPass;
    Button mSignUpbtn;
    TextView malreadyhaveaccount;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mconfPass = findViewById(R.id.confpassword);
        mSignUpbtn = findViewById(R.id.createacount);
        malreadyhaveaccount = findViewById(R.id.alreadyhaveaccount);

        mSignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
               final String password = mPassword.getText().toString();
                String confPassword = mconfPass.getText().toString();
                if (email.isEmpty()){
                    mEmail.setError("Email Required");
                    mEmail.requestFocus();
                }
                else if (password.isEmpty()){
                    mPassword.setError("Password Required");
                    mPassword.requestFocus();
                }
                else if (confPassword.isEmpty()){
                    mPassword.setError("Confirm password Required");
                    mPassword.requestFocus();
                }
                else if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confPassword)){
                    Toast.makeText(SignUpActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confPassword))){
                    if(password.equals(confPassword)) {
                        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "SignUp is Unsuccessful, Please try again ", Toast.LENGTH_SHORT).show();

                                } else {
                                    Log.d("Log_test", "create User With Email : Success");
                                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                                }
                            }
                        });
                    }
                    else{
                        Toast.makeText(SignUpActivity.this,"Password's Not Match",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUpActivity.this,"Error! Please Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        malreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
