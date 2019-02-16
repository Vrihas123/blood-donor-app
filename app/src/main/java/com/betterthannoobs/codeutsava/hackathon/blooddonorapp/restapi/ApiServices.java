package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.BloodBankListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.DonorListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.constants.HttpRequestConstants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET(HttpRequestConstants.REQUEST_BLOOD_BANKS)
    Call<BloodBankListResponse> getBloodBankList();

    @GET(HttpRequestConstants.REQUEST_DONOR_LIST)
    Call<DonorListResponse> getDonorList();


}
