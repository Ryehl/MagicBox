package com.xaoyv.magicbox.ui.splash;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseActivity;
import com.xaoyv.magicbox.ui.home.HomeActivity;
import com.xaoyv.magicbox.util.PermissionUtil;
import com.xaoyv.magicbox.util.SpUtil;
import com.xaoyv.magicbox.util.ToastUtil;

/**
 * step1: check first open
 * step2: check permission
 * step3: check Version (net)
 * step4: load config & Ad
 * step5: goto home
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";
    public static final int REQ_PERMISSION_EXTERNAL = 0x0;
    private boolean doNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        checkFirstOpen();
    }

    /**
     * 进入主页
     */
    private void goHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (doNext) {
            doNext = false;
            checkVersion();
        }
    }

    /**
     * step 4 加载配置和广告
     */
    private void loadConfig_AD() {
        goHome();
    }

    /**
     * step 3 check version
     * 需要网络
     */
    private void checkVersion() {
        //Todo Test
        if (!PermissionUtil.checkSelfPermission(this, Manifest.permission.INTERNET)) {
            finish();
            ToastUtil.toast("没有网络权限");
            return;
        }
        loadConfig_AD();
    }

    /**
     * step 2 check permission
     */
    private void checkPermission(boolean needGotoSetting) {
        if (PermissionUtil.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            checkVersion();
        } else if (needGotoSetting){
            doNext = true;
            PermissionUtil.gotoSetting(this);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQ_PERMISSION_EXTERNAL);
            }
        }
    }

    /**
     * step 1
     */
    private void checkFirstOpen() {
        boolean isFirst = SpUtil.isFirstOpen();
        if (isFirst) {
            UserArgumentDialog userArgumentDialog = new UserArgumentDialog(this);
            userArgumentDialog.setListener(new UserArgumentDialog.Listener() {
                @Override
                public void onAgree() {
                    //Do Next temp 2
                    SpUtil.saveFirstOpenTime();
                    checkPermission(false);
                }

                @Override
                public void onDisAgree() {
                    //exit
                    finish();
                    System.exit(0);
                }
            });
            userArgumentDialog.show();
        } else {
            //Do Next
            checkPermission(false);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_PERMISSION_EXTERNAL) {
            //next step 3
            checkPermission(true);
        }
    }
}