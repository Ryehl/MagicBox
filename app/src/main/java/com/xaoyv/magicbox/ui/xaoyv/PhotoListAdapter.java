package com.xaoyv.magicbox.ui.xaoyv;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseAdapter;
import com.xaoyv.magicbox.base.BaseViewHolder;

public class PhotoListAdapter extends BaseAdapter<String> {
    @Override
    protected int getItemLayoutId() {
        return R.layout.item_photolist;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
//        int dp_10 = DensityUtils.dp2px(holder.getContext(), 10);
        String s = getData().get(position);
        ImageView ivShow = holder.findViewById(R.id.iv_show);
        holder.itemView.post(() -> {
            ViewGroup.LayoutParams layoutParams = ivShow.getLayoutParams();
            layoutParams.height = ivShow.getWidth();
            ivShow.setLayoutParams(layoutParams);
            Glide.with(ivShow).load(s).into(ivShow);
        });
    }
}
