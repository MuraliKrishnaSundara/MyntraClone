package com.example.myntra.NavBarAvtivity.Catogries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private ArrayList<CategoryDataModel> demoList;
    private ItemClickListener itemClickListener;

    public CategoryAdapter(ArrayList<CategoryDataModel> demoList, ItemClickListener itemClickListener) {
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
        CategoryDataModel catogeryDataModel = demoList.get(position);
        holder.setData(catogeryDataModel);
    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }
}
