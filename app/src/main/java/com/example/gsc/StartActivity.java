package com.example.gsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //load the xml file for the starting loading screen
        setContentView(R.layout.activity_start);

        Log.d("StartActivity:", "onCreate: created activity_main.xml UI succesfully.");

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();

                Log.d("StartActivity:", "onCreate: waiting 5 seconds for StartActivity... loading LoginActivity.class");
            }
        }, 2000 );
    }
}
