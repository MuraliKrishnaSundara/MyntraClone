package com.example.myntra;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;

public class FootWearActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> footWearProductList;
    private TextView mTvSort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_wear);
        initViews();
        buildIdentityList();
        setRecyclerView();
        mTvSort.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                footWearProductList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });
    }

    private void buildIdentityList() {
        footWearProductList = new ArrayList<>();
        ProductData footWearData1 = new ProductData(R.drawable.fwi1, "Red Tape", "Men Walking Shoes", 1224);
        footWearProductList.add(footWearData1);
        ProductData footWearData2 = new ProductData(R.drawable.fwi2, "Carbon London sports", "Men Striped Sliders", 649);
        footWearProductList.add(footWearData2);
        ProductData footWearData3 = new ProductData(R.drawable.fwi3, "Puma", "Zeta Running Shoes", 2474);
        footWearProductList.add(footWearData3);
        ProductData footWearData4 = new ProductData(R.drawable.fwi4, "Nike", "Men AIR ZOOM Running Shoes", 7721);
        footWearProductList.add(footWearData4);
        ProductData footWearData5 = new ProductData(R.drawable.fwi5, "Crocs", "Unisex Solid Thong Flip-Flops", 1797);
        footWearProductList.add(footWearData5);
        ProductData footWearData6 = new ProductData(R.drawable.fwi6, "Puma", "Unisex Kent 2.0 IDP Sneakers", 1799);
        footWearProductList.add(footWearData6);
        ProductData footWearData7 = new ProductData(R.drawable.fwi7, "SUDEA By Decathlon", "Unisex Aqua Shoes 100", 699);
        footWearProductList.add(footWearData7);
        ProductData footWearData8 = new ProductData(R.drawable.fwi8, "Nike", "Unisex COSMIC UNITY", 13495);
        footWearProductList.add(footWearData8);
        ProductData footWearData9 = new ProductData(R.drawable.fwi9, "Crocs", "Unisex Kids Printed Clogs", 2096);
        footWearProductList.add(footWearData9);
        ProductData footWearData10 = new ProductData(R.drawable.fwi10, "Puma", "Racer PS IDP Sneakers", 1259);
        footWearProductList.add(footWearData10);
        ProductData footWearData11 = new ProductData(R.drawable.fwi11, "FILA", "Unisex Kids Sneakers", 839);
        footWearProductList.add(footWearData11);
        ProductData footWearData12 = new ProductData(R.drawable.fwi12, "ADIDAS", "Boys Tensaur Running Shoes", 1949);
        footWearProductList.add(footWearData12);
        ProductData footWearData13 = new ProductData(R.drawable.fwi13, "Provogue", "Men Solid Thong Flip-Flops", 782);
        footWearProductList.add(footWearData13);
        ProductData footWearData14 = new ProductData(R.drawable.fwi14, "Metronaut", "Men Solid Thong Flip-Flops", 598);
        footWearProductList.add(footWearData14);
        ProductData footWearData15 = new ProductData(R.drawable.fwi15, "HIGHLANDER", "Men Solid Sneakers", 696);
        footWearProductList.add(footWearData15);
        ProductData footWearData16 = new ProductData(R.drawable.fwi16, "Reebok", "Women Running Shoes", 1799);
        footWearProductList.add(footWearData16);
        ProductData footWearData17 = new ProductData(R.drawable.fwi17, "ALDO", "Women Pumps", 7999);
        footWearProductList.add(footWearData17);
        ProductData footWearData18 = new ProductData(R.drawable.fwi18, "ADIDAS", "Ultraboost 20 Running Shoes", 17999);
        footWearProductList.add(footWearData18);
        ProductData footWearData19 = new ProductData(R.drawable.fwi19, "Nike", "FLEX RUNNER FABLE (GS)", 2596);
        footWearProductList.add(footWearData19);
        ProductData footWearData20 = new ProductData(R.drawable.fwi20, "Clarks", "Women Leather Pumps", 3599);
        footWearProductList.add(footWearData20);
    }

    private void setRecyclerView() {
        ProductAdapter footWearAdapter = new ProductAdapter(footWearProductList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(footWearAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.footWearRecyclerView);
        mTvSort = findViewById(R.id.tvSort);
    }

    @Override
    public void ItemClicked(ProductData productData, int position) {
        Intent intent = new Intent(FootWearActivity.this, ProductDetailedView.class);
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
