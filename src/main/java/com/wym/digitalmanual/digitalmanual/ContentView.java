package com.wym.digitalmanual.digitalmanual;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Map;

public class ContentView {
    private Stage stage;
    private String deviceId;
    private ManualSystem manualSystem;
    private VBox contentArea;

    public ContentView(String deviceId) {
        this.deviceId = deviceId;
        this.stage = new Stage();
        this.manualSystem = new ManualSystem();
        initialize();
    }

    private void initialize() {
        BorderPane mainLayout = new BorderPane();

        Button selfDiagnosisButton = new Button("Self-Diagnosis");
        selfDiagnosisButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white;");
        selfDiagnosisButton.setOnAction(e -> showTroubleshooting());

        // Add warranty info
        Label warrantyLabel = new Label("Warranty expires: 2025-12-31");
        warrantyLabel.setStyle("-fx-font-style: italic;");

        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.getChildren().addAll(selfDiagnosisButton, warrantyLabel);

        contentArea = new VBox(10);
        contentArea.setPadding(new Insets(20));
        showManualContent();

        ScrollPane scrollPane = new ScrollPane(contentArea);
        scrollPane.setFitToWidth(true);

        mainLayout.setTop(topBar);
        mainLayout.setCenter(scrollPane);

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setTitle("SSH Device Manual - " + deviceId);
        stage.setScene(scene);
    }

    private void showManualContent() {
        contentArea.getChildren().clear();
        Map<String, String> manualContent = manualSystem.getManualContent(deviceId);

        Label titleLabel = new Label("User Manual");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        contentArea.getChildren().add(titleLabel);

        manualContent.forEach((title, content) -> {
            TitledPane section = new TitledPane();
            section.setText(title);
            section.setExpanded(false);
            TextArea contentArea = new TextArea(content);
            contentArea.setWrapText(true);
            contentArea.setEditable(false);
            section.setContent(contentArea);
            this.contentArea.getChildren().add(section);
        });
    }

    private void showTroubleshooting() {
        contentArea.getChildren().clear();
        Map<String, String> troubleshootingContent = manualSystem.getTroubleshooting(deviceId);

        Label titleLabel = new Label("Self-Diagnosis");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        contentArea.getChildren().add(titleLabel);

        troubleshootingContent.forEach((title, content) -> {
            TitledPane section = new TitledPane();
            section.setText(title);
            section.setExpanded(false);
            TextArea contentArea = new TextArea(content);
            contentArea.setWrapText(true);
            contentArea.setEditable(false);
            section.setContent(contentArea);
            this.contentArea.getChildren().add(section);
        });
    }

    public void show() {
        stage.show();
    }
}
