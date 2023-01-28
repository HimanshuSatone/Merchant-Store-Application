package com.example.utopianstore;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserDetailsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField cityField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField numberField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField lastnameField;
    @FXML
    private Label hiddenEmailLabel;
    @FXML
    Button updateFirstNameButton;
    @FXML
    Button updateLastNameButton;
    @FXML
    Button updateNumberButton;
    @FXML
    Button updateCityButton;
    @FXML
    Button updateGenderButton;
    @FXML
    AnchorPane scenePane;

    @FXML
    private TableColumn<UserDetails, String> city_column;
    @FXML
    private TableColumn<UserDetails, String> firstName_column;
    @FXML
    private TableColumn<UserDetails, String> gender_column;
    @FXML
    private TableColumn<UserDetails, String> lastName_column;
    @FXML
    private TableColumn<UserDetails, String> number_column;
    @FXML
    private TableColumn<UserDetails, String> password_column;
    @FXML
    private TableColumn<UserDetails, String> email_column;
    @FXML
    private TableView<UserDetails> tableView;

    ObservableList<UserDetails> userDetails;

    //Functionality to show user details on table
    public void setShowDetails(ActionEvent event){

        firstName_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("firstName"));
        lastName_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("lastName"));
        number_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("number"));
        email_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("email"));
        city_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("city"));
        password_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("password"));
        gender_column.setCellValueFactory(new PropertyValueFactory<UserDetails,String>("gender"));


        userDetails = UserDetails.getCustomerDetails(hiddenEmailLabel.getText());
        tableView.setItems(userDetails);
    }

    //Function to get user email id
    public void getEmailId(String Email){

        hiddenEmailLabel.setText(Email);
    }

    //Functionality to set clear first name button
    public void setClearFirstNameButton(ActionEvent event){

        try{
            firstnameField.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Functionality to set clear last name button
    public void setClearLastNameButton(ActionEvent event){

        try{
            lastnameField.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Functionality to set clear number button
    public void setClearNumberButton(ActionEvent event){

        try{
            numberField.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Functionality to set clear city button
    public void setClearCityButton(ActionEvent event){

        try{
            cityField.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Functionality to set clear gender button
    public void setClearGenderButton(ActionEvent event){

        try{
            genderField.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Functionality for update first name button
    public void setFirstNameUpdateButton(ActionEvent event){

        if(UserDetails.updateFirstName(firstnameField.getText(),hiddenEmailLabel.getText())){

            System.out.println("Update Successful");

            //Create alert when successful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("First Name updated Successfully 😄");

            //Some events on click of OK button on alert
            if (alert.showAndWait().get() == ButtonType.OK) {

                firstnameField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
        else{

            System.out.println("Update failed");

            //Create alert when unsuccessful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update failed");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Update failed, please try again later 😊 ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                firstnameField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

    //Functionality for update last name button
    public void setLastNameUpdateButton(ActionEvent event){

        if(UserDetails.updateLastName(lastnameField.getText(),hiddenEmailLabel.getText())){

            System.out.println("Update Successful");

            //Create alert when successful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Last Name updated Successfully 😄");

            //Some events on click of OK button on alert
            if (alert.showAndWait().get() == ButtonType.OK) {

                lastnameField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
        else{

            System.out.println("Update failed");

            //Create alert when unsuccessful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update failed");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Update failed, please try again later 😊 ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                lastnameField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

    //Functionality for update number button
    public void setNumberUpdateButton(ActionEvent event){

        if(UserDetails.updateNumber(numberField.getText(),hiddenEmailLabel.getText())){

            System.out.println("Update Successful");

            //Create alert when successful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Number updated Successfully 😄");

            //Some events on click of OK button on alert
            if (alert.showAndWait().get() == ButtonType.OK) {

                numberField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
        else{

            System.out.println("Update failed");

            //Create alert when unsuccessful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update failed");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Update failed, please try again later 😊 ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                numberField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

    //Functionality for update city button
    public void setCityUpdateButton(ActionEvent event){

        if(UserDetails.updateCity(cityField.getText(),hiddenEmailLabel.getText())){

            System.out.println("Update Successful");

            //Create alert when successful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("City updated Successfully 😄");

            //Some events on click of OK button on alert
            if (alert.showAndWait().get() == ButtonType.OK) {

                cityField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
        else{

            System.out.println("Update failed");

            //Create alert when unsuccessful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update failed");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Update failed, please try again later 😊 ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                cityField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

    //Functionality for update gender button
    public void setGenderUpdateButton(ActionEvent event){

        if(UserDetails.updateGender(genderField.getText(),hiddenEmailLabel.getText())){

            System.out.println("Update Successful");

            //Create alert when successful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Gender updated Successfully 😄");

            //Some events on click of OK button on alert
            if (alert.showAndWait().get() == ButtonType.OK) {

                genderField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
        else{

            System.out.println("Update failed");

            //Create alert when unsuccessful update
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update failed");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Update failed, please try again later 😊 ");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                genderField.clear();
                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

    //Functionality for back button
    public void setBackButton(ActionEvent event) throws IOException {

        //Go to Setting option page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SettingFile.fxml"));
        root = loader.load();

        //Send data from UserDetailsController to Setting Controller
        SettingController settingController = loader.getController();
        settingController.getEmailId(hiddenEmailLabel.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Functionality for update complete button
    public void setUpdateCompleteButton(ActionEvent event) throws IOException {

        //Create alert before leaving the user details page
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update Complete");
        alert.setHeaderText(hiddenEmailLabel.getText());
        alert.setContentText("You will leave this page to setting page. Are you sure? 😄");

        //Some events on click of OK button on alert
        if (alert.showAndWait().get() == ButtonType.OK) {

            stage = (Stage) scenePane.getScene().getWindow();

            //Go to Setting option page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SettingFile.fxml"));
            root = loader.load();

            //Send data from UserDetailsController to Setting Controller
            SettingController settingController = loader.getController();
            settingController.getEmailId(hiddenEmailLabel.getText());

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


}
