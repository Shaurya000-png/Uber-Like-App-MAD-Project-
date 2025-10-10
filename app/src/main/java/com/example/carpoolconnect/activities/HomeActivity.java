package com.example.carpoolconnect.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolconnect.R;
import com.example.carpoolconnect.adapters.RideAdapter;
import com.example.carpoolconnect.models.Ride;
import com.example.carpoolconnect.services.RideStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private final List<Ride> allRides = new ArrayList<>();
    private RideAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.btnCreateRide).setOnClickListener(v ->
                startActivity(new Intent(this, CreateRideActivity.class)));

        findViewById(R.id.btnMyRides).setOnClickListener(v ->
                startActivity(new Intent(this, MyRidesActivity.class)));

        RecyclerView rv = findViewById(R.id.rvRides);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RideAdapter(ride -> {
            Intent i = new Intent(this, RideDetailsActivity.class);
            i.putExtra(RideDetailsActivity.EXTRA_RIDE_ID, ride.getId());
            startActivity(i);
        });
        rv.setAdapter(adapter);

        EditText etSearch = findViewById(R.id.etSearchDestination);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { filter(s.toString()); }
            @Override public void afterTextChanged(Editable s) {}
        });

        loadLocal();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocal();
    }

    private void loadLocal() {
        RideStore store = new RideStore(this);
        allRides.clear();
        allRides.addAll(store.getAll());
        adapter.submit(new ArrayList<>(allRides));
    }

    private void filter(String q) {
        if (q == null) { adapter.submit(new ArrayList<>(allRides)); return; }
        String query = q.toLowerCase(Locale.getDefault());
        List<Ride> filtered = new ArrayList<>();
        for (Ride r : allRides) {
            if (r.getDestination() != null && r.getDestination().toLowerCase(Locale.getDefault()).contains(query)) {
                filtered.add(r);
            }
        }
        adapter.submit(filtered);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // No auth when Firebase removed; keep menu for future
        return super.onOptionsItemSelected(item);
    }
}


