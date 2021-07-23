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
        relativeLayout = itemView.findViewById(R.id.ProductRelativeLayout);
    }


    public void setDataMen(MenData menData) {
        mIvProductImage.setImageResource(menData.getMensWearImage());
        mTvProductName.setText(menData.getMensWearName());
        mTvProductType.setText(menData.getMensWearType());
        mTvProductCost.setText(menData.getMensWearCost() + "");
    }

    public void setDataWomen(WomenData womenData) {
        mIvProductImage.setImageResource(womenData.getWomensWearImage());
        mTvProductName.setText(womenData.getWomensWearName());
        mTvProductType.setText(womenData.getWomensWearType());
        mTvProductCost.setText(womenData.getWomensWearCost() + "");
    }

    public void setDataGadgets(GadgetsData gadgetsData) {
        mIvProductImage.setImageResource(gadgetsData.getGadgetsWearImage());
        mTvProductName.setText(gadgetsData.getGadgetsWearName());
        mTvProductType.setText(gadgetsData.getGadgetsWearType());
        mTvProductCost.setText(gadgetsData.getGadgetsWearCost() + "");
    }

    public void setDataKids(KidsData kidsData) {
        mIvProductImage.setImageResource(kidsData.getKidsWearImage());
        mTvProductName.setText(kidsData.getKidsWearName());
        mTvProductType.setText(kidsData.getKidsWearType());
        mTvProductCost.setText(kidsData.getKidsWearCost() + "");

    }
}