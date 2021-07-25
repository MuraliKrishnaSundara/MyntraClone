package com.example.myntra;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MenActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> menProductList;
    private ImageView mTvSortA;
    private ImageView mTvSortD;
    private ImageView wishlist;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        initViews();
        buildIdentityList();
        setRecyclerView();
        mTvSortA.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                menProductList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });
        mTvSortD.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                menProductList.sort(Comparator.comparing(ProductData::getProductCost).reversed());
                setRecyclerView();
            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
    }

    private void buildIdentityList() {
        menProductList = new ArrayList<>();
        ProductData productData1 = new ProductData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        menProductList.add(productData1);
        ProductData productData2 = new ProductData(R.drawable.mwi2, "HERE & NOW", "Coloured Round Neck", 314);
        menProductList.add(productData2);
        ProductData productData3 = new ProductData(R.drawable.mwi3, "Campus Sutra", "Men Standard Fit Casual Shirt", 599);
        menProductList.add(productData3);
        ProductData productData4 = new ProductData(R.drawable.mwi4, "Dennis Lingo", "Men Slim Fit Casual Shirt", 665);
        menProductList.add(productData4);
        ProductData productData5 = new ProductData(R.drawable.mwi5, "LOCOMOTIVE", "Men Slim Fit Jeans", 899);
        menProductList.add(productData5);
        ProductData productData6 = new ProductData(R.drawable.mwi6, "Bene Kleed", "Men Slim Fit Casual Shirt", 734);
        menProductList.add(productData6);
        ProductData productData7 = new ProductData(R.drawable.mwi7, "HERE & NOW", "Men Printed Round Neck", 194);
        menProductList.add(productData7);
        ProductData productData8 = new ProductData(R.drawable.mwi8, "Roadster", "Regular Fit Casual Shirt", 399);
        menProductList.add(productData8);
        ProductData productData9 = new ProductData(R.drawable.mwi9, "Campus Sutra", "Men Sweat Shirt", 799);
        menProductList.add(productData9);
        ProductData productData10 = new ProductData(R.drawable.mwi10, "HERE & NOW", "Solid Round Neck T-shirt", 194);
        menProductList.add(productData10);
        ProductData productData11 = new ProductData(R.drawable.mwi11, "Roadster", "Men Skinny Fit Jeans", 719);
        menProductList.add(productData11);
        ProductData productData12 = new ProductData(R.drawable.mwi12, "LOCOMOTIVE", "Men Tapered Fit Jeans", 899);
        menProductList.add(productData12);
        ProductData productData13 = new ProductData(R.drawable.mwi13, "Campus Sutra", "Printed Round Neck T-shirt", 399);
        menProductList.add(productData13);
        ProductData productData14 = new ProductData(R.drawable.mwi14, "Roadster", "Men Regular Fit Denim Shirt", 594);
        menProductList.add(productData14);
        ProductData productData15 = new ProductData(R.drawable.mwi15, "Huetrap", "MPrinted Round Neck T-shirt", 494);
        menProductList.add(productData15);
        ProductData productData16 = new ProductData(R.drawable.mwi16, "Roadster", "Colourblocked T-shirt", 319);
        menProductList.add(productData16);
        ProductData productData17 = new ProductData(R.drawable.mwi17, "HIGHLANDER", "Slim Fit Casual Shirt", 499);
        menProductList.add(productData17);
        ProductData productData18 = new ProductData(R.drawable.mwi18, "Dennis Lingo", "Men Slim Fit Casual Shirt", 665);
        menProductList.add(productData18);
        ProductData productData19 = new ProductData(R.drawable.mwi19, "Mast & Harbour", "Printed Pure Cotton Night suit", 629);
        menProductList.add(productData19);
        ProductData productData20 = new ProductData(R.drawable.mwi20, "Roadster", "Striped Polo Collar T-shirt", 439);
        menProductList.add(productData20);
    }

    private void setRecyclerView() {
        ProductAdapter productAdapter = new ProductAdapter(menProductList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.mensWearRecyclerView);
        mTvSortA = findViewById(R.id.downArrow);
        mTvSortD = findViewById(R.id.upArrow);
        wishlist = findViewById(R.id.ivWishlist);
        cart = findViewById(R.id.ivCart);
    }

    @Override
    public void ItemClicked(ProductData productData, int position) {
        Intent intent = new Intent(MenActivity.this, ProductDetailedView.class);
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