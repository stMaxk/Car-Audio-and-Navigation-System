package com.example.demo;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<AudioTrack> tracks = new ArrayList<>();
    private int currentIndex = 0;

    public void addTrack(AudioTrack track) {
        if (track.isSupported()) {
            tracks.add(track);
        } else {
            System.out.println("Unsupported file format: " + track.getFileName());
        }
    }

    public boolean isEmpty() {
        return tracks.isEmpty();
    }

    public AudioTrack getCurrentTrack() {
        if (tracks.isEmpty()) {
            return null;
        }
        return tracks.get(currentIndex);
    }

    public void nextTrack() {
        if (!tracks.isEmpty()) {
            currentIndex = (currentIndex + 1) % tracks.size();
        }
    }

    public void previousTrack() {
        if (!tracks.isEmpty()) {
            currentIndex = (currentIndex - 1 + tracks.size()) % tracks.size();
        }
    }

    public void showPlaylist() {
        if (tracks.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("Playlist:");
        for (int i = 0; i < tracks.size(); i++) {
            AudioTrack track = tracks.get(i);
            if (i == currentIndex) {
                System.out.println("-> " + track.getTitle() + " (" + track.getFileName() + ")");
            } else {
                System.out.println("   " + track.getTitle() + " (" + track.getFileName() + ")");
            }
        }
    }
}