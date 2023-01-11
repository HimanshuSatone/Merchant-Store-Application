package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    //Function to switch to login page on click to signup button
    public void switchToLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
