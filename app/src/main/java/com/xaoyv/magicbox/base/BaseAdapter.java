package com.xaoyv.magicbox.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<D> data;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(getItemId(), parent, false);
        return new RecyclerView.ViewHolder(inflate) {
        };
    }

    protected ArrayList<D> getData() {
        return data;
    }

    protected abstract int getItemId();

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
