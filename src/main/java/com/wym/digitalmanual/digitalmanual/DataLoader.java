package com.wym.digitalmanual.digitalmanual;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DataLoader {
    private static ManualSystem manualSystem = new ManualSystem();

    // 加载设备说明书内容
    public static List<String> loadManualData(String deviceId) {
        Map<String, String> manualContent = manualSystem.getManualContent(deviceId);
        List<String> result = new ArrayList<>();
        manualContent.forEach((title, content) -> result.add(title + "\n" + content));
        return result;
    }

    // 加载设备故障自查内容
    public static List<String> loadTroubleshootingData(String deviceId) {
        Map<String, String> troubleshootingContent = manualSystem.getTroubleshooting(deviceId);
        List<String> result = new ArrayList<>();
        troubleshootingContent.forEach((title, content) -> result.add(title + "\n" + content));
        return result;
    }
}