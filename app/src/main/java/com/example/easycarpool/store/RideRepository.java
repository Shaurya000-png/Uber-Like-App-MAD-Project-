package com.example.easycarpool.store;

import com.example.easycarpool.models.Ride;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RideRepository {
    private static final List<Ride> RIDES = new ArrayList<>();

    public static void addRide(Ride ride) {
        RIDES.add(ride);
    }

    public static List<Ride> getRides() {
        return RIDES;
    }

    public static void seedSampleDataIfEmpty() {
        if (RIDES.isEmpty()) {
            RIDES.add(new Ride("Alex", "Campus", "Downtown", "8:30 AM", 3));
            RIDES.add(new Ride("Sam", "Library", "Mall", "10:00 AM", 2));
            RIDES.add(new Ride("Jamie", "Hostel", "Station", "5:15 PM", 1));
        }
    }
}


