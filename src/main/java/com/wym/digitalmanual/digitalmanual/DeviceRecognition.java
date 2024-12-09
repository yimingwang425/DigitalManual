package com.wym.digitalmanual.digitalmanual;
import java.util.List;

public class DeviceRecognition {
    public static boolean validateDevice(String deviceId) {

        List<String> validDevices = List.of("SSH001", "SSH002");
        return validDevices.contains(deviceId);

    }

}
