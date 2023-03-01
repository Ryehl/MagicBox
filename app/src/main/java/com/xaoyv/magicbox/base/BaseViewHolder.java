package com.xaoyv.magicbox.base;

import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final View view;
    private final Context mContext;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        mContext = itemView.getContext();
    }

    public Context getContext() {
        return mContext;
    }

    public <T extends View> T findViewById(@IdRes int id) {
        return view.findViewById(id);
    }
}
