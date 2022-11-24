module com.example.valentinlevente_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.valentinlevente_javafxrestclientdolgozat to javafx.fxml, com.google.gson;
    exports com.example.valentinlevente_javafxrestclientdolgozat;
}