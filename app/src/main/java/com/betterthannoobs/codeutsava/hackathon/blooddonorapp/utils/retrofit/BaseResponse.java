package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;

    }
}
