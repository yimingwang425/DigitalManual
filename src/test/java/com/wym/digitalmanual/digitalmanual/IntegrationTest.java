package com.wym.digitalmanual.digitalmanual;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IntegrationTest {

    @Test
    public void testFullFlow_ValidDevice() {

        String deviceId = "SSH001";
        assertTrue(DeviceRecognition.validateDevice(deviceId), "Device should be valid");


        ManualSystem manualSystem = new ManualSystem();
        Manual manual = manualSystem.getManual(deviceId);
        assertNotNull(manual, "Manual should not be null");
        assertEquals("Smart Lock Manual", manual.getTitle(), "Manual title should match");
        assertFalse(manual.getContent().isEmpty(), "Manual content should not be empty");


        List<String> troubleshootingSteps = DataLoader.loadTroubleshootingData(deviceId);
        assertFalse(troubleshootingSteps.isEmpty(), "Troubleshooting steps should not be empty");
    }

    @Test
    public void testFullFlow_InvalidDevice() {
        String invalidDeviceId = "INVALID001";
        assertFalse(DeviceRecognition.validateDevice(invalidDeviceId), "Invalid device should not be validated");
    }
}