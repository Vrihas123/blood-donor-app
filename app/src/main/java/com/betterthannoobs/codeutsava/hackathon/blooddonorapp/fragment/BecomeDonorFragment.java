package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.GenericResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.ApiServices;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.AppClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BecomeDonorFragment extends DialogFragment {


    private ProgressBar progressBarBecomeDonor;
    private TextView result_text;
    private Toolbar toolbar;
    public BecomeDonorFragment() {
        // Required empty public constructor
    }

    public static BecomeDonorFragment newInstance() {
        BecomeDonorFragment fragment = new BecomeDonorFragment();
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
       View view = inflater.inflate(R.layout.fragment_become_donor, container, false);
        toolbar = view.findViewById(R.id.become_donor_toolbar);
        result_text = view.findViewById(R.id.txt_become_donor);
        progressBarBecomeDonor = view.findViewById(R.id.progress_bar_become_donor);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Become a Donor");
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BecomeDonorFragment.this.dismiss();
            }
        });


       APICall();
       return view;
    }

    public void APICall() {
        progressBarBecomeDonor.setVisibility(View.VISIBLE);
        ApiServices services = AppClient.getInstance().createService(ApiServices.class);
        Call<GenericResponse> call = services.getBecomeDonorResult();
        call.enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
                progressBarBecomeDonor.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    GenericResponse genericResponse = response.body();

                    if (genericResponse != null){
                        if (genericResponse.isSuccess()) {
                            result_text.setText(genericResponse.getMessage());
                        }
                    }else {
                        result_text.setText(genericResponse.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenericResponse> call, Throwable t) {
                progressBarBecomeDonor.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Something went wrong",Toast.LENGTH_LONG).show();
            }
        });
    }
}
