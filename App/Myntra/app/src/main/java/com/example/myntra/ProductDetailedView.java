package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailedView extends AppCompatActivity {
    private ImageView productImage;
    private ImageView detailedProductCart;
    private ImageView detailedProductWishList;
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
                String userNameData = PreferenceHelper.getStringFromPreference(ProductDetailedView.this, "userName");
                if (userNameData.equals("")) {
                    Toast.makeText(ProductDetailedView.this, "Please Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProductDetailedView.this, Login_Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ProductDetailedView.this, "Added to WishList", Toast.LENGTH_SHORT).show();
                    PreferenceHelper.writeStringToPreference(ProductDetailedView.this, "wproductName", productName.getText().toString());
                    PreferenceHelper.writeStringToPreference(ProductDetailedView.this, "wproductCompany", productCompanyName.getText().toString());
                    PreferenceHelper.writeStringToPreference(ProductDetailedView.this, "wsize", "S");
                    PreferenceHelper.writeIntToPreference(ProductDetailedView.this, "wproductPrice", Integer.parseInt(productPrice.getText().toString()));
                    PreferenceHelper.writeIntToPreference(ProductDetailedView.this, "wproductImage", getIntent().getIntExtra("image", R.drawable.image_1));
                }
            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameData = PreferenceHelper.getStringFromPreference(ProductDetailedView.this, "userName");
                if (userNameData.equals("")) {
                    Toast.makeText(ProductDetailedView.this, "Please Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProductDetailedView.this, Login_Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ProductDetailedView.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                    PreferenceHelper.writeStringToPreference(ProductDetailedView.this, "productName", productName.getText().toString());
                    PreferenceHelper.writeStringToPreference(ProductDetailedView.this, "productCompany", productCompanyName.getText().toString());
                    PreferenceHelper.writeStringToPreference(ProductDetailedView.this, "size", "S");
                    PreferenceHelper.writeIntToPreference(ProductDetailedView.this, "productPrice", Integer.parseInt(productPrice.getText().toString()));
                    PreferenceHelper.writeIntToPreference(ProductDetailedView.this, "productImage", getIntent().getIntExtra("image", R.drawable.image_1));
                    PreferenceHelper.writeIntToPreference(ProductDetailedView.this, "added", 1);

                }
            }
        });
        detailedProductCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailedView.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        detailedProductWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailedView.this, WishlistActivity.class);
                startActivity(intent);
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
        detailedProductCart = findViewById(R.id.productToCart);
        detailedProductWishList = findViewById(R.id.wishList);
    }
}