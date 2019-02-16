package com.betterthannoobs.codeutsava.hackathon.blooddonorapp;

import android.app.Application;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.injection.component.ApplicationComponent;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.injection.component.DaggerApplicationComponent;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.injection.module.ApplicationModule;


public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    public ApplicationComponent getComponent() {
        if (applicationComponent == null){
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return applicationComponent;
    }
}
