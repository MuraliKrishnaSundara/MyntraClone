package com.example.myntra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WomenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<WomenData> womenDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
        initViews();
        buildIdentityList();
        setRecyclerView();
    }

    private void buildIdentityList() {
        womenDataList = new ArrayList<>();
        WomenData womenData1 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData1);
        WomenData womenData2 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData2);
        WomenData womenData3 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData3);
        WomenData womenData4 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData4);
        WomenData womenData5 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData5);
        WomenData womenData6 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData6);
        WomenData womenData7 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData7);
        WomenData womenData8 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData8);
        WomenData womenData9 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData9);
        WomenData womenData10 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData10);
        WomenData womenData11 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData11);
        WomenData womenData12 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData12);
        WomenData womenData13 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData13);
        WomenData womenData14 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData14);
        WomenData womenData15 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData15);
        WomenData womenData16 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData16);
        WomenData womenData17 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData17);
        WomenData womenData18 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData18);
        WomenData womenData19 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData19);
        WomenData womenData20 = new WomenData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        womenDataList.add(womenData20);
    }

    private void setRecyclerView() {
        WomenAdapter womenAdapter = new WomenAdapter(womenDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(womenAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.womenWearRecyclerView);
    }
}