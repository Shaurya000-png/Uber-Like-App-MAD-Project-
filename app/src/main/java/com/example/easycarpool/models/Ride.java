package com.example.easycarpool.models;

import java.io.Serializable;

public class Ride implements Serializable {
    private String driverName;
    private String startPoint;
    private String destination;
    private String time;
    private int availableSeats;

    public Ride(String driverName, String startPoint, String destination, String time, int availableSeats) {
        this.driverName = driverName;
        this.startPoint = startPoint;
        this.destination = destination;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}


