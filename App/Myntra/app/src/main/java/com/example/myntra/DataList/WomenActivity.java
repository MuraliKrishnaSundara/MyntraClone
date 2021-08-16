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

public class WomenActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> womenProductList;
    private ImageView mTvSortA;
    private ImageView mTvSortD;
    private ImageView wishlist;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
        initViews();
        buildIdentityList();
        setRecyclerView();

    }

    private void buildIdentityList() {
        womenProductList = new ArrayList<>();
        womenProductList.add(new ProductData(R.drawable.wwi1, "Yuris", "Kurta with Trousers & Dupatta", 1329));
        womenProductList.add(new ProductData(R.drawable.wwi2, "Indo Era", "Printed Kurta with Trousers", 1479));
        womenProductList.add(new ProductData(R.drawable.wwi4, "Yuris", "Kurta with Trousers & Dupatta", 1329));
        womenProductList.add(new ProductData(R.drawable.wwi5, "Nayo", "Women Kurta Sets", 1399));
        womenProductList.add(new ProductData(R.drawable.wwi6, "Jaipur Kurti", "Printed Straight Kurta", 643));
        womenProductList.add(new ProductData(R.drawable.wwi7, "Yuris", "Printed Kurta with Sharara", 1359));
        womenProductList.add(new ProductData(R.drawable.wwi8, "Yuris", "Kurta with Palazzos & Dupatta", 1329));
        womenProductList.add(new ProductData(R.drawable.wwi9, "RARE", "Women Printed Maxi Dress", 959));
        womenProductList.add(new ProductData(R.drawable.wwi10, "Libas", "Hunter Green Flowy Kurta Set", 1599));
        womenProductList.add(new ProductData(R.drawable.wwi11, "Roadster", "Women Skinny Fit Jeans", 719));
        womenProductList.add(new ProductData(R.drawable.wwi12, "HERE & NOW", "Printed A-Line Kurta", 559));
        womenProductList.add(new ProductData(R.drawable.wwi13, "RARE", "Women Printed Fit and Flare", 959));
        womenProductList.add(new ProductData(R.drawable.wwi14, "Indo Era", "Kurta with Palazzos & Dupatta", 1679));
        womenProductList.add(new ProductData(R.drawable.wwi15, "Anubhutee", "Kurta with Trousers & Dupatta", 1215));
        womenProductList.add(new ProductData(R.drawable.wwi16, "Tokyo Talkies", "Floral Flared Belted Dress", 899));
        womenProductList.add(new ProductData(R.drawable.wwi17, "Yuris", "Bandhani Pure Cotton Kurta Set", 1329));
        womenProductList.add(new ProductData(R.drawable.wwi18, "Jaipur Kurti", "Women Yoke Design Kurta", 1735));
        womenProductList.add(new ProductData(R.drawable.wwi19, "Anubhutee", "Screen Print Kurta", 559));
        womenProductList.add(new ProductData(R.drawable.wwi20, "Varanga", "Women Embroidered Kurta Set", 1999));
    }

    private void setRecyclerView() {
        ProductAdapter womenAdapter = new ProductAdapter(womenProductList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(womenAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.womenWearRecyclerView);
        mTvSortA = findViewById(R.id.downArrow);
        mTvSortD = findViewById(R.id.upArrow);
        wishlist = findViewById(R.id.ivWishlist);
        cart = findViewById(R.id.ivCart);

        //Sorting
        mTvSortA.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                womenProductList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });

        //Reverse sorting
        mTvSortD.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                womenProductList.sort(Comparator.comparing(ProductData::getProductCost).reversed());
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