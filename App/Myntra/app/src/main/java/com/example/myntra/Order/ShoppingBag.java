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
import com.example.myntra.R;

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
    private ImageView wishList;
    private ImageView addQuantity;
    private TextView quantity;
    private ImageView removeQuantity;
    private static int quantityNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_bag);
        initViews();
        int added = PreferenceHelper.getIntFromPreference(ShoppingBag.this, "added");
        int price = PreferenceHelper.getIntFromPreference(ShoppingBag.this, "productPrice");
    // If order is present then the layout visibility is visible.
        if (added != 1) {
            itemCount.setText("NO ITEMS ADDED TO CART");
            orderTotal.setText("0");
            constraintLayout.setVisibility(View.GONE);
        } else {
            quantityNum = 1;
            constraintLayout.setVisibility(View.VISIBLE);
            itemCount.setText("1 ITEM");
            productName.setText(PreferenceHelper.getStringFromPreference(ShoppingBag.this, "productName"));
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
            // Adding data to Preference helper for the payment
            @Override
            public void onClick(View v) {
                if (PreferenceHelper.getStringFromPreference(ShoppingBag.this, "userName").equals("")) {
                    Toast.makeText(ShoppingBag.this, "Login First", Toast.LENGTH_LONG).show();
                } else if (added != 1) {
                    Toast.makeText(ShoppingBag.this, "Add orders to Cart first", Toast.LENGTH_SHORT).show();
                } else {
                    PreferenceHelper.writeIntToPreference(ShoppingBag.this, "orderDone", 1);
                    PreferenceHelper.writeIntToPreference(ShoppingBag.this, "added", 0);
                    PreferenceHelper.writeIntToPreference(ShoppingBag.this, "quantity", quantityNum);
                    PreferenceHelper.writeIntToPreference(ShoppingBag.this, "total", price * quantityNum);
                    if (PreferenceHelper.getIntFromPreference(ShoppingBag.this, "orderDone") == 1) {
                        constraintLayout.setVisibility(View.GONE);
                        itemCount.setText("NO ITEMS ADDED TO CART");
                        orderTotal.setText("0");
                    }
                    Intent intent = new Intent(ShoppingBag.this, AddressActivity.class);
                    startActivity(intent);
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
                quantityNum = 0;
            }
        });
        btnMove.setOnClickListener(new View.OnClickListener() {
            //Adding data to WishList through different preference helper key
            @Override
            public void onClick(View v) {
                constraintLayout.setVisibility(View.GONE);
                itemCount.setText("NO ITEMS IN CART");
                orderTotal.setText("0");
                PreferenceHelper.writeIntToPreference(ShoppingBag.this, "added", 0);
                PreferenceHelper.writeIntToPreference(ShoppingBag.this, "wish", 1);
                PreferenceHelper.writeStringToPreference(ShoppingBag.this, "wproductName", productName.getText().toString());
                PreferenceHelper.writeStringToPreference(ShoppingBag.this, "wproductCompany", productCompanyName.getText().toString());
                PreferenceHelper.writeStringToPreference(ShoppingBag.this, "wsize", "S");
                PreferenceHelper.writeIntToPreference(ShoppingBag.this, "wproductPrice", Integer.parseInt(productPrice.getText().toString()));
                PreferenceHelper.writeIntToPreference(ShoppingBag.this, "wproductImage", PreferenceHelper.getIntFromPreference(ShoppingBag.this, "productImage"));
            }
        });
        wishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingBag.this, WishlistActivity.class);
                startActivity(intent);
            }
        });

        // Adding quantity to the order item.
        addQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityNum > 9) {
                    Toast.makeText(ShoppingBag.this, "Maximum item", Toast.LENGTH_SHORT).show();
                } else {
                    quantityNum++;
                    quantity.setText(quantityNum + "");
                    orderTotal.setText(price * quantityNum + "");
                }
            }
        });
        removeQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityNum > 1) {
                    quantityNum--;
                    quantity.setText(quantityNum + "");
                    orderTotal.setText(price * quantityNum + "");
                } else {
                    Toast.makeText(ShoppingBag.this, "Minimum reached", Toast.LENGTH_SHORT).show();
                }
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
        orderTotal = findViewById(R.id.orderTotal);
        itemCount = findViewById(R.id.tvItemCount);
        placeOrder = findViewById(R.id.placeOrder);
        wishList = findViewById(R.id.like);
        addQuantity = findViewById(R.id.addQuantity);
        quantity = findViewById(R.id.quantity);
        removeQuantity = findViewById(R.id.removeQuantity);
    }
}