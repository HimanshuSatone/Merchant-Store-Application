package com.example.utopianstore;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Utopian extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
        Scene scene = new Scene(root);

        //Application icon
        Image icon = new Image(new FileInputStream("C:\\Users\\Himanshu\\IdeaProjects\\UtopianStore\\src\\main\\photos\\icon.jpg"));
        stage.getIcons().add(icon);

        //Application title
        stage.setTitle("Utopian Store");

        stage.setScene(scene);
        stage.show();

        //Set stage to call logoutOnHitRedCross function on press of Red Cross Button
        stage.setOnCloseRequest(event -> {
            try {
                event.consume();
                logoutOnHitRedCross(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //Function to logout on hit of Red Cross Button
    public void logoutOnHitRedCross(Stage stage) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to Exit !");
        alert.setContentText("Do you want to save before exiting?: ");

        if(alert.showAndWait().get() == ButtonType.OK){

            System.out.println("You successfully logout");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}