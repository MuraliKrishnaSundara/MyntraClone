package com.example.myntra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailedView extends AppCompatActivity {
    private ImageView productImage;
    private TextView productCompanyName;
    private TextView productName;
    private TextView productPrice;
    private RadioGroup size;
    private Button btnWishList;
    private Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailed_view);
        initViews();
        setData();
        btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailedView.this, "Added to WishList", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setData() {
        productImage.setImageResource((getIntent().getIntExtra("image", R.drawable.image_1)));
        productCompanyName.setText(getIntent().getStringExtra("productCompany"));
        productName.setText(getIntent().getStringExtra("productName"));
        productPrice.setText((getIntent().getIntExtra("productPrice", 0)) + "");
    }

    private void initViews() {
        productImage = findViewById(R.id.productImage);
        productCompanyName = findViewById(R.id.productCompanyName);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        size = findViewById(R.id.size);
        btnWishList = findViewById(R.id.wishListButton);
        btnAddToCart = findViewById(R.id.addToCartButton);
    }
}