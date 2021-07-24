package com.example.myntra;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvProductImage;
    private TextView mTvProductName;
    private TextView mTvProductType;
    private TextView mTvProductCost;
    private ConstraintLayout constraintLayout;
    private Button move;
    private Button remove;
    private OnProductClick onProductClick;
    private LinearLayout linearLayout;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
//        mIvProductImage = itemView.findViewById(R.id.cartImageView);
//        mTvProductName = itemView.findViewById(R.id.bagCompanyName);
//        mTvProductType = itemView.findViewById(R.id.bagProductName);
//        mTvProductCost = itemView.findViewById(R.id.bagProductCost);
        constraintLayout = itemView.findViewById(R.id.ProductRelativeLayout);
        move = itemView.findViewById(R.id.btnMove);
        remove = itemView.findViewById(R.id.btnRemove);
        linearLayout = itemView.findViewById(R.id.btnShowHide);
    }

    public void setOrderData(ProductData productData) {
        mIvProductImage.setImageResource(productData.getProductImage());
        mTvProductName.setText(productData.getProductName());
        mTvProductType.setText(productData.getProductType());
        mTvProductCost.setText(productData.getProductCost() + "");
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductClick.ItemClicked(productData, getAdapterPosition());
                if (linearLayout.getVisibility() == View.GONE) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.GONE);
                }

            }
        });
    }
}
