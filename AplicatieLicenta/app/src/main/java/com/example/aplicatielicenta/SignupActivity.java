package com.example.aplicatielicenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
    private TextView fullNameTextView;
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView passwordTextView;
    private TextView confirmPasswordTextView;
    private Button registerButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("SingUp");
        initViews();
    }

    private void initViews() {
        fullNameTextView = findViewById(R.id.et_full_name);
        usernameTextView = findViewById(R.id.et_username);
        emailTextView = findViewById(R.id.et_email);
        passwordTextView = findViewById(R.id.et_password);
        confirmPasswordTextView = findViewById(R.id.et_confirm_password);
        registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void openHome() {
        String fullName = fullNameTextView.getText().toString();
        String username = usernameTextView.getText().toString();
        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        // Add user in database

        Intent intent = new Intent(this, SetKiloActivity.class);
        startActivity(intent);
    }

    private void openLogin(){
        finish();
    }
}
