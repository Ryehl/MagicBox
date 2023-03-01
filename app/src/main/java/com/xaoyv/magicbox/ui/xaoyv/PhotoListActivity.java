package com.xaoyv.magicbox.ui.xaoyv;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseActivity;
import com.xaoyv.magicbox.bean.TitleBean;
import com.xaoyv.magicbox.entity.PhotoListBean;
import com.xaoyv.magicbox.util.NetUtils;
import com.xaoyv.magicbox.util.ToastUtil;

import java.util.HashMap;
import java.util.List;

public class PhotoListActivity extends BaseActivity {
    private PhotoListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        initView();
        initData();
    }

    private void initData() {
        HashMap<String, Object> parameterMap = new HashMap<>();
        NetUtils.getNetUtils().postInfo("xaoyv/getimgs", parameterMap, new NetUtils.RequestListener() {
            @Override
            public void success(String string) {
                PhotoListBean photoListBean = new Gson().fromJson(string, PhotoListBean.class);
                List<String> fileNames = photoListBean.getFileNames();
                adapter.setData(fileNames);
                ToastUtil.toast("" + fileNames.size());
            }

            @Override
            public void error(String message) {
                ToastUtil.toast(message);
                Log.e("TAG", "error: " + message);
            }
        });
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new PhotoListAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected TitleBean initTitle() {
        return new TitleBean(R.string.title_photolist);
    }
}
