package com.example.utopianstore;

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
}
