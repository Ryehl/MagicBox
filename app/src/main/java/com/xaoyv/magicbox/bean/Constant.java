package com.xaoyv.magicbox.bean;

import android.Manifest;

public class Constant {

    //<editor-fold desc="Url">
    public static final String BASE_URL = "https://api.bloomad.cn/";

    public static final String Url_getUserInfo = "widget/user/userInfo";

    public static final String Url_uploadImage = "widget/uploadImage";

    public static final String Url_submit = "widget/draw/submit";

    public static final String Url_getNewCount = "widget/draw/getNewCount";

    public static final String Url_getList = "widget/draw/getList";

    public static final String Url_getDetail = "widget/draw/getDetail";
    //</editor-fold>

    //<editor-fold desc="url_CDN">
    public static final String CDN_BASE_URL = "https://cdn.bloomad.cn/";//https://cdn.bloomad.cn/config/ba10ee19c1425718d6/getConfigs/cache

    public static final String CDN_REQUEST = "config/ba10ee19c1425718d6/getConfigs/cache";//"common/config/client/getConfigs/V2"
    //</editor-fold>

    public static final String AppId_Emo = "ba10ee19c1425718d6";
    public static final String AppId_Kt = "vh";
    public static final String OS_TYPE_iOS = "ios";
    public static final String ConfigVersion = "1.1.2";

    public static final String Cloud_Code_KeyWord = "700713";

    public static final String XHS_Scheme = "xhsdiscover://topic/v2/637dee0dc25e4400017fcb7d";
    public static final String XHS_Url = "https://www.xiaohongshu.com/page/topics/637dee0dc25e4400017fcb7d?fullscreen=true&naviHidden=yes&xhsshare=CopyLink&appuid=57f77f0450c4b426c0876f9a&apptime=1669289107";
    public static final String XHS_PackageName = "com.xingin.xhs";


    //<editor-fold desc="AiDraw Constant">
    public static final String ORI_H = "HORIZONTAL";
    public static final String ORI_V = "VERTICAL";

    public static final String STATE_WAITING = "WAITING";
    public static final String STATE_PROCESSING = "PROCESSING";
    public static final String STATE_FINISHED = "FINISHED";
    public static final String STATE_ERROR = "ERROR";

    public static final int size_long = 768;
    public static final int size_shot = 448;
    //</editor-fold>


    public static final String JPG = ".jpg";
    public static final String CHILDPATG = "/DCIM/Camera/";
    public static final String KV_SET_UPED = "set_uped";
    public static final String PICTURES_SAVE_PATH = "/Pictures/";
    public static String APP_SAVE_PATH = "/storage/emulated/0/Android/data/com.xaoyv.qqcache/files";
    public static final String PACKAGE_URI = "package:com.xaoyv.qqcache";
    public static final String path = "/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/chatpic/chatimg/";
    public static final int REQUESTCODE = 0;
    public static final String URL = "xaoyv/uploadimg";
    public static final String Xaoyv_BASE_URL = "http://8.140.155.202:8082/";
    public static final String KV_NEED_DEL = "need_del";
    public static final String KV_DEL_AUTHOR = "del_author";
    //    static final String BASE_URL = "http://192.168.1.51:8080/";
    public static String[] ALL_PERMISSIONS = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };
}
