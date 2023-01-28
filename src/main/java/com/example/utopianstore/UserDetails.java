package com.example.utopianstore;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class UserDetails {

    //Functionality to insert customer details into customer table
    public static boolean makeNewCustomerData(String firstName, String lastName, String gender, String city, String email, String password, String number ){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("INSERT INTO `customer` (`first_name`, `last_name`, `email`, `number`, `password`, `city`, `gender`) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s')",firstName,lastName,email,number,password,city,gender);
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }

    private String firstName;
    private String lastName;
    private String number;
    private String gender;
    private String city;
    private String email;
    private String password;

    public UserDetails(String firstName, String lastName, String number, String gender, String city, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getNumber() {
        return number;
    }
    public String getGender() {
        return gender;
    }
    public String getCity() {
        return city;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    //Function to get all details of customer
    public static ObservableList<UserDetails> getCustomerDetails(String email){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<UserDetails> userDetails = FXCollections.observableArrayList();
        String selectProduct = String.format("select first_name, last_name, number, city, email, password, gender from customer where email = '"+email+"'");
        try{

            ResultSet rs = databaseConnection.getQueryTable(selectProduct);
            while(rs.next()){

                userDetails.add(new UserDetails(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("number"),
                        rs.getString("gender"),
                        rs.getString("city"),
                        rs.getString("email"),
                        rs.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userDetails;
    }

    //Functionality to update customer first name
    public static boolean updateFirstName(String firstName,String email ){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("UPDATE `customer` SET `first_name` = '%s' WHERE (`email` = '%s')",firstName,email);
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }

    //Functionality to update customer first name
    public static boolean updateLastName(String lastName,String email ){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("UPDATE `customer` SET `last_name` = '%s' WHERE (`email` = '%s')",lastName,email);
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }

    //Functionality to update customer first name
    public static boolean updateNumber(String number,String email ){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("UPDATE `customer` SET `number` = '%s' WHERE (`email` = '%s')",number,email);
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }

    //Functionality to update customer city
    public static boolean updateCity(String city,String email ){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("UPDATE `customer` SET `city` = '%s' WHERE (`email` = '%s')",city,email);
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }

    //Functionality to update customer gender
    public static boolean updateGender(String gender,String email ){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format("UPDATE `customer` SET `gender` = '%s' WHERE (`email` = '%s')",gender,email);
        int rowCount =0;
        try{
            rowCount = databaseConnection.executeUpdateQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0;
    }
}
