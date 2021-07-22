package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private ImageView home;
    private ImageView categories;
    private ImageView studio;
    private ImageView explore;
    private ImageView profile;
    private TextView tvProfile;
    private Button btn_login_signup;
    private LinearLayout loginScreen;
    private ImageView closeLogin;
    private Button loginContinue;
    private Button forgot;
    private Button signUp;
    private EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        profile.setColorFilter(getResources().getColor(R.color.red));
        tvProfile.setTextColor(getResources().getColor(R.color.red));
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