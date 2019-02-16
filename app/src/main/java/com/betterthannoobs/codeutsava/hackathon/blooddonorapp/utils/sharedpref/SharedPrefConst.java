package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.sharedpref;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SharedPrefConst {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            SharedPreferenceUtil.MOBILE_TAG,
            SharedPreferenceUtil.TOKEN_TAG,
            SharedPreferenceUtil.IS_SMS_PERMISSION_GRANTED,
            SharedPreferenceUtil.SHOW_AUTHENTICATION_DIALOG_TAG,
            SharedPreferenceUtil.FACULTY_NAME_TAG,
            SharedPreferenceUtil.IS_FACULTY_LOGGED_IN_TAG,
            SharedPreferenceUtil.FACULTY_ID_TAG,
            SharedPreferenceUtil.PRODUCTION
    })

    public @interface Key {

    }
}

