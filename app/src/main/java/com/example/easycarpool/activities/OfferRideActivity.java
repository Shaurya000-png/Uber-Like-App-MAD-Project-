package com.example.easycarpool.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easycarpool.R;
import com.example.easycarpool.models.Ride;
import com.example.easycarpool.store.RideRepository;

public class OfferRideActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputStart;
    private EditText inputDestination;
    private EditText inputTime;
    private EditText inputSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ec_activity_offer_ride);

        inputName = findViewById(R.id.input_name);
        inputStart = findViewById(R.id.input_start);
        inputDestination = findViewById(R.id.input_destination);
        inputTime = findViewById(R.id.input_time);
        inputSeats = findViewById(R.id.input_seats);
        Button saveButton = findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString().trim();
                String start = inputStart.getText().toString().trim();
                String destination = inputDestination.getText().toString().trim();
                String time = inputTime.getText().toString().trim();
                String seatsStr = inputSeats.getText().toString().trim();

                if (name.isEmpty() || start.isEmpty() || destination.isEmpty() || time.isEmpty() || seatsStr.isEmpty()) {
                    Toast.makeText(OfferRideActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
                    return;
                }

                int seats = 1;
                try {
                    seats = Integer.parseInt(seatsStr);
                } catch (NumberFormatException ignored) { }

                Ride ride = new Ride(name, start, destination, time, seats);
                RideRepository.addRide(ride);
                Toast.makeText(OfferRideActivity.this, R.string.ride_added, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}


