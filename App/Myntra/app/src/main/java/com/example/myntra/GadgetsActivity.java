package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GadgetsActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> gadgetsDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets);
        initViews();
        buildIdentityList();
        setRecyclerView();
    }

    private void buildIdentityList() {
        gadgetsDataList = new ArrayList<>();
        ProductData womenData1 = new ProductData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData1);
        ProductData womenData2 = new ProductData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData2);
        ProductData womenData3 = new ProductData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData3);
        ProductData womenData4 = new ProductData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData4);
    }

    private void setRecyclerView() {
        ProductAdapter gadgetsAdapter = new ProductAdapter(gadgetsDataList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gadgetsAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.gadgetsRecyclerView);
    }

    @Override
    public void ItemClicked(ProductData productData, int position) {
        Intent intent = new Intent(GadgetsActivity.this, ProductDetailedView.class);
        intent.putExtra("productName", productData.getProductType());
        intent.putExtra("productCompany", productData.getProductName());
        intent.putExtra("productPrice", productData.getProductCost());
        intent.putExtra("image", productData.getProductImage());
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}