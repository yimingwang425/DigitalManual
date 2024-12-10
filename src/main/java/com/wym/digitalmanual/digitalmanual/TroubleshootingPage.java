package com.wym.digitalmanual.digitalmanual;

import java.util.List;

public class TroubleshootingPage {
    public static void showTroubleshooting(String deviceId) {
        List<String> troubleshootingData = DataLoader.loadTroubleshootingData(deviceId);

        System.out.println("Troubleshooting Steps for Device: " + deviceId);
        for (String step : troubleshootingData) {
            System.out.println(step);
        }
    }
}