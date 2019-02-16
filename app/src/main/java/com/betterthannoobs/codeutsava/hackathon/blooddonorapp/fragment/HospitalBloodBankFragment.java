package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.adapter.HospitalBloodBankAdapter;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.BloodBankListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.ApiServices;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.AppClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalBloodBankFragment extends DialogFragment {

    private HospitalBloodBankAdapter hospitalBloodBankAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBarBloodBank;
    private Toolbar toolbar;
    public HospitalBloodBankFragment() {

    }


    public static HospitalBloodBankFragment newInstance() {
        HospitalBloodBankFragment fragment = new HospitalBloodBankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital_blood_bank, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_blood_banks);
        toolbar = view.findViewById(R.id.blood_bank_toolbar);
        progressBarBloodBank = view.findViewById(R.id.progress_bar_blood_banks);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Available Hospitals and Blood Banks");
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HospitalBloodBankFragment.this.dismiss();
            }
        });
        hospitalBloodBankAdapter = new HospitalBloodBankAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(hospitalBloodBankAdapter);
        APICall();
        return view;
    }

    private void APICall() {
        progressBarBloodBank.setVisibility(View.VISIBLE);
        ApiServices services = AppClient.getInstance().createService(ApiServices.class);
        Call<BloodBankListResponse> call = services.getBloodBankList();
        call.enqueue(new Callback<BloodBankListResponse>() {
            @Override
            public void onResponse(Call<BloodBankListResponse> call, Response<BloodBankListResponse> response) {
                progressBarBloodBank.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    BloodBankListResponse bloodBankListResponse = response.body();

                    if (bloodBankListResponse != null) {
                        if (bloodBankListResponse.isSuccess()) {
                            hospitalBloodBankAdapter.setHospitalBloodBankDataList(bloodBankListResponse.getBloodBankDataList());
                            hospitalBloodBankAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BloodBankListResponse> call, Throwable t) {
                progressBarBloodBank.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }

}
