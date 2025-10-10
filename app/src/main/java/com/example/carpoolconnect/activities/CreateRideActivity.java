package com.example.carpoolconnect.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.carpoolconnect.R;
import com.example.carpoolconnect.models.Ride;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.carpoolconnect.services.RideStore;

public class CreateRideActivity extends AppCompatActivity {

    private GoogleMap map;
    private FusedLocationProviderClient fused;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ride);

        fused = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(googleMap -> {
                map = googleMap;
                map.getUiSettings().setZoomControlsEnabled(true);
            });
        }

        EditText etDestination = findViewById(R.id.etDestination);
        EditText etDateTime = findViewById(R.id.etDateTime);
        EditText etSeats = findViewById(R.id.etSeats);
        EditText etCost = findViewById(R.id.etCost);
        Button btnSave = findViewById(R.id.btnSaveRide);

        btnSave.setOnClickListener(v -> {
            String dest = etDestination.getText().toString().trim();
            String datetimeStr = etDateTime.getText().toString().trim();
            String seatsStr = etSeats.getText().toString().trim();
            String costStr = etCost.getText().toString().trim();
            if (TextUtils.isEmpty(dest) || TextUtils.isEmpty(datetimeStr) || TextUtils.isEmpty(seatsStr)) {
                Toast.makeText(this, "Fill destination, date/time and seats", Toast.LENGTH_SHORT).show();
                return;
            }
            long ts;
            try { ts = Long.parseLong(datetimeStr); } catch (Exception e) { ts = System.currentTimeMillis(); }
            int seats = Integer.parseInt(seatsStr);
            double cost = TextUtils.isEmpty(costStr) ? 0 : Double.parseDouble(costStr);

            LatLng start = new LatLng(0,0);
            if (map != null) {
                // If user moved camera to start position, use that. For MVP default.
                start = map.getCameraPosition().target;
            }

            String uid = "local-user";
            Ride ride = new Ride(null, uid, "", "Current Location", start.latitude, start.longitude,
                    dest, 0, 0, ts, seats, cost);
            new RideStore(this).add(ride);
            Toast.makeText(this, "Ride created", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}




