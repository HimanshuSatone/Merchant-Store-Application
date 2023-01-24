package com.example.utopianstore;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product {

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleStringProperty availability;
    private SimpleIntegerProperty stock;

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public int getPrice() {
        return price.get();
    }

    public String getAvailability() {
        return availability.get();
    }

    public int getStock() {
        return stock.get();
    }

    public Product(String id, String name, int price, String availability, int stock) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.availability = new SimpleStringProperty(availability);
        this.stock = new SimpleIntegerProperty(stock);
    }

    //Function to get all the products from the table
//    public static ObservableList<Product> getAllProducts(){
//
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        ObservableList<Product> productList = FXCollections.observableArrayList();
//        String selectProduct = "select * from product";
//        try{
//
//            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
//            while(rs.next()){
//
//                productList.add(new Product(
//                        rs.getInt("pid"),
//                        rs.getString("pname"),
//                        rs.getInt("price"),
//                        rs.getString("availability"),
//                        rs.getInt("stock")));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return productList;
//    }

    //Function to get all the mobile table details
    public static ObservableList<Product> getAllMobile(){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProduct = "select * from mobile";
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                productList.add(new Product(
                        rs.getString("mobileid"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("availability"),
                        rs.getInt("stock")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    //Function to get all the ipad table details
    public static ObservableList<Product> getAllIpad(){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProduct = "select * from ipad";
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                productList.add(new Product(
                        rs.getString("ipadid"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("availability"),
                        rs.getInt("stock")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    //Function to get all the laptop table details
    public static ObservableList<Product> getAllLaptop(){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProduct = "select * from laptop";
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                productList.add(new Product(
                        rs.getString("laptopid"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("availability"),
                        rs.getInt("stock")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    //Function to get all the smartwatch table details
    public static ObservableList<Product> getAllSmartWatch(){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProduct = "select * from smartwatch";
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                productList.add(new Product(
                        rs.getString("smartwatchid"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("availability"),
                        rs.getInt("stock")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }



    //Function to get products by name
//    public static ObservableList<Product> getProductsByName(String productName){
//
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        ObservableList<Product> productList = FXCollections.observableArrayList();
//        String selectProduct = String.format("select * from product where lower(pname) like'%s%%'",productName.toLowerCase());
//        try{
//
//            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
//            while(rs.next()){
//
//                productList.add(new Product(
//                        rs.getInt("pid"),
//                        rs.getString("pname"),
//                        rs.getInt("price"),
//                        rs.getString("availability"),
//                        rs.getInt("stock")));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return productList;
//    }
}
