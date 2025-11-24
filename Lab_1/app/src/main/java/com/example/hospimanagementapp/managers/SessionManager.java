package com.example.hospimanagementapp.managers;

import android.content.Context;

public class SessionManager {

    private static final String PREFS = "hms_prefs";
    private static final String KEY_ROLE = "current_role";
    private static final String KEY_EMAIL = "current_email";

    public static void setCurrentUser(Context c, String role, String email) {

        c.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .edit()
                .putString(KEY_ROLE, role)
                .putString(KEY_EMAIL, email)
                .apply();
    }

    public static String getCurrentRole(Context c) {
        return c.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getString(KEY_ROLE,null);
    }

    public static String getCurrrentEmail(Context c) {
        return c.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getString(KEY_EMAIL,null);
    }

    public static void clearCurrentUser(Context c) {
        c.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .apply();
    }
}
