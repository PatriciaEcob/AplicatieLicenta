package com.example.aplicatielicenta.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aplicatielicenta.R;
import com.example.aplicatielicenta.managers.ApplicationManager;
import com.example.aplicatielicenta.managers.DatabaseManager;

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
        double current = Double.parseDouble(currentTextView.getText().toString());
        double goal = Double.parseDouble(goalTextView.getText().toString());

        ApplicationManager.getInstance().getUser().currentKilo = current;
        ApplicationManager.getInstance().getUser().goalKilo = goal;
        DatabaseManager.getInstance().setKilos(current, goal);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
