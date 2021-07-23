package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private ArrayList<MenData> menDataList;

    public MenAdapter(ArrayList<MenData> mensWearList) {
        this.menDataList = mensWearList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        MenData menData = menDataList.get(position);
        holder.setDataMen(menData);
    }

    @Override
    public int getItemCount() {
        return menDataList.size();
    }
}