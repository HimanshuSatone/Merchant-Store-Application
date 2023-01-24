module com.example.utopianstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires java.desktop;


    opens com.example.utopianstore to javafx.fxml;
    exports com.example.utopianstore;
}