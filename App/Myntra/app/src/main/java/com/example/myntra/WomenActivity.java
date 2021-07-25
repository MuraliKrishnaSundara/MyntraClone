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

public class WomenActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> womenProductList;
    private TextView mTvSort;
    private ImageView wishlist;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
        initViews();
        buildIdentityList();
        setRecyclerView();
        mTvSort.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                womenProductList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WomenActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WomenActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
    }

    private void buildIdentityList() {
        womenProductList = new ArrayList<>();
        ProductData womenData1 = new ProductData(R.drawable.wwi1, "Yuris", "Kurta with Trousers & Dupatta", 1329);
        womenProductList.add(womenData1);
        ProductData womenData2 = new ProductData(R.drawable.wwi2, "Indo Era", "Printed Kurta with Trousers", 1479);
        womenProductList.add(womenData2);
        ProductData womenData3 = new ProductData(R.drawable.wwi3, "Nayo", "Printed Kurta with Trousers", 1479);
        womenProductList.add(womenData3);
        ProductData womenData4 = new ProductData(R.drawable.wwi4, "Yuris", "Kurta with Trousers & Dupatta", 1329);
        womenProductList.add(womenData4);
        ProductData womenData5 = new ProductData(R.drawable.wwi5, "Nayo", "Women Kurta Sets", 1399);
        womenProductList.add(womenData5);
        ProductData womenData6 = new ProductData(R.drawable.wwi6, "Jaipur Kurti", "Printed Straight Kurta", 643);
        womenProductList.add(womenData6);
        ProductData womenData7 = new ProductData(R.drawable.wwi7, "Yuris", "Printed Kurta with Sharara", 1359);
        womenProductList.add(womenData7);
        ProductData womenData8 = new ProductData(R.drawable.wwi8, "Yuris", "Kurta with Palazzos & Dupatta", 1329);
        womenProductList.add(womenData8);
        ProductData womenData9 = new ProductData(R.drawable.wwi9, "RARE", "Women Printed Maxi Dress", 959);
        womenProductList.add(womenData9);
        ProductData womenData10 = new ProductData(R.drawable.wwi10, "Libas", "Hunter Green Flowy Kurta Set", 1599);
        womenProductList.add(womenData10);
        ProductData womenData11 = new ProductData(R.drawable.wwi11, "Roadster", "Women Skinny Fit Jeans", 719);
        womenProductList.add(womenData11);
        ProductData womenData12 = new ProductData(R.drawable.wwi12, "HERE & NOW", "Printed A-Line Kurta", 559);
        womenProductList.add(womenData12);
        ProductData womenData13 = new ProductData(R.drawable.wwi13, "RARE", "Women Printed Fit and Flare", 959);
        womenProductList.add(womenData13);
        ProductData womenData14 = new ProductData(R.drawable.wwi14, "Indo Era", "Kurta with Palazzos & Dupatta", 1679);
        womenProductList.add(womenData14);
        ProductData womenData15 = new ProductData(R.drawable.wwi15, "Anubhutee", "Kurta with Trousers & Dupatta", 1215);
        womenProductList.add(womenData15);
        ProductData womenData16 = new ProductData(R.drawable.wwi16, "Tokyo Talkies", "Floral Flared Belted Dress", 899);
        womenProductList.add(womenData16);
        ProductData womenData17 = new ProductData(R.drawable.wwi17, "Yuris", "Bandhani Pure Cotton Kurta Set", 1329);
        womenProductList.add(womenData17);
        ProductData womenData18 = new ProductData(R.drawable.wwi18, "Jaipur Kurti", "Women Yoke Design Kurta", 1735);
        womenProductList.add(womenData18);
        ProductData womenData19 = new ProductData(R.drawable.wwi19, "Anubhutee", "Screen Print Kurta", 559);
        womenProductList.add(womenData19);
        ProductData womenData20 = new ProductData(R.drawable.wwi20, "Varanga", "Women Embroidered Kurta Set", 1999);
        womenProductList.add(womenData20);
    }

    private void setRecyclerView() {
        ProductAdapter womenAdapter = new ProductAdapter(womenProductList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(womenAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.womenWearRecyclerView);
        mTvSort = findViewById(R.id.tvSort);
        wishlist = findViewById(R.id.ivWishlist);
        cart = findViewById(R.id.ivCart);
    }

    @Override
    public void ItemClicked(ProductData productData, int position) {
        Intent intent = new Intent(WomenActivity.this, ProductDetailedView.class);
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