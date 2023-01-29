package com.example.utopianstore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Order {

    //Functionality to insert order details into order table
    public static boolean placeOrder(String customerEmail, Product product, String productId){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("INSERT INTO `order` ( `customerid`, `%s`) VALUES ((select customerid from customer where email ='%s') , '%s')",productId,customerEmail,product.getId());
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }

    private int orderId;
    private int customerId;
    private String laptopId;
    private String mobileId;
    private String ipadId;
    private String smartwatchId;

    public Order(int orderId, int customerId, String laptopId, String mobileId, String ipadId, String smartwatchId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.laptopId = laptopId;
        this.mobileId = mobileId;
        this.ipadId = ipadId;
        this.smartwatchId = smartwatchId;
    }

    public int getOrderId() {
        return orderId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getLaptopId() {
        return laptopId;
    }
    public String getMobileId() {
        return mobileId;
    }
    public String getIpadId() {
        return ipadId;
    }
    public String getSmartwatchId() {
        return smartwatchId;
    }

    //functionality to get order details from order table
    public static ObservableList<Order> getOrderDetails(String email){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Order> orderDetails = FXCollections.observableArrayList();
        String selectProduct = String.format("SELECT * FROM supply_chain.order where customerid = (select customerid from customer where email = '%s') ",email);
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                orderDetails.add(new Order(
                        rs.getInt("orderid"),
                        rs.getInt("customerid"),
                        rs.getString("laptopid"),
                        rs.getString("mobileid"),
                        rs.getString("ipadid"),
                        rs.getString("smarwatchid")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderDetails;
    }

    //functionality to delete selected order from order table
    public static boolean deleteOrder(Order order){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("DELETE FROM `supply_chain`.`order` WHERE (`orderid` = %s)",order.getOrderId());
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }
}
