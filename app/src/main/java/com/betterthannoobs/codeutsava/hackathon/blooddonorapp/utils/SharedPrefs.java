package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidHiveLogin";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_PRESCRIPTION = "prescription";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_FACULTY_MOBILE = "mobile";
    private static final int KEY_VERSION = 1;
        // LogCat tag
        private static String TAG = "Shared Preference";
        // Shared Preferences
        SharedPreferences pref;
        SharedPreferences.Editor editor;
        Context _context;
        // Shared pref mode
        int PRIVATE_MODE = 0;

        public static int getKeyVersion() {
            return KEY_VERSION;
        }

        public SharedPrefs(Context context) {
            this._context = context;
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }

        public void setLogin(boolean isLoggedIn) {

            editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
            editor.commit();
        }

        public boolean isLoggedIn() {
            return pref.getBoolean(KEY_IS_LOGGEDIN, false);
        }


        public String getMobile() {

            return pref.getString(KEY_FACULTY_MOBILE, "Your Phone Number");
        }

        public void setMobile(String userName) {

            editor.putString(KEY_FACULTY_MOBILE, userName);
            editor.commit();
        }

        public void setPrescription(String prescription){
            editor.putString(KEY_PRESCRIPTION, prescription);
            editor.commit();
        }
        public String getPrescription(){
            return pref.getString(KEY_PRESCRIPTION, "");
        }

    public void setLanguage(boolean isLanguageSelected) {

        editor.putBoolean(KEY_LANGUAGE, isLanguageSelected);
        editor.commit();
    }

    public boolean isLanguageSelected() {
        return pref.getBoolean(KEY_LANGUAGE, false);
    }
    }
