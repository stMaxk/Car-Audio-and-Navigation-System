package com.example.demo;

public class RouteSystem {
    private double startLat;
    private double startLng;
    private double destLat;
    private double destLng;
    private int zoomLevel = 13;

    public void calculateRoute(double startLat, double startLng, double destLat, double destLng) {
        this.startLat = startLat;
        this.startLng = startLng;
        this.destLat = destLat;
        this.destLng = destLng;

        System.out.println("Route calculated successfully.");
    }

    public void displayRoute() {
        System.out.println("Route Path:");
        System.out.println("Start Point: " + startLat + ", " + startLng);
        System.out.println("Mid Point: " + ((startLat + destLat) / 2) + ", " + ((startLng + destLng) / 2));
        System.out.println("Destination Point: " + destLat + ", " + destLng);
        System.out.println("Full route path is visible.");
    }

    public void zoomIn() {
        zoomLevel++;
        System.out.println("Zoomed in. Current zoom level: " + zoomLevel);
    }

    public void zoomOut() {
        zoomLevel--;
        System.out.println("Zoomed out. Current zoom level: " + zoomLevel);
    }

    public void pan(String direction) {
        System.out.println("Map panned " + direction + ".");
    }
}