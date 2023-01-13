package com.xaoyv.magicbox.util;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

public class FilePath_s_2_BitmapDrawable {
    public void createBitmapDrawable(final Context context, int mFps) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        while (--mFps > 0) { //test
            BitmapDrawable drawable = new BitmapDrawable(context.getResources(), "filepath");
            animationDrawable.addFrame(drawable, 1000 / mFps);
        }
    }
}
