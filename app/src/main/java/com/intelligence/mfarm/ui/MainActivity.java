package com.intelligence.mfarm.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intelligence.mfarm.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView temp, humidity, rainfall, windspeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSummaryCard();

        findViewById(R.id.fab_buy_farm_input)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, BuyFarmInputActivity.class));
                    }
                });
    }

    private void initSummaryCard() {
        temp = findViewById(R.id.img_temp);
        temp.setImageResource(R.drawable.thermometer);
    }
}
