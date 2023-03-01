package com.xaoyv.magicbox.util;

import android.app.Application;
import android.content.Context;

import com.xaoyv.magicbox.app.BoxApplication;

public class SpUtil {
    public static final String FIRST_OPEN_TIME = "l_first_open_time";

    public static Context getContext() {
        return BoxApplication.getContext();
    }

    public static long getFirstOpenTime() {
        return SharedPreferencesUtils.getLong(getContext(), FIRST_OPEN_TIME, -1);
    }

    public static void saveFirstOpenTime() {
        SharedPreferencesUtils.put(getContext(), FIRST_OPEN_TIME, System.currentTimeMillis());
    }

    public static boolean isFirstOpen() {
        return getFirstOpenTime() == -1;
    }
}
