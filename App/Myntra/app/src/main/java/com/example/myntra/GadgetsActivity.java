package com.example.myntra;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;

public class GadgetsActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> gadgetsDataList;
    private ImageView mTvSortA;
    private ImageView mTvSortD;
    private ImageView wishlist;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets);
        initViews();
        buildIdentityList();
        setRecyclerView();
        mTvSortA.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                gadgetsDataList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });
        mTvSortD.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                gadgetsDataList.sort(Comparator.comparing(ProductData::getProductCost).reversed());
                setRecyclerView();
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GadgetsActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GadgetsActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
    }

    private void buildIdentityList() {
        gadgetsDataList = new ArrayList<>();
        ProductData gadgetData1 = new ProductData(R.drawable.gi1, "boAt", "Unisex Storm Smart Watch", 2999);
        gadgetsDataList.add(gadgetData1);
        ProductData gadgetData2 = new ProductData(R.drawable.gi2, "NOISE", "ColorFit 2 Smart Fitness Band", 1699);
        gadgetsDataList.add(gadgetData2);
        ProductData gadgetData3 = new ProductData(R.drawable.gi3, "boAt", "Airdopes 131 Type C Earbuds", 1299);
        gadgetsDataList.add(gadgetData3);
        ProductData gadgetData4 = new ProductData(R.drawable.gi4, "JBL", "Earphones with Mic", 649);
        gadgetsDataList.add(gadgetData4);
        ProductData gadgetData5 = new ProductData(R.drawable.gi5, "boAt", "Unisex Rockerz Headphones", 1499);
        gadgetsDataList.add(gadgetData5);
        ProductData gadgetData6 = new ProductData(R.drawable.gi6, "BOULT AUDIO", "Wireless AirBass Cobuds", 1099);
        gadgetsDataList.add(gadgetData6);
        ProductData gadgetData7 = new ProductData(R.drawable.gi7, "NOISE", "Buds VS101 Bluetooth Earbuds", 1299);
        gadgetsDataList.add(gadgetData7);
        ProductData gadgetData8 = new ProductData(R.drawable.gi8, "HAMMER", "Unisex Pulse Touch Waterproof", 2999);
        gadgetsDataList.add(gadgetData8);
        ProductData gadgetData9 = new ProductData(R.drawable.gi9, "JBL", "Charge 3 Bluetooth Speaker", 8999);
        gadgetsDataList.add(gadgetData9);
        ProductData gadgetData10 = new ProductData(R.drawable.gi10, "OnePlus", "2 Bass Edition Headphones", 1999);
        gadgetsDataList.add(gadgetData10);
        ProductData gadgetData11 = new ProductData(R.drawable.gi11, "WINGS", "Bluetooth Wireless Earphones", 2999);
        gadgetsDataList.add(gadgetData11);
        ProductData gadgetData12 = new ProductData(R.drawable.gi12, "Realme", "Buds Air 2 Headphones", 3299);
        gadgetsDataList.add(gadgetData12);
        ProductData gadgetData13 = new ProductData(R.drawable.gi13, "boAt", "Unisex Wireless Headphones", 1499);
        gadgetsDataList.add(gadgetData13);
        ProductData gadgetData14 = new ProductData(R.drawable.gi14, "Apple", "Apple Watch Series 3 GPS", 23900);
        gadgetsDataList.add(gadgetData14);
        ProductData gadgetData15 = new ProductData(R.drawable.gi15, "Apple", "AirPods Pro", 24900);
        gadgetsDataList.add(gadgetData15);
        ProductData gadgetData16 = new ProductData(R.drawable.gi16, "iball", "Cinebar 200DD with Subwoofer", 11399);
        gadgetsDataList.add(gadgetData16);
        ProductData gadgetData17 = new ProductData(R.drawable.gi17, "Fastrack", "Unisex REFLEX 3.0 Smartwatch", 2515);
        gadgetsDataList.add(gadgetData17);
        ProductData gadgetData18 = new ProductData(R.drawable.gi18, "OPTA", "Solid Bluetooth Fitness Smartwatch", 2519);
        gadgetsDataList.add(gadgetData18);
        ProductData gadgetData19 = new ProductData(R.drawable.gi19, "BOULT AUDIO", "CurvePro Wired Earphones", 1199);
        gadgetsDataList.add(gadgetData19);
        ProductData gadgetData20 = new ProductData(R.drawable.gi20, "boAt", "Unisex Wireless Headphones", 1299);
        gadgetsDataList.add(gadgetData20);
    }

    private void setRecyclerView() {
        ProductAdapter gadgetsAdapter = new ProductAdapter(gadgetsDataList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gadgetsAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.gadgetsRecyclerView);
        mTvSortA = findViewById(R.id.downArrow);
        mTvSortD = findViewById(R.id.upArrow);
        wishlist = findViewById(R.id.ivWishlist);
        cart = findViewById(R.id.ivCart);
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