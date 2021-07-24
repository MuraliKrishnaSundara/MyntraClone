package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KidsActivity extends AppCompatActivity implements OnProductClick {

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
        ProductData kidData1 = new ProductData(R.drawable.kwi1, "pspeaches", "Ready to Wear Lehenga Blous", 1827);
        kidsDataList.add(kidData1);
        ProductData kidData2 = new ProductData(R.drawable.kwi2, "JBN Creation", "Boys Kurta with Pyjamas", 1199);
        kidsDataList.add(kidData2);
        ProductData kidData3 = new ProductData(R.drawable.kwi3, "Tiber Taber", "Boys Printed Panchakattu", 1950);
        kidsDataList.add(kidData3);
        ProductData kidData4 = new ProductData(R.drawable.kwi4, "Bitiya by Bhama", "Ready to Wear Lehenga & Blous", 987);
        kidsDataList.add(kidData4);
        ProductData kidData5 = new ProductData(R.drawable.kwi5, "LilPicks", "Girls Printed Playsuit", 899);
        kidsDataList.add(kidData5);
        ProductData kidData6 = new ProductData(R.drawable.kwi6, "pspeaches", "Girls Cotton Kurti & Dhoti", 1159);
        kidsDataList.add(kidData6);
        ProductData kidData7 = new ProductData(R.drawable.kwi7, "pspeaches", "Ready to Wear Lehenga Blous", 1712);
        kidsDataList.add(kidData7);
        ProductData kidData8 = new ProductData(R.drawable.kwi8, "Bitiya by Bhama", "Girls Printed Kurta with Palazzos", 987);
        kidsDataList.add(kidData8);
        ProductData kidData9 = new ProductData(R.drawable.kwi9, "LilPicks", "Girls Printed Top with Palazzos", 899);
        kidsDataList.add(kidData9);
        ProductData kidData10 = new ProductData(R.drawable.kwi10, "Stylo Bug", "Girls Colourblocked Culotte", 768);
        kidsDataList.add(kidData10);
        ProductData kidData11 = new ProductData(R.drawable.kwi11, "Maniac", "Boys Printed Hood T-shirt", 387);
        kidsDataList.add(kidData11);
        ProductData kidData12 = new ProductData(R.drawable.kwi12, "Stylo Bug", "Girls Printed A-Line Dress", 815);
        kidsDataList.add(kidData12);
        ProductData kidData13 = new ProductData(R.drawable.kwi13, "CUTECUMBER", "Girls Printed Sheath Dress", 990);
        kidsDataList.add(kidData13);
        ProductData kidData14 = new ProductData(R.drawable.kwi14, "Bitiya by Bhama", "Girls Printed Basic Jumpsuit", 799);
        kidsDataList.add(kidData14);
        ProductData kidData15 = new ProductData(R.drawable.kwi15, "pspeaches", "Girls Geometric Printed Kurta", 1484);
        kidsDataList.add(kidData15);
        ProductData kidData16 = new ProductData(R.drawable.kwi16, "Bitiya by Bhama", "Girls Printed Fit and Flare Dress", 909);
        kidsDataList.add(kidData16);
        ProductData kidData17 = new ProductData(R.drawable.kwi17, "Cutiekins", "Girls Printed Top with Palazzos", 951);
        kidsDataList.add(kidData17);
        ProductData kidData18 = new ProductData(R.drawable.kwi18, "Bitiya by Bhama", "Girls Kurta Set & Dupatta", 989);
        kidsDataList.add(kidData18);
        ProductData kidData19 = new ProductData(R.drawable.kwi19, "naughty ninos", "Girls Striped Top with Palazzos", 900);
        kidsDataList.add(kidData19);
        ProductData kidData20 = new ProductData(R.drawable.kwi20, "Bitiya by Bhama", "Girls Printed Kurta with Palazzos", 989);
        kidsDataList.add(kidData20);
    }

    private void setRecyclerView() {
        ProductAdapter kidsAdapter = new ProductAdapter(kidsDataList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(kidsAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.kidsRecyclerView);
    }

    @Override
    public void ItemClicked(ProductData productData, int position) {
        Intent intent = new Intent(KidsActivity.this, ProductDetailedView.class);
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