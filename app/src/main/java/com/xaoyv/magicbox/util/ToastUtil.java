package com.xaoyv.magicbox.util;

import android.widget.Toast;

import com.xaoyv.magicbox.app.BoxApplication;

public class ToastUtil {
    public static void toast(String toast) {
        Toast.makeText(BoxApplication.getContext(), toast, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(String toast) {
        Toast.makeText(BoxApplication.getContext(), toast, Toast.LENGTH_LONG).show();
    }
}
