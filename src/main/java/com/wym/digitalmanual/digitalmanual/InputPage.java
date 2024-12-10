package com.wym.digitalmanual.digitalmanual;

public class InputPage {
    public static void main(String[] args) {
        String input = "SSH001";
        if (DeviceRecognition.validateDevice(input)) {
            System.out.println("Device recognized!");
        } else {
            System.out.println("Invalid device.");
        }
    }
}
