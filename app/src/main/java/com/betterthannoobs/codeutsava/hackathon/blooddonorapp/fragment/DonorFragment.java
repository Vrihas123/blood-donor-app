package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
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
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.adapter.DonorAdapter;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.DonorListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.ApiServices;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.AppClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonorFragment extends DialogFragment {

    private DonorAdapter donorAdapter;
    private RecyclerView recyclerViewDonor;
    private ProgressBar progressBarDonor;
    private Toolbar toolbar;

    public DonorFragment() {
        // Required empty public constructor
    }

    public static DonorFragment newInstance() {
        DonorFragment fragment = new DonorFragment();
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
        View view = inflater.inflate(R.layout.fragment_donor, container, false);
        toolbar = view.findViewById(R.id.donor_toolbar);
        recyclerViewDonor = view.findViewById(R.id.recycler_view_donor);
        progressBarDonor = view.findViewById(R.id.progress_bar_donor);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Available Donors");
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DonorFragment.this.dismiss();
            }
        });
        donorAdapter = new DonorAdapter(getContext());
        recyclerViewDonor.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDonor.setAdapter(donorAdapter);
        APICall();
        return view;
    }

    private void APICall() {
        progressBarDonor.setVisibility(View.VISIBLE);
        ApiServices services = AppClient.getInstance().createService(ApiServices.class);
        Call<DonorListResponse> call = services.getDonorList();
        call.enqueue(new Callback<DonorListResponse>() {
            @Override
            public void onResponse(Call<DonorListResponse> call, Response<DonorListResponse> response) {
                progressBarDonor.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    DonorListResponse donorListResponse = response.body();

                    if (donorListResponse != null) {
                        if (donorListResponse.isSuccess()) {
                            donorAdapter.setDonorDataList(donorListResponse.getDonorDataList());
                            donorAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<DonorListResponse> call, Throwable t) {
                progressBarDonor.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

    }

}
