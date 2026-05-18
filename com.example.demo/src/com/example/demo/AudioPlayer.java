package com.example.demo;

public class AudioPlayer {
    private boolean playing = false;
    private boolean paused = false;
    private boolean muted = false;

    private int volume = 50;
    private int previousVolume = 50;

    private int bass = 0;
    private int treble = 0;
    private int balance = 0;

    private double playbackPosition = 0.0;

    public void play(AudioTrack track) {
        if (track == null) {
            System.out.println("No track selected.");
            return;
        }

        playing = true;
        paused = false;

        if (muted) {
            System.out.println("Track loaded: " + track.getTitle() + " but system is muted.");
        } else {
            System.out.println("Playing: " + track.getTitle());
            System.out.println("Volume: " + volume);
            System.out.println("Playback Position: " + playbackPosition + " seconds");
        }
    }

    public void pause() {
        if (playing) {
            playing = false;
            paused = true;
            System.out.println("Playback paused at position " + playbackPosition + " seconds.");
        } else {
            System.out.println("No track is currently playing.");
        }
    }

    public void resume(AudioTrack track) {
        if (track == null) {
            System.out.println("No track selected.");
            return;
        }

        if (paused) {
            playing = true;
            paused = false;
            if (muted) {
                System.out.println("Playback resumed but system is muted.");
            } else {
                System.out.println("Resumed: " + track.getTitle() + " from " + playbackPosition + " seconds.");
            }
        } else {
            System.out.println("Playback is not paused.");
        }
    }

    public void stopForTrackChange() {
        playbackPosition = 0.0;
        playing = false;
        paused = false;
    }

    public void advancePlayback(double seconds) {
        if (playing) {
            playbackPosition += seconds;
            System.out.println("Playback advanced to " + playbackPosition + " seconds.");
        } else {
            System.out.println("Track must be playing to advance playback.");
        }
    }

    public void toggleMute() {
        if (!muted) {
            previousVolume = volume;
            volume = 0;
            muted = true;
            System.out.println("System muted. Audio stopped immediately.");
        } else {
            muted = false;
            volume = previousVolume;
            System.out.println("System unmuted. Previous volume restored to " + volume + ".");
        }
    }

    public void setVolume(int newVolume) {
        if (muted) {
            System.out.println("System is muted. Stored volume remains at " + previousVolume + ".");
            return;
        }

        if (newVolume < 0) {
            newVolume = 0;
        }
        if (newVolume > 100) {
            newVolume = 100;
        }

        volume = newVolume;
        previousVolume = newVolume;
        System.out.println("Volume set to " + volume + ".");
    }

    public void setBass(int bass) {
        this.bass = clampAudioSetting(bass);
        System.out.println("Bass set to " + this.bass + ".");
    }

    public void setTreble(int treble) {
        this.treble = clampAudioSetting(treble);
        System.out.println("Treble set to " + this.treble + ".");
    }

    public void setBalance(int balance) {
        this.balance = clampAudioSetting(balance);
        System.out.println("Balance set to " + this.balance + ".");
    }

    private int clampAudioSetting(int value) {
        if (value < -10) {
            return -10;
        }
        if (value > 10) {
            return 10;
        }
        return value;
    }

    public void showStatus(AudioTrack track) {
        System.out.println("Audio Status:");
        System.out.println("Current Track: " + (track != null ? track.getTitle() : "None"));
        System.out.println("Playing: " + playing);
        System.out.println("Paused: " + paused);
        System.out.println("Muted: " + muted);
        System.out.println("Volume: " + volume);
        System.out.println("Stored Previous Volume: " + previousVolume);
        System.out.println("Playback Position: " + playbackPosition + " seconds");
        System.out.println("Bass: " + bass);
        System.out.println("Treble: " + treble);
        System.out.println("Balance: " + balance);
    }
}