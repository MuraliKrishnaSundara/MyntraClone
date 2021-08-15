package com.example.myntra.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.NavBarAvtivity.ProfileActivity;
import com.example.myntra.PreferenceHelper;
import com.example.myntra.R;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText password;
    private EditText rePassword;
    private Button signUpAccount;
    private TextView agreePermission;
    private ArrayList<AccountData> accountList = new ArrayList<>();
    private AccountData accountData;
    private String validEmailCheck = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private CheckBox tick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        initViews();
    }

    private void initViews() {
        name = findViewById(R.id.signUpName);
        email = findViewById(R.id.signUpEmail);
        phone = findViewById(R.id.signUpPhone);
        password = findViewById(R.id.signUpPassword);
        rePassword = findViewById(R.id.signUpRePassword);
        signUpAccount = findViewById(R.id.signUpAccount);
        tick = findViewById(R.id.cbSignUp);
        agreePermission = findViewById(R.id.agreePermission);
        /*
        Storing signUP data inside Preference Helper.
         */
        signUpAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validName() && validEmail() && validPhoneNumber() && passwordLength() && passwordMatch() && isClicked()) {
                    accountData = new AccountData(name.getText().toString(), email.getText().toString(),
                            phone.getText().toString(), password.getText().toString());
                    accountList.add(accountData);
                    PreferenceHelper.writeStringToPreference(SignUpActivity.this, "userName", name.getText().toString());
                    PreferenceHelper.writeStringToPreference(SignUpActivity.this, "email", email.getText().toString());
                    PreferenceHelper.writeStringToPreference(SignUpActivity.this, "phone", phone.getText().toString());
                    PreferenceHelper.writeStringToPreference(SignUpActivity.this, "password", password.getText().toString());

                    new AlertDialog.Builder(SignUpActivity.this).setMessage("Account Successfully Created").show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                            startActivity(intent);
                        }
                    }, 500);

                }
            }
        });
    }

    private boolean validEmail() {
        if (email.getText().toString().matches(validEmailCheck))
            return true;
        else {
            email.setError("Invalid Email");
            return false;
        }
    }

    private boolean passwordMatch() {
        if (password.getText().toString().equals(rePassword.getText().toString()))
            return true;
        else {
            rePassword.setError("Password does not Matches");
            return false;
        }
    }

    private boolean passwordLength() {
        if (password.getText().toString().length() >= 6)
            return true;
        else {
            password.setError("Too short");
            return false;
        }
    }

    private boolean validName() {
        if (name.getText().toString().length() > 2)
            return true;
        else {
            name.setError("Invalid Name");
            return false;
        }
    }

    private boolean validPhoneNumber() {
        if (phone.getText().toString().length() != 10) {
            phone.setError("Not valid Phone Number");
            return false;
        }
        return true;
    }

    private boolean isClicked() {
        if (tick.isChecked()) {
            return true;
        } else {
            agreePermission.setVisibility(View.VISIBLE);
            return false;
        }
    }
}