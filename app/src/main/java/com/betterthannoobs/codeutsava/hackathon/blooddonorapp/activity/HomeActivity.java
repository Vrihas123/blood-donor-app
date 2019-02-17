package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment.BecomeDonorFragment;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment.DonorFragment;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment.HospitalBloodBankFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class HomeActivity extends AppCompatActivity {


    private CardView btRegisteredBloodBanks, btDonorList, nearby, becomeDonor;
    private HospitalBloodBankFragment hospitalBloodBankFragment;
    private DonorFragment donorFragment;
    private BecomeDonorFragment becomeDonorFragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        btRegisteredBloodBanks = findViewById(R.id.card1);
        btDonorList = findViewById(R.id.card2);
        nearby = findViewById(R.id.card3);
        becomeDonor = findViewById(R.id.card4);
        btRegisteredBloodBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospitalBloodBankFragment = HospitalBloodBankFragment.newInstance();
                createFragment(hospitalBloodBankFragment, "BloodBankFragment", true);
            }
        });
        btDonorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donorFragment = DonorFragment.newInstance();
                createFragment(donorFragment, "DonorFragment", true);
            }
        });
        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        becomeDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                becomeDonorFragment = BecomeDonorFragment.newInstance();
                createFragment(becomeDonorFragment, "BecomeDonorFragment", true);
            }
        });
    }

    public void createFragment(Fragment fragment, String tag, boolean addToBackStack) {
        if (fragment != null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(tag);
            }
            if (!isFinishing() && !isDestroyed()) {
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
    }


}
