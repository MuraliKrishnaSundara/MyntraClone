package com.example.myntra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ShoppingBag extends AppCompatActivity {
    private ImageView productImage;
    private TextView productCompanyName;
    private TextView productName;
    private TextView productPrice;
    private TextView productSize;
    private Button btnRemove;
    private Button btnMove;
    private LinearLayout linearLayout;
    private ConstraintLayout constraintLayout;
    private TextView itemCount;
    private TextView orderTotal;
    private Button placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_bag);
        initViews();
        int added = PreferenceHelper.getIntFromPreference(ShoppingBag.this, "added");
        String name = PreferenceHelper.getStringFromPreference(ShoppingBag.this, "productName");
        int price = PreferenceHelper.getIntFromPreference(ShoppingBag.this, "productPrice");

        if (added != 1) {
            itemCount.setText("NO ITEMS ADDED TO CART");
            orderTotal.setText("0");
            constraintLayout.setVisibility(View.GONE);
        } else {
            constraintLayout.setVisibility(View.VISIBLE);
            itemCount.setText("1 ITEM");
            productName.setText(name);
            productCompanyName.setText(PreferenceHelper.getStringFromPreference(ShoppingBag.this, "productCompany"));
            productSize.setText(PreferenceHelper.getStringFromPreference(ShoppingBag.this, "size"));
            productPrice.setText(price + "");
            orderTotal.setText(price + "");
            productImage.setImageResource(PreferenceHelper.getIntFromPreference(ShoppingBag.this, "productImage"));
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.GONE) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PreferenceHelper.getStringFromPreference(ShoppingBag.this, "userName").equals("")) {
                    Toast.makeText(ShoppingBag.this, "Login First", Toast.LENGTH_LONG).show();
                } else if (added != 1) {
                    Toast.makeText(ShoppingBag.this, "Add orders to Cart first", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ShoppingBag.this, "order done", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.setVisibility(View.GONE);
                itemCount.setText("NO ITEMS ADDED TO CART");
                orderTotal.setText("0");
                PreferenceHelper.writeIntToPreference(ShoppingBag.this, "added", 0);
            }
        });
    }

    private void initViews() {
        productImage = findViewById(R.id.productImage);
        productCompanyName = findViewById(R.id.productCompanyName);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        productSize = findViewById(R.id.productSize);
        btnRemove = findViewById(R.id.btnRemove);
        btnMove = findViewById(R.id.btnMove);
        linearLayout = findViewById(R.id.btnShowHide);
        constraintLayout = findViewById(R.id.v5);
        itemCount = findViewById(R.id.tvItemCount);
        orderTotal = findViewById(R.id.orderTotal);
        placeOrder = findViewById(R.id.placeOrder);
    }
}