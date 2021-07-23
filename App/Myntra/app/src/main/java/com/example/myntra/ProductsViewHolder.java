package com.example.myntra;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvProductImage;
    private TextView mTvProductName;
    private TextView mTvProductType;
    private TextView mTvProductCost;
    private RelativeLayout relativeLayout;

    public ProductsViewHolder(@NonNull View itemView) {
        super(itemView);
        iniViews(itemView);
    }

    private void iniViews(View itemView) {
        mIvProductImage = itemView.findViewById(R.id.ivProductImage);
        mTvProductName = itemView.findViewById(R.id.tvProductName);
        mTvProductType = itemView.findViewById(R.id.tvProductType);
        mTvProductCost = itemView.findViewById(R.id.tvProductCost);
        relativeLayout = itemView.findViewById(R.id.mensWearRelativeLayout);
    }

    public void setData(ProductsData productsData) {
        mIvProductImage.setImageResource(productsData.getProductImage());
        mTvProductName.setText(productsData.getProductName());
        mTvProductType.setText(productsData.getProductType());
        mTvProductCost.setText(productsData.getProductCost());
    }
}