package com.example.myntra;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {
    private Button signUP;
    private Button forgotPassword;
    private Button loginContinue;
    private TextView loginPhoneNumber;
    private EditText loginPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        initViews();
        String phone = PreferenceHelper.getStringFromPreference(Login_Activity.this, "phone");
        String password = PreferenceHelper.getStringFromPreference(Login_Activity.this, "password");
        loginContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginPhoneNumber.getText().toString().equals(phone) && passwordCheck(password)) {
                    new AlertDialog.Builder(Login_Activity.this).setMessage("Login Successful").show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Login_Activity.this, ProfileActivity.class);
                            startActivity(intent);
                        }
                    }, 500);
                }
            }
        });
        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, ForgotActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean passwordCheck(String password) {
        if (loginPassword.getText().toString().equals(password)) {
            return true;
        } else {
            loginPassword.setError("Password Wrong");
            return false;
        }
    }

    private void initViews() {
        signUP = findViewById(R.id.signUP);
        forgotPassword = findViewById(R.id.forgotPassword);
        loginContinue = findViewById(R.id.btnContinue);
        loginPhoneNumber = findViewById(R.id.tvLoginPhoneNumber);
        loginPassword = findViewById(R.id.loginPassword);
        loginPhoneNumber.setText(getIntent().getStringExtra("phoneNumber"));
    }
}