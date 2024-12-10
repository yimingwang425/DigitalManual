package com.wym.digitalmanual.digitalmanual;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.scene.control.Alert;

import java.awt.image.BufferedImage;

public class QRScanner {
    public static String scanQRCode() {
        Webcam webcam = Webcam.getDefault();
        if (webcam == null) {
            showAlert("Error", "No webcam detected!");
            return null;
        }

        try {
            webcam.open();

            BufferedImage image = webcam.getImage();

            if (image != null) {
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                Result result = new MultiFormatReader().decode(bitmap);
                String deviceId = result.getText();

                if (DeviceRecognition.validateDevice(deviceId)) {
                    return deviceId;
                } else {
                    showAlert("Error", "Invalid QR Code: " + deviceId);
                }
            }
        } catch (NotFoundException e) {
            showAlert("Error", "No QR code found");
        } catch (Exception e) {
            showAlert("Error", "Error scanning QR code: " + e.getMessage());
        } finally {
            webcam.close();
        }

        return null;
    }

    public static String inputDeviceId(String input) {

        return input;
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
