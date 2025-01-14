package com.india.cpgram.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharePrefrence {

    public static void saveObjectToSharedPreference(Context context, String preferenceFileName, String serializedObjectKey, Object object) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        final Gson gson = new Gson();
        String serializedObject = gson.toJson(object);
        sharedPreferencesEditor.putString(serializedObjectKey, serializedObject);
        sharedPreferencesEditor.apply();
    }
    public static <GenericClass> GenericClass getSavedObjectFromPreference(Context context, String preferenceFileName, String preferenceKey, Class<GenericClass> classType) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        if (sharedPreferences.contains(preferenceKey)) {
            final Gson gson = new Gson();
            return gson.fromJson(sharedPreferences.getString(preferenceKey, ""), classType);
        }
        return null;
    }

    public static void saveLogin(Context context, String preferenceFileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putBoolean("loginStatus", true);
        sharedPreferencesEditor.apply();
    }
    public static boolean isLogin(Context context, String preferenceFileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        return sharedPreferences.getBoolean("loginStatus", false);

    }
}
