package com.xaoyv.magicbox.ui.home;

import android.content.Intent;
import android.view.View;

import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseFragment;
import com.xaoyv.magicbox.ui.xaoyv.PhotoListActivity;

public class MineFragment extends BaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        View viewById = view.findViewById(R.id.btn_list);
        viewById.setOnClickListener(v -> {
            Intent intent = new Intent(getNonNullContext(), PhotoListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getNonNullContext().startActivity(intent);
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
