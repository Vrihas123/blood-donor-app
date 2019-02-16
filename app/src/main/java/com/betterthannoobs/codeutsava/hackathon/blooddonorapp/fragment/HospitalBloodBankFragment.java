package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.MyApplication;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.adapter.HospitalBloodBankAdapter;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.HospitalBloodBankData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.viewmodel.HospitalBloodBankViewModel;

import java.util.List;

public class HospitalBloodBankFragment extends Fragment implements HospitalBloodBankViewModel.BloodBankResponseHandler {

    private HospitalBloodBankViewModel hospitalBloodBankViewModel;
    private HospitalBloodBankAdapter hospitalBloodBankAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBarBloodBank;
   // private WeakReference<HospitalBloodBankFragment> weakReference;
    public HospitalBloodBankFragment() {
        // Required empty public constructor
        MyApplication.getInstance().getComponent().inject(this);
    }


//    public void setWeakReference(WeakReference<HospitalBloodBankFragment> weakReference) {
//        this.weakReference = weakReference;
//    }

    public static HospitalBloodBankFragment newInstance() {
        HospitalBloodBankFragment fragment = new HospitalBloodBankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hospitalBloodBankViewModel = ViewModelProviders.of(this).get(HospitalBloodBankViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital_blood_bank, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_blood_banks);
        progressBarBloodBank = view.findViewById(R.id.progress_bar_blood_banks);
        hospitalBloodBankAdapter = new HospitalBloodBankAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(hospitalBloodBankAdapter);
        progressBarBloodBank.setVisibility(View.VISIBLE);
        hospitalBloodBankViewModel.sendData();
        return view;
    }


    @Override
    public void responseHandlingBloodBank(List<HospitalBloodBankData> dataList, int code) {
        if (dataList != null && code == 1){
            progressBarBloodBank.setVisibility(View.GONE);
            hospitalBloodBankAdapter.setHospitalBloodBankDataList(dataList);
        } else {
            Toast.makeText(getContext(), "Some error occurred", Toast.LENGTH_LONG).show();
        }

    }
}
