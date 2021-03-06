package com.example.myntra.NavBarAvtivity.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.DataList.FootWearActivity;
import com.example.myntra.DataList.GadgetsActivity;
import com.example.myntra.DataList.KidsActivity;
import com.example.myntra.Login.Login_Activity;
import com.example.myntra.DataList.MenActivity;
import com.example.myntra.NavBarAvtivity.Catogries.CategoriesActivity;
import com.example.myntra.NavBarAvtivity.ExploreActivity;
import com.example.myntra.NavBarAvtivity.ProfileActivity;
import com.example.myntra.NavBarAvtivity.Studio.StudioActivity;
import com.example.myntra.Order.OrderActivity;
import com.example.myntra.PreferenceHelper;
import com.example.myntra.R;
import com.example.myntra.Order.ShoppingBag;
import com.example.myntra.Order.WishlistActivity;
import com.example.myntra.DataList.WomenActivity;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

/*
After MainActivity we land on homeActivity.
 */
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
    private ImageView ivHs1FootWear;
    private ImageView cart;
    private ImageView menuBar;
    private ImageView closeMenu;
    private ImageView menuArrow;
    private ImageView flipFlops;
    private ImageView wishList;
    private ImageView womenWest;
    private TextView loginSignUp;
    private View bgBlack;
    private View menuCategoriesBar;
    private View themeStoreBar;
    private View order;
    private LinearLayout menuScreen;

    // urls for the auto Scroll..
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
        someItemClicked();
        onHome();
        autoScrollData();
        isUserLogin();

    }

    private void someItemClicked() {
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        menuCategoriesBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        themeStoreBar.setOnClickListener(new View.OnClickListener() {
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
        bgBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameData = PreferenceHelper.getStringFromPreference(HomeActivity.this, "userName");
                if (userNameData.equals("")) {
                    Intent intent = new Intent(HomeActivity.this, Login_Activity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
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
        ivHs1FootWear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FootWearActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        menuBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScreen.setVisibility(View.VISIBLE);

            }
        });
        closeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScreen.setVisibility(View.GONE);
            }
        });
        wishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        flipFlops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FootWearActivity.class);
                startActivity(intent);
            }
        });
        womenWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WomenActivity.class);
                startActivity(intent);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }


    private void isUserLogin() {
        // If user will login on navigation bar the text changes..
        String userNameData = PreferenceHelper.getStringFromPreference(HomeActivity.this, "userName");
        if (userNameData.equals("")) {

        } else {
            menuArrow.setVisibility(View.GONE);
            loginSignUp.setText(userNameData);
            bgBlack.setBackgroundColor(getResources().getColor(R.color.red));
        }
    }

    private void onHome() {
        //When clicked on home the icon color is red.
        home.setColorFilter(getResources().getColor(R.color.red));
        tvHome.setTextColor(getResources().getColor(R.color.red));
    }

    private void autoScrollData() {
        //for autoScroll we have created an array of data and added the data form the link..
        ArrayList<AutoScroll1Model> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = findViewById(R.id.slider);
        sliderDataArrayList.add(new AutoScroll1Model(url1));
        sliderDataArrayList.add(new AutoScroll1Model(url2));
        sliderDataArrayList.add(new AutoScroll1Model(url3));
        sliderDataArrayList.add(new AutoScroll1Model(url4));
        sliderDataArrayList.add(new AutoScroll1Model(url5));
        sliderDataArrayList.add(new AutoScroll1Model(url6));
        sliderDataArrayList.add(new AutoScroll1Model(url7));
        //created recycler view for the autoScroll and adapter to set Data..
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
        womenWest = findViewById(R.id.WomenWest);
        tvHome = findViewById(R.id.tvCHome);
        order = findViewById(R.id.menuOrderBar);
        ivHs1Men = findViewById(R.id.hs1Men);
        ivHs1Women = findViewById(R.id.hs1Women);
        ivHs1Gadget = findViewById(R.id.hs1Gadgets);
        ivHs1Kid = findViewById(R.id.hs1Kids);
        ivHs1FootWear = findViewById(R.id.hs1FootWear);
        cart = findViewById(R.id.cart);
        wishList = findViewById(R.id.favourite);
        menuBar = findViewById(R.id.dehaze);
        closeMenu = findViewById(R.id.closeMenu);
        menuScreen = findViewById(R.id.menuScreen);
        menuCategoriesBar = findViewById(R.id.menuCategoriesBar);
        themeStoreBar = findViewById(R.id.themeStoreBar);
        bgBlack = findViewById(R.id.bgBlack);
        menuArrow = findViewById(R.id.menuArrow);
        loginSignUp = findViewById(R.id.Login_SignUp);
        flipFlops = findViewById(R.id.ivFlipFlops);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        menuCategoriesBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        themeStoreBar.setOnClickListener(new View.OnClickListener() {
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
        bgBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameData = PreferenceHelper.getStringFromPreference(HomeActivity.this, "userName");
                if (userNameData.equals("")) {
                    Intent intent = new Intent(HomeActivity.this, Login_Activity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
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
        ivHs1FootWear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FootWearActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ShoppingBag.class);
                startActivity(intent);
            }
        });
        menuBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScreen.setVisibility(View.VISIBLE);

            }
        });
        closeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuScreen.setVisibility(View.GONE);
            }
        });
        wishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        flipFlops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FootWearActivity.class);
                startActivity(intent);
            }
        });
        womenWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WomenActivity.class);
                startActivity(intent);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}