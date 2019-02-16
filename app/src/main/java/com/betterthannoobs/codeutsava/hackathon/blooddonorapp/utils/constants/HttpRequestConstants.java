package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.constants;

public class HttpRequestConstants {

    public static final String BASE_PROD_URL = "http://172.22.124.196:8000/";
    public static final String BASE_STAG_URL = "http://erp-stag.adda247.com/";
    public static final String REQUEST_REGISTER = "user/faculty/app/registration";
    public static final String REQUEST_LOGIN = "/login";
    public static String BASE_URL = BASE_PROD_URL; //actual api
    public static final String REQUEST_BLOOD_BANKS = "bloodbank_list/";

    private HttpRequestConstants() {
    }


    public static final class VerificationMobileResponse {

        public static final int SUCCESS_OTP_FRAGMENT = 0;
        public static final int SUCCESS_LOGIN_FRAGMENT = 1;
        public static final int FACULTY_NOT_EXIST = 2;

        private VerificationMobileResponse() {
        }
    }

    public static final class VerificationOtpResponse {

        public static final int SUCCESS_REGISTER_FRAGMENT = 0;
        public static final int FAILURE_WRONG_OTP = 1;

        private VerificationOtpResponse() {
        }
    }

    public static final class RegistrationResponse {

        public static final int SUCCESS_FACULTY_ACTIVITY = 0;
        public static final int REENTER_FACULTY_DETAILS = 1;

        private RegistrationResponse() {
        }
    }

    public static final class LoginResponse {

        public static final int SUCCESS_FACULTY_ACTIVITY = 0;
        public static final int FAILURE_WRONG_PIN = 1;

        private LoginResponse() {
        }
    }

    public static final class OtpResponse {

        public static final int OTP_FRAGMENT_TAG = 0;

        private OtpResponse() {
        }
    }

}
