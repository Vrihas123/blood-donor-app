package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;

    }

}
