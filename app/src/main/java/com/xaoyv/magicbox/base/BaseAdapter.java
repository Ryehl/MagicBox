package com.xaoyv.magicbox.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<D> data;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(getItemLayoutId(), parent, false);
        return new BaseViewHolder(inflate);
    }

    protected List<D> getData() {
        return data;
    }

    protected abstract int getItemLayoutId();

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<D> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<D> data) {
        if (this.data == null) {
            this.data = data;
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }
}
