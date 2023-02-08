package com.xaoyv.magicbox.view;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomWebViewClient extends WebViewClient {

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // 证书错误也继续加载
        if (handler != null) {
            handler.proceed();
        }
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (view == null || url == null) {
            return false;
        }
        if (!url.startsWith("http")) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            PackageManager packageManager = view.getContext().getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                view.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }
}
