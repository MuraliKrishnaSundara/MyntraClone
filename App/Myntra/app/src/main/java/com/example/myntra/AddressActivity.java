package com.example.myntra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {

    private Button placeOrder;
    private EditText pincode;
    private EditText phone;
    private ConstraintLayout constraintLayout;
    private TextView itemCount;
    private TextView orderTotal;
    private ImageView wishList;
    private ImageView addQuantity;
    private TextView quantity;
    private ImageView removeQuantity;
    private static int quantityNum;
    private int added;
    private Button orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initViews();
        added = PreferenceHelper.getIntFromPreference(AddressActivity.this, "added");
        int price = PreferenceHelper.getIntFromPreference(AddressActivity.this, "productPrice");

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validPincode() && validPhoneNumber()) {
                    Toast.makeText(AddressActivity.this, "Order placed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddressActivity.this, OrderActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        placeOrder = findViewById(R.id.btnPlaceOrder);
        pincode = findViewById(R.id.tvPincode);
        phone = findViewById(R.id.tvMobile);
    }

    private boolean validPincode() {
        if (pincode.getText().toString().length() != 6) {
            pincode.setError("Enter Valid Pincode");
            return false;
        }
        return true;
    }

    private boolean validPhoneNumber() {
        if (phone.getText().toString().length() != 10) {
            phone.setError("Not valid Phone Number");
            return false;
        }
        return true;
    }

}