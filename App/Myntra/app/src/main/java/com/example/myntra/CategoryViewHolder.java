package com.example.myntra;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private TextView text;
    private ItemClickListener itemClickListener;

    public CategoryViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        text = itemView.findViewById(R.id.tvCtext);
    }

    public void setData(CategoryDataModel categoryDataModel) {
        text.setText(categoryDataModel.getText());
    }
}
