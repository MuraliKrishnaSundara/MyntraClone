package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudioAdapter extends RecyclerView.Adapter<StudioViewHolder> {

    private ArrayList<StudioData> studioDataList;

    public StudioAdapter(ArrayList<StudioData> studioDataList) {
        this.studioDataList = studioDataList;
    }

    @NonNull
    @Override
    public StudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studio_item_layout, parent, false);
        return new StudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudioViewHolder holder, int position) {
        StudioData studioData = studioDataList.get(position);
        holder.setData(studioData);
    }

    @Override
    public int getItemCount() {
        return studioDataList.size();
    }
}