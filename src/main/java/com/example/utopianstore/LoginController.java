package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    Label loginLabel;
    @FXML
    TextField emailTextField;
    @FXML
    PasswordField passwordTextField;
    Login login = new Login();//Object of Login class

    //Function to do action on click of login button
    public void login(ActionEvent event) throws IOException {

        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        //after successful login, go to main page
        if(login.customerLogin(email,password)){

            //Way to send data from login page to Main-Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            root = loader.load();

            //Send data from LoginController to MainPageController
            MainPageController mainPageController = loader.getController();
            mainPageController.displayName(email);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            loginLabel.setText("Login Failed");
        }
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Function to switch to signup page on click of signup button
    public void switchToSignup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SignupFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}