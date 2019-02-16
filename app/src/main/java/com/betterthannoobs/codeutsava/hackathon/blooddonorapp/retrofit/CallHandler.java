package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.MyApplication;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model.LoginData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit.internal.ApiHelper;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit.BaseResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Call;
import retrofit2.Callback;

public class CallHandler {

    @Inject
    ApiService apiService;

    public CallHandler() {
        MyApplication.getInstance().getComponent().inject(this);
    }

    private <T> void enqueue(Call<T> call, Callback<T> callback) {
        ApiHelper.enqueueWithRetry(call, callback);
    }

//    public Observable<BaseResponse<OtpResponse>> getOtpResultsUsingObservable(String mobile, String otp) {
//        return apiService.getOtpResultsUsingObservable(mobile, otp).retry(3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }

//    public Observable<BaseResponse<RegisterResponse>> getRegisterResultsUsingObservable(FacultyInfoData facultyInfoData) {
//        return apiService.getRegisterResultsUsingObservable(facultyInfoData).retry(3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }

    public Observable<BaseResponse> getLoginResultsUsingObservable(LoginData loginData) {
        return apiService.getLoginResultsUsingObservable(loginData).retry(3).subscribeOn(AndroidSchedulers.mainThread());
    }

}
