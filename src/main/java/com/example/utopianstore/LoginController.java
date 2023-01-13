package com.example.utopianstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ImageView imageView;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    private Login login = new Login();//Object of Login class

    Image logo = new Image(new FileInputStream("C:\\Users\\Himanshu\\IdeaProjects\\UtopianStore\\src\\main\\photos\\LoginBanner.jpg"));



    public LoginController() throws FileNotFoundException {
    }

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
            //Create alert after failed login attempt
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Login Failed");
            alert.setContentText("Either wrong email or password or no account found. Try signup. ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

    //Function to switch to signup page on click of signup button
    public void switchToSignup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SignupFile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}