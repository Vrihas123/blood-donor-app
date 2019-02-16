package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest;
        newRequest = request.newBuilder()
//                .addHeader("Token", new SharedPrefProvider().getAccountSettingSharedPref().getData(SharedPreferenceUtil.TOKEN_TAG, "default"))
                .build();
        return chain.proceed(newRequest);
    }
}