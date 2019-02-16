package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

import static android.content.Context.ACTIVITY_SERVICE;

public class Utils {

    private Utils() {
    }
    /**
     * Checks that an Iterable is both non-null and non-empty. This method does not check individual elements in the Iterable, it just checks that the Iterable has at least one
     * element.
     *
     * @param argument the argument to validate
     * @return true is argument is empty. false otherwise
     */
    public static <S, T extends Iterable<S>> boolean isEmpty(T argument) {
        return (argument == null) || !argument.iterator().hasNext();
    }

    public static void clearAppData(Context context){
        if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
            ((ActivityManager)context.getSystemService(ACTIVITY_SERVICE))
                    .clearApplicationUserData(); // note: it has a return value!
        }
    }


}
