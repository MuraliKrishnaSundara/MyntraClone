package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MensWearAdapter extends RecyclerView.Adapter<MensWearViewHolder> {

    private ArrayList<MensWearData> mensWearDataList;

    public MensWearAdapter(ArrayList<MensWearData> mensWearList) {
        this.mensWearDataList = mensWearList;
    }

    @NonNull
    @Override
    public MensWearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new MensWearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensWearViewHolder holder, int position) {
        MensWearData mensWearData = mensWearDataList.get(position);
        holder.setData(mensWearData);
    }

    @Override
    public int getItemCount() {
        return mensWearDataList.size();
    }
}