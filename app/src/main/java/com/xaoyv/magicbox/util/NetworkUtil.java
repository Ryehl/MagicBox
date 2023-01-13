package com.xaoyv.magicbox.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import androidx.annotation.Nullable;

public class NetworkUtil {
    private NetworkUtil() {
    }

    private static final NetworkUtil INSTANCE = new NetworkUtil();

    public static NetworkUtil getInstance() {
        return INSTANCE;
    }

    //获取Wi-Fi IP地址
    @Nullable
    public String getIpv4Address(@Nullable Context context) {
        if (context == null) return null;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // 判断WiFi是否开启
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        return (ipAddress & 0xFF) + "." +
                ((ipAddress >> 8) & 0xFF) + "." +
                ((ipAddress >> 16) & 0xFF) + "." +
                (ipAddress >> 24 & 0xFF);
    }

}
