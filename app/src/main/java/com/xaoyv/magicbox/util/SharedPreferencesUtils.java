package com.xaoyv.magicbox.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

public class SharedPreferencesUtils {
    private static final String NAME = "s_magic_box";

    /**
     * 存储
     */
    public static void put(@Nullable Context context, String key, Object object) {
        if (context == null) return;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        }
        editor.apply();
    }

    public static boolean getBoolean(@Nullable Context context, String key, boolean defaultValue) {
        if (context == null) return defaultValue;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }

    public static int getInt(@Nullable Context context, String key, int defaultValue) {
        if (context == null) return defaultValue;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defaultValue);
    }

    public static float getFloat(@Nullable Context context, String key, float defaultValue) {
        if (context == null) return defaultValue;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getFloat(key, defaultValue);
    }

    public static String getString(@Nullable Context context, String key, String defaultValue) {
        if (context == null) return defaultValue;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }

    public static Boolean contain(@Nullable Context context, String key) {
        if (context == null) return false;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    public static void remove(@Nullable Context context, String key) {
        if (context == null) return;
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }

}
