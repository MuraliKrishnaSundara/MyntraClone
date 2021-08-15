package com.example.myntra.NavBarAvtivity.Studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.NavBarAvtivity.Catogries.CategoriesActivity;
import com.example.myntra.NavBarAvtivity.ExploreActivity;
import com.example.myntra.NavBarAvtivity.Home.HomeActivity;
import com.example.myntra.NavBarAvtivity.ProfileActivity;
import com.example.myntra.R;

import java.util.ArrayList;

public class StudioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<StudioData> studioDataList;
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
        buildIdentityList();
        setRecyclerView();
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

    private void buildIdentityList() {
        studioDataList = new ArrayList<>();
        StudioData studioData1 = new StudioData(R.drawable.p_image_1, "Rahul Karel", "23 hours ago", R.drawable.image_1, "25", "Wear your #stripes with pride with this #blackandwhite\n#stripedkurta from #Hypernation. With my\n#ethniccollection constantly growing I am sometimes\nspoiled for choice but this #kurta is definitely one of my\nfavourites\n#festiveprintsformen #menkurtaset #mentrousers");
        studioDataList.add(studioData1);
        StudioData studioData2 = new StudioData(R.drawable.p_image_2, "Sarang Patil", "7 hours ago", R.drawable.image_2, "17", "Looking for a #Party Wear in #Solid Hues ? #MANQ\n#Maroon #Slim Fit #PartyShirt fits in perfectly! Style it up with a pair of #GreyChinos or #Black Trousers\n#partywear #oufit #menswear #fashion #partyoutfit\n#menshirt");
        studioDataList.add(studioData2);
        StudioData studioData3 = new StudioData(R.drawable.p_image_3, "Rhythm Sitlani", "7 hours ago", R.drawable.image_3, "68", "#Buckethat is very in right now. #FabSeasons has come\nout with a collection of bucket hats in a variety of different colours.\n#accesories #InTrend #solids #Typographic Tee\n#womentshirt");
        studioDataList.add(studioData3);
        StudioData studioData4 = new StudioData(R.drawable.p_image_4, "Irfan Khan Afridi", "8 hours ago", R.drawable.image_4, "25", "This #INVICTUS #White #SlimFit #Stretch #FormalShirt\nis a must-have for any wardrobe. Go for a pair of darker\n#denim and comfy #loafers to keep it looking casually\ncool at work. #menshirt");
        studioDataList.add(studioData4);
        StudioData studioData5 = new StudioData(R.drawable.p_image_5, "Udita Sarkar", "11 hours ago", R.drawable.image_5, "27", "A #solidcolored #croptop when paired with a pair of\n#Printedpants is always a fun look. This #Blue #Croptop\nfrom #CampusSutra is the perfect addition to my\nwardrobe and can be matched with anything\n#simpleisstylish #sportsbra #womentrousers");
        studioDataList.add(studioData5);
    }

    private void setRecyclerView() {
        StudioAdapter studioAdapter = new StudioAdapter(studioDataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studioAdapter);
    }

    private void initViews() {
        home = findViewById(R.id.home);
        categories = findViewById(R.id.category);
        studio = findViewById(R.id.studio);
        explore = findViewById(R.id.explore);
        profile = findViewById(R.id.profile);
        tvStudio = findViewById(R.id.tvCStudio);
        recyclerView = findViewById(R.id.recyclerView);
    }
}