package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.injection.component;


import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.injection.module.ApplicationModule;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit.ApiService;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit.CallHandler;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit.SharedPrefProvider;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.sharedpref.SharedPreferenceUtil;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    ApiService apiService();

    CallHandler provideCallHandler();

    @Named(SharedPreferenceUtil.ACCOUNT_SETTINGS)
    SharedPreferenceUtil provideSharedPreferenceUtil();

    void inject(CallHandler callHandler);

    void inject(ApiService apiService);

    void inject(SharedPrefProvider sharedPrefProvider);

}