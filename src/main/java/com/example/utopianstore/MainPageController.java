package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label nameLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    //Function to go on Login Page on click of logout button
    public void logout(ActionEvent event) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Do you want to save before exiting?: ");

        if(alert.showAndWait().get() == ButtonType.OK){

            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logout");
            //stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    //Function to display username on welcome bar
    public void displayName(String userEmail){
        nameLabel.setText(userEmail);
    }
}
