package com.xaoyv.magicbox.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

import com.xaoyv.magicbox.bean.SPKey;

public class AppUtils {
    private static Context context;

    public static void init(Context c) {
        context = c.getApplicationContext();
    }

    public static boolean isFirstStart() {
        String string = SharedPreferencesUtils.getString(context, SPKey.FIRST_INSTALL, null);
        return TextUtils.isEmpty(string);
//        if (string == null || string.equals("")) {
//            return true;
//        }
//        return false;
    }

    public static void start() {
        SharedPreferencesUtils.put(context, SPKey.FIRST_INSTALL, "start");
    }
    public static boolean isAppInstall(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName) || context == null) {
            return false;
        }
        try {
            return context.getPackageManager()
                    .getApplicationInfo(packageName, 0)
                    .enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static String AndroidId;

    /**
     * 获取AndroidId
     *
     * @param context 上下文
     * @return AndroidId
     */
    public static String getAndroidId(Context context) {
        if (TextUtils.isEmpty(AndroidId)) {
            AndroidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return AndroidId;
    }
}
