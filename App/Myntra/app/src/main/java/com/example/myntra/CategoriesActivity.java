package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements ItemClickListener {
    private ImageView home;
    private ImageView categories;
    private ImageView studio;
    private ImageView explore;
    private ImageView profile;
    private TextView tvCategories;
    private ImageView downArrow;
    private ImageView women;
    private ImageView men;
    private ImageView kid;
    private ImageView gadgets;
    private ArrayList<CategoryDataModel> womenList = new ArrayList<>();
    private ArrayList<CategoryDataModel> menList = new ArrayList<>();
    private ArrayList<CategoryDataModel> kidList = new ArrayList<>();
    private ArrayList<CategoryDataModel> gadgetsList = new ArrayList<>();
    private RecyclerView rWomen;
    private RecyclerView rMen;
    private RecyclerView rKid;
    private RecyclerView rGadgets;
    private ConstraintLayout showGadgets;
    private LinearLayout llgadgets;
    private TextView tvgadgestsLL;
    private ImageView cart;
    private ImageView Favourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogeries);
        initViews();
        buildData();
        setRecyclerView();
        categories.setColorFilter(getResources().getColor(R.color.red));
        tvCategories.setTextColor(getResources().getColor(R.color.red));
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, StudioActivity.class);
                startActivity(intent);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        Favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rWomen.getVisibility() == View.GONE) {
                    rWomen.setVisibility(View.VISIBLE);
                } else {
                    rWomen.setVisibility(View.GONE);
                }
            }
        });
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rMen.getVisibility() == View.GONE) {
                    rMen.setVisibility(View.VISIBLE);
                } else {
                    rMen.setVisibility(View.GONE);
                }
            }
        });
        kid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rKid.getVisibility() == View.GONE) {
                    rKid.setVisibility(View.VISIBLE);

                } else {
                    rKid.setVisibility(View.GONE);
                }
            }
        });
        gadgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rGadgets.getVisibility() == View.GONE) {
                    rGadgets.setVisibility(View.VISIBLE);
                    //downArrow.setColorFilter(getResources().getColor(R.color.red));
                    rGadgets.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (llgadgets.getVisibility() == View.GONE) {
                                llgadgets.setVisibility(View.VISIBLE);
                                //downArrow.setColorFilter(getResources().getColor(R.color.red));

                            } else {
                                llgadgets.setVisibility(View.GONE);
                            }
                        }
                    });

                } else {
                    rGadgets.setVisibility(View.GONE);
                }
            }
        });


    }

    private void setRecyclerView() {
        CategoryAdapter categoryAdapterWomen = new CategoryAdapter(womenList, this);
        CategoryAdapter categoryAdapterMen = new CategoryAdapter(menList, this);
        CategoryAdapter categoryAdapterKid = new CategoryAdapter(kidList, this);
        CategoryAdapter categoryAdapterGadgets = new CategoryAdapter(gadgetsList, this);

        LinearLayoutManager linearLayoutManagerWomen = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManagerMen = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManagerKid = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManagerGadgets = new LinearLayoutManager(this);

        rWomen.setAdapter(categoryAdapterWomen);
        rMen.setAdapter(categoryAdapterMen);
        rKid.setAdapter(categoryAdapterKid);
        rGadgets.setAdapter(categoryAdapterGadgets);

        rWomen.setLayoutManager(linearLayoutManagerWomen);
        rMen.setLayoutManager(linearLayoutManagerMen);
        rKid.setLayoutManager(linearLayoutManagerKid);
        rGadgets.setLayoutManager(linearLayoutManagerGadgets);

    }

    private void buildData() {
        womenList.add(new CategoryDataModel("Westernwear"));
        womenList.add(new CategoryDataModel("Ethnic & Fusionwear"));
        womenList.add(new CategoryDataModel("Footwear"));
        womenList.add(new CategoryDataModel("Lingerie"));
        womenList.add(new CategoryDataModel("Bags, Wallets & Clutches"));
        womenList.add(new CategoryDataModel("Jewellery"));
        womenList.add(new CategoryDataModel("Other Accessories"));
        womenList.add(new CategoryDataModel("Beauty & Personal Care"));
        womenList.add(new CategoryDataModel("Sports & Activewear"));
        womenList.add(new CategoryDataModel("Luggage & Trolleys"));
        womenList.add(new CategoryDataModel("Watches"));
        womenList.add(new CategoryDataModel("Myntra StyleCast"));
        womenList.add(new CategoryDataModel("Winterwear Store"));
        womenList.add(new CategoryDataModel("Gift Card"));

        menList.add(new CategoryDataModel("Top wear"));
        menList.add(new CategoryDataModel("Ethnic & Fusionwear"));
        menList.add(new CategoryDataModel("Footwear"));
        menList.add(new CategoryDataModel("Innerwear"));
        menList.add(new CategoryDataModel("Bags, Wallets & Clutches"));
        menList.add(new CategoryDataModel("Sports and Activewwear"));
        menList.add(new CategoryDataModel("Other Accessories"));
        menList.add(new CategoryDataModel("Personal Care"));
        menList.add(new CategoryDataModel("Sports & Activewear"));
        menList.add(new CategoryDataModel("Luggage & Trolleys"));
        menList.add(new CategoryDataModel("Watches"));
        menList.add(new CategoryDataModel("Myntra StyleCast"));
        menList.add(new CategoryDataModel("Winterwear Store"));
        menList.add(new CategoryDataModel("Gift Card"));

        kidList.add(new CategoryDataModel("Explore kid store"));
        kidList.add(new CategoryDataModel("Girls clothing"));
        kidList.add(new CategoryDataModel("Footwear"));
        kidList.add(new CategoryDataModel("Girls Footwear"));
        kidList.add(new CategoryDataModel("Toys"));
        kidList.add(new CategoryDataModel("Boys Clothing"));
        kidList.add(new CategoryDataModel("Bags & Accessories"));
        kidList.add(new CategoryDataModel("Masks"));

        gadgetsList.add(new CategoryDataModel("Smart Wearables"));
        gadgetsList.add(new CategoryDataModel("Audio & Hearables"));
        gadgetsList.add(new CategoryDataModel("Mobile Accessories"));
    }

    private void initViews() {
        home = findViewById(R.id.home);
        categories = findViewById(R.id.category);
        studio = findViewById(R.id.studio);
        explore = findViewById(R.id.explore);
        profile = findViewById(R.id.profile);
        tvCategories = findViewById(R.id.tvCCategories);
        women = findViewById(R.id.c_women);
        men = findViewById(R.id.c_men);
        kid = findViewById(R.id.c_kid);
        gadgets = findViewById(R.id.c_gadgets);
        rWomen = findViewById(R.id.recyclerViewWomen);
        rMen = findViewById(R.id.recyclerViewMen);
        rKid = findViewById(R.id.recyclerViewKid);
        rGadgets = findViewById(R.id.recyclerViewGadgets);
        downArrow = findViewById(R.id.ivCdown);
        llgadgets = findViewById(R.id.llGadgets);
        tvgadgestsLL = findViewById(R.id.tvGadgetsLL);
        showGadgets = findViewById(R.id.showGadgets);
        cart = findViewById(R.id.cart);
        Favourite = findViewById(R.id.favourite);
    }

    @Override
    public void ItemClicked(CategoryDataModel categoryDataModel, int position) {
        Toast.makeText(this, "Item clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}