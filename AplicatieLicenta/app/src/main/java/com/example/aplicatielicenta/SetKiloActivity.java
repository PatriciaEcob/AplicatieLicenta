package com.example.aplicatielicenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SetKiloActivity extends AppCompatActivity {
    private TextView currentTextView;
    private TextView goalTextView;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_set_kilo);
        getSupportActionBar().setTitle("Set goal");
        initViews();
    }

    private void initViews() {
        currentTextView = findViewById(R.id.et_current);
        goalTextView = findViewById(R.id.et_goal);
        continueButton = findViewById(R.id.button_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }

    private void openHome() {
        String current = currentTextView.getText().toString();
        String goal = goalTextView.getText().toString();

        // Add these 2 in user data in database

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
