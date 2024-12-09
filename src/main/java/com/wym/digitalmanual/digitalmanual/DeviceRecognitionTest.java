package com.wym.digitalmanual.digitalmanual;

public class DeviceRecognitionTest {
    public static void main(String[] args) {
        String deviceId = QRScanner.scanQRCode();
        boolean isValid = DeviceRecognition.validateDevice(deviceId);
        System.out.println("Device valid: " + isValid);
    }
}
