package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.GenericResponse;
import com.google.gson.annotations.SerializedName;

public class LoginDataResponse extends GenericResponse {
    @SerializedName("access_token")
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }


}
