module com.example.phase3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phase3 to javafx.fxml;
    exports com.example.phase3;
}