package com.example.easycarpool.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easycarpool.R;
import com.example.easycarpool.models.Ride;
import com.example.easycarpool.store.RideRepository;

import java.util.List;

public class FindRideActivity extends AppCompatActivity implements RideListAdapter.OnRideClickListener {

    private RecyclerView recyclerView;
    private RideListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ec_activity_find_ride);

        recyclerView = findViewById(R.id.recycler_rides);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RideListAdapter(RideRepository.getRides(), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRideClick(Ride ride) {
        Intent intent = new Intent(this, RideDetailsActivity.class);
        intent.putExtra("ride", ride);
        startActivity(intent);
    }
}


