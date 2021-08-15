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

public class FootWearActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> footWearProductList;
    private ImageView mTvSortA;
    private ImageView mTvSortD;
    private ImageView wishlist;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_wear);
        initViews();
        buildIdentityList();
        setRecyclerView();

    }

    private void buildIdentityList() {
        footWearProductList = new ArrayList<>();
        footWearProductList.add(new ProductData(R.drawable.fwi1, "Red Tape", "Men Walking Shoes", 1224));
        footWearProductList.add(new ProductData(R.drawable.fwi2, "Carbon London sports", "Men Striped Sliders", 649));
        footWearProductList.add(new ProductData(R.drawable.fwi3, "Puma", "Zeta Running Shoes", 2474));
        footWearProductList.add(new ProductData(R.drawable.fwi4, "Nike", "Men AIR ZOOM Running Shoes", 7721));
        footWearProductList.add(new ProductData(R.drawable.fwi5, "Crocs", "Unisex Solid Thong Flip-Flops", 1797));
        footWearProductList.add(new ProductData(R.drawable.fwi6, "Puma", "Unisex Kent 2.0 IDP Sneakers", 1799));
        footWearProductList.add(new ProductData(R.drawable.fwi7, "SUDEA By Decathlon", "Unisex Aqua Shoes 100", 699));
        footWearProductList.add(new ProductData(R.drawable.fwi8, "Nike", "Unisex COSMIC UNITY", 13495));
        footWearProductList.add(new ProductData(R.drawable.fwi9, "Crocs", "Unisex Kids Printed Clogs", 2096));
        footWearProductList.add(new ProductData(R.drawable.fwi10, "Puma", "Racer PS IDP Sneakers", 1259));
        footWearProductList.add(new ProductData(R.drawable.fwi11, "FILA", "Unisex Kids Sneakers", 839));
        footWearProductList.add(new ProductData(R.drawable.fwi12, "ADIDAS", "Boys Tensaur Running Shoes", 1949));
        footWearProductList.add(new ProductData(R.drawable.fwi13, "Provogue", "Men Solid Thong Flip-Flops", 782));
        footWearProductList.add(new ProductData(R.drawable.fwi14, "Metronaut", "Men Solid Thong Flip-Flops", 598));
        footWearProductList.add(new ProductData(R.drawable.fwi15, "HIGHLANDER", "Men Solid Sneakers", 696));
        footWearProductList.add(new ProductData(R.drawable.fwi16, "Reebok", "Women Running Shoes", 1799));
        footWearProductList.add(new ProductData(R.drawable.fwi17, "ALDO", "Women Pumps", 7999));
        footWearProductList.add(new ProductData(R.drawable.fwi18, "ADIDAS", "Ultraboost 20 Running Shoes", 17999));
        footWearProductList.add(new ProductData(R.drawable.fwi19, "Nike", "FLEX RUNNER FABLE (GS)", 2596));
        footWearProductList.add(new ProductData(R.drawable.fwi20, "Clarks", "Women Leather Pumps", 3599));
    }

    private void setRecyclerView() {
        ProductAdapter footWearAdapter = new ProductAdapter(footWearProductList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(footWearAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.footWearRecyclerView);
        mTvSortA = findViewById(R.id.downArrow);
        mTvSortD = findViewById(R.id.upArrow);
        wishlist = findViewById(R.id.ivWishlist);
        cart = findViewById(R.id.ivCart);
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FootWearActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FootWearActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        mTvSortA.setOnClickListener(new View.OnClickListener() {
            @androidx.annotation.RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                footWearProductList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });
        mTvSortD.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                footWearProductList.sort(Comparator.comparing(ProductData::getProductCost).reversed());
                setRecyclerView();
            }
        });
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
