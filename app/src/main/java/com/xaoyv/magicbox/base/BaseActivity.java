package com.xaoyv.magicbox.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initListener();
        initData();
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
