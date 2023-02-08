package com.xaoyv.magicbox.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import androidx.annotation.Nullable;

public class DeviceUtil {

    private static String deviceId;

    /**
     * 获设备id
     */
    public static String getDeviceId(@Nullable Context context) {
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
//        if (SharedPreferencesUtils.contain(context, SPKey.DEVICE_ID)) {
//            deviceId = SharedPreferencesUtils.getString(context, SPKey.DEVICE_ID, "");
//        }
//        if (!TextUtils.isEmpty(deviceId)) {
//            return deviceId;
//        }
        String info = getFakeUniqueId() + getAndroidID(context);
        deviceId = Md5Util.md5(info);
//        SharedPreferencesUtils.put(context, SPKey.DEVICE_ID, deviceId);
        return deviceId;
    }


    private static String getFakeUniqueId() {
        return "35" +
                Build.BOARD.length() % 10 +
                Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 +
                Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 +
                Build.HOST.length() % 10 +
                Build.ID.length() % 10 +
                Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 +
                Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 +
                Build.TYPE.length() % 10 +
                Build.USER.length() % 10;
    }

    private static String getAndroidID(@Nullable Context context) {
        if (context == null) return "";
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }


}
