package com.example.myntra.Order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myntra.PreferenceHelper;
import com.example.myntra.NavBarAvtivity.Home.HomeActivity;
import com.example.myntra.R;

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
        //If some data in PreferenceHelper is not present then the item visiblity is gone..
        if (PreferenceHelper.getIntFromPreference(WishlistActivity.this, "wish") != 1) {
            constraintLayout.setVisibility(View.GONE);
        } else {
            //data present so visibility is visible and items data is set from PreferenceHelper.
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
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Btn move is used to move data to Preference Helper with setting visiblity gone to the layout
                // of product item and setting data to new key of preference helper for the order.
                constraintLayout.setVisibility(View.GONE);
                Toast.makeText(WishlistActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                PreferenceHelper.writeStringToPreference(WishlistActivity.this, "productName", productName.getText().toString());
                PreferenceHelper.writeStringToPreference(WishlistActivity.this, "productCompany", productCompanyName.getText().toString());
                PreferenceHelper.writeStringToPreference(WishlistActivity.this, "size", "S");
                PreferenceHelper.writeIntToPreference(WishlistActivity.this, "productPrice", Integer.parseInt(productPrice.getText().toString()));
                PreferenceHelper.writeIntToPreference(WishlistActivity.this, "productImage", PreferenceHelper.getIntFromPreference(WishlistActivity.this, "wproductImage"));
                PreferenceHelper.writeIntToPreference(WishlistActivity.this, "added", 1);
                PreferenceHelper.writeIntToPreference(WishlistActivity.this, "wish", 0);
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