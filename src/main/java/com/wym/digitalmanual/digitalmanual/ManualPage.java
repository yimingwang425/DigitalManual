package com.wym.digitalmanual.digitalmanual;

public class ManualPage {
    public static void showManual(String deviceId) {
        ManualSystem system = new ManualSystem();
        Manual manual = system.getManual(deviceId);

        if (manual != null) {
            System.out.println("Manual Title: " + manual.getTitle());
            System.out.println("Manual Content: " + manual.getContent());
        } else {
            System.out.println("No manual found for device ID: " + deviceId);
        }
    }
}