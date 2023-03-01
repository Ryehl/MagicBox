package com.xaoyv.magicbox.view.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomWebView extends WebView {
    public CustomWebView(@NonNull Context context) {
        this(context, null);
    }

    public CustomWebView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initConfig();
    }

    private void initConfig() {
        // 水平滚动条不显示
        setHorizontalScrollBarEnabled(false);
        // 垂直滚动条不显示
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        // 允许从任何来源加载内容，即使来源是不安全的
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        // 设置WebView是否需要用户手势才能播放媒体,例如在进入webView时是否可以自动播放h5里的video视频
        settings.setMediaPlaybackRequiresUserGesture(false);
        // 可以获取地理位置
        settings.setGeolocationEnabled(true);

        setWebViewClient(new CustomWebViewClient());
    }
}
