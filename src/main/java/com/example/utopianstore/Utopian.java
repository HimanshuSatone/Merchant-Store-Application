package com.example.utopianstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    }

    public static void main(String[] args) {
        launch();
    }
}