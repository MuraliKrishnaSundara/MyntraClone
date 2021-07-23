package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private ArrayList<ProductsData> productsDataList;

    public ProductsAdapter(ArrayList<ProductsData> mensWearList) {
        this.productsDataList = mensWearList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        ProductsData productsData = productsDataList.get(position);
        holder.setData(productsData);
    }

    @Override
    public int getItemCount() {
        return productsDataList.size();
    }
}