package com.example.myntra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ProductsData> productsDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initViews();
        buildIdentityList();
        setRecyclerView();
    }

    private void buildIdentityList() {
        productsDataList = new ArrayList<>();
        ProductsData productsData1 = new ProductsData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", "₹ 379");
        productsDataList.add(productsData1);
        ProductsData productsData2 = new ProductsData(R.drawable.mwi2, "HERE & NOW", "Coloured Round Neck", "₹ 314");
        productsDataList.add(productsData2);
        ProductsData productsData3 = new ProductsData(R.drawable.mwi3, "Campus Sutra", "Men Standard Fit Casual Shirt", "₹ 599");
        productsDataList.add(productsData3);
        ProductsData productsData4 = new ProductsData(R.drawable.mwi4, "Dennis Lingo", "Men Slim Fit Casual Shirt", "₹ 665");
        productsDataList.add(productsData4);
        ProductsData productsData5 = new ProductsData(R.drawable.mwi5, "LOCOMOTIVE", "Men Slim Fit Jeans", "₹ 899");
        productsDataList.add(productsData5);
        ProductsData productsData6 = new ProductsData(R.drawable.mwi6, "Bene Kleed", "Men Slim Fit Casual Shirt", "₹ 734");
        productsDataList.add(productsData6);
        ProductsData productsData7 = new ProductsData(R.drawable.mwi7, "HERE & NOW", "Men Printed Round Neck", "₹ 194");
        productsDataList.add(productsData7);
        ProductsData productsData8 = new ProductsData(R.drawable.mwi8, "Roadster", "Regular Fit Casual Shirt", "₹ 399");
        productsDataList.add(productsData8);
        ProductsData productsData9 = new ProductsData(R.drawable.mwi9, "Campus Sutra", "Men Sweat Shirt", "₹ 799");
        productsDataList.add(productsData9);
        ProductsData productsData10 = new ProductsData(R.drawable.mwi10, "HERE & NOW", "Solid Round Neck T-shirt", "₹ 194");
        productsDataList.add(productsData10);
        ProductsData productsData11 = new ProductsData(R.drawable.mwi11, "Roadster", "Men Skinny Fit Jeans", "₹ 719");
        productsDataList.add(productsData11);
        ProductsData productsData12 = new ProductsData(R.drawable.mwi12, "LOCOMOTIVE", "Men Tapered Fit Jeans", "₹ 899");
        productsDataList.add(productsData12);
        ProductsData productsData13 = new ProductsData(R.drawable.mwi13, "Campus Sutra", "Printed Round Neck T-shirt", "₹ 399");
        productsDataList.add(productsData13);
        ProductsData productsData14 = new ProductsData(R.drawable.mwi14, "Roadster", "Men Regular Fit Denim Shirt", "₹ 594");
        productsDataList.add(productsData14);
        ProductsData productsData15 = new ProductsData(R.drawable.mwi15, "Huetrap", "MPrinted Round Neck T-shirt", "₹ 494");
        productsDataList.add(productsData15);
        ProductsData productsData16 = new ProductsData(R.drawable.mwi16, "Roadster", "Colourblocked T-shirt", "₹ 319");
        productsDataList.add(productsData16);
        ProductsData productsData17 = new ProductsData(R.drawable.mwi17, "HIGHLANDER", "Slim Fit Casual Shirt", "₹ 499");
        productsDataList.add(productsData17);
        ProductsData productsData18 = new ProductsData(R.drawable.mwi18, "Dennis Lingo", "Men Slim Fit Casual Shirt", "₹ 665");
        productsDataList.add(productsData18);
        ProductsData productsData19 = new ProductsData(R.drawable.mwi19, "Mast & Harbour", "Printed Pure Cotton Night suit", "₹ 629");
        productsDataList.add(productsData19);
        ProductsData productsData20 = new ProductsData(R.drawable.mwi20, "Roadster", "Striped Polo Collar T-shirt", "₹ 439");
        productsDataList.add(productsData20);
    }

    private void setRecyclerView() {
        ProductsAdapter productsAdapter = new ProductsAdapter(productsDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productsAdapter);


    }

    private void initViews() {
        recyclerView = findViewById(R.id.mensWearRecyclerView);
    }
}