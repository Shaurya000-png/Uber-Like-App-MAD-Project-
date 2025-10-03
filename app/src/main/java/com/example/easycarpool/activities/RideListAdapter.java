package com.example.easycarpool.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easycarpool.R;
import com.example.easycarpool.models.Ride;

import java.util.List;

public class RideListAdapter extends RecyclerView.Adapter<RideListAdapter.RideViewHolder> {

    public interface OnRideClickListener {
        void onRideClick(Ride ride);
    }

    private final List<Ride> rides;
    private final OnRideClickListener listener;

    public RideListAdapter(List<Ride> rides, OnRideClickListener listener) {
        this.rides = rides;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ride, parent, false);
        return new RideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RideViewHolder holder, int position) {
        Ride ride = rides.get(position);
        holder.name.setText(ride.getDriverName());
        holder.route.setText(ride.getStartPoint() + " → " + ride.getDestination());
        holder.time.setText(ride.getTime());
        holder.seats.setText(String.valueOf(ride.getAvailableSeats()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onRideClick(ride);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rides.size();
    }

    static class RideViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView route;
        TextView time;
        TextView seats;

        RideViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            route = itemView.findViewById(R.id.item_route);
            time = itemView.findViewById(R.id.item_time);
            seats = itemView.findViewById(R.id.item_seats);
        }
    }
}


