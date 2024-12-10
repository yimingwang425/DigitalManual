package com.wym.digitalmanual.digitalmanual;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label titleLabel = new Label("Digital User Manual");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label inputLabel = new Label("Enter Device ID:");
        TextField deviceInputField = new TextField();
        deviceInputField.setPromptText("e.g., SSH001");
        deviceInputField.setMaxWidth(200);

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white;");
        submitButton.setOnAction(e -> processDeviceInput(deviceInputField.getText()));

        Button qrScanButton = new Button("Scan QR Code");
        qrScanButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white;");
        qrScanButton.setOnAction(e -> navigateToQRCodeScanner());

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.getChildren().addAll(
                titleLabel,
                inputLabel,
                deviceInputField,
                submitButton,
                qrScanButton
        );

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Digital User Manual");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processDeviceInput(String deviceId) {
        if (deviceId == null || deviceId.trim().isEmpty()) {
            showAlert("Error", "Please enter a valid device ID.");
        } else {
            boolean isValid = DeviceRecognition.validateDevice(deviceId);
            if (isValid) {
                ContentView contentView = new ContentView(deviceId);
                contentView.show();
            } else {
                showAlert("Error", "Device ID not found. Please check again.");
            }
        }
    }

    // 跳转到二维码扫描页面
    private void navigateToQRCodeScanner() {
        System.out.println("Navigating to QR Code Scanner Page...");
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}