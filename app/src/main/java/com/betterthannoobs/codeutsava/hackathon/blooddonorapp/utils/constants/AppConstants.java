package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AppConstants {

    private AppConstants() {
    }

    public static final int SLOW_INTERNET_STATUS_CODE = 11;
    public static final int START_TIME = 0;
    public static final int END_TIME = 1;
    public static final String SERVICE_PROVIDER_CODE = "TM-ADDACP";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            START_TIME,
            END_TIME
    })

    public @interface Key {

    }

    public static final class Source {

        private Source() {
        }

        public static final int SERVER_SUCCESS = 0;

        public static final int LOADING = 1;

        public static final int DB = 2;

        public static final int SERVER_FAIL = 3;
    }
}