package com.jamshidbek.shoppingapp.fragments;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndicatorAdapter extends RecyclerView.Adapter {

    public IndicatorAdapter(int size) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setSelectedDotPosition(int position) {
    }

    public void setSize(int size) {
    }
}
