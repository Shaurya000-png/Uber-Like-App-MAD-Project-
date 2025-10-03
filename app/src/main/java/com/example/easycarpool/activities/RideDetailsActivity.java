package com.example.easycarpool.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easycarpool.R;
import com.example.easycarpool.models.Ride;

public class RideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ec_activity_ride_details);

        Ride ride = (Ride) getIntent().getSerializableExtra("ride");

        TextView name = findViewById(R.id.text_name);
        TextView route = findViewById(R.id.text_route);
        TextView time = findViewById(R.id.text_time);
        TextView seats = findViewById(R.id.text_seats);

        if (ride != null) {
            name.setText(ride.getDriverName());
            route.setText(ride.getStartPoint() + " → " + ride.getDestination());
            time.setText(ride.getTime());
            seats.setText(String.valueOf(ride.getAvailableSeats()));
        }
    }
}


