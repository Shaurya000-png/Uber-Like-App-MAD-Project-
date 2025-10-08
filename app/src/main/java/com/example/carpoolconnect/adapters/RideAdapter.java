package com.example.carpoolconnect.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolconnect.R;
import com.example.carpoolconnect.models.Ride;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.RideVH> {

    public interface OnRideClickListener { void onRideClicked(Ride ride); }

    private final List<Ride> items = new ArrayList<>();
    private final OnRideClickListener listener;
    private final SimpleDateFormat df = new SimpleDateFormat("MMM d, h:mm a", Locale.getDefault());

    public RideAdapter(OnRideClickListener listener) { this.listener = listener; }

    public void submit(List<Ride> rides) {
        items.clear();
        if (rides != null) items.addAll(rides);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public RideVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ride, parent, false);
        return new RideVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RideVH holder, int position) {
        Ride r = items.get(position);
        holder.tvFrom.setText(r.getStartAddress());
        holder.tvTo.setText(r.getDestination());
        holder.tvTime.setText(df.format(new Date(r.getDatetime())));
        holder.tvSeats.setText(String.valueOf(r.getSeatsAvailable()));
        holder.itemView.setOnClickListener(v -> listener.onRideClicked(r));
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class RideVH extends RecyclerView.ViewHolder {
        TextView tvFrom, tvTo, tvTime, tvSeats;
        RideVH(@NonNull View itemView) {
            super(itemView);
            tvFrom = itemView.findViewById(R.id.tvFrom);
            tvTo = itemView.findViewById(R.id.tvTo);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvSeats = itemView.findViewById(R.id.tvSeats);
        }
    }
}




