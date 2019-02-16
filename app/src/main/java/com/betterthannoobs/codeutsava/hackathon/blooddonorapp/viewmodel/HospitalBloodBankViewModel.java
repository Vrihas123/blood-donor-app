package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.MyApplication;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.BloodBankListResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.HospitalBloodBankData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit.CallHandler;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit.BaseResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit.CallbackWrapper;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.sharedpref.SharedPreferenceUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.observers.DisposableObserver;

public class HospitalBloodBankViewModel extends ViewModel {
    @Inject
    CallHandler callHandler;
    @Inject
    @Named(SharedPreferenceUtil.ACCOUNT_SETTINGS)
    SharedPreferenceUtil sharedPreferenceUtil;

    private List<HospitalBloodBankData> dataList = new ArrayList<>();
    private WeakReference<BloodBankResponseHandler> bloodBankResponseHandler;

    private DisposableObserver<BaseResponse<BloodBankListResponse>> disposableObserverBloodBank;

    public HospitalBloodBankViewModel() {
        MyApplication.getInstance().getComponent().inject(this);
    }

    private CallbackWrapper<BaseResponse<BloodBankListResponse>> getApiListener() {
        return new CallbackWrapper<BaseResponse<BloodBankListResponse>>() {
            @Override
            protected void onSuccess(BaseResponse<BloodBankListResponse> response) {
                if (bloodBankResponseHandler != null){
                    bloodBankResponseHandler.get().responseHandlingBloodBank(response.getData().getBloodBankDataList(), 0);
                }
            }

            @Override
            public void onErrorNotConsumed(Throwable e) {
                    bloodBankResponseHandler.get().responseHandlingBloodBank(null, 1);
            }
        };
    }

    public void sendData() {

        disposableObserverBloodBank = callHandler.getBloodBankResultUsingObservable().subscribeWith(getApiListener());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposableObserverBloodBank != null)
            disposableObserverBloodBank.dispose();
    }

    public interface BloodBankResponseHandler {
        void responseHandlingBloodBank(List<HospitalBloodBankData> dataList, int code );
    }
}
