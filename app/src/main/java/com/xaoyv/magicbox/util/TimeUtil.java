package com.xaoyv.magicbox.util;

import android.os.SystemClock;

public class TimeUtil {
    /**
     * @return 手机（JVM）启动时间
     */
    public static long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }
}
