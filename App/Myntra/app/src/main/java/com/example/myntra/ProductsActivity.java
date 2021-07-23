package com.example.myntra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MensWearData> mensWearDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initViews();
        buildIdentityList();
        setRecyclerView();
    }

    private void buildIdentityList() {
        mensWearDataList = new ArrayList<>();
        MensWearData mensWearData1 = new MensWearData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", "₹ 379");
        mensWearDataList.add(mensWearData1);
        MensWearData mensWearData2 = new MensWearData(R.drawable.mwi2, "HERE & NOW", "Coloured Round Neck", "₹ 314");
        mensWearDataList.add(mensWearData2);
        MensWearData mensWearData3 = new MensWearData(R.drawable.mwi3, "Campus Sutra", "Men Standard Fit Casual Shirt", "₹ 599");
        mensWearDataList.add(mensWearData3);
        MensWearData mensWearData4 = new MensWearData(R.drawable.mwi4, "Dennis Lingo", "Men Slim Fit Casual Shirt", "₹ 665");
        mensWearDataList.add(mensWearData4);
        MensWearData mensWearData5 = new MensWearData(R.drawable.mwi5, "LOCOMOTIVE", "Men Slim Fit Jeans", "₹ 899");
        mensWearDataList.add(mensWearData5);
        MensWearData mensWearData6 = new MensWearData(R.drawable.mwi6, "Bene Kleed", "Men Slim Fit Casual Shirt", "₹ 734");
        mensWearDataList.add(mensWearData6);
        MensWearData mensWearData7 = new MensWearData(R.drawable.mwi7, "HERE & NOW", "Men Printed Round Neck", "₹ 194");
        mensWearDataList.add(mensWearData7);
        MensWearData mensWearData8 = new MensWearData(R.drawable.mwi8, "Roadster", "Regular Fit Casual Shirt", "₹ 399");
        mensWearDataList.add(mensWearData8);
        MensWearData mensWearData9 = new MensWearData(R.drawable.mwi9, "Campus Sutra", "Men Sweat Shirt", "₹ 799");
        mensWearDataList.add(mensWearData9);
        MensWearData mensWearData10 = new MensWearData(R.drawable.mwi10, "HERE & NOW", "Solid Round Neck T-shirt", "₹ 194");
        mensWearDataList.add(mensWearData10);
        MensWearData mensWearData11 = new MensWearData(R.drawable.mwi11, "Roadster", "Men Skinny Fit Jeans", "₹ 719");
        mensWearDataList.add(mensWearData11);
        MensWearData mensWearData12 = new MensWearData(R.drawable.mwi12, "LOCOMOTIVE", "Men Tapered Fit Jeans", "₹ 899");
        mensWearDataList.add(mensWearData12);
        MensWearData mensWearData13 = new MensWearData(R.drawable.mwi13, "Campus Sutra", "Printed Round Neck T-shirt", "₹ 399");
        mensWearDataList.add(mensWearData13);
        MensWearData mensWearData14 = new MensWearData(R.drawable.mwi14, "Roadster", "Men Regular Fit Denim Shirt", "₹ 594");
        mensWearDataList.add(mensWearData14);
        MensWearData mensWearData15 = new MensWearData(R.drawable.mwi15, "Huetrap", "MPrinted Round Neck T-shirt", "₹ 494");
        mensWearDataList.add(mensWearData15);
        MensWearData mensWearData16 = new MensWearData(R.drawable.mwi16, "Roadster", "Colourblocked T-shirt", "₹ 319");
        mensWearDataList.add(mensWearData16);
        MensWearData mensWearData17 = new MensWearData(R.drawable.mwi17, "HIGHLANDER", "Slim Fit Casual Shirt", "₹ 499");
        mensWearDataList.add(mensWearData17);
        MensWearData mensWearData18 = new MensWearData(R.drawable.mwi18, "Dennis Lingo", "Men Slim Fit Casual Shirt", "₹ 665");
        mensWearDataList.add(mensWearData18);
        MensWearData mensWearData19 = new MensWearData(R.drawable.mwi19, "Mast & Harbour", "Printed Pure Cotton Night suit", "₹ 629");
        mensWearDataList.add(mensWearData19);
        MensWearData mensWearData20 = new MensWearData(R.drawable.mwi20, "Roadster", "Striped Polo Collar T-shirt", "₹ 439");
        mensWearDataList.add(mensWearData20);
    }

    private void setRecyclerView() {
        MensWearAdapter mensWearAdapter = new MensWearAdapter(mensWearDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mensWearAdapter);


    }

    private void initViews() {
        recyclerView = findViewById(R.id.mensWearRecyclerView);
    }
}