package com.example.carpoolconnect.models;

import java.util.HashMap;
import java.util.Map;

public class Ride {
    private String id;
    private String ownerId;
    private String ownerName;
    private String startAddress;
    private double startLat;
    private double startLng;
    private String destination;
    private double destLat;
    private double destLng;
    private long datetime;
    private int seatsAvailable;
    private double costPerSeat;

    public Ride() { }

    public Ride(String id,
                String ownerId,
                String ownerName,
                String startAddress,
                double startLat,
                double startLng,
                String destination,
                double destLat,
                double destLng,
                long datetime,
                int seatsAvailable,
                double costPerSeat) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.startAddress = startAddress;
        this.startLat = startLat;
        this.startLng = startLng;
        this.destination = destination;
        this.destLat = destLat;
        this.destLng = destLng;
        this.datetime = datetime;
        this.seatsAvailable = seatsAvailable;
        this.costPerSeat = costPerSeat;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("ownerId", ownerId);
        map.put("ownerName", ownerName);
        map.put("startAddress", startAddress);
        map.put("startLat", startLat);
        map.put("startLng", startLng);
        map.put("destination", destination);
        map.put("destLat", destLat);
        map.put("destLng", destLng);
        map.put("datetime", datetime);
        map.put("seatsAvailable", seatsAvailable);
        map.put("costPerSeat", costPerSeat);
        return map;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public String getStartAddress() { return startAddress; }
    public void setStartAddress(String startAddress) { this.startAddress = startAddress; }
    public double getStartLat() { return startLat; }
    public void setStartLat(double startLat) { this.startLat = startLat; }
    public double getStartLng() { return startLng; }
    public void setStartLng(double startLng) { this.startLng = startLng; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public double getDestLat() { return destLat; }
    public void setDestLat(double destLat) { this.destLat = destLat; }
    public double getDestLng() { return destLng; }
    public void setDestLng(double destLng) { this.destLng = destLng; }
    public long getDatetime() { return datetime; }
    public void setDatetime(long datetime) { this.datetime = datetime; }
    public int getSeatsAvailable() { return seatsAvailable; }
    public void setSeatsAvailable(int seatsAvailable) { this.seatsAvailable = seatsAvailable; }
    public double getCostPerSeat() { return costPerSeat; }
    public void setCostPerSeat(double costPerSeat) { this.costPerSeat = costPerSeat; }
}




