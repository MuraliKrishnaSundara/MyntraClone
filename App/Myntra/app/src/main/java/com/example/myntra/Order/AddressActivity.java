package com.example.myntra.Order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.PreferenceHelper;
import com.example.myntra.R;

public class AddressActivity extends AppCompatActivity {

    private Button placeOrder;
    private EditText pinCode;
    private EditText phone;
    private int added;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initViews();
        added = PreferenceHelper.getIntFromPreference(AddressActivity.this, "added");
        int price = PreferenceHelper.getIntFromPreference(AddressActivity.this, "productPrice");

    }

    private void initViews() {
        placeOrder = findViewById(R.id.btnPlaceOrder);
        pinCode = findViewById(R.id.tvPincode);
        phone = findViewById(R.id.tvMobile);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validPinCode() && validPhoneNumber()) {
                    Toast.makeText(AddressActivity.this, "Order placed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddressActivity.this, OrderActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validPinCode() {
        if (pinCode.getText().toString().length() != 6) {
            pinCode.setError(getString(R.string.enterValidPinCode));
            return false;
        }
        return true;
    }

    private boolean validPhoneNumber() {
        if (phone.getText().toString().length() != 10) {
            phone.setError(getString(R.string.notValidPhoneNumber));
            return false;
        }
        return true;
    }

}