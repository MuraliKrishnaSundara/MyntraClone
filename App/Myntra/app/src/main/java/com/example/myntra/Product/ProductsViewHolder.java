package com.example.myntra.Product;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.R;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvProductImage;
    private TextView mTvProductName;
    private TextView mTvProductType;
    private TextView mTvProductCost;
    private RelativeLayout relativeLayout;
    private OnProductClick onProductClick;

    public ProductsViewHolder(@NonNull View itemView, OnProductClick onProductClick) {
        super(itemView);
        this.onProductClick = onProductClick;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvProductImage = itemView.findViewById(R.id.ivProductImage);
        mTvProductName = itemView.findViewById(R.id.tvProductName);
        mTvProductType = itemView.findViewById(R.id.tvProductType);
        mTvProductCost = itemView.findViewById(R.id.tvProductCost);
        relativeLayout = itemView.findViewById(R.id.ProductRelativeLayout);
    }

    public void setData(ProductData productData) {
        mIvProductImage.setImageResource(productData.getProductImage());
        mTvProductName.setText(productData.getProductName());
        mTvProductType.setText(productData.getProductType());
        mTvProductCost.setText(productData.getProductCost() + "");
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductClick.ItemClicked(productData, getAdapterPosition());
            }
        });
    }

}