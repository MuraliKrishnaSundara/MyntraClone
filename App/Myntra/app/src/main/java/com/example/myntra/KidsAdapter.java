package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KidsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private ArrayList<KidsData> kidsDataList;

    public KidsAdapter(ArrayList<KidsData> kidList) {
        this.kidsDataList = kidList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        KidsData gadgetsData = kidsDataList.get(position);
        holder.setDataKids(gadgetsData);
    }

    @Override
    public int getItemCount() {
        return kidsDataList.size();
    }
}