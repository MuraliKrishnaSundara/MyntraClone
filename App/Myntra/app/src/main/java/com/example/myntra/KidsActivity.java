package com.example.myntra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KidsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> kidsDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        initViews();
        buildIdentityList();
        setRecyclerView();
    }

    private void buildIdentityList() {
        kidsDataList = new ArrayList<>();
        ProductData womenData1 = new ProductData(R.drawable.mwi1, "Campus Sutra", "Coloured Round Neck", 379);
        kidsDataList.add(womenData1);
    }

    private void setRecyclerView() {
        ProductAdapter kidsAdapter = new ProductAdapter(kidsDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(kidsAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.kidsRecyclerView);
    }
}