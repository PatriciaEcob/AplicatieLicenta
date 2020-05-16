package com.example.aplicatielicenta.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplicatielicenta.R;
import com.example.aplicatielicenta.managers.ApplicationManager;
import com.example.aplicatielicenta.managers.DatabaseManager;
import com.example.aplicatielicenta.models.UserModel;

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

        UserModel user = DatabaseManager.getInstance().getUser(username, password);
        if(user != null) {
            ApplicationManager.getInstance().setUser(user);

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show();
        }
    }
}
