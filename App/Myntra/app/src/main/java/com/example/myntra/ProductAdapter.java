package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private ArrayList<ProductData> productDataList;
    private OnProductClick onProductClick;

    public ProductAdapter(ArrayList<ProductData> productList, OnProductClick onProductClick) {
        this.productDataList = productList;
        this.onProductClick = onProductClick;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new ProductsViewHolder(view, onProductClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        ProductData productData = productDataList.get(position);
        holder.setData(productData);
    }

    @Override
    public int getItemCount() {
        return productDataList.size();
    }
}