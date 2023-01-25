package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button backButton;
    @FXML
    private Button resetButton;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    Button signupButton;
    @FXML
    AnchorPane scenePane;

    //Functionality for back button
    public void setBackButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //Functionality for signup button
    public void setSignupButton(ActionEvent event) throws IOException {

        String firstName = firstnameField.getText();
        String lastName = lastnameField.getText();
        String gender = genderField.getText();
        String number = numberField.getText();
        String city = cityField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if(UserDetails.makeNewCustomerData(firstName, lastName, gender, city, email, password, number)){

            System.out.println("Customer Details added");

            //Create alert when successful customer details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Welcome");
            alert.setHeaderText(firstName);
            alert.setContentText("Welcome to Utopian.llp :) ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                stage = (Stage) scenePane.getScene().getWindow();

                stage = (Stage) scenePane.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }
        else{

            System.out.println("error");

            //Create alert when unsuccessful customer details
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText(firstName);
            alert.setContentText("Sorry we couldn't proceed your request :( ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
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
