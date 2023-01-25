package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button backButton;
    @FXML
    Button resetButton;
    @FXML
    TextField firstnameField;
    @FXML
    TextField lastnameField;
    @FXML
    TextField genderField;
    @FXML
    TextField numberField;
    @FXML
    TextField cityField;
    @FXML
    TextField emailField;
    @FXML
    PasswordField passwordField;

    //Functionality for back button
    public void setBackButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //Function to switch to login page on click to signup button
    public void switchToLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Functionality for reset button
    public void setResetButton(ActionEvent event){

        firstnameField.clear();
        lastnameField.clear();
        genderField.clear();
        numberField.clear();
        cityField.clear();
        emailField.clear();
        passwordField.clear();
    }
}
