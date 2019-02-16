package com.betterthannoobs.codeutsava.hackathon.blooddonorapp;

import com.facebook.stetho.Stetho;

public class StethoApplication extends MyApplication {

    public static final String TAG = "StethoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
