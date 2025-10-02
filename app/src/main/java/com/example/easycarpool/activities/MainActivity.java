package com.example.easycarpool.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easycarpool.R;
import com.example.easycarpool.store.RideRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ec_activity_main);

        Button offerButton = findViewById(R.id.button_offer);
        Button findButton = findViewById(R.id.button_find);

        RideRepository.seedSampleDataIfEmpty();

        offerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OfferRideActivity.class));
            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FindRideActivity.class));
            }
        });
    }
}


