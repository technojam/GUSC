package com.example.gsc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeadsBottomClass extends BottomSheetDialogFragment  {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.heads_bottom_layout,container,false);

        TextView title = view.findViewById(R.id.headtitle);
        TextView Head1 = view.findViewById(R.id.clubHeadName1);
        TextView Head2 = view.findViewById(R.id.clubHeadName2);
        LinearLayout mnamebox1 = view.findViewById(R.id.box1);
        LinearLayout mnamebox2 = view.findViewById(R.id.box2);
        ImageButton mEmail_1_btn = view.findViewById(R.id.emailbutton1);
        ImageButton mEmail_2_btn = view.findViewById(R.id.emailbutton2);
        ImageButton mCall_1_btn = view.findViewById(R.id.callbutton1);
        ImageButton mCall_2_btn = view.findViewById(R.id.callbutton2);

        String headname1 = getArguments().getString("head1");
        String headname2 = getArguments().getString("head2");
        final String email1 = getArguments().getString("email1");
        final String email2 = getArguments().getString("email2");
        final String phone1 = getArguments().getString("phone1");
        final String phone2 = getArguments().getString("phone2");

        if (headname1 != null && headname2 != null)
            title.setText("Heads");
        else
            title.setText("Head");

        if(headname1 != null)
        {
            Head1.setText(headname1);
            // for mail
            if (email1 != null)
            {
                mEmail_1_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* composeEmail */
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:"));// only email apps should handle this
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email1});
                        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });
            }
            else
                mEmail_1_btn.setVisibility(View.GONE);
            // for phone
            if(phone1 != null)
            {
                mCall_1_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialPhoneNumber(phone1);
                    }
                });
            }
            else
                mCall_1_btn.setVisibility(View.GONE);
        }
        else
            mnamebox1.setVisibility(View.GONE);
        if (headname2 != null)
            {
                Head2.setText(headname2);

                // for mail

                if (email2 != null)
                {
                    mEmail_2_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                          /*  composeEmail */
                            Intent intent = new Intent(Intent.ACTION_SENDTO);
                            intent.setData(Uri.parse("mailto:"));// only email apps should handle this
                            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email2});
                            if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                                startActivity(intent);
                            }
                        }
                    });
                }
                else
                    mEmail_2_btn.setVisibility(View.GONE);

                // for phone

                if(phone2 != null)
                {
                    mCall_2_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialPhoneNumber(phone2);
                        }
                    });
                }
                else
                    mCall_2_btn.setVisibility(View.GONE);
            }
        else
            mnamebox2.setVisibility(View.GONE);



        return view;
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
