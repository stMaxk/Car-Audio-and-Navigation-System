package com.example.demo;

import java.util.Scanner;

public class AudioPlaybackSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        USBService usb = new USBService();
        Playlist playlist = new Playlist();
        AudioPlayer player = new AudioPlayer();
        RadioSystem radio = new RadioSystem();
        GPS gps = new GPS(32.7157, -117.1611);
        RouteSystem route = new RouteSystem();

        playlist.addTrack(new AudioTrack("Song 1", "song1.mp3"));
        playlist.addTrack(new AudioTrack("Song 2", "song2.wav"));
        playlist.addTrack(new AudioTrack("Song 3", "song3.mp3"));

        boolean running = true;

        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. USB");
            System.out.println("2. Playlist");
            System.out.println("3. Audio Controls");
            System.out.println("4. Audio Settings");
            System.out.println("5. Radio");
            System.out.println("6. GPS");
            System.out.println("7. Route Map");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- USB MENU ---");
                    System.out.println("1. Connect USB");
                    System.out.println("2. Show USB Status");
                    int usbChoice = scanner.nextInt();

                    if (usbChoice == 1) {
                        usb.connectUSB();
                    } else if (usbChoice == 2) {
                        usb.showStatus();
                    }
                    break;

                case 2:
                    System.out.println("\n--- PLAYLIST MENU ---");
                    playlist.showPlaylist();
                    break;

                case 3:
                    System.out.println("\n--- AUDIO CONTROLS ---");
                    System.out.println("1. Play");
                    System.out.println("2. Pause");
                    System.out.println("3. Resume");
                    System.out.println("4. Next Track");
                    System.out.println("5. Previous Track");
                    System.out.println("6. Mute/Unmute");
                    System.out.println("7. Set Volume");
                    System.out.println("8. Advance Playback Position");
                    System.out.println("9. Show Audio Status");
                    int audioChoice = scanner.nextInt();

                    switch (audioChoice) {
                        case 1:
                            player.play(playlist.getCurrentTrack());
                            break;
                        case 2:
                            player.pause();
                            break;
                        case 3:
                            player.resume(playlist.getCurrentTrack());
                            break;
                        case 4:
                            playlist.nextTrack();
                            player.stopForTrackChange();
                            player.play(playlist.getCurrentTrack());
                            break;
                        case 5:
                            playlist.previousTrack();
                            player.stopForTrackChange();
                            player.play(playlist.getCurrentTrack());
                            break;
                        case 6:
                            player.toggleMute();
                            break;
                        case 7:
                            System.out.print("Enter volume (0-100): ");
                            int volume = scanner.nextInt();
                            player.setVolume(volume);
                            break;
                        case 8:
                            System.out.print("Enter seconds to advance: ");
                            double seconds = scanner.nextDouble();
                            player.advancePlayback(seconds);
                            break;
                        case 9:
                            player.showStatus(playlist.getCurrentTrack());
                            break;
                    }
                    break;

                case 4:
                    System.out.println("\n--- AUDIO SETTINGS ---");
                    System.out.println("1. Set Bass");
                    System.out.println("2. Set Treble");
                    System.out.println("3. Set Balance");
                    int settingsChoice = scanner.nextInt();

                    switch (settingsChoice) {
                        case 1:
                            System.out.print("Enter bass (-10 to 10): ");
                            player.setBass(scanner.nextInt());
                            break;
                        case 2:
                            System.out.print("Enter treble (-10 to 10): ");
                            player.setTreble(scanner.nextInt());
                            break;
                        case 3:
                            System.out.print("Enter balance (-10 to 10): ");
                            player.setBalance(scanner.nextInt());
                            break;
                    }
                    break;

                case 5:
                    System.out.println("\n--- RADIO MENU ---");
                    System.out.println("1. Select FM");
                    System.out.println("2. Select AM");
                    System.out.println("3. Tune Frequency");
                    System.out.println("4. Show Radio Status");
                    int radioChoice = scanner.nextInt();

                    switch (radioChoice) {
                        case 1:
                            radio.setMode("FM");
                            break;
                        case 2:
                            radio.setMode("AM");
                            break;
                        case 3:
                            System.out.print("Enter frequency: ");
                            radio.tune(scanner.nextDouble());
                            break;
                        case 4:
                            radio.showStatus();
                            break;
                    }
                    break;

                case 6:
                    System.out.println("\n--- GPS MENU ---");
                    System.out.println("1. Show Current Location");
                    System.out.println("2. Update Location");
                    int gpsChoice = scanner.nextInt();

                    switch (gpsChoice) {
                        case 1:
                            gps.displayLocation();
                            break;
                        case 2:
                            System.out.print("Enter latitude: ");
                            double lat = scanner.nextDouble();
                            System.out.print("Enter longitude: ");
                            double lng = scanner.nextDouble();
                            gps.updateLocation(lat, lng);
                            gps.displayLocation();
                            break;
                    }
                    break;

                case 7:
                    System.out.println("\n--- ROUTE MAP MENU ---");
                    System.out.println("1. Calculate Route");
                    System.out.println("2. Display Route");
                    System.out.println("3. Zoom In");
                    System.out.println("4. Zoom Out");
                    System.out.println("5. Pan Map");
                    int routeChoice = scanner.nextInt();

                    switch (routeChoice) {
                        case 1:
                            System.out.print("Enter start latitude: ");
                            double startLat = scanner.nextDouble();
                            System.out.print("Enter start longitude: ");
                            double startLng = scanner.nextDouble();
                            System.out.print("Enter destination latitude: ");
                            double destLat = scanner.nextDouble();
                            System.out.print("Enter destination longitude: ");
                            double destLng = scanner.nextDouble();
                            route.calculateRoute(startLat, startLng, destLat, destLng);
                            break;
                        case 2:
                            route.displayRoute();
                            break;
                        case 3:
                            route.zoomIn();
                            break;
                        case 4:
                            route.zoomOut();
                            break;
                        case 5:
                            System.out.print("Enter direction to pan (left/right/up/down): ");
                            String direction = scanner.next();
                            route.pan(direction);
                            break;
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}