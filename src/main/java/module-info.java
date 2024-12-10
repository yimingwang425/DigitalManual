module com.wym.digitalmanual.digitalmanual {
    requires javafx.controls;
    requires javafx.fxml;
    requires webcam.capture;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires java.desktop;


    opens com.wym.digitalmanual.digitalmanual to javafx.fxml;
    exports com.wym.digitalmanual.digitalmanual;
}