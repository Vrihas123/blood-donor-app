package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.BloodBankListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.DonorData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.DonorListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.GenericResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model.LoginData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model.LoginDataResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.constants.HttpRequestConstants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @GET(HttpRequestConstants.REQUEST_BLOOD_BANKS)
    Call<BloodBankListResponse> getBloodBankList();

    @GET(HttpRequestConstants.REQUEST_DONOR_LIST)
    Call<DonorListResponse> getDonorList();

    @POST(HttpRequestConstants.REQUEST_REGISTER)
    Call<GenericResponse> getRegisterResult(@Body DonorData donorData);

    @POST(HttpRequestConstants.REQUEST_LOGIN)
    Call<LoginDataResponse> getLoginResult(@Body LoginData loginData);

    @POST(HttpRequestConstants.REQUEST_BECOME_DONOR)
    Call<GenericResponse> getBecomeDonorResult();
}
