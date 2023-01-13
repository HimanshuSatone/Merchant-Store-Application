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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label nameLabel;
    @FXML
    private Button settingButton;
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchTextField;

    //Functionality for fetching data from sql product table to our table view
    @FXML
    private TableColumn<Product,String> availability;
    @FXML
    private TableColumn<Product,Integer> id;
    @FXML
    private TableColumn<Product,String> name;
    @FXML
    private TableColumn<Product,Integer> price;
    @FXML
    private TableColumn<Product,Integer> stock;
    @FXML
    private TableView<Product> tableView;

    ObservableList<Product> products;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        stock.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        availability.setCellValueFactory(new PropertyValueFactory<Product,String>("availability"));

        products = Product.getAllProducts();
        tableView.setItems(products);
    }

    //Functionality for search button
    public void search(ActionEvent event){

        String productName = searchTextField.getText();
        searchTextField.clear();

        id.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        stock.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        availability.setCellValueFactory(new PropertyValueFactory<Product,String>("availability"));

        products = Product.getProductsByName(productName);
        tableView.setItems(products);
    }

    //Functionality to go on Login Page on click of logout button
    public void logout(ActionEvent event) throws IOException {

        //Create alert when click on logout button
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Do you want to save before exiting?: ");

        //Some events on click of OK button on alert
        if(alert.showAndWait().get() == ButtonType.OK){

            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logout");

            //It will shift to login page
            Parent root = FXMLLoader.load(getClass().getResource("LoginFile.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    //Functionality to display username on welcome bar
    public void displayName(String userEmail){
        nameLabel.setText(userEmail);
    }
}
