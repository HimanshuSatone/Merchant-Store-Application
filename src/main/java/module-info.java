module com.example.utopianstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.utopianstore to javafx.fxml;
    exports com.example.utopianstore;
}