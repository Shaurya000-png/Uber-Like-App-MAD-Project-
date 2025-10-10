package com.example.carpoolconnect.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.carpoolconnect.R;
import com.example.carpoolconnect.models.Ride;
import com.example.carpoolconnect.services.RideStore;

public class RideDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_RIDE_ID = "ride_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_details);

        String rideId = getIntent().getStringExtra(EXTRA_RIDE_ID);
        TextView tvInfo = findViewById(R.id.tvInfo);
        Button btnJoin = findViewById(R.id.btnJoin);

        tvInfo.setText("Ride: " + rideId);

        btnJoin.setOnClickListener(v -> {
            if (rideId == null) { finish(); return; }
            boolean ok = new RideStore(this).decrementSeats(rideId);
            if (ok) Toast.makeText(this, "Joined ride", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "No seats left", Toast.LENGTH_SHORT).show();
        });
    }
}




