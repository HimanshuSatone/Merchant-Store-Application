package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class OtpController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button cancelButton;
    @FXML
    Button submitButton;
    @FXML
    TextField otpTextField;
    @FXML
    Label emailLabel;

    String email;

    //Functionality for cancel button
    public void setCancelButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Function to fetch email and show it on otp verification page
    public void getEmail(String email_id){

        email=email_id;
        emailLabel.setText(email);
    }

    public void Random(){
        Random rd = new Random();
    }

    //Functionality for submit button
    public void setSubmitButton(ActionEvent event) throws IOException {

        //Go to main page after successful otp verification
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
}
