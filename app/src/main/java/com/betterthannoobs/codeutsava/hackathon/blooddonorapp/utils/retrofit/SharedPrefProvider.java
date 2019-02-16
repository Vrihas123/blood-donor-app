package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit;


import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.MyApplication;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.sharedpref.SharedPreferenceUtil;

import javax.inject.Inject;
import javax.inject.Named;

public class SharedPrefProvider {

    @Inject
    @Named(SharedPreferenceUtil.ACCOUNT_SETTINGS)
    SharedPreferenceUtil sharedPreferenceUtil;

    public SharedPrefProvider() {
        MyApplication.getInstance().getComponent().inject(this);
    }

    public SharedPreferenceUtil getAccountSettingSharedPref() {
        return sharedPreferenceUtil;
    }
}
