package com.wym.digitalmanual.digitalmanual;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.wym.digitalmanual.digitalmanual.*;

import java.util.List;

public class IntegrationTest {

    @Test
    public void testFullFlow_ValidDevice() {

        String deviceId = "SSH001";
        assertTrue(DeviceRecognition.validateDevice(deviceId), "Device Authentication Failure");


        ManualSystem manualSystem = new ManualSystem();
        assertNotNull(manualSystem.getManualContent(deviceId), "Manual content not found");


        Manual manual = manualSystem.getManual(deviceId);
        assertEquals("Smart Lock Manual", manual.getTitle(), "Manual title mismatch");
        assertTrue(manual.getContent().contains("WiFi Setup"), "Incomplete contents of the manual");


        List<String> troubleshootingSteps = DataLoader.loadTroubleshootingData(deviceId);
        assertFalse(troubleshootingSteps.isEmpty(), "Troubleshooting steps not found");
        assertTrue(troubleshootingSteps.contains("Steps to resolve connection problems..."), "Incorrect fault content");
    }

    @Test
    public void testFullFlow_InvalidDevice() {

        String invalidDeviceId = "INVALID001";
        assertFalse(DeviceRecognition.validateDevice(invalidDeviceId), "Failed to verify invalid device ID");
    }
}
