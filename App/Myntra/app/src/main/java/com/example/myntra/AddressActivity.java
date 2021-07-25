package com.example.myntra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {

    private Button placeOrder;
    private EditText pincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initViews();
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validPincode()) {
                    Toast.makeText(AddressActivity.this, "Order placed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        placeOrder = findViewById(R.id.btnPlaceOrder);
        pincode = findViewById(R.id.tvPincode);
    }

    private boolean validPincode() {
        if (pincode.getText().toString().length() != 6) {
            pincode.setError("Enter Valid Pincode");
            return false;
        }
        return true;
    }

}