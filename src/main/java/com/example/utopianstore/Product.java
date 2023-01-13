package com.example.utopianstore;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleStringProperty availability;
    private SimpleIntegerProperty stock;

    public int getId() {
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

    public Product(int id, String name, int price, String availability, int stock) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.availability = new SimpleStringProperty(availability);
        this.stock = new SimpleIntegerProperty(stock);
    }

    //Function to get all the products from the table
    public static ObservableList<Product> getAllProducts(){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProduct = "select * from product";
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                productList.add(new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
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
    public static ObservableList<Product> getProductsByName(String productName){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProduct = String.format("select * from product where lower(pname) like'%%%s%%'",productName.toLowerCase());
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                productList.add(new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getInt("price"),
                        rs.getString("availability"),
                        rs.getInt("stock")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
}
