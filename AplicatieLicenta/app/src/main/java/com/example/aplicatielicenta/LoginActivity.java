package com.example.aplicatielicenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView usernameTextView;
    private TextView passwordTextView;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LogIn");
        initViews();
    }

    private void initViews() {
        usernameTextView = findViewById(R.id.et_username);
        passwordTextView = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });
    }

    private void openSignup() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    private void openHome() {
        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        // Check if user exists

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
