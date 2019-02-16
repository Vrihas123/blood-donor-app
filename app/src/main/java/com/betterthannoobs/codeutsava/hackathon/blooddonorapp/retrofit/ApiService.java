package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit;


import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.OkHttpClientProvider;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model.LoginData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.constants.HttpRequestConstants;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit.BaseResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {


    @POST(HttpRequestConstants.REQUEST_LOGIN)
    Observable<BaseResponse> getLoginResultsUsingObservable(@Body LoginData loginData);

    class Creator {

        private Creator() {

        }

        public static ApiService newApiService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HttpRequestConstants.BASE_URL)
                    .client(new OkHttpClientProvider().getOkHttpClient())
                    .build();
            return retrofit.create(ApiService.class);
        }
    }

}
