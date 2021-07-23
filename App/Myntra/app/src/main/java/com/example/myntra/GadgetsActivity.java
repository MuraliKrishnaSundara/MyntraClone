package com.example.myntra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GadgetsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<GadgetsData> gadgetsDataList;

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
        GadgetsData womenData1 = new GadgetsData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData1);
        GadgetsData womenData2 = new GadgetsData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData2);
        GadgetsData womenData3 = new GadgetsData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData3);
        GadgetsData womenData4 = new GadgetsData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        gadgetsDataList.add(womenData4);
    }

    private void setRecyclerView() {
        GadgetsAdapter gadgetsAdapter = new GadgetsAdapter(gadgetsDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gadgetsAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.gadgetsRecyclerView);
    }
}