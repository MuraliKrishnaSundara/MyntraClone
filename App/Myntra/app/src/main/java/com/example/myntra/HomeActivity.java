package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ImageView home;
    private ImageView categories;
    private ImageView studio;
    private ImageView explore;
    private ImageView profile;
    private TextView tvHome;
    private ImageView ivHs1Men;
    private ImageView ivHs1Women;
    private ImageView ivHs1Gadget;
    private ImageView ivHs1Kid;

    String url1 = "https://www.linkpicture.com/q/megaendofseason.jpeg";
    String url2 = "https://www.linkpicture.com/q/glowupsale.jpeg";
    String url3 = "https://www.linkpicture.com/q/lakme.jpeg";
    String url4 = "https://www.linkpicture.com/q/odelaunchoffer.jpeg";
    String url5 = "https://www.linkpicture.com/q/mastandharbour.jpeg";
    String url6 = "https://www.linkpicture.com/q/lotus.jpeg";
    String url7 = "https://www.linkpicture.com/q/innerwear.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        home.setColorFilter(getResources().getColor(R.color.red));
        tvHome.setTextColor(getResources().getColor(R.color.red));
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StudioActivity.class);
                startActivity(intent);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        ivHs1Men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MenActivity.class);
                startActivity(intent);
            }
        });
        ivHs1Women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WomenActivity.class);
                startActivity(intent);
            }
        });
        ivHs1Gadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GadgetsActivity.class);
                startActivity(intent);
            }
        });
        ivHs1Kid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, KidsActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<AutoScroll1Model> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = findViewById(R.id.slider);
        sliderDataArrayList.add(new AutoScroll1Model(url1));
        sliderDataArrayList.add(new AutoScroll1Model(url2));
        sliderDataArrayList.add(new AutoScroll1Model(url3));
        sliderDataArrayList.add(new AutoScroll1Model(url4));
        sliderDataArrayList.add(new AutoScroll1Model(url5));
        sliderDataArrayList.add(new AutoScroll1Model(url6));
        sliderDataArrayList.add(new AutoScroll1Model(url7));
        AutoScroll1Adapter adapter = new AutoScroll1Adapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_RTL);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }


    private void initViews() {
        home = findViewById(R.id.home);
        categories = findViewById(R.id.category);
        studio = findViewById(R.id.studio);
        explore = findViewById(R.id.explore);
        profile = findViewById(R.id.profile);
        tvHome = findViewById(R.id.tvCHome);
        ivHs1Men = findViewById(R.id.hs1Men);
        ivHs1Women = findViewById(R.id.hs1Women);
        ivHs1Gadget = findViewById(R.id.hs1Gadgets);
        ivHs1Kid = findViewById(R.id.hs1Kids);
    }
}