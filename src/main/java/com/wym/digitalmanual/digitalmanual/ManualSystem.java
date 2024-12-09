package com.wym.digitalmanual.digitalmanual;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

public class ManualSystem {
    private Map<String, Map<String, String>> manualMap = new HashMap<>();
    private Map<String, Map<String, String>> troubleshootingMap = new HashMap<>();

    public ManualSystem() {
        // SSH001 Manual
        Map<String, String> ssh001Manual = new LinkedHashMap<>();
        ssh001Manual.put("WiFi Setup", "1. Open SSH App\n2. Go to Device Settings\n3. Select WiFi Network\n4. Enter Password\n5. Confirm Connection");
        ssh001Manual.put("Password Configuration", "Detailed steps for password setup...");
        ssh001Manual.put("Firmware Update", "Steps for updating device firmware...");
        ssh001Manual.put("Security Settings", "Instructions for security configuration...");
        ssh001Manual.put("Remote Access", "Guide for setting up remote access...");
        manualMap.put("SSH001", ssh001Manual);

        // SSH002 Manual
        Map<String, String> ssh002Manual = new LinkedHashMap<>();
        ssh002Manual.put("Initial Setup", "Steps for initial device setup...");
        ssh002Manual.put("Network Configuration", "Network setup instructions...");
        ssh002Manual.put("User Management", "User access control guide...");
        ssh002Manual.put("Backup Settings", "Data backup configuration...");
        ssh002Manual.put("Advanced Features", "Advanced feature setup...");
        manualMap.put("SSH002", ssh002Manual);

        // SSH001 Troubleshooting
        Map<String, String> ssh001Trouble = new LinkedHashMap<>();
        ssh001Trouble.put("Connection Issues", "Steps to resolve connection problems...");
        ssh001Trouble.put("Login Failed", "Login troubleshooting guide...");
        ssh001Trouble.put("Device Offline", "Offline device resolution steps...");
        ssh001Trouble.put("Update Error", "Update error solutions...");
        ssh001Trouble.put("System Reset", "System reset procedure...");
        troubleshootingMap.put("SSH001", ssh001Trouble);

        // SSH002 Troubleshooting
        Map<String, String> ssh002Trouble = new LinkedHashMap<>();
        ssh002Trouble.put("Power Problems", "Power-related troubleshooting...");
        ssh002Trouble.put("Network Error", "Network error solutions...");
        ssh002Trouble.put("App Sync Failed", "App synchronization fixes...");
        ssh002Trouble.put("Sensor Issues", "Sensor troubleshooting guide...");
        ssh002Trouble.put("Factory Reset", "Factory reset instructions...");
        troubleshootingMap.put("SSH002", ssh002Trouble);
    }

    public Map<String, String> getManualContent(String deviceId) {
        return manualMap.getOrDefault(deviceId, new HashMap<>());
    }

    public Map<String, String> getTroubleshooting(String deviceId) {
        return troubleshootingMap.getOrDefault(deviceId, new HashMap<>());
    }

    public Manual getManual(String deviceId) {
        String title = "";
        String content = "";
        Map<String, String> manualContent = manualMap.get(deviceId);

        if (manualContent != null) {
            title = deviceId.equals("SSH001") ? "Smart Lock Manual" : "Security Camera Manual";
            content = String.join("\n", manualContent.values());
        }

        return manualContent != null ? new Manual(title, content) : null;
    }
}