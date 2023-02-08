package com.xaoyv.magicbox.util;

import java.io.Closeable;

public class CloseableUtil {
    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            try {
                closeable.close();
            } catch (Throwable ignore) {
            }
        }
    }
}
