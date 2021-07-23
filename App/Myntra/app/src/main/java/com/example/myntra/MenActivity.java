package com.example.myntra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MenData> menDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        initViews();
        buildIdentityList();
        setRecyclerView();
    }

    private void buildIdentityList() {
        menDataList = new ArrayList<>();
        MenData menData1 = new MenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        menDataList.add(menData1);
        MenData menData2 = new MenData(R.drawable.mwi2, "HERE & NOW", "Coloured Round Neck", 314);
        menDataList.add(menData2);
        MenData menData3 = new MenData(R.drawable.mwi3, "Campus Sutra", "Men Standard Fit Casual Shirt", 599);
        menDataList.add(menData3);
        MenData menData4 = new MenData(R.drawable.mwi4, "Dennis Lingo", "Men Slim Fit Casual Shirt", 665);
        menDataList.add(menData4);
        MenData menData5 = new MenData(R.drawable.mwi5, "LOCOMOTIVE", "Men Slim Fit Jeans", 899);
        menDataList.add(menData5);
        MenData menData6 = new MenData(R.drawable.mwi6, "Bene Kleed", "Men Slim Fit Casual Shirt", 734);
        menDataList.add(menData6);
        MenData menData7 = new MenData(R.drawable.mwi7, "HERE & NOW", "Men Printed Round Neck", 194);
        menDataList.add(menData7);
        MenData menData8 = new MenData(R.drawable.mwi8, "Roadster", "Regular Fit Casual Shirt", 399);
        menDataList.add(menData8);
        MenData menData9 = new MenData(R.drawable.mwi9, "Campus Sutra", "Men Sweat Shirt", 799);
        menDataList.add(menData9);
        MenData menData10 = new MenData(R.drawable.mwi10, "HERE & NOW", "Solid Round Neck T-shirt", 194);
        menDataList.add(menData10);
        MenData menData11 = new MenData(R.drawable.mwi11, "Roadster", "Men Skinny Fit Jeans", 719);
        menDataList.add(menData11);
        MenData menData12 = new MenData(R.drawable.mwi12, "LOCOMOTIVE", "Men Tapered Fit Jeans", 899);
        menDataList.add(menData12);
        MenData menData13 = new MenData(R.drawable.mwi13, "Campus Sutra", "Printed Round Neck T-shirt", 399);
        menDataList.add(menData13);
        MenData menData14 = new MenData(R.drawable.mwi14, "Roadster", "Men Regular Fit Denim Shirt", 594);
        menDataList.add(menData14);
        MenData menData15 = new MenData(R.drawable.mwi15, "Huetrap", "MPrinted Round Neck T-shirt", 494);
        menDataList.add(menData15);
        MenData menData16 = new MenData(R.drawable.mwi16, "Roadster", "Colourblocked T-shirt", 319);
        menDataList.add(menData16);
        MenData menData17 = new MenData(R.drawable.mwi17, "HIGHLANDER", "Slim Fit Casual Shirt", 499);
        menDataList.add(menData17);
        MenData menData18 = new MenData(R.drawable.mwi18, "Dennis Lingo", "Men Slim Fit Casual Shirt", 665);
        menDataList.add(menData18);
        MenData menData19 = new MenData(R.drawable.mwi19, "Mast & Harbour", "Printed Pure Cotton Night suit", 629);
        menDataList.add(menData19);
        MenData menData20 = new MenData(R.drawable.mwi20, "Roadster", "Striped Polo Collar T-shirt", 439);
        menDataList.add(menData20);
    }

    private void setRecyclerView() {
        MenAdapter menAdapter = new MenAdapter(menDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(menAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.mensWearRecyclerView);
    }
}