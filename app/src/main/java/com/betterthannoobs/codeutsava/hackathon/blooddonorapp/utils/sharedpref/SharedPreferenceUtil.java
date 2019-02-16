package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.sharedpref;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StringDef;


import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.Utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Class that helps read & write from Shared pref.
 */
public class SharedPreferenceUtil {

    public static final String ACCOUNT_SETTINGS = "accountSettings";
    public static final String MOBILE_TAG = "mobileTag";
    public static final String TOKEN_TAG= "tokenTag";
    public static final String IS_SMS_PERMISSION_GRANTED = "isSmsPermissionGranted";
    public static final String SHOW_AUTHENTICATION_DIALOG_TAG = "showAuthenticationDialog";
    public static final String FACULTY_NAME_TAG = "facultyNameTag";
    public static final String IS_FACULTY_LOGGED_IN_TAG = "isFacultyLoggedInTag";
    public static final String PRODUCTION = "production";
    public static final String FACULTY_ID_TAG = "facultyId";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ACCOUNT_SETTINGS})
    public @interface SharedPrefFile {
    }

    private SharedPreferences accountSettingsSharedPreferences;

    private SharedPreferences.Editor editor;

    public SharedPreferenceUtil(Context context, String argSharedPrefName) {
        accountSettingsSharedPreferences = context.getSharedPreferences(argSharedPrefName, Activity.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        editor = accountSettingsSharedPreferences.edit();
    }

    public synchronized void saveData(@SharedPrefConst.Key String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public synchronized void saveData(@SharedPrefConst.Key String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public synchronized void saveData(@SharedPrefConst.Key String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public synchronized void saveData(@SharedPrefConst.Key String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    public synchronized void saveData(@SharedPrefConst.Key String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public synchronized void saveDataMap(Map<String, Integer> keyValueMap) {
        if (keyValueMap != null && keyValueMap.size() > 0) {
            Set<String> keys = keyValueMap.keySet();
            for (String key : keys) {
                editor.putInt(key, keyValueMap.get(key));
            }
            editor.apply();
        }
    }

    public synchronized void saveDataSet(@SharedPrefConst.Key String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.apply();
    }

    public synchronized void removeData(@SharedPrefConst.Key String key) {
        editor.remove(key);
        editor.apply();
    }

    public synchronized void removeData(Set<String> keys) {
        if (!Utils.isEmpty(keys)) {
            for (String key : keys) {
                editor.remove(key);
            }
            editor.apply();
        }
    }

    public synchronized Boolean getData(@SharedPrefConst.Key String key, boolean defaultValue) {
        return accountSettingsSharedPreferences.getBoolean(key, defaultValue);
    }

    public synchronized String getData(@SharedPrefConst.Key String key, String defaultValue) {
        return accountSettingsSharedPreferences.getString(key, defaultValue);
    }

    public synchronized Set<String> getDataSet(@SharedPrefConst.Key String key, Set<String> defaultValues) {
        // Changes here for issue : https://hikeapp.atlassian.net/browse/CPR-337
        Set<String> stringSet = accountSettingsSharedPreferences.getStringSet(key, defaultValues);
        if (Utils.isEmpty(stringSet)) {
            return new HashSet<>();
        }
        return new HashSet<>(stringSet);
    }

    public synchronized float getData(@SharedPrefConst.Key String key, float defaultValue) {
        return accountSettingsSharedPreferences.getFloat(key, defaultValue);
    }

    public synchronized int getData(@SharedPrefConst.Key String key, int defaultValue) {
        return accountSettingsSharedPreferences.getInt(key, defaultValue);
    }

    public synchronized long getData(@SharedPrefConst.Key String key, long defaultValue) {
        return accountSettingsSharedPreferences.getLong(key, defaultValue);
    }

    public synchronized Map<String, ?> getAllData() {
        Map<String, ?> hikeSharedPreferencesAll = accountSettingsSharedPreferences.getAll();
        // Changes here for issue : https://hikeapp.atlassian.net/browse/CPR-337
        if (hikeSharedPreferencesAll == null || hikeSharedPreferencesAll.isEmpty()) {
            return new HashMap<>();
        }
        return new HashMap<>(hikeSharedPreferencesAll);
    }

    public synchronized void deleteAllData() {
        editor.clear();
        editor.apply();
    }

    public SharedPreferences getPref() {
        return accountSettingsSharedPreferences;
    }

    public synchronized boolean contains(@SharedPrefConst.Key String key) {
        return accountSettingsSharedPreferences.contains(key);
    }

    public interface EditPreference {
        public void edit(SharedPreferences.Editor editor);
    }

    public synchronized void apply(EditPreference editPreference) {
        editPreference.edit(editor);
        editor.apply();
    }
}
