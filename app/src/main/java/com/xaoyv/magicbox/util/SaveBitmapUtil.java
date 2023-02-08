package com.xaoyv.magicbox.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SaveBitmapUtil {

    public static boolean saveBitmap(Context context, Bitmap bitmap, boolean isToastTip) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            return saveBlowQ(context, bitmap, isToastTip);
        }
        boolean isSuccess = true;
        try {
            String fileName = System.currentTimeMillis() + "";
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);
            contentValues.put(MediaStore.Images.Media.TITLE, fileName);
            contentValues.put(MediaStore.Images.Media.DESCRIPTION, fileName);
            contentValues.put(MediaStore.Images.Media.WIDTH, bitmap.getWidth());
            contentValues.put(MediaStore.Images.Media.HEIGHT, bitmap.getHeight());
            contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            contentValues.put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis() / 1000);
            contentValues.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
            contentValues.put(MediaStore.Images.Media.DATE_MODIFIED, System.currentTimeMillis() / 1000);

            // IS_PENDING 字段表示正在插入图片，其他应用不可以访问此图片, IS_PENDING是api29才有的
            contentValues.put(MediaStore.Images.Media.IS_PENDING, 1);
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            // 保存图片
            OutputStream outputStream = contentResolver.openOutputStream(uri);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();

            // 更新图片大小
            contentValues.clear();
            InputStream inputStream = contentResolver.openInputStream(uri);
            int available = inputStream.available();
            inputStream.close();
            contentValues.put(MediaStore.Images.Media.SIZE, available);
            // 标示图片插入完毕
            contentValues.put(MediaStore.Images.Media.IS_PENDING, 0);
            contentResolver.update(uri, contentValues, null, null);
        } catch (IOException e) {
            isSuccess = false;
        }
        // 提示是否保存成功
        if (isToastTip) {
//            int resId = isSuccess ? R.string.kt_save_image_success : R.string.kt_save_image_fail;
//            ToastUtil.show(context, resId);
            ToastUtil.toast(isSuccess ? "保存成功" : "保存失败");
        }
        return isSuccess;
    }


    private static boolean saveBlowQ(Context context, Bitmap bitmap, boolean isToastTip) {
        boolean isSuccess = false;
        try {
            File pathDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File descDir = new File(pathDir, context.getPackageName());
            if (!descDir.exists()) {
                descDir.mkdirs();
            }
            BufferedOutputStream os = null;
            File descFile = new File(descDir, System.currentTimeMillis() + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(descFile);
            try {
                os = new BufferedOutputStream(fileOutputStream);
                isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            } catch (Exception e) {
            } finally {
                CloseableUtil.close(os);
            }
            if (isSuccess) {
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.parse("file://" + descFile.getAbsolutePath()));
                context.sendBroadcast(intent);
            }
            // 提示是否保存成功
            if (isToastTip) {
//                int resId = isSuccess ? R.string.kt_save_image_success : R.string.kt_save_image_fail;
//                ToastUtil.show(context, resId);
                ToastUtil.toast(isSuccess ? "保存成功" : "保存失败");
            }
        } catch (Exception e) {
            isSuccess = false;
        }
        return isSuccess;
    }

}
