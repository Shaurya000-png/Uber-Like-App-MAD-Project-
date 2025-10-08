package com.example.carpoolconnect.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.carpoolconnect.models.Ride;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class RideStore {
    private static final String PREFS = "rides_store";
    private static final String KEY = "rides_json";
    private final SharedPreferences prefs;
    private final Gson gson = new Gson();
    private final Type listType = new TypeToken<List<Ride>>(){}.getType();

    public RideStore(Context context) {
        this.prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized List<Ride> getAll() {
        String json = prefs.getString(KEY, null);
        if (json == null || json.isEmpty()) return new ArrayList<>();
        List<Ride> rides = gson.fromJson(json, listType);
        return rides != null ? rides : new ArrayList<>();
    }

    public synchronized Ride add(Ride ride) {
        List<Ride> rides = getAll();
        if (ride.getId() == null || ride.getId().isEmpty()) {
            ride.setId(UUID.randomUUID().toString());
        }
        rides.add(ride);
        save(rides);
        return ride;
    }

    public synchronized void update(Ride ride) {
        List<Ride> rides = getAll();
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getId().equals(ride.getId())) {
                rides.set(i, ride);
                break;
            }
        }
        save(rides);
    }

    public synchronized boolean decrementSeats(String rideId) {
        List<Ride> rides = getAll();
        for (Ride r : rides) {
            if (r.getId().equals(rideId)) {
                if (r.getSeatsAvailable() > 0) {
                    r.setSeatsAvailable(r.getSeatsAvailable() - 1);
                    save(rides);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public synchronized void removeById(String rideId) {
        List<Ride> rides = getAll();
        Iterator<Ride> it = rides.iterator();
        while (it.hasNext()) {
            if (rideId.equals(it.next().getId())) it.remove();
        }
        save(rides);
    }

    private void save(List<Ride> rides) {
        prefs.edit().putString(KEY, gson.toJson(rides, listType)).apply();
    }
}


