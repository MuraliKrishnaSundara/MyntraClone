package com.example.myntra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private ArrayList<Data> demoList;
    private ItemClickListener itemClickListener;

    public CategoryAdapter(ArrayList<Data> demoList, ItemClickListener itemClickListener) {
        this.demoList = demoList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catogery_item_layout, parent, false);
        return new CategoryViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Data data = demoList.get(position);
        holder.setData(data);
    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }
}
