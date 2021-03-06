package com.example.myntra.NavBarAvtivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.Login.ForgotActivity;
import com.example.myntra.Login.Login_Activity;
import com.example.myntra.Login.SignUpActivity;
import com.example.myntra.NavBarAvtivity.Catogries.CategoriesActivity;
import com.example.myntra.NavBarAvtivity.Home.HomeActivity;
import com.example.myntra.NavBarAvtivity.Studio.StudioActivity;
import com.example.myntra.Order.OrderActivity;
import com.example.myntra.Order.WishlistActivity;
import com.example.myntra.PreferenceHelper;
import com.example.myntra.R;

/*
Profile show is layout and shown Through visibility on and off
 */
public class ProfileActivity extends AppCompatActivity {
    private ImageView home;
    private ImageView categories;
    private ImageView studio;
    private ImageView explore;
    private ImageView profile;
    private ImageView closeLogin;
    private ImageView profileImage;
    private Button btn_login_signup;
    private Button loginContinue;
    private Button forgot;
    private Button signUp;
    private EditText phoneNumber;
    private TextView profileName;
    private TextView tvProfile;
    private View bgView;
    private View WishlistBar;
    private View order;
    private LinearLayout loginScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        onProfile();
        someItemClicked();
    }

    private void onProfile() {
        profile.setColorFilter(getResources().getColor(R.color.red));
        tvProfile.setTextColor(getResources().getColor(R.color.red));
    }

    private void someItemClicked() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, StudioActivity.class);
                startActivity(intent);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
        WishlistBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
        btn_login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginScreen.setVisibility(View.VISIBLE);

            }
        });
        closeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginScreen.setVisibility(View.GONE);
            }
        });
        loginContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validPhoneNumber()) {
                    Intent intent = new Intent(ProfileActivity.this, Login_Activity.class);
                    intent.putExtra("phoneNumber", phoneNumber.getText().toString());
                    startActivity(intent);
                }
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ForgotActivity.class);
                startActivity(intent);
            }
        });
        /* Getting some name from PreferenceHelper..
         if the name have some data then don't show the login Button instead show the userName*/
        String userNameData = PreferenceHelper.getStringFromPreference(ProfileActivity.this, "userName");
        if (userNameData.equals("")) {
        } else {
            profileName.setVisibility(View.VISIBLE);
            PreferenceHelper.writeIntToPreference(ProfileActivity.this, "added", 0);
            btn_login_signup.setVisibility(View.GONE);
            profileName.setText(userNameData);
            bgView.setBackgroundColor(getResources().getColor(R.color.red));
        }
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initViews() {
        home = findViewById(R.id.myntraLogo);
        categories = findViewById(R.id.category);
        studio = findViewById(R.id.studio);
        explore = findViewById(R.id.explore);
        profile = findViewById(R.id.profile);
        tvProfile = findViewById(R.id.tvCProfile);
        btn_login_signup = findViewById(R.id.btnLogin_Signup);
        loginScreen = findViewById(R.id.loginScreen);
        closeLogin = findViewById(R.id.closeLogin);
        loginContinue = findViewById(R.id.btnContinue);
        forgot = findViewById(R.id.forgotPassword);
        signUp = findViewById(R.id.signUP);
        phoneNumber = findViewById(R.id.loginPhoneNumber);
        profileName = findViewById(R.id.tvProfileName);
        bgView = findViewById(R.id.blackView);
        profileImage = findViewById(R.id.ivProductImage);
        order = findViewById(R.id.ordersBar);
        WishlistBar = findViewById(R.id.wishlistBar);

    }

    private boolean validPhoneNumber() {
        if (phoneNumber.getText().toString().length() == 10)
            return true;
        else {
            phoneNumber.setError("Enter valid Phone Number");
            return false;
        }
    }
}