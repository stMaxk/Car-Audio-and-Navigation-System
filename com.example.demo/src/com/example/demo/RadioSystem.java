package com.example.demo;

public class RadioSystem {
    private String mode = "FM";
    private Double currentFrequency = null;
    private boolean playing = false;

    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("AM") || mode.equalsIgnoreCase("FM")) {
            this.mode = mode.toUpperCase();
            this.currentFrequency = null;
            this.playing = false;
            System.out.println("Switched to " + this.mode + " band.");
        } else {
            System.out.println("Invalid radio mode.");
        }
    }

    public void tune(double frequency) {
        if (mode.equals("FM")) {
            if (frequency >= 87.5 && frequency <= 108.0) {
                currentFrequency = frequency;
                playing = true;
                System.out.println("Tuned to FM " + frequency);
            } else {
                System.out.println("Invalid FM frequency. Enter a value between 87.5 and 108.0.");
            }
        } else {
            if (frequency >= 530 && frequency <= 1700) {
                currentFrequency = frequency;
                playing = true;
                System.out.println("Tuned to AM " + frequency);
            } else {
                System.out.println("Invalid AM frequency. Enter a value between 530 and 1700.");
            }
        }
    }

    public void showStatus() {
        System.out.println("Radio Status:");
        System.out.println("Band: " + mode);
        System.out.println("Current Frequency: " + (currentFrequency != null ? currentFrequency : "None"));
        System.out.println("Playing: " + playing);
    }
}