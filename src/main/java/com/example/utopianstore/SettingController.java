package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label hiddenEmailLabel;

    //Function to get user email
    public void getEmailId(String email){
        hiddenEmailLabel.setText(email);
    }

    //Functionality to see or update current user details
    public void setUserDetailsButton(ActionEvent event) throws IOException {

        //Go to User Details page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDetailsFile.fxml"));
        root = loader.load();

        //Send data from SettingController to UserDetailsController
        UserDetailsController userDetailsController = loader.getController();
        userDetailsController.getEmailId(hiddenEmailLabel.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Functionality for back button
    public void setBackButton(ActionEvent event) throws IOException {

        //Go to main page after successful otp verification
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        root = loader.load();

        //Send data from SettingController to MainPageController
        MainPageController mainPageController = loader.getController();
        mainPageController.displayName(hiddenEmailLabel.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Functionality to see or update order details
    public void setOrderDetailsButton(ActionEvent event) throws IOException {

        //Go to User Details page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderDetailsFile.fxml"));
        root = loader.load();

        //Send data from SettingController to OrderDetailsController
        OrderDetailsController orderDetailsController = loader.getController();
        orderDetailsController.getEmailId(hiddenEmailLabel.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
