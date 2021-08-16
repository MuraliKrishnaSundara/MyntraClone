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

import com.example.myntra.Product.OnProductClick;
import com.example.myntra.Product.ProductAdapter;
import com.example.myntra.Product.ProductData;
import com.example.myntra.Product.ProductDetailedView;
import com.example.myntra.R;
import com.example.myntra.Order.ShoppingBag;
import com.example.myntra.Order.WishlistActivity;

import java.util.ArrayList;
import java.util.Comparator;

public class KidsActivity extends AppCompatActivity implements OnProductClick {

    private RecyclerView recyclerView;
    private ArrayList<ProductData> kidsDataList;
    private ImageView mTvSortA;
    private ImageView mTvSortD;
    private ImageView wishlist;
    private ImageView cart;

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
        kidsDataList.add(new ProductData(R.drawable.kwi1, "pspeaches", "Ready to Wear Lehenga Blous", 1827));
        kidsDataList.add(new ProductData(R.drawable.kwi2, "JBN Creation", "Boys Kurta with Pyjamas", 1199));
        kidsDataList.add(new ProductData(R.drawable.kwi3, "Tiber Taber", "Boys Printed Panchakattu", 1950));
        kidsDataList.add(new ProductData(R.drawable.kwi4, "Bitiya by Bhama", "Ready to Wear Lehenga & Blous", 987));
        kidsDataList.add(new ProductData(R.drawable.kwi5, "LilPicks", "Girls Printed Playsuit", 899));
        kidsDataList.add(new ProductData(R.drawable.kwi6, "pspeaches", "Girls Cotton Kurti & Dhoti", 1159));
        kidsDataList.add(new ProductData(R.drawable.kwi7, "pspeaches", "Ready to Wear Lehenga Blous", 1712));
        kidsDataList.add(new ProductData(R.drawable.kwi8, "Bitiya by Bhama", "Girls Printed Kurta with Palazzos", 987));
        kidsDataList.add(new ProductData(R.drawable.kwi9, "LilPicks", "Girls Printed Top with Palazzos", 899));
        kidsDataList.add(new ProductData(R.drawable.kwi10, "Stylo Bug", "Girls Colourblocked Culotte", 768));
        kidsDataList.add(new ProductData(R.drawable.kwi11, "Maniac", "Boys Printed Hood T-shirt", 387));
        kidsDataList.add(new ProductData(R.drawable.kwi12, "Stylo Bug", "Girls Printed A-Line Dress", 815));
        kidsDataList.add(new ProductData(R.drawable.kwi13, "CUTECUMBER", "Girls Printed Sheath Dress", 990));
        kidsDataList.add(new ProductData(R.drawable.kwi14, "Bitiya by Bhama", "Girls Printed Basic Jumpsuit", 799));
        kidsDataList.add(new ProductData(R.drawable.kwi15, "pspeaches", "Girls Geometric Printed Kurta", 1484));
        kidsDataList.add(new ProductData(R.drawable.kwi16, "Bitiya by Bhama", "Girls Printed Fit and Flare Dress", 909));
        kidsDataList.add(new ProductData(R.drawable.kwi17, "Cutiekins", "Girls Printed Top with Palazzos", 951));
        kidsDataList.add(new ProductData(R.drawable.kwi18, "Bitiya by Bhama", "Girls Kurta Set & Dupatta", 989));
        kidsDataList.add(new ProductData(R.drawable.kwi19, "naughty ninos", "Girls Striped Top with Palazzos", 900));
        kidsDataList.add(new ProductData(R.drawable.kwi20, "Bitiya by Bhama", "Girls Printed Kurta with Palazzos", 989));
    }

    private void setRecyclerView() {
        ProductAdapter kidsAdapter = new ProductAdapter(kidsDataList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(kidsAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.kidsRecyclerView);
        mTvSortA = findViewById(R.id.downArrow);
        mTvSortD = findViewById(R.id.upArrow);
        wishlist = findViewById(R.id.ivWishlist);
        cart = findViewById(R.id.ivCart);

        //Sorting
        mTvSortA.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                kidsDataList.sort(Comparator.comparing(ProductData::getProductCost));
                setRecyclerView();
            }
        });

        //Reverse sorting
        mTvSortD.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                kidsDataList.sort(Comparator.comparing(ProductData::getProductCost).reversed());
                setRecyclerView();
            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KidsActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KidsActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
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