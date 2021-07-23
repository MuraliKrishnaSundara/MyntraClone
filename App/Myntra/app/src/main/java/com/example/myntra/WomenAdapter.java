package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WomenAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private ArrayList<WomenData> womenDataList;

    public WomenAdapter(ArrayList<WomenData> womensWearList) {
        this.womenDataList = womensWearList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        WomenData womenData = womenDataList.get(position);
        holder.setDataWomen(womenData);
    }

    @Override
    public int getItemCount() {
        return womenDataList.size();
    }
}