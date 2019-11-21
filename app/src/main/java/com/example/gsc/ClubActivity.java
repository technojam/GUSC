package com.example.gsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;

public class ClubActivity extends AppCompatActivity {

    private String clubName;
    private FirebaseAuth mAuth;
    FloatingActionMenu mFab;
    FloatingActionButton mFab1,mFab2;
    private boolean isFabOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        TextView mClubName = findViewById(R.id.clubName);
        ImageView mclubLogo = findViewById(R.id.clubLogo);
        TextView mAboutClub = findViewById(R.id.aboutclub);
        Button mHeadsBtn = findViewById(R.id.HeadsButton);
        Button mPhotoBtn = findViewById(R.id.PhotosButton);
        Button mRegisterBtn = findViewById(R.id.RegistrationButton);
        mFab1 = findViewById(R.id.fab1);
        mFab2 = findViewById(R.id.fab2);
        mFab = findViewById(R.id.menu);

        int clubLogo = getIntent().getExtras().getInt("clubLogo");
        clubName = getIntent().getStringExtra("ClubName");
        final String aboutClub = getIntent().getStringExtra("AboutClub");

        final String head1 = getIntent().getStringExtra("Head1");
        final String head2 = getIntent().getStringExtra("Head2");
        final String email1 = getIntent().getStringExtra("Email1");
        final String email2 = getIntent().getStringExtra("Email2");
        final String phone1 = getIntent().getStringExtra("Phone1");
        final String phone2 = getIntent().getStringExtra("Phone2");
        final int mClubHeadPic1 = getIntent().getExtras().getInt("ClubHeadPic1");
        final int mClubHeadPic2 = getIntent().getExtras().getInt("ClubHeadPic2");


//-------------------------------------hide element-------------------------------------------------

        mAuth = FirebaseAuth.getInstance();


        // to show a view after auth
        if (mAuth.getCurrentUser() != null) {
            if (mAuth.getCurrentUser().getUid().equals("k2lF12xwmyZrN2Etm7rKfO10RdL2" ) || mAuth.getCurrentUser().getUid().equals("2NUaYkzscvXNSoA8OZj9Y9niwbp2")) {
                mFab.setVisibility(View.VISIBLE);
                mRegisterBtn.setText("Add Student");
            }

            mFab1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ClubActivity.this, CreateEventActivity.class);
                    intent.putExtra("clubname", clubName);
                    startActivity(intent);
                    finish();
                }
            });

            mFab2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ClubActivity.this, RegisteredStudentActivity.class);
                    intent.putExtra("clubname", clubName);
                    startActivity(intent);
                    finish();
                }
            });

            mclubLogo.setImageResource(clubLogo);
            mClubName.setText(clubName);
            mAboutClub.setText(aboutClub);


            mHeadsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HeadsBottomClass headsbottomview = new HeadsBottomClass();

                    Bundle clubHeadNamesBundle = new Bundle();
                    clubHeadNamesBundle.putString("head1", head1);
                    clubHeadNamesBundle.putString("head2", head2);
                    clubHeadNamesBundle.putString("email1", email1);
                    clubHeadNamesBundle.putString("email2", email2);
                    clubHeadNamesBundle.putString("phone1", phone1);
                    clubHeadNamesBundle.putString("phone2", phone2);
                    clubHeadNamesBundle.putInt("clubHeadPic1", mClubHeadPic1);
                    clubHeadNamesBundle.putInt("clubHeadPic2", mClubHeadPic2);

                    headsbottomview.setArguments(clubHeadNamesBundle);
                    headsbottomview.show(getSupportFragmentManager(), "HeadsBottomView");
                }
            });


            mPhotoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ClubActivity.this, "Image is not there", Toast.LENGTH_SHORT).show();
                }
            });

            mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ClubActivity.this, RegistrationActivity.class);
                    intent.putExtra("clubname", clubName);
                    startActivity(intent);
                    finish();
                }
            });

        }

    }
}