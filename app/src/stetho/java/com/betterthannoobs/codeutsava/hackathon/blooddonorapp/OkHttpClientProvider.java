package com.betterthannoobs.codeutsava.hackathon.blooddonorapp;


import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit.HeaderInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientProvider {

    public okhttp3.OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new com.facebook.stetho.okhttp3.StethoInterceptor())
                .build();
    }
}
