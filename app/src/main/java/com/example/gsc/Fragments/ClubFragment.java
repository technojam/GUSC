package com.example.gsc.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gsc.Adapters.ClubListAdapter;
import com.example.gsc.HelperClass.ClubList;
import com.example.gsc.R;

import java.util.ArrayList;

public class ClubFragment extends Fragment {

    RecyclerView mClubList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_club,container,false);

        // this is for club list.

        ArrayList<ClubList> mclublist = new ArrayList<>();

        mclublist.add(new ClubList(R.drawable.artsclubnew_logo,"Artistico",getString(R.string.Artistico_Club),"Mohd Rehan Shaikh","Simran Kushwah","rehannshaikh5@gmail.com","xx","9956484367","8130323814",R.drawable.mohd_rehan_shaikh,R.drawable.simran_kushwah));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Automantra Racing",getString(R.string.Automantra),"Shobhit Agarwal","Aakash Jawla","shobhit.agarwal@galgotiasuniversity.edu.in","aakash.jawla@galgotiasuniversity.edu.in","9717279078","9458268292",R.drawable.shobhit,R.drawable.aakash_jawla));
        mclublist.add(new ClubList(R.drawable.cam_circle_refined2_logo,"Cam Circle",getString(R.string.Cam_Circle),"xx","Kartik Saxena","xx","kartiksaxena055@gmail.com","xx","8588051025",00,R.drawable.kartik_saxena));
        mclublist.add(new ClubList(R.drawable.comikaze_1_logo,"Comikaze",getString(R.string.Comikaze),"Pragya bhardwaj","Dishank sharma","sharma06pragya@gmail.com","kdevesh58@gmail.com","9990703496","9540386339",R.drawable.pragya_bhardwaj,R.drawable.dishank_sharma));
        mclublist.add(new ClubList(R.drawable.ecell_logo, "E-Cell", getString(R.string.E_Cell),"Earthson Xavier","xx","earthson@galgotiasuniversity.edu.in","xx","xx","xx",00,00));
        mclublist.add(new ClubList(R.drawable.frag_logo,"F.R.A.G Club",getString(R.string.Frag),"Prayas Kundu","Amaan Siddiqui","prayasm4a1@gmail.com","amaansiddiqui14@gmail.com","9818441774","9811679465",R.drawable.prayaskundu,R.drawable.amaan));
        mclublist.add(new ClubList(R.drawable.g_post_logo,"G-Post",getString(R.string.G_Post),"Priyansh Mishra","xx","priyansh.mishra01_2017@galgotiasuniversity.edu.in","xx","8448948119","xx",R.drawable.priyansh_mishra,00));
        mclublist.add(new ClubList(R.drawable.grace_logo,"GRACE",getString(R.string.Grace),"Shahzeb Khan","Mohd Saquib","shahzeb.khan@galgotiasuniversity.edu.in","mohd.saquib1@galgotiasuniversity.edu.in","9795406782","9554262772",R.drawable.shahzeb_khan,R.drawable.mohd_saquib));
        mclublist.add(new ClubList(R.drawable.graphex_club_logo_dark,"Graphex",getString(R.string.test_string),"Ankur pal","Ayush upadhyay","palankur891@gmail.com","uayush600@gmail.com","8448661167","8765910889",R.drawable.ankur_pal,R.drawable.ayush));
        mclublist.add(new ClubList(R.drawable.gu_mnangement_logo,"GU Management Team",getString(R.string.GU_Management),"Gautam Arya","Deepanshu Goyal","gautam.arya01_2017@galgotiasuniversity.edu.in","deepanshu.goyal01_2017@galgotiasuniversity.edu.in","7764911451","8979106667",R.drawable.gautam_arya,R.drawable.deepanshu));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"IRIS",getString(R.string.I_R_I_S),"KUMAR DIVYA MANI","xx","dxivyamani@gmail.com","xx","9667898837","xx",R.drawable.divya_mani,00));
        mclublist.add(new ClubList(R.drawable.kafila_logo,"Kafila",getString(R.string.test_string),"Swastik Anand Tripathi","Sujata Tripathi","swastik.tripathicool@gmail.com","sujatatripathi1619@gmail.com","8918756193","7985211676",R.drawable.swastik_anand_tripathi,R.drawable.sujata_tripathi));
        mclublist.add(new ClubList(R.drawable.literary_club_lingo_freax_logo,"Lingo Freaks",getString(R.string.Lingo_Freaks),"Sneha Sakshi","Bakhtawar Parvez","snehasdf@gmail.com","bakhtawarparvez@gmail.com","9868342117","9044322341",R.drawable.sneha_sakshi,R.drawable.bakhtawar_parvez));
        mclublist.add(new ClubList(R.drawable.marketing_logo1,"Marketing Team",getString(R.string.Marketing_Team),"Harsh Chandani","Tanmay Shukla","harsh.chandani01_2017@galgotiasuniversity.edu.in","tanmay.shukla01_2017@galgotiasuniversity.edu.in","7455095984","8448948126",R.drawable.harsh_chandani,R.drawable.tanmay_shukla));
        mclublist.add(new ClubList(R.drawable.note_veda_logo,"Noteveda",getString(R.string.Note_Veda),"Shubhang Sinha","Pratibha Saanvi","shubhangsinha7@gmail.com","saanvisings201@gmail.com","9889805805","xx",R.drawable.shubhang_sinha,R.drawable.pratibha_saanvi));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Online Promotions",getString(R.string.Online_Promotions_Team),"Anindita Chaki","Tanul Prabhat Rai","aninditachaki1234@gmail.com","tanul9876@gmail.com","8448268447","8604607841",R.drawable.anindita_chaki,R.drawable.tanul_prabhat_rai));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Reverso",getString(R.string.Reverso),"Apoorv Mishra","xx","apoorv.misra@galgotiasuniversity.edu.in","xx","7291826231","xx",R.drawable.apoorv_mishra,00));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Scintillation",getString(R.string.Scintillations),"Shubham Rawat","Harsha Anisy","shubhamrawat8393@gmail.com","harshanisy98@gmail.com","8393814338","9939285138",R.drawable.shubham_rawat,R.drawable.harsha_anisy));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Sponsorship Team",getString(R.string.Sponsorship_Team),"Akarsh Baliyan","Abhishek Anand","akarsh.baliyan@galgotiasuniversity.edu.in","abhishek.anand02_2017@galgotiasuniversity.edu.in","7042741941","8800285169",R.drawable.akarsh_baliyan,R.drawable.abhishek_anand));
        mclublist.add(new ClubList(R.drawable.galgotias_university_small_logo,"Stage Management",getString(R.string.Stage_Management_Team),"Abhishek Das","xx","abhishekdas672@gmail.com","xx","7503674855","xx",R.drawable.abhishek_das,00));
        mclublist.add(new ClubList(R.drawable.studio_d_club_logo,"Studio-D",getString(R.string.Studio_D),"Sachin pal","Rakshit Malhotra","sachinpal.sp20@gmail.com","rakshit5898@gmail.com","8447335115","9811131428",R.drawable.sachin,R.drawable.rakshit));
        mclublist.add(new ClubList(R.drawable.technojam_logo,"TechnoJam",getString(R.string.TechnoJAM),"Anubhav Raj Singh","Swetank","anubhavraj.08@gmail.com","Swetank199@gmail.com","9521419475","7042435242",R.drawable.anubhav_raj_singh,R.drawable.swatank));
        mclublist.add(new ClubList(R.drawable.the_actors_hub_logo,"The Actor's Hub",getString(R.string.The_Actors_Hub),"Priyank Bhardwaj","Vishvendra Singh","Priyank.bhardwaj@galgotiasuniversity.edu.in","vishvendra993@gmail.com","8650831342","9784352341",R.drawable.pragya_bhardwaj,R.drawable.vishvendra_singh));
        mclublist.add(new ClubList(R.drawable.humanity_saviours_logo,"The Humanity Saviours",getString(R.string.The_Humanity_Saviours),"Sudhanshu Agarwal","Pallavi Thakur","sudhanshu.agarwal@galgotiasuniversity.edu.in","Pallavi@galgotiasuniversity.edu.in","8588075444","7982549405",R.drawable.sudhanshu_agarwal,R.drawable.pallavi));
        mclublist.add(new ClubList(R.drawable.vervelogo,"Verve",getString(R.string.Verve),"Syed Awwab Tausif","Niharika Kashyap","awwabtausif@gmail.com","niharikakashyap3456@gmail.com","8791788834","919650181408",R.drawable.syed_awwab_tausif,R.drawable.niharika_kashyap));
        mclublist.add(new ClubList(R.drawable.gu_quiz_club_logo,"Quizita Mavens",getString(R.string.Quizita_Mavens),"Vimal K B","Sagar Patel","vimal.kb@galgotiasuniversity.edu.in","sagar.patel@galgotiasuniversity.edu.in","8281121354","9795644119",00,00));


        mClubList = rootView.findViewById(R.id.clubRecyclerView);
        mClubList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClubList.setAdapter(new ClubListAdapter(mclublist,getActivity()));
        return rootView;
    }
}

