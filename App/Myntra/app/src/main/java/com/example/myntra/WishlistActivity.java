package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class WishlistActivity extends AppCompatActivity {
    private ImageView productImage;
    private TextView productCompanyName;
    private TextView productName;
    private TextView productPrice;
    private TextView productSize;
    private TextView btnRemove;
    private TextView btnMove;
    private LinearLayout linearLayout;
    private ConstraintLayout constraintLayout;
    private Button goToCart;
    private Button goToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        initViews();
        goToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WishlistActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WishlistActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.setVisibility(View.GONE);
                PreferenceHelper.writeIntToPreference(WishlistActivity.this, "wish", 0);
            }
        });
        if (PreferenceHelper.getIntFromPreference(WishlistActivity.this, "wish") != 1) {
            constraintLayout.setVisibility(View.GONE);
        } else {
            constraintLayout.setVisibility(View.VISIBLE);
            productName.setText(PreferenceHelper.getStringFromPreference(WishlistActivity.this, "wproductName"));
            productCompanyName.setText(PreferenceHelper.getStringFromPreference(WishlistActivity.this, "wproductCompany"));
            productSize.setText(PreferenceHelper.getStringFromPreference(WishlistActivity.this, "wsize"));
            productPrice.setText(PreferenceHelper.getIntFromPreference(WishlistActivity.this, "wproductPrice") + "");
            productImage.setImageResource(PreferenceHelper.getIntFromPreference(WishlistActivity.this, "wproductImage"));
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.GONE) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else
                    linearLayout.setVisibility(View.GONE);
            }
        });
    }

    private void initViews() {
        productImage = findViewById(R.id.wProductImage);
        productCompanyName = findViewById(R.id.wProductCompanyName);
        productName = findViewById(R.id.wProductName);
        productPrice = findViewById(R.id.wProductPrice);
        productSize = findViewById(R.id.wProductSize);
        btnRemove = findViewById(R.id.btnRemove);
        btnMove = findViewById(R.id.btnMove);
        linearLayout = findViewById(R.id.btnShowHide);
        constraintLayout = findViewById(R.id.wishCart);
        goToCart = findViewById(R.id.btnWCart);
        goToHome = findViewById(R.id.btnWShop);
    }
}