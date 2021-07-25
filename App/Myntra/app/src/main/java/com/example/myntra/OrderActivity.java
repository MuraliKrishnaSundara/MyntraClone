package com.example.myntra;

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

public class OrderActivity extends AppCompatActivity {
    private ImageView productImage;
    private TextView productCompanyName;
    private TextView productName;
    private TextView productPrice;
    private TextView productSize;
    private Button btnTrack;
    private Button btnCancel;
    private LinearLayout linearLayout;
    private ConstraintLayout constraintLayout;
    private Button goToHome;
    private TextView total;
    private TextView quantity;
    boolean order = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initViews();
        int ordered = PreferenceHelper.getIntFromPreference(OrderActivity.this, "orderDone");
        if (ordered != 1 && order) {
            constraintLayout.setVisibility(View.GONE);
        } else {
            constraintLayout.setVisibility(View.VISIBLE);
            productName.setText(PreferenceHelper.getStringFromPreference(OrderActivity.this, "productName"));
            productCompanyName.setText(PreferenceHelper.getStringFromPreference(OrderActivity.this, "productCompany"));
            productSize.setText(PreferenceHelper.getStringFromPreference(OrderActivity.this, "size"));
            productPrice.setText(PreferenceHelper.getIntFromPreference(OrderActivity.this, "productPrice") + "");
            productImage.setImageResource(PreferenceHelper.getIntFromPreference(OrderActivity.this, "productImage"));
            total.setText(PreferenceHelper.getIntFromPreference(OrderActivity.this, "total") + "");
            quantity.setText(PreferenceHelper.getIntFromPreference(OrderActivity.this, "quantity") + "");
        }

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.GONE && order) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else linearLayout.setVisibility(View.GONE);
            }
        });
        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OrderActivity.this, "Feature not available yet", Toast.LENGTH_SHORT).show();
            }
        });
        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.setAlpha((float) 0.50);
                linearLayout.setVisibility(View.GONE);
                order = false;
            }
        });
    }

    private void initViews() {
        productImage = findViewById(R.id.oProductImage);
        productCompanyName = findViewById(R.id.oProductCompanyName);
        productName = findViewById(R.id.oProductName);
        productPrice = findViewById(R.id.oProductPrice);
        productSize = findViewById(R.id.oProductSize);
        btnTrack = findViewById(R.id.btnTrack);
        btnCancel = findViewById(R.id.btnRemove);
        linearLayout = findViewById(R.id.btnShowHide);
        constraintLayout = findViewById(R.id.wishCart);
        goToHome = findViewById(R.id.btnOrderMore);
        total = findViewById(R.id.oTotal);
        quantity = findViewById(R.id.oQuantity);
    }
}