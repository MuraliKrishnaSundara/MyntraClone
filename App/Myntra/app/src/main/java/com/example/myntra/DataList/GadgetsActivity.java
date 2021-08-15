package com.example.myntra.DataList;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.Order.ShoppingBag;
import com.example.myntra.Order.WishlistActivity;
import com.example.myntra.Product.OnProductClick;
import com.example.myntra.Product.ProductAdapter;
import com.example.myntra.Product.ProductData;
import com.example.myntra.Product.ProductDetailedView;
import com.example.myntra.R;

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

    }

    private void buildIdentityList() {
        gadgetsDataList = new ArrayList<>();
        gadgetsDataList.add(new ProductData(R.drawable.gi1, "boAt", "Unisex Storm Smart Watch", 2999));
        gadgetsDataList.add(new ProductData(R.drawable.gi2, "NOISE", "ColorFit 2 Smart Fitness Band", 1699));
        gadgetsDataList.add(new ProductData(R.drawable.gi3, "boAt", "Airdopes 131 Type C Earbuds", 1299));
        gadgetsDataList.add(new ProductData(R.drawable.gi4, "JBL", "Earphones with Mic", 649));
        gadgetsDataList.add(new ProductData(R.drawable.gi5, "boAt", "Unisex Rockerz Headphones", 1499));
        gadgetsDataList.add(new ProductData(R.drawable.gi6, "BOULT AUDIO", "Wireless AirBass Cobuds", 1099));
        gadgetsDataList.add(new ProductData(R.drawable.gi7, "NOISE", "Buds VS101 Bluetooth Earbuds", 1299));
        gadgetsDataList.add(new ProductData(R.drawable.gi8, "HAMMER", "Unisex Pulse Touch Waterproof", 2999));
        gadgetsDataList.add(new ProductData(R.drawable.gi9, "JBL", "Charge 3 Bluetooth Speaker", 8999));
        gadgetsDataList.add(new ProductData(R.drawable.gi10, "OnePlus", "2 Bass Edition Headphones", 1999));
        gadgetsDataList.add(new ProductData(R.drawable.gi11, "WINGS", "Bluetooth Wireless Earphones", 2999));
        gadgetsDataList.add(new ProductData(R.drawable.gi12, "Realme", "Buds Air 2 Headphones", 3299));
        gadgetsDataList.add(new ProductData(R.drawable.gi13, "boAt", "Unisex Wireless Headphones", 1499));
        gadgetsDataList.add(new ProductData(R.drawable.gi14, "Apple", "Apple Watch Series 3 GPS", 23900));
        gadgetsDataList.add(new ProductData(R.drawable.gi15, "Apple", "AirPods Pro", 24900));
        gadgetsDataList.add(new ProductData(R.drawable.gi16, "iball", "Cinebar 200DD with Subwoofer", 11399));
        gadgetsDataList.add(new ProductData(R.drawable.gi17, "Fastrack", "Unisex REFLEX 3.0 Smartwatch", 2515));
        gadgetsDataList.add(new ProductData(R.drawable.gi18, "OPTA", "Solid Bluetooth Fitness Smartwatch", 2519));
        gadgetsDataList.add(new ProductData(R.drawable.gi19, "BOULT AUDIO", "CurvePro Wired Earphones", 1199));
        gadgetsDataList.add(new ProductData(R.drawable.gi20, "boAt", "Unisex Wireless Headphones", 1299));
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