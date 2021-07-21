package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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
    private ArrayList<Data> womenList = new ArrayList<>();
    private ArrayList<Data> menList = new ArrayList<>();
    private ArrayList<Data> kidList = new ArrayList<>();
    private ArrayList<Data> gadgetsList = new ArrayList<>();
    private RecyclerView rWomen;
    private RecyclerView rMen;
    private RecyclerView rKid;
    private RecyclerView rGadgets;


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
        womenList.add(new Data("Westernwear"));
        womenList.add(new Data("Ethnic & Fusionwear"));
        womenList.add(new Data("Footwear"));
        womenList.add(new Data("Lingerie"));
        womenList.add(new Data("Bags, Wallets & Clutches"));
        womenList.add(new Data("Jewellery"));
        womenList.add(new Data("Other Accessories"));
        womenList.add(new Data("Beauty & Personal Care"));
        womenList.add(new Data("Sports & Activewear"));
        womenList.add(new Data("Luggage & Trolleys"));
        womenList.add(new Data("Watches"));
        womenList.add(new Data("Myntra StyleCast"));
        womenList.add(new Data("Winterwear Store"));
        womenList.add(new Data("Gift Card"));

        menList.add(new Data("Top wear"));
        menList.add(new Data("Ethnic & Fusionwear"));
        menList.add(new Data("Footwear"));
        menList.add(new Data("Innerwear"));
        menList.add(new Data("Bags, Wallets & Clutches"));
        menList.add(new Data("Sports and Activewwear"));
        menList.add(new Data("Other Accessories"));
        menList.add(new Data("Personal Care"));
        menList.add(new Data("Sports & Activewear"));
        menList.add(new Data("Luggage & Trolleys"));
        menList.add(new Data("Watches"));
        menList.add(new Data("Myntra StyleCast"));
        menList.add(new Data("Winterwear Store"));
        menList.add(new Data("Gift Card"));

        kidList.add(new Data("Explore kid store"));
        kidList.add(new Data("Girls clothing"));
        kidList.add(new Data("Footwear"));
        kidList.add(new Data("Girls Footwear"));
        kidList.add(new Data("Toys"));
        kidList.add(new Data("Boys Clothing"));
        kidList.add(new Data("Bags & Accessories"));
        kidList.add(new Data("Masks"));

        gadgetsList.add(new Data("Smart Wearables"));
        gadgetsList.add(new Data("Audio & Hearables"));
        gadgetsList.add(new Data("Mobile Accessories"));


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
    }

    @Override
    public void ItemClicked(Data data, int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}