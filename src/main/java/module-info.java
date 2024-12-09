module com.wym.digitalmanual.digitalmanual {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.wym.digitalmanual.digitalmanual to javafx.fxml;
    exports com.wym.digitalmanual.digitalmanual;
}