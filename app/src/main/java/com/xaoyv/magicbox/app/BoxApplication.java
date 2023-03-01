package com.xaoyv.magicbox.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;

public class BoxApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @SuppressLint("StaticFieldLeak")
    private static BoxApplication application;

    public static Context getContext() {
        return context;
    }

    public static BoxApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        application = this;
    }
}
