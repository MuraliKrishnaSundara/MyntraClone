package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudioActivity extends AppCompatActivity {
    private ImageView home;
    private ImageView categories;
    private ImageView studio;
    private ImageView explore;
    private ImageView profile;
    private TextView tvStudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio);
        initViews();
        studio.setColorFilter(getResources().getColor(R.color.red));
        tvStudio.setTextColor(getResources().getColor(R.color.red));
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudioActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudioActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudioActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudioActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        home = findViewById(R.id.home);
        categories = findViewById(R.id.category);
        studio = findViewById(R.id.studio);
        explore = findViewById(R.id.explore);
        profile = findViewById(R.id.profile);
        tvStudio = findViewById(R.id.tvCStudio);
    }
}