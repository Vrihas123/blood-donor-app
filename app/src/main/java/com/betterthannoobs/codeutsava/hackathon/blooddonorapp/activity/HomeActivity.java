package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.MyApplication;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment.HospitalBloodBankFragment;

public class HomeActivity extends AppCompatActivity {


    private Button btRegisteredBloodBanks;
    private HospitalBloodBankFragment hospitalBloodBankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().getComponent().inject(this);
        setContentView(R.layout.activity_home);
        btRegisteredBloodBanks = findViewById(R.id.hospital_blood_bank_fragment);

        btRegisteredBloodBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospitalBloodBankFragment = HospitalBloodBankFragment.newInstance();
                createFragment(hospitalBloodBankFragment, "BloodBankFragment", true);
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
