package com.xaoyv.magicbox.ui.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseActivity;
import com.xaoyv.magicbox.view.webview.CustomWebView;

public class WebActivity extends BaseActivity {
    private static final String PARAM_URL = "p_url";

    private CustomWebView webView;

    public static void start(Context context, String url) {
        if (context == null || url == null) {
            return;
        }
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(PARAM_URL, url);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();
        loadUrl();
    }

    private void loadUrl() {
        String url = getIntent().getStringExtra(PARAM_URL);
        if (TextUtils.isEmpty(url)) return;
        webView.loadUrl(url);
    }

    private void initView() {
        FrameLayout flWeb = findViewById(R.id.fl_web);
        webView = new CustomWebView(this);
        flWeb.addView(webView);
    }
}
