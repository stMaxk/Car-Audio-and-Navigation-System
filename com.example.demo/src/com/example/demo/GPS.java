package com.example.demo;

public class GPS {
    private double latitude;
    private double longitude;

    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void updateLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        System.out.println("Location updated.");
    }

    public void displayLocation() {
        System.out.println("Current Location: " + latitude + ", " + longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}