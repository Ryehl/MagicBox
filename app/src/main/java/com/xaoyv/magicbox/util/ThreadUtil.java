package com.xaoyv.magicbox.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (Throwable ignore) {
        }
    }

    public static void startOnNewThread(Runnable runnable) {
        if (runnable == null) return;
        new Thread(runnable).start();
    }

    public static ExecutorService createThreadPool(int fixedPoolSize) {
        return Executors.newFixedThreadPool(fixedPoolSize);
    }
}
