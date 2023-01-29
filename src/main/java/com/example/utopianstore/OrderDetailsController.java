package com.example.utopianstore;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderDetailsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button backButton;
    @FXML
    Button showDetailsButton;
    @FXML
    Button deleteOrderButton;
    @FXML
    Label hiddenEmailLabel;
    @FXML
    AnchorPane scenePane;

    @FXML
    TableColumn<Order,Integer> orderId_column;
    @FXML
    TableColumn<Order,Integer> customerId_column;
    @FXML
    TableColumn<Order,String> laptop_column;
    @FXML
    TableColumn<Order,String> mobile_column;
    @FXML
    TableColumn<Order,String> ipad_column;
    @FXML
    TableColumn<Order,String> smartwatch_column;
    @FXML
    TableView<Order> tableView;

    ObservableList<Order> orderDetails;

    //Functionality for show details button
    public void setShowDetailsButton(ActionEvent event){

        orderId_column.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderId"));
        customerId_column.setCellValueFactory(new PropertyValueFactory<Order, Integer>("customerId"));
        laptop_column.setCellValueFactory(new PropertyValueFactory<Order,String>("laptopId"));
        mobile_column.setCellValueFactory(new PropertyValueFactory<Order,String>("mobileId"));
        ipad_column.setCellValueFactory(new PropertyValueFactory<Order,String>("ipadId"));
        smartwatch_column.setCellValueFactory(new PropertyValueFactory<Order,String>("smartwatchId"));

        orderDetails = Order.getOrderDetails(hiddenEmailLabel.getText());
        tableView.setItems(orderDetails);
    }

    //Function to get user email id
    public void getEmailId(String Email){

        hiddenEmailLabel.setText(Email);
    }

    //Functionality for back button
    public void setBackButton(ActionEvent event) throws IOException {

        //Go to Setting option page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SettingFile.fxml"));
        root = loader.load();

        //Send data from OrderDetailsController to Setting Controller
        SettingController settingController = loader.getController();
        settingController.getEmailId(hiddenEmailLabel.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Function to get selected Order
    public  Order getSelectedProduct(){

        try{
            Order selectOrder = tableView.getSelectionModel().getSelectedItem();
            return selectOrder;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Functionality for delete order button
    public void setDeleteOrderButton(ActionEvent event){

        Order selectedOrder = getSelectedProduct();

        if(Order.deleteOrder(selectedOrder)){

            System.out.println("Delete Successful");

            //Create alert when successful order delete
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Successful");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("Your selected order has been deleted successfully :)");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
        else{

            System.out.println("Delete failed");

            //Create alert when unsuccessful order delete
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Failed");
            alert.setHeaderText(hiddenEmailLabel.getText());
            alert.setContentText("We cannot process your request right now, please try again later :)");

            //Some events on click of OK button on alert
            if(alert.showAndWait().get() == ButtonType.OK){

                stage = (Stage) scenePane.getScene().getWindow();
            }
        }
    }

}
