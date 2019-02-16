package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.injection.module;

import android.app.Application;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit.ApiService;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.retrofit.CallHandler;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.sharedpref.SharedPreferenceUtil;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    ApiService provideApiService() {
        return ApiService.Creator.newApiService();
    }


    @Provides
    @Singleton
    CallHandler provideCallHandler() {
        return new CallHandler();
    }

    @Provides
    @Singleton
    @Named(SharedPreferenceUtil.ACCOUNT_SETTINGS)
    SharedPreferenceUtil provideSharedPreferenceUtil() {
        return new SharedPreferenceUtil(mApplication, SharedPreferenceUtil.ACCOUNT_SETTINGS);
    }

}
