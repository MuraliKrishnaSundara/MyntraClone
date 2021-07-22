package com.example.myntra;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {
    private Button signUP;
    private Button forgotPassword;
    private Button login;
    private EditText loginPhoneNumber;
    private EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        signUP = findViewById(R.id.signUP);
        forgotPassword = findViewById(R.id.forgotPassword);
        login = findViewById(R.id.btnContinue);
        loginPassword = findViewById(R.id.loginPhoneNumber);
        loginPassword = findViewById(R.id.loginPassword);
    }
}