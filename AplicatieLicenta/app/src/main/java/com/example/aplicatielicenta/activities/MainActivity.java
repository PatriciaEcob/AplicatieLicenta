package com.example.aplicatielicenta.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.aplicatielicenta.R;
import com.example.aplicatielicenta.managers.DatabaseManager;

public class MainActivity extends AppCompatActivity implements DatabaseManager.DatabaseManagerCallback {
    private RelativeLayout mContainer;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mContainer = findViewById(R.id.rl_main_container);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTapHere();
            }
        });

        if(DatabaseManager.getInstance().isInitReady()) {
            mContainer.setVisibility(View.VISIBLE);
        }
        else {
            mContainer.setVisibility(View.INVISIBLE);
            DatabaseManager.getInstance().init(this);
        }
    }

    @Override
    public void initReady() {
        mContainer.setVisibility(View.VISIBLE);
    }

    private void openTapHere() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
